/**
 * Created by Varun on 2/7/2017.
 */
public class StringEncoding {
    public static void main(String []args){
        System.out.println(new StringEncoding().encode("aaaabbcc"));
    }

    public String encode(String a){
        if(a.length()<2)
            return a;
        if(a.length()==2)
        {   if(a.charAt(0)==a.charAt(1))
            return a.charAt(0)+"2";
            else return a;
        }
        for(int i=0;i<a.length();i++)
        {
            int c=i+1;
            while(c<a.length()&&a.charAt(c)==a.charAt(i))
            { c++; }
            if(c-i!=1)
            {
                a=a.substring(0,i+1)+(c-i)+a.substring(c);
                i++;
            }
        }

        return a;
    }
}
