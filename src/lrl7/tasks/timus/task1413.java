package lrl7.tasks.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        double x = 0, y = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '0':
                    i = s.length();
                    break;
                case '8':
                    y += 1;
                    break;
                case '2':
                    y -= 1;
                    break;
                case '6':
                    x += 1;
                    break;
                case '4':
                    x -= 1;
                    break;
                case '7':
                    x -= 1;
                    y += 1;
                    break;
                case '9':
                    x += 1;
                    y += 1;
                    break;
                case '1':
                    x -= 1;
                    y -= 1;
                    break;
                case '3':
                    x += 1;
                    y -= 1;
                    break;
                case '5':
                    // ничего
                    break;
            }
        }

        System.out.printf("%.10f %.10f\n", x, y);
    }
}
