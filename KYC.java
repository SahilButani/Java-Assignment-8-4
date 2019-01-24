/*
Gruber Healthcare has different types of forms for their customer, one of which is a know your customer form ( KYC ) which has to be filled annually. Each form has a date which signifies the date the form was filled called the form date.

Due to government regulations the KYC form can only be filled within + or - 30 days of the signup anniversary of a customer. When filling it up, you have to provide the form date. If you are past the +-30 day anniversary then you can back-date it so that it falls in the +-30-day window. When filling it up you cannot use a future date for the form date.

For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014, my window for KYC submission this year would be 30 Jan 2017 to 31 Mar 2017. Since it is already 4th Apr - I would have to back-date the KYC to a date in this range.

Note: The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
Anniversary refers to same day and month every year. If your birthday is 01-02-1992 -then your first anniversary will be 01-02-1993, the 2nd will be 01-02-1994 and so on. 01-02-1992 is not an anniversary.

 Given the signup date and the current date, provide the allowable date range for the form date.



Input  -  First line is an integer n as the number of inputs to be passed. Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy    Each line has two dates separated by space where the first date in signup date and the second date is the current date.

Output  -  Range of dates for KYC form in format    dd-mm-yyyy dd-mm-yyyy

 Assignment:

1. Read the above problem statement.

2. Keeping in mind the given problem statement, go through the below code, identify and list down the issues in the code.

3. Rectify/correct the found issues and rewrite the correct code.

4. Submit the modified code for evaluation along with listed issues(which you have found in the existing code)


*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class GruberHealthCareKYC {

  /**
   * rangeOfFormFillingDate takes input parameter as numberofinputs and gives
   * the range of form filling dates.
   * @param numberofinputs takes input from user where it indicates how many
   * times user wants to give input.
   */
    public static void rangeOfFormFillingDate(int numberofinputs){
      Scanner sc=new Scanner(System.in);
      for(int i=0 ; i<numberofinputs ;i++) {
        System.out.println("Enter signup date:");
          String signup_date_in_string = sc.next();
          System.out.println("Enter current date:");
          String current_date_in_string = sc.next();
          DateTimeFormatter formatter_1=DateTimeFormatter.ofPattern("dd-MM-yyyy");
          LocalDate signup_date = LocalDate.parse(signup_date_in_string,formatter_1);
          LocalDate current_date = LocalDate.parse(current_date_in_string,formatter_1);

          LocalDate current_anniversary_date = LocalDate.of(current_date.getYear(),signup_date.getMonth(),signup_date.getDayOfMonth());
          LocalDate start_date = current_anniversary_date.minusDays(30);
          LocalDate end_date = current_anniversary_date.plusDays(30);
          printRange(signup_date, current_date, start_date, end_date);


      }

    }
    /**
     * printRange prints the range according to the signup date and current_date.
     */
    public static void  printRange(LocalDate signup_date,LocalDate current_date, LocalDate start_date, LocalDate end_date){
      if (signup_date.compareTo(current_date) > 0) {
        System.out.println("NO RANGE");
        return;
      }
      System.out.print(start_date+" ");

     if(end_date.compareTo(current_date)>0)
          System.out.print(current_date);
     else
          System.out.println(end_date);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of inputs:");
        int numberofinputs=sc.nextInt();
        rangeOfFormFillingDate(numberofinputs);

    }
}

/*

 Test Input

5

16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016


Test output

16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016

*/
