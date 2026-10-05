package Practice;
import genericUtility.JavaUtility;
public class JavaUtilityPractice {
public static void main(String[] args) {
	
	JavaUtility jutil=new JavaUtility();
	String value=jutil.getCalenderDetails("dd-MM-YY");
	System.out.println(value);
	String value1=jutil.getCalenderDetails("dd-MM-YY hh-mm-ss");
	System.out.println(value1);
	int number=(int)(Math.random()*9999);
	System.out.println(number);
	int num=jutil.generateRandomNumber(10000);
	System.out.println(num);
}
}
