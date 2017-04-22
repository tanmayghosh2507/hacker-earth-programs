package hackerEarth;

import java.io.*;

public class LastIndex {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = br.readLine();

        int N, M;
        String[] strs = lines.trim().split("\\s+");

        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        String arr = br.readLine();
        strs = arr.trim().split("\\s+");
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }

        int point = -2;
        for (int i = N - 1; i >= 0; i--) {
            if (a[i] == M) {
                point = i;
                break;
            }
        }

        System.out.println(point + 1);
    }
}
