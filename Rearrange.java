import java.util.*;

public class Rearrange{

    //creating scanner object to take input
    static Scanner sc = new Scanner(System.in);

    //Declaring instance/class variables
    static String wrd , newwrd;

    //Default constructor
    Rearrange(){
        wrd = "";
        newwrd = "";
    }

    //Function to accept the word from user.
    void readword(){
        System.out.println("Enter Any Word : ");
        wrd = sc.next();
        wrd = wrd.trim().toUpperCase();
    }

    //to calculate the freqeuncy of vowels and consonants in given input/word
    void freq_vow_con(){
        char c;
        int v=0 , co = 0;
        for( int i = 0 ; i<wrd.length() ; i++ ){
            c = wrd.charAt(i);
            if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                v++;
            else
                co++;
        }

        System.out.println("Frequency of vowel :: "+v);
        System.out.println("Frequency of consonants :: "+co);
    }

    //arranging the word by bringing vowel at begining and consonants at last.
    void arrange(){
        char c;
        String v="" , co ="";
        for(int i=0 ; i<wrd.length() ; i++ ){
            c=wrd.charAt(i);
            if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
                v += c;
            else
                co += c;
        }

        newwrd = v+co;

    }

    //Function to display the original as well as arranged word.
    void display(){
        System.out.println("Original word :: "+wrd);
        System.out.println("New Arranged Word :: "+newwrd);
    }

    //Main Function
    public static void main(String[] args) {
        Rearrange obj = new Rearrange();
        obj.readword();
        obj.freq_vow_con();
        obj.arrange();
        obj.display();
    }

}
