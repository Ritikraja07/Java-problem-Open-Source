import java.util.*;
class Armstrong
{
   public static void main(String args[])
	 {
	    Scanner sc=new Scanner(System.in);
		  System.out.println("Enter a no.:");
		  int a=sc.nextInt();
		  int r,sum=0,temp;
		  temp=a;
		  while(a>0)
		  {
		     r=a%10;
	       sum=(r*r*r)+sum;
		     a=a/10;
		  }
		  if(temp==sum)
		  {
		     System.out.println("Armstrong no.");
		  }
		  else
		  {
		     System.out.println("not an armstrng no.");
		  }   
	 }
}
