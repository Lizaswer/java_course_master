package lrl6.timus;

import java.math.BigInteger;
import java.util.Scanner;

public class task1402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        BigInteger sum = BigInteger.ZERO;
        for (int k = 2; k <= n; k++) {
            // A(n,k) = n! / (n-k)!
            BigInteger permutations = fact.divide(fact(n - k));
            sum = sum.add(permutations);
        }

        System.out.println(sum);
    }


    private static BigInteger fact(int m) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= m; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

