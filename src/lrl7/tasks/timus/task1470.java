package lrl7.tasks.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class task1470 {

    static int N;
    static long[][][] tree;

    static void update(int x, int y, int z, long delta) {
        for (int i = x + 1; i <= N; i += i & -i) {
            for (int j = y + 1; j <= N; j += j & -j) {
                for (int k = z + 1; k <= N; k += k & -k) {
                    tree[i][j][k] += delta;
                }
            }
        }
    }

    static long sum(int x, int y, int z) {
        long res = 0;
        for (int i = x + 1; i > 0; i -= i & -i) {
            for (int j = y + 1; j > 0; j -= j & -j) {
                for (int k = z + 1; k > 0; k -= k & -k) {
                    res += tree[i][j][k];
                }
            }
        }
        return res;
    }

    static long rangeSum(int x1, int y1, int z1, int x2, int y2, int z2) {
        return sum(x2, y2, z2)
                - (x1 > 0 ? sum(x1 - 1, y2, z2) : 0)
                - (y1 > 0 ? sum(x2, y1 - 1, z2) : 0)
                - (z1 > 0 ? sum(x2, y2, z1 - 1) : 0)
                + (x1 > 0 && y1 > 0 ? sum(x1 - 1, y1 - 1, z2) : 0)
                + (x1 > 0 && z1 > 0 ? sum(x1 - 1, y2, z1 - 1) : 0)
                + (y1 > 0 && z1 > 0 ? sum(x2, y1 - 1, z1 - 1) : 0)
                - (x1 > 0 && y1 > 0 && z1 > 0 ? sum(x1 - 1, y1 - 1, z1 - 1) : 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        tree = new long[N + 1][N + 1][N + 1];

        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());

            if (m == 3) break;

            if (m == 1) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                update(x, y, z, k);
            } else if (m == 2) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int z1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int z2 = Integer.parseInt(st.nextToken());
                sb.append(rangeSum(x1, y1, z1, x2, y2, z2)).append('\n');
            }
        }

        System.out.print(sb);
    }
}