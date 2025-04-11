import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValid(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1)
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "((()";
        int result = longestValid(s);
        System.out.println("Output: " + result);
    }
}
