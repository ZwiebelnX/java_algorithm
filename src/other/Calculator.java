package other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Title: Calculator</p>
 * <p>Description: 带括号优先级的计算器的java实现</p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Calculator {
    private static Deque<Long> numberStack = new ArrayDeque<>();
    private static Deque<Character> symbolStack = new ArrayDeque<>();

    public static long caculate(String numString) {
        numString = numString.replaceAll(" ", "");

        // 添加“=”为结束标志符
        // 注意equals要比较两个String类型，用charAt取出来的是char所以要进行转换
        if (numString.length() > 1 && !"=".equals(Character.toString(numString.charAt(numString.length() - 1)))) {
            numString += "=";
        }

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < numString.length(); i++) {
            char ch = numString.charAt(i);
            // 是数字则加入数字缓存
            if (ch >= '0' && ch <= '9') {
                temp.append(ch);
            } else {
                String tempStr = temp.toString();
                // 由于运算符只有一位，所以如果temp不为空，那么当前操作字符（串）肯定为数字
                if (!tempStr.isEmpty()) {
                    long num = Long.parseLong(tempStr);
                    numberStack.push(num);
                    temp = new StringBuilder();
                }

                // 注意：ch超前一个运算符
                // comparePri(ch)为false时运算，因为只有超前一个的运算符优先级不高于当前运算符时，当前运算符才允许运算
                while (!comparePri(ch) && !symbolStack.isEmpty()) {
                    long b = numberStack.poll();
                    long a = numberStack.poll();

                    switch (symbolStack.poll()) {
                        case '+':
                            numberStack.push(a + b);
                            break;
                        case '-':
                            numberStack.push(a - b);
                            break;
                        case '*':
                            numberStack.push(a * b);
                            break;
                        case '/':
                            numberStack.push(a / b);
                            break;
                        default:
                            break;
                    }
                }

                if(ch != '='){
                    symbolStack.push(ch);
                    if(ch == ')'){
                        symbolStack.poll();
                        symbolStack.poll();
                    }
                }
            }
        }
        return numberStack.poll();

    }

    // 与栈顶（前一个符号）比较优先级，如果当前运算符比栈顶元素运算符优先级高则返回true，否则返回false
    private static boolean comparePri(char symbol) {
        if (symbolStack.isEmpty()) return true;

        char top = symbolStack.peek();

        if (top == '(') return true;

        switch (symbol) {
            case '(':
                return true;
            case '*':
            case '/':
                return top == '+' || top == '-';
            default:
                return false;
        }
    }

    public static void main(String[] args){
        System.out.println(Calculator.caculate("1 + 2 + ( 3 * 4 + 5 ) / 6"));
    }
}
