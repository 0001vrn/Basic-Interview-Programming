import java.util.EmptyStackException;
import java.util.Stack;


public class AddLargeNumbers {
    public static void main(String args[]){
        AddLargeNumbers obj = new AddLargeNumbers();
        obj.addUsingStrings("9999","9999");
        int []a = {9,9,9,9};
        int []b = {9,9,9,9};
        obj.addUsingArrays(a,b);

        Stack<Integer> s1 = new Stack<>();
        s1.push(9);
        s1.push(9);
        s1.push(9);
        s1.push(9);

        Stack<Integer> s2 = new Stack<>();
        s2.push(9);
        s2.push(9);
        s2.push(9);
        s2.push(9);
        obj.addUsingStack(s1,s2);
    }

    private void addUsingStack(Stack<Integer> s1, Stack<Integer> s2) {
    Stack<Integer> res = new Stack<>();
    int carry=0,sum;
    while(!s1.empty() || !s2.empty()){

        try {
            sum = (s2.peek() + s1.peek() + carry )%10;
            carry = (s2.peek() + s1.peek() + carry )>=10?1:0;
            s1.pop();
            s2.pop();
            res.push(sum);
        }
        catch (EmptyStackException e){

        }

    }
    res.push(carry);

    while (!res.empty()) {

        System.out.print(res.peek());
        res.pop();
    }
    System.out.println();


    }


    private void addUsingArrays(int[] a, int[] b) {
        int max=a.length>b.length?a.length:b.length;
        //int min=a.length>b.length?b.length:a.length;

        int []sum = new int[max+1];
        int carry=0;

        for(int i=0;i<max;i++)
        {
            try
            {
                sum[i] = (a[a.length - 1 - i] + b[b.length - 1 - i] + carry) % 10;
                carry = (a[a.length - 1 - i] + b[b.length - 1 - i] + carry) >= 10 ? 1 : 0;
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                try{
                    sum[i]=(a[a.length-1-i]+carry)%10;
                    carry = (a[a.length-1-i]+carry)>=10?1:0;
                }
                catch (ArrayIndexOutOfBoundsException ex){

                    try{
                        sum[i]=(b[b.length-1-i]+carry)%10;
                        carry = (b[b.length-1-i]+carry)>=10?1:0;
                    }
                    catch (ArrayIndexOutOfBoundsException exx){

                    }
                }
            }
        }

        sum[max]=carry;

        for (int i=max;i>=0;i--)
            System.out.print(sum[i]);
        System.out.println();

    }

    private void addUsingStrings(String a, String b) {

        int max=a.length()>b.length()?a.length():b.length();
        int min=a.length()>b.length()?b.length():a.length();

        String pad="";

        for(int i=0;i<max-min;i++)
            pad+="0";

        if(a.length()<b.length())
            a=pad+a;
        else b = pad+b;

        String sum="";
        int carry=0;

        for(int i=0;i<max;i++)
        {
            sum+=(a.charAt(a.length()-1-i)+b.charAt(b.length()-1-i)-96+carry)%10;
            carry = (a.charAt(a.length()-1-i)+b.charAt(b.length()-1-i)-96+carry)>=10?1:0;
        }
        sum+=carry;

        for(int i=sum.length()-1;i>=0;i--)
            System.out.print(sum.charAt(i));
        System.out.println();

    }
}
