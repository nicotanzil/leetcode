import java.util.Stack;

public class Solution {

    // In this solution we're going to use a stack to keep track of the pushed
    // elements
    // on each push operation, if we can pop the element from the stack, we pop it
    // we need to keep track of the index of the pushed and popped array
    // if the index of the pushed array is equal to the length of the pushed array
    // and the index of the popped array is equal to the length of the popped array
    // we return true
    // otherwise we return false

    // Time: O(n)
    // Space: O(n)

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();

        int push = 0;
        int pop = 0;

        while (push < pushed.length) {
            s.push(pushed[push]);
            while (pop < popped.length && !s.isEmpty() && s.peek() == popped[pop]) {
                s.pop();
                pop++;
            }
            push++;
        }
        return push == pushed.length && pop == popped.length;
    }
}
