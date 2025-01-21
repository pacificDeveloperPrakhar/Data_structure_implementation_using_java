public class SetOfStringUsingRecursion{
    public int strCount(int index,String str,int ans)
    {

        if(index==0)
        return 1;
        int include=strCount(index-1, str, ans+1);
        int exclude=strCount(index-1, str, ans);
        return include+exclude;

    }
    public static void main(String args[])
    {
       int ans=new SetOfStringUsingRecursion().strCount(2, null, 0);
       System.out.println(ans);
    }
}