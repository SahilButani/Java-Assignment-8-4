import java.time.*;
import java.util.*;

public class KYC
{
   public static void main(String ar[])  {

       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       while(n>0) {
           String s1 = sc.next();
           String s2 = sc.next();
           LocalDate dt_1 = LocalDate.parse(s1);
           LocalDate dt_2 =  LocalDate.parse(s2 );

           if (dt_1.compareTo(dt_2) > 0) {
               System.out.println("No Range");
               System.exit(0);

           }

           LocalDate range=dt_1.withYear(dt_2.getYear());

           LocalDate range1=range.minusDays(30);
           LocalDate range2=range.plusDays(30);

            System.out.println(range1);

            if(range2.compareTo(dt_2)>0)
                System.out.println(dt_2);
            else
                System.out.println(range2);
       n--;
       }//04-05-2017 04-04-2017s
   }
}
