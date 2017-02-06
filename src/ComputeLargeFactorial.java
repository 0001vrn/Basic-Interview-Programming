

public class ComputeLargeFactorial {

    public static void main(String []args){
        new ComputeLargeFactorial().compute(100);
    }

    private void compute(int val) {
        int []res = new int[200];
        res[0]=1;
        int k=0;
        int carry=0;
        for(int i=1;i<=val;i++)
        {
            for(int j=0;j<=k;j++)
            {
                int prod=res[j]*i+carry;
                carry=prod/10;
                res[j]=prod%10;
            }
            while(carry>0)    //Propogate the remaining carry to higher order digits
            {
                k++;
                res[k]=carry%10;
                carry/=10;
            }
        }
        for(int i=k;i>=0;i--)
            System.out.print(res[i]);

        System.out.println();


    }
}
