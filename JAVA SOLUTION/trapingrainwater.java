//import java.util.*;
public class trapingrainwater {
    public static int Trappedwater(int height[]){
        int n=height.length;
        int maxleftheight[]= new int[n];
        // calculate left max  boundary -array
        maxleftheight[0]=height[0];
        for(int i=1;i<n;i++){
            maxleftheight[i]=Math.max(height[i], maxleftheight[i-1]);

        }
        //calculate right max boundary aaray
        int maxrightheight[]= new int[n];
        maxrightheight[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            maxrightheight[i]=Math.max(height[i], maxrightheight[i+1]);
        }
       int trappedwater=0;
       //calculate trapped water
         for(int i=1;i<n;i++){
            //calculate waterlevel
            int waterlevel=Math.min(maxleftheight[i], maxrightheight[i]);
            trappedwater+=waterlevel - height[i];
         }
         return trappedwater;
    }
     
    public static void main(String args[]){
        int height[]={0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
      System.out.print(Trappedwater(height));
    }
}
