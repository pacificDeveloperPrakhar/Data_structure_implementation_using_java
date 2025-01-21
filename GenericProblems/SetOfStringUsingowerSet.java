public class SetOfStringUsingowerSet {
    public void solution(String str)
    {
        for(int i=(1<<str.length());i>=0;i--)
        {
            int p=i;
            int j=0;
            while(p>0&&j<str.length())
            {
                if((p&1)==1)
                System.out.print(str.charAt(j));
                j++;
                p=p>>1;
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        new SetOfStringUsingowerSet().solution("hello");
    }
}
