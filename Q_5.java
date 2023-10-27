public class Q_5{
    public static void main(String args[])
    {
        int fl1=0;
        int fl2=0;
        int p[]=new int[101];
        p[0]=0;
        p[1]=0;
        for(int i=2;i<=100;i++){
            fl2=0;
            for(int j=2;j<i;j++)
            {
                if(i%j==0){
                    fl2=1;
                    break;
                }
            }
            if(fl2==0)
            {
                p[i]=1;
            }
            else{
                p[i]=0;
            }
        }
        int num=0;
        while(num<=100){
            if((p[num]==1)&&(p[num+2]==1))
            {
                int d=num+2;
                System.out.print("("+num+", "+d+")\n");
                num+=2;
            }
            else{
                num++;
            }
        }
    }
}
