package problems;

import java.io.*;
import java.util.*;

public class AffirmSolution
{
    Stack<String> stack;

    public AffirmSolution()
    {
        stack = new Stack<String>();
    }

    public String lisp(String args[])
    {
        // String[] tokens = new String[]{"(","+","2","(","+","3","2",")",")"};
        for (int i = 0; i < args.length; i++)
        {
            System.out.println(args[i]);
            if (args[i].contains("add"))
            {
                String[] temp = new String[] {
                                String.valueOf(args[i].charAt(0)), "add"
                };
                stack.push(temp[0]);
                stack.push(temp[1]);
            }
            else if (args[i].contains("mult"))
            {
                String[] temp = new String[] {
                                String.valueOf(args[i].charAt(0)), "mult"
                };
                stack.push(temp[0]);
                stack.push(temp[1]);
            }
            else if (args[i].contains(")"))
            {
                String[] temp = new String[] {
                                String.valueOf(args[i].charAt(0)), ")"
                };
                stack.push(temp[0]);
                stack.push(temp[1]);
            }
            else
            {
                stack.push(args[i]);
            }

            if (args[i].contains(")")) Interprete();
        }

        return stack.pop();
    }

    public void Interprete()
    {
        String tok;
        Stack<String> callStack = new Stack<String>();
        tok = stack.pop(); /* This is the ) character */
        while (!(tok = stack.pop()).equals("("))
        {
            callStack.push(tok);
        }
        Call(callStack);
    }

    public void Call(Stack<String> callStack)
    {
        String func = callStack.pop(); /* This is the operator or function */
        if (func.equals("add"))
        {
            double result = Plus(callStack);
            stack.push(String.valueOf(result));
        }
        // if(func.equals("-")) Minus(callStack);
        else if (func.equals("mult"))
        {
            double result = Mult(callStack);
            stack.push(String.valueOf(result));
        }
    }

    public double Plus(Stack<String> callStack)
    {
        double a = Double.parseDouble(callStack.pop());
        double b = Double.parseDouble(callStack.pop());
        System.out.println("Answer is " + (a + b));
        return (a + b);
    }

    public double Mult(Stack<String> callStack)
    {
        double a = Double.parseDouble(callStack.pop());
        double b = Double.parseDouble(callStack.pop());
        System.out.println("Answer is " + (a * b));
        return (a * b);
    }

    public static void main(String args[]) throws Exception
    {
        AffirmSolution obj = new AffirmSolution();

        Scanner scan = new Scanner(System.in);

        String[] args1 = scan.nextLine().split(" ");
        System.out.println(obj.lisp(args1));
    }
}
