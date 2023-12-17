import java.util.*;

public class CCC {
    static final long MOD = (long)1e9 + 7;

    public static List<Long> primeFactorization(long x) {
        List<Long> answer = new ArrayList<>();
        long i = 2;
        while (i * i <= x) {
            if (x % i == 0) {
                answer.add(i);
                while (x % i == 0) x /= i;
            }
            i += 1;
        }
        if (x > 1) answer.add(x);
        return answer;
    }

    public static long main(long X, long N) {
        long answer = 1;
        List<Long> xPrimes = primeFactorization(X);
        for (long prime : xPrimes) {
            long power = 0;
            long factor = prime;
            while (factor <= N) {
                System.out.println(factor);
                power += N / factor;
                if (factor <= Long.MAX_VALUE / prime) {
                    factor *= prime;
                } else {
                    break;
                }

            }
            answer *= pow(prime, power, MOD);
            answer %= MOD;
        }
        return answer;
    }

    public static long pow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long n = scanner.nextLong();
        System.out.println(main(x, n));
    }
}