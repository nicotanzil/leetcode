import java.util.Stack;

public class Solution {

    // This is a stack problem.
    // The idea is to use a stack to keep track of the opening brackets.
    // If we encounter a closing bracket, we check if the top of the stack is the
    // corresponding opening bracket.
    // If it is, we pop the stack.
    // If it is not, we return false.
    // If we encounter a closing bracket and the stack is empty, we return false.
    // If we have reached the end of the string and the stack is empty, we return
    // true.

    // Time: O(n)
    // Space: O(n)

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                else if (stack.peek() == '(' && c != ')')
                    return false;
                else if (stack.peek() == '{' && c != '}')
                    return false;
                else if (stack.peek() == '[' && c != ']')
                    return false;

                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
