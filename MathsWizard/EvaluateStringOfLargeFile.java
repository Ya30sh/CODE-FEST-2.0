import java.util.Stack;
import java.io.*;
import java.util.Scanner;

public class EvaluateStringOfLargeFile
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
            String fileName = "TMW_large.txt";
            File inputFile = new File(fileName);
            Scanner sc = new Scanner(inputFile);
            String eqaution = new String();
            File outputFile = new File("outputforlargefile.txt");
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
                eqaution = eqaution.replace("eleven","11");
                eqaution = eqaution.replace("twelve","12");
                eqaution = eqaution.replace("thirteen","13");
                eqaution = eqaution.replace("fourteen","14");
                eqaution = eqaution.replace("fifteen","15");
                eqaution = eqaution.replace("sixteen","16");
                eqaution = eqaution.replace("seventeen","17");
                eqaution = eqaution.replace("eighteen","18");
                eqaution = eqaution.replace("nineteen","19");
                eqaution = eqaution.replace("twenty","20");
                eqaution = eqaution.replace("twenty one ","21");
                eqaution = eqaution.replace("twenty two","22");
                eqaution = eqaution.replace("twenty three","23");
                eqaution = eqaution.replace("twenty four","24");
                eqaution = eqaution.replace("twenty five","25");
                eqaution = eqaution.replace("twenty six","26");
                eqaution = eqaution.replace("twenty seven","27");
                eqaution = eqaution.replace("twenty eight","28");
                eqaution = eqaution.replace("twenty nine","29");
                eqaution = eqaution.replace("thirty","30");
                eqaution = eqaution.replace("thirty one","31");
                eqaution = eqaution.replace("thirty two","32");
                eqaution = eqaution.replace("thirty three","33");
                eqaution = eqaution.replace("thirty four","34");
                eqaution = eqaution.replace("thirty five","35");
                eqaution = eqaution.replace("thirty six","36");
                eqaution = eqaution.replace("thirty seven","37");
                eqaution = eqaution.replace("thirty eight","38");
                eqaution = eqaution.replace("thirty nine","39");
                eqaution = eqaution.replace("forty","40");
                eqaution = eqaution.replace("forty one","41");
                eqaution = eqaution.replace("forty two","42");
                eqaution = eqaution.replace("forty three","43");
                eqaution = eqaution.replace("forty four","44");
                eqaution = eqaution.replace("forty five","45");
                eqaution = eqaution.replace("forty six","46");
                eqaution = eqaution.replace("forty seven","47");
                eqaution = eqaution.replace("forty eight","48");
                eqaution = eqaution.replace("forty nine","49");
                eqaution = eqaution.replace("fifty","50");
                eqaution = eqaution.replace("fifty one","51");
                eqaution = eqaution.replace("fifty two","52");
                eqaution = eqaution.replace("fifty three","53");
                eqaution = eqaution.replace("fifty four","54");
                eqaution = eqaution.replace("fifty five","55");
                eqaution = eqaution.replace("fifty six","56");
                eqaution = eqaution.replace("fifty seven","57");
                eqaution = eqaution.replace("fifty eight","58");
                eqaution = eqaution.replace("fifty nine","59");
                eqaution = eqaution.replace("sixty","60");
                eqaution = eqaution.replace("sixty one","61");
                eqaution = eqaution.replace("sixty two","62");
                eqaution = eqaution.replace("sixty three","63");
                eqaution = eqaution.replace("sixty four","64");
                eqaution = eqaution.replace("sixty five","65");
                eqaution = eqaution.replace("sixty six","66");
                eqaution = eqaution.replace("sixty seven","67");
                eqaution = eqaution.replace("sixty eight","68");
                eqaution = eqaution.replace("sixty nine","69");
                eqaution = eqaution.replace("seventy","70");
                eqaution = eqaution.replace("seventy one","71");
                eqaution = eqaution.replace("seventy two","72");
                eqaution = eqaution.replace("seventy three","73");
                eqaution = eqaution.replace("seventy four","74");
                eqaution = eqaution.replace("seventy five","75");
                eqaution = eqaution.replace("seventy six","76");
                eqaution = eqaution.replace("seventy seven","77");
                eqaution = eqaution.replace("seventy eight","78");
                eqaution = eqaution.replace("seventy nine","79");
                eqaution = eqaution.replace("eighty","80");
                eqaution = eqaution.replace("eighty one","81");
                eqaution = eqaution.replace("eighty two","82");
                eqaution = eqaution.replace("eighty three","83");
                eqaution = eqaution.replace("eighty four","84");
                eqaution = eqaution.replace("eighty five","85");
                eqaution = eqaution.replace("eighty six","86");
                eqaution = eqaution.replace("eighty seven","87");
                eqaution = eqaution.replace("eighty eight","88");
                eqaution = eqaution.replace("eighty nine","89");
                eqaution = eqaution.replace("ninety","90");
                eqaution = eqaution.replace("ninety one","91");
                eqaution = eqaution.replace("ninety two","92");
                eqaution = eqaution.replace("ninety three","93");
                eqaution = eqaution.replace("ninety four","94");
                eqaution = eqaution.replace("ninety five","95");
                eqaution = eqaution.replace("ninety six","96");
                eqaution = eqaution.replace("ninety seven","97");
                eqaution = eqaution.replace("ninety eight","98");
                eqaution = eqaution.replace("ninety nine","99");
                eqaution = eqaution.replace("hundred","100");
                eqaution = eqaution.replace("one hundred","100");
                eqaution = eqaution.replace("two hundred","200");
                eqaution = eqaution.replace("three hundred","300");
                eqaution = eqaution.replace("four hundred","400");
                eqaution = eqaution.replace("five hundred","500");
                eqaution = eqaution.replace("six hundred","600");
                eqaution = eqaution.replace("seven hundred","700");
                eqaution = eqaution.replace("eight hundred","800");
                eqaution = eqaution.replace("nine hundred","900");
                eqaution = eqaution.replace("and","+");
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

                String ans = EvaluateStringOfLargeFile.evaluate(parts[0].trim())+"";
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
