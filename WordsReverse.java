import java.util.*;
class WordsReverse {
    public static String reverseWords(String s) {
        Stack<String> words=new Stack<>();
        String word="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' ')
            {   if(!word.isEmpty())
                words.push(word);
                word="";
            }
            else
            {   if(c!=' ')
                word=word+c;
            }
        }
        words.push(word);
        String sentence="";
        sentence=sentence+words.pop();
        while(!words.isEmpty()){
           sentence= sentence+" "+words.pop();
        }
        return sentence;
    }
    public static void main(String args[]){
     String str=reverseWords("  hello sir ");
    System.out.print(str);
    }
}