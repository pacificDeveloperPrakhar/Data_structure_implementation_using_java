class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        ans[0]=0;
        if(n>=1)
        ans[1]=1;
        if(n<=1)
        {
            return ans;
        }
        for(int i=2;i<=n;i++)
        {
           ans[i]=ans[i&(i-1)]+1;
        }
        return ans;
    }
}