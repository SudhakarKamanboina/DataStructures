package misc;

import java.util.Stack;

public class MaxStack {

    // Asked in amazon

    public static void main(String[] args) {
        MStack ms = new MStack();
        ms.push(5);
        ms.push(10);
        ms.push(70);
        ms.push(7);
        System.out.println(ms.max());

        ms.pop();
        System.out.println(ms.max());

        ms.pop();
        System.out.println(ms.max());

        ms.push(20);
        System.out.println(ms.max());

        ms.push(20);
        System.out.println(ms.max());

        ms.pop();
        System.out.println(ms.max());
    }
}

class MStack{
    Stack<Integer> stack = new Stack();
    Stack<int[]> maxStack = new Stack();

    public void push(int num){
        stack.push(num);
        if (maxStack.isEmpty() || num > maxStack.peek()[0])
            maxStack.push(new int[]{num, 1});
        else if (maxStack.isEmpty() && num == maxStack.peek()[0]) {
            maxStack.peek()[1]++;
        }
    }

    public int pop(){
        if (!maxStack.isEmpty() && stack.peek() == maxStack.peek()[0]) {
            maxStack.peek()[1]--;
        }

        if (!maxStack.isEmpty() && maxStack.peek()[1] == 0) {
            maxStack.pop();
        }
        return stack.pop();
    }

    public int max(){
        return !maxStack.isEmpty() ? maxStack.peek()[0] : -1;
    }
}
