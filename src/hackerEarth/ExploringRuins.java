package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Tanmay on 22-Apr-17.
 */
public class ExploringRuins {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '?') {
                if (i == 0) {
                    if (line.length() == 1) {
                        line = "a";
                    } else if (line.charAt(i + 1) != 'a') {
                        line = line.substring(0, i) + 'a' + line.substring(i + 1);
                    } else {
                        line = line.substring(0, i) + 'b' + line.substring(i + 1);
                    }
                } else if (i == line.length() - 1) {
                    if (line.charAt(i - 1) != 'a') {
                        line = line.substring(0, i) + 'a' + line.substring(i + 1);
                    } else {
                        line = line.substring(0, i) + 'b' + line.substring(i + 1);
                    }
                } else {
                    if (line.charAt(i - 1) != 'a' && line.charAt(i + 1) != 'a') {
                        line = line.substring(0, i) + 'a' + line.substring(i + 1);
                    } else {
                        line = line.substring(0, i) + 'b' + line.substring(i + 1);
                    }
                }
            }
        }
        System.out.println(line);
    }
}
