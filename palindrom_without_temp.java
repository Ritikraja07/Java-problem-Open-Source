
public class PalindromWithoutTemp 
{	 
	static boolean isPalindrome(int n)
	{ 
	
		int divisor = 1;
		while (n / divisor >= 10)
			divisor *= 10;
	
		while (n != 0)
		{
			int leading = n / divisor; 
			int trailing = n % 10;
	
			
			if (leading != trailing) 
				return false;
	
		
			n = (n % divisor) / 10;
	
			
			divisor = divisor / 100;
		}
		return true;
	}
	

	public static void main(String args[])
	{
		if(isPalindrome(1001))
			System.out.println("Yes, it is Palindrome");
		else
			System.out.println("No, not Palindrome");
	} 
}

