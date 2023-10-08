package arithmatic;

import java.util.Scanner;

public class complexNo {
	int real,img;
    complexNo(int r,int i){
        this.real=r;
        this.img=i;
    }
    public static complexNo add(complexNo c1,complexNo c2){
        complexNo temp=new complexNo(0,0);
        temp.real=c1.real+c2.real;
        temp.img=c1.img+c2.img;
        return temp;
    }
    public static complexNo sub(complexNo c1,complexNo c2){
        complexNo tem=new complexNo(0,0);
        tem.real=c1.real-c2.real;
        tem.img=c1.img-c2.img;
        return tem;
    }
    public static complexNo multi(complexNo c1,complexNo c2){
        complexNo te=new complexNo(0,0);
        te.real = (c1.real * c2.real) - (c1.img * c2.img);
        te.img = (c1.real * c2.img) + (c1.img * c2.real);
        return te;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter real and imaginary part of 1st no : ");
        int rc1=s.nextInt();
        int cc1=s.nextInt();
        complexNo c1=new complexNo(rc1,cc1);
        System.out.print("Enter real and imaginary part of 2nd no : ");
        int rc2=s.nextInt();
        int cc2=s.nextInt();
        complexNo c2=new complexNo(rc2,cc2);
        complexNo temp=add(c1,c2);
        System.out.println("Sum is: "+ temp.real+" + "+temp.img+"i");
        complexNo tem=sub(c1,c2);
        System.out.println("Subtraction is: "+ tem.real+" + "+tem.img+"i");
        complexNo te=multi(c1,c2);
        System.out.println("Multiplication is: "+ te.real+" + "+te.img+"i");
    }
}

