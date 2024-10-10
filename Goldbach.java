import java.util.*;
class Goldbach
{
    int N; //declaration
    public Goldbach() //default constructor to initialise N
    {
        N=0;
    }
    void input() //to input N
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        N=sc.nextInt();
    }    
    int prime(int n) //to check for prime
    {
        int c=0;
        for(int i=1;i<=n;i++)
           {
               if(n%i==0)
                  c++;
            }        
        return c;
    }    
    void sum()
    {
        if(N%2==0) 
          {
              if(N>9 && N<50)
                {
                   for(int i=3;i<=N/2;i++)
                     {
                         for(int j=3;j<=N;j++)
                            {
                                if(i+j==N && prime(i)==2 && prime(j)==2)
                                  {
                                      System.out.println("Prime pairs are="+i+" "+j); //printing the odd prime pairs
                                    }
                                }
                            }
                        }            
               else
                  System.out.print("Invalid input,Number out of range");
                }
            else
               System.out.print("Invalid input,number is Odd");
    }
    public static void main()
    {
        Goldbach ob=new Goldbach(); //creating object
        ob.input(); //calling
        ob.sum(); //calling
    }
} 