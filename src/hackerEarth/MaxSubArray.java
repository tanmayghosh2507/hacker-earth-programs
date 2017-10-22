package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSubArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int N = Integer.parseInt(input.split(" ")[0]);
		int Q = Integer.parseInt(input.split(" ")[1]);

		int[] arr = new int[N];
		String array = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(array.split(" ")[i]);
		}

		for (int i = 0; i < Q; i++) {
			int K = Integer.parseInt(br.readLine());
			System.out.println(maxSubArray(arr, K));
		}
	}

	public static int maxSubArray(int[] nums, int K) {
		int max = 0;
		int negMax = nums[0];
		int current = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == K)
				continue;
			current = current + nums[i];
			if (current <= 0) {
				current = 0;
				if (negMax < nums[i]) {
					negMax = nums[i];
				}
			} else if (current > max)
				max = current;
		}
		if (max == 0)
			return negMax;
		return max;
	}

}
