public class Stack {
    int[] stack;
    int tos;

    Stack(int size) {
        stack = new int[size];
        tos = -1;
    }

    //Pushes an element to the top of the stack
    public void push(int element) {
        if (tos < stack.length)
            stack[++tos] = element;
        else
            System.out.println("Stack Overflow");
    }

    //Removes and returns the last element in the stack
    public int pop() {
        if (tos > 0){
            int element = stack[tos];
            stack[tos] =0;
            tos--;
            return element;
        }
        else
            System.out.println("Stack Underflow");
        return 0;
    }

    //Displays the stack content
    public void display(){
        System.out.println("Stack Contents: ");
        for(int element:stack){
            System.out.println(element);
        }
        System.out.println();

    }
}
