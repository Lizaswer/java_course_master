package lr8.timus;

import java.io.*;
import java.util.*;

public class task1710 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Читаем точки
        double[] A = readPoint(br);
        double[] B = readPoint(br);
        double[] C = readPoint(br);

        // Вычисляем стороны
        double AB = distance(A, B);
        double BC = distance(B, C);
        double AC = distance(A, C);

        // Находим угол при A (между AB и AC)
        double angleBAC = angleBetween(A, B, C);
        double angleRad = Math.toRadians(angleBAC);

        // Пытаемся построить второй треугольник
        // A2 = (0,0), B2 = (AB, 0)
        // C2 лежит на луче под углом angleRad на расстоянии AC

        double cx = AC * Math.cos(angleRad);
        double cy = AC * Math.sin(angleRad);

        // Проверяем, какая из двух возможных точек C2 даёт правильное BC
        // Точка выше оси X
        double b2c2_up = distance(new double[]{AB, 0}, new double[]{cx, cy});
        // Точка ниже оси X
        double b2c2_down = distance(new double[]{AB, 0}, new double[]{cx, -cy});

        if (Math.abs(b2c2_up - BC) < 1e-9 && Math.abs(cy) > 1e-9) {
            // Есть два варианта: cy и -cy
            // Проверяем, совпадают ли треугольники
            double c1x = cx;
            double c1y = cy;
            double c2x = cx;
            double c2y = -cy;

            // Если треугольники не совпадают (разные координаты C)
            if (Math.abs(c1y - c2y) > 1e-9) {
                // Проверяем, что C2 не совпадает с C1 с точностью до поворота
                System.out.println("NO");
                System.out.printf("%.15f %.15f\n", 0.0, 0.0);
                System.out.printf("%.15f %.15f\n", AB, 0.0);
                System.out.printf("%.15f %.15f\n", cx, -cy);
                return;
            }
        }

        System.out.println("YES");
    }

    static double[] readPoint(BufferedReader br) throws IOException {
        String[] parts = br.readLine().trim().split(" ");
        return new double[]{
                Double.parseDouble(parts[0]),
                Double.parseDouble(parts[1])
        };
    }

    static double distance(double[] p1, double[] p2) {
        double dx = p1[0] - p2[0];
        double dy = p1[1] - p2[1];
        return Math.sqrt(dx*dx + dy*dy);
    }

    static double angleBetween(double[] A, double[] B, double[] C) {
        double ABx = B[0] - A[0];
        double ABy = B[1] - A[1];
        double ACx = C[0] - A[0];
        double ACy = C[1] - A[1];

        double dot = ABx * ACx + ABy * ACy;
        double cross = ABx * ACy - ABy * ACx;

        return Math.toDegrees(Math.atan2(cross, dot));
    }
}

