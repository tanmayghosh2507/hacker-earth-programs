package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

class HE {
	
	long max=0, min=0;
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
    	
    	long archers[] = null;
    	String strs[] = null;
    	int N = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i =0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            String line = br.readLine();
            strs = line.trim().split("\\s+");
            archers = new long[N];

            for (int j=0; j<N; j++) {
                archers[j] = Long.parseLong(strs[j]);
            }
        }
        
        System.out.println(lcm(archers));
    }
    
    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    private static long lcm(long[] input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) {
        	result = lcm(result, input[i]);
        }
        return result;
    }
    
    private static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}
