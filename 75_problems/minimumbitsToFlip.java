class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;

        while (a > 0 || b > 0 || c > 0) {
            int ai = a & 1;
            int bi = b & 1;
            int ci = c & 1;

            if ((ai | bi) != ci) {
                if (ci == 0) {
                    count += (ai + bi);
                } else {
                    count++;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return count;
    }
}
