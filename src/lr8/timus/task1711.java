package lr8.timus;

import java.io.*;
import java.util.*;

public class task1711 {
    static int n;
    static String[][] variants;
    static int[] order;
    static String[] chosen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Читаем n
        n = Integer.parseInt(br.readLine());

        // Читаем варианты для каждой задачи
        variants = new String[n][3];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            variants[i][0] = line[0];
                variants[i][1] = line[1];
                variants[i][2] = line[2];
                // Сортируем варианты лексикографически
                Arrays.sort(variants[i]);
            }

            // Читаем порядок задач
            order = new int[n];
            String[] orderLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                order[i] = Integer.parseInt(orderLine[i]) - 1; // в 0-индексацию
            }

            chosen = new String[n];

            // Запускаем поиск
            if (backtrack(0, null)) {
                for (int i = 0; i < n; i++) {
                    System.out.println(chosen[i]);
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        static boolean backtrack(int pos, String prevName) {
            if (pos == n) {
                return true;
            }

            int taskIdx = order[pos]; // какая задача сейчас

            for (String name : variants[taskIdx]) {
                if (prevName == null || name.compareTo(prevName) > 0) {
                    chosen[taskIdx] = name;
                    if (backtrack(pos + 1, name)) {
                        return true;
                    }
                    chosen[taskIdx] = null;
                }
            }

            return false;
        }
    }

