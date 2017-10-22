package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WinTheGameProb {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			String rg = br.readLine();
			double r = Double.parseDouble(rg.split(" ")[0]);
			double g = Double.parseDouble(rg.split(" ")[1]);

			double sum = 0;
			if (g == 0 || r == 0) {
				sum = 1;
			} else {
				double[] prob = new double[2000];
				prob[0] = r / (r + g);
				for (int k = 0, j = 1; k < (r + g - 2); k = k + 2, j++) {
					prob[j] = prob[j - 1] * ((g - k) * (g - k - 1)) / ((r + g - k - 1) * (r + g - k - 2));
				}
				for (double f : prob) {
					sum = sum + f;
				}
			}
			System.out.printf("%.6f", sum);
			System.out.println();
		}
	}
}
