package solution;

/**
 * Created by lakb2_000 on 2014/8/24.
 */
public class Pow {
    public static void main(String[] args){
        Pow pow = new Pow() ;
        System.out.print(pow.pow(1,-13)) ;
    }
    public double pow(double x, int n) {
        double temp=x;
        if(n==0)
            return 1;
        temp=pow(x,n/2);
        if(n%2==0)
            return temp*temp;
        else
        {
            if(n > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }
    }
}
