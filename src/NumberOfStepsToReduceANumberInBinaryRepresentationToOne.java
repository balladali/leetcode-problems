/*
    Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
 */
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public int numSteps(String s) {
        int carry = 0;
        int operations = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int digit = (s.charAt(i) - '0') + carry;
            if (digit == 1) {
                carry = 1;
                operations += 2;
            } else {
                operations++;
            }
        }
        return operations + carry;
    }
}
