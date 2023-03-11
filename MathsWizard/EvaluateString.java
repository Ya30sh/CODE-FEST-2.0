import java.util.Stack;
import java.io.*;
import java.util.Scanner;

public class EvaluateString
{
    public static double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        Stack<Double> values = new Stack<Double>();

        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;

            if ((tokens[i] >= '0' && tokens[i] <= '9')||tokens[i]=='.')
            {
                StringBuffer sbuf = new StringBuffer();
                try{
                    while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9') ||tokens[i]=='.')
                        sbuf.append(tokens[i++]);
                }
                catch(Exception e){

                }
                values.push(Double.parseDouble(sbuf.toString()));
            }

            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }


       public static void main(String[] args) {

        try{
            int i = 1;
            String fileName = "TMW_small.txt";
            File inputFile = new File(fileName);
            Scanner sc = new Scanner(inputFile);
            String eqaution = new String();
            File outputFile = new File("output.txt");
            PrintWriter answer = new PrintWriter(outputFile);
            while(sc.hasNext()){
                eqaution = sc.nextLine();
                eqaution = eqaution.replace("one","1");
                eqaution = eqaution.replace("two","2");
                eqaution = eqaution.replace("three","3");
                eqaution = eqaution.replace("four","4");
                eqaution = eqaution.replace("five","5");
                eqaution = eqaution.replace("six","6");
                eqaution = eqaution.replace("seven","7");
                eqaution = eqaution.replace("eight","8");
                eqaution = eqaution.replace("nine","9");
                eqaution = eqaution.replace("ten","10");
                eqaution = eqaution.replace("add","+");
                eqaution = eqaution.replace("substract","-");
                eqaution = eqaution.replace("multiple","*");
                eqaution = eqaution.replace("division","/");
                eqaution = eqaution.replace("plus","+");
                eqaution = eqaution.replace("subtract","-");
                
                eqaution = eqaution.replace("equals","=");

                if(eqaution.indexOf("=")<0){
                    continue;
                }
                String[] parts = eqaution.split("=");

                String ans = EvaluateString.evaluate(parts[0].trim())+"";
                // System.out.print(ans);
                // System.out.print("case"+i+": "+ans.equals(parts[1].trim()));
                // System.out.println("");
                answer.write("case"+i+": "+ans.equals(parts[1].trim()));
                answer.write("\n");
                i++;
            }
            sc.close();
            answer.flush();
            answer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
