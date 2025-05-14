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

class AlternateChar {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        List<Character> charList = new ArrayList<>(set);
        int maxLength = 0;

        for (int i = 0; i < charList.size(); i++) {
            for (int j = i + 1; j < charList.size(); j++) {
                char c1 = charList.get(i);
                char c2 = charList.get(j);



                StringBuilder temp = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == c1 || c == c2) {
                        temp.append(c);
                    }
                }
                String str =temp.toString();
                boolean check = true;
                for (int k = 0; k < str.length()-1; k++) {
                    if (str.charAt(k) == str.charAt(k + 1)) {
                        check = false;
                        break;
                    }
                }

                if (check && str.length() >= 1) {
                    maxLength = Math.max(maxLength, str.length());
                }
            }
        }
        return maxLength;
    }
}






public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
