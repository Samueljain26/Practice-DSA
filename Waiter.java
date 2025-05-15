import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if (q == 0) {
            return number;
        }

        int prime = 2;
        while (primes.size() < q) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(prime); j++) {
                if (prime % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(prime);
            }
            prime++;
        }

        int j = 0;
        while (q > 0) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            for (int i = number.size() - 1; i >= 0; i--) {
                if (number.get(i) % primes.get(j) == 0) {
                    stack2.push(number.get(i));
                } else {
                    stack1.push(number.get(i));
                }
            }

            while (!stack2.isEmpty()) {
                result.add(stack2.pop());
            }

            number = new ArrayList<>();
            while (!stack1.isEmpty()) {
                number.add( stack1.pop());
            }
            Collections.reverse(number);

            j++;
            q--;
        }
        Collections.reverse(number);
        for (int i = 0; i < number.size(); i++) {
            result.add(number.get(i));
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
