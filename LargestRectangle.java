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
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
    // Write your code here
        long area = 0, minHeight = 0, length = 0;
        int left = 0, right = 0;
        
        for(int i = 0; i < h.size(); i++)
        {
            minHeight = h.get(i);
            length = 0;
            left = i;
            right = i;
            
            while(left >= 0 && (h.get(left) >= minHeight))
            {
                length += 1;
                left--;
            }
            
            while(right < h.size() && (h.get(right) >= minHeight))
            {
                length += 1;
                right++;    
            }
            
            length -= 1;
            area = Math.max(area, (minHeight * length));
        }
        return area;
}
}

public class largestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
