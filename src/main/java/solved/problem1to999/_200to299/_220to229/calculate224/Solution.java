package solved.problem1to1000._201to300._221to230.calculate224;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {

    public int calculate(String s) {
        s = s.replace(" ","");
        s = s.replace("-(-","+(");

        int minor = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char[] newChars = s.toCharArray();
        int n = chars.length;
        if (chars[0]=='(') {
            stack.add('+');
        }
        for (int i=1;i<n;i++) {
            if (chars[i]=='(' && chars[i-1]=='-') {
                stack.add('-');

                minor++;
            } else {
                if (chars[i]=='+'||chars[i]=='-') {
                    if (minor%2!=0) {
                        newChars[i] = chars[i]=='+' ? '-' : '+';
                    }
                } else if (chars[i]==')') {
                    if (stack.pop()=='-') {
                        minor--;
                    }

                } else if (chars[i]=='(') {
                    stack.add('+');
                }
            }
        }
        int res = 0;
        int i= 0;
        boolean flag = false;
        boolean digitStart = false;
        for (;i<n;i++) {
            if (digitStart&&(newChars[i]=='+'||newChars[i]=='-')) {
                break;
            }
            if (Character.isDigit(newChars[i])) {
                digitStart=true;
                res=res*10+newChars[i]-'0';
            } else if (newChars[i]=='-') {
                flag=true;
            }
        }
        int opr = 0;
        res = flag? -res:res;
        for (;i<n;i++) {
            if (newChars[i]=='+') {
                while (i+1<n&&newChars[i+1]!='+'&&newChars[i+1]!='-') {
                    i++;
                    if (Character.isDigit(newChars[i])) {
                        opr = opr * 10 + newChars[i] - '0';
                    }
                }
                res +=opr;
                opr=0;
            } else if (newChars[i]=='-') {
                while (i+1<n&&newChars[i+1]!='+'&&newChars[i+1]!='-') {
                    i++;
                    if (Character.isDigit(newChars[i])) {
                        opr = opr * 10 + newChars[i] - '0';
                    }
                }
                res -=opr;
                opr=0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("-(-2)+4"));
    }
}



/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */