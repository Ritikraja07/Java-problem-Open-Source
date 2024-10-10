import java.util.*;
class PrimeAdam
{
    int m,n; //declaration
    public PrimeAdam()
    {
        m=n=0;
    }
    void input() //input lower and upper range
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter m and n");
        m=sc.nextInt();
        n=sc.nextInt();
    }
    int prime(int no) //check for prime 
    {
        int c=0; //declaration
        for(int i=1;i<=no;i++)
           {
               if(no%i==0)
                 c++;
                }
        return c;
    }
    int adam(int no) //check for adam
    {
        int s=0,p=1,s1=0; //declaration
        while(no>0)
        {
            s=s*10+(no%10);
            no=no/10;
        }
        p=s*s;
        while(p>0)
        {
            s1=s1*10+(p%10);
            p=p/10;
        }
        return s1;        
    }
    void print() //printing prime-adam numbers between m and n
    {
        int c=0; //declaration
        for(int i=m;i<=n;i++)
           {
               if((prime(i)==2) && ((adam(i))==(i*i)))
                  {
                      System.out.print(i+" ");
                      c++;
                    }
                }
        System.out.println();
        System.out.print("FREQUENCY OF PRIME-ADAM INTEGERS IS="+c);
    }
    public static void main()
    {
        PrimeAdam ob=new PrimeAdam(); //creating object ob
        ob.input(); //calling function
        ob.print(); //calling function
    }
}
    
       
    