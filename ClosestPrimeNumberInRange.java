import java.util.*;
/*
time complexity: O(n)
space complexity: O(n)
 */
public class ClosestPrimeNumberInRange {
    public int[] closestPrimes(int left, int right) {
        boolean isprime[] = sieve(right);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isprime[num]) {
                list.add(num);
            }
        }
        if (list.size() < 2) return new int[]{-1, -1};

        int mindiff = Integer.MAX_VALUE;
        int res[] = new int[2];
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff < mindiff) {
                mindiff = diff;
                res[0] = list.get(i - 1);
                res[1] = list.get(i);
            }
        }
        return res;
    }

    public boolean[] sieve(int right) {
        boolean checkprime[] = new boolean[right + 1];
        Arrays.fill(checkprime, true);

        if (right >= 0) checkprime[0] = false;
        if (right >= 1) checkprime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (checkprime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    checkprime[j] = false;
                }
            }
        }
        return checkprime;
    }
}
