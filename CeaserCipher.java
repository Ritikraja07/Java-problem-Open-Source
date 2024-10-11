import java.util.*;
class CaeserCipher
{
    String s; //declaration
    public CaeserCipher() //default constructor to initialise s
    {
        s="";
    }
    void input() //input text
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter text");
        s=sc.nextLine();
    }
    void encrpyt()
    {
        int L; //declaration
        char ch;
        String s1="";
        L=s.length();
        if(L>3 && L<100)
          {
              for(int i=0;i<L;i++)
                 {
                     ch=s.charAt(i); //character extraction
                     if(ch>='A' && ch<='M' || ch>='a' && ch<='m')
                        s1=s1+(char)(ch+13);
                        else 
                          if(ch>='N' && ch<='Z' || ch>='n' && ch<='z')
                              s1=s1+(char)(ch-13);
                           else 
                              s1=s1+ch;
                        }
              System.out.println("Encrypted text="+s1); //printing
            }
            else
              System.out.print("INVALID LENGTH");
    }
    public static void main()
    {
        CaeserCipher ob=new CaeserCipher(); //creating object ob
        ob.input(); //calling function
        ob.encrpyt(); //calling function
    }
}    
                     
        
       
    
    
    