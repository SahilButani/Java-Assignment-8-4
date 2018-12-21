import java.time.*;
import java.util.*;

public class KYC
{
   public static void main(String ar[])  {
         ArrayList<LocalDate> ld=new ArrayList<>();
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       while(n>0) {
           String s1 = sc.next();
           String s2 = sc.next();
           LocalDate dt_1 = LocalDate.parse(s1);
           LocalDate dt_2 =  LocalDate.parse(s2 );

           if (dt_1.compareTo(dt_2) > 0) {
               ld.add(null);ld.add(null);n--;
              continue;

           }

           LocalDate range=dt_1.withYear(dt_2.getYear());

           LocalDate range1=range.minusDays(30);
           LocalDate range2=range.plusDays(30);

            ld.add(range1);

            if(range2.compareTo(dt_2)>0)
                ld.add(dt_2);
          else
                 ld.add(range2);
          n--;
       }
      for(int i=0;i<ld.size();i++){
         if(i%2!=0){
            if(ld.get(i)==null){
               System.out.println(" RANGE!");
            continue;}
         System.out.println(ld.get(i));
           }
         else{
            if(ld.get(i)==null){
               System.out.print("NO");
            continue;}
            System.out.print(ld.get(i)+" ");
         }
      }
   }
}
