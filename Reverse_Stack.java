import java.util.*;

public class Reverse_Stack {
    //reverse a stack 
    
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // at every level -> upar jate hue element ko remove
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop(); //removing of top
        reverseStack(s); //next call
        pushAtBottom(s, top); //stack insert from bottom
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
public static void main(String[] args) {
    Stack<Integer> s= new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    // 3 2 1
    reverseStack(s);
    printStack(s);
    // 1 2 3 
}
}

