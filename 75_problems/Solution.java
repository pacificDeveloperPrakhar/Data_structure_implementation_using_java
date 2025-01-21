public class Solution{
    public int findLongestSubsequence(int[] nums,int[] ans,int k)
{
    if(k<0)
    return 0;
    if(k==0)
    return 1;
    int prev=k;
    while(prev>=0&&nums[prev]>nums[k])
    prev--;
    if(ans[prev]==0)
    ans[prev]=findLongestSubsequence(nums, ans, prev)
    ans[k]=ans[prev]+1;
    return ans[k];

}
}