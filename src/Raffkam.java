import java.util.Arrays;

/**
 * Created by DIPAK on 4/1/2017.
 */
public class Raffkam
{

    public static void main(String[] args)
    {

        double a[]={5,7.5,4,6,5};
        double sum=0;

        for (int i = 0; i < a.length ; i++)
        {

            sum=sum + a[i]/a.length;
        }
        System.out.println("Total average value:"+sum);




    }


}
