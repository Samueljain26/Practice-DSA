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



public class HourGlassSum {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[6][6];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] =sc.nextInt();
            }
        }
            int sum =0;
            int maxSum =Integer.MIN_VALUE;
            
            for( int i=0; i<4;i++){
                for(int  j=0;j<4;j++){
                    int top = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                    int middle = arr[i+1][j+1];
                    int bottom = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                     sum = top+middle+bottom;
                     if(sum>maxSum){
                        maxSum =sum;
                     }
                    
                }
            }
            System.out.println(maxSum);
            
        }
        
    }
