public class LongestCommonSubsequence {
    public static String longestCommonSequence(String str1, String str2, int n, int m, String[][] ans) {
        if (n < 0 || m < 0) return ""; 
        if (n > 0 && ans[n - 1][m] == null) 
            ans[n - 1][m] = longestCommonSequence(str1, str2, n - 1, m, ans);
        if (m > 0 && ans[n][m - 1] == null) 
            ans[n][m - 1] = longestCommonSequence(str1, str2, n, m - 1, ans);
        if (str1.charAt(n) == str2.charAt(m)) 
            ans[n][m] = str1.charAt(n) + "";
        if (ans[n][m] == null) 
            ans[n][m] = "";
        ans[n][m] = ((m > 0 && ans[n][m - 1].length() > (n > 0 ? ans[n - 1][m].length() : 0))
                    ? ans[n][m - 1]
                    : (n > 0 ? ans[n - 1][m] : "")) + ans[n][m];
                    
        return ans[n][m];
    }

    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "appppllple";
        int n = str1.length();
        int m = str2.length();
        String[][] ans = new String[n][m];
        System.out.println(longestCommonSequence(str1, str2, n - 1, m - 1, ans));
    }
}
