public class SumOfPrime {
    public static void main(String[] args) {
        int sum=0;
        for(int i=2;i<10;i++){
            int num=i;
            int count=0;
            for(int j=1;j<=num;j++){
                if(num%j==0){
                    count++;
                }
            }
            if(count==2) sum+=num;
        }
        System.out.println(sum);
    }
}
