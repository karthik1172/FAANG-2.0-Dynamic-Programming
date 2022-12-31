//https://www.geeksforgeeks.org/super-ugly-number-number-whose-prime-factors-given-set/
//https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/super-ugly-number-official/ojquestion
import java.util.*;
public class SuperUglyNumbers {
    static class Pair {
        int prime;
        int pointer;
        int value;

        Pair(int prime, int pointer, int value) {
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }
    }
    public static int superUglyNumber(int[] primes, int n) {
        int[] point = new int[primes.length];
        Arrays.fill(point, 1);

        int[] dp = new int[n+1];
        dp[1] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            return a.value - b.value;
        });

       for(int i=0; i<primes.length; i++) {
           pq.offer(new Pair(primes[i], 1, primes[i] * dp[1]));
       }

        for(int i=2 ; i<= n; ) {
            Pair p = pq.poll();
            if(dp[i-1] != p.value) {
                dp[i] = p.value;
                i++;
            }
            pq.add(new Pair(p.prime, p.pointer+1, p.prime* dp[p.pointer+1]));
        }
        //System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        int[] primes = {3, 5, 7, 11, 13};
        int n = 9;
        System.out.println(superUglyNumber(primes, n));
    }
}
