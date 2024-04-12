package Stacks;

public class DecodeStrings {
//    Given an encoded string, return its decoded string.
//    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//    You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//    The test cases are generated so that the length of the output will never exceed 105.
//    Example 1:
//    Input: s = "3[a]2[bc]"
//    Output: "aaabcbc"
public String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    StringBuilder str = new StringBuilder();
    Stack<Integer> countStack = new Stack<>();
    Stack<StringBuilder> strStack = new Stack<>(); // Stack to store intermediate strings

    int index = 0;
    while (index < s.length()) {
        char ch = s.charAt(index);
        if (Character.isDigit(ch)) {
            int value = 0;
            while (Character.isDigit(s.charAt(index))) {
                value = value * 10 + (s.charAt(index) - '0');
                index++;
            }
            countStack.push(value);
        } else if (ch == '[') {
            strStack.push(new StringBuilder(str.toString())); // Store the current intermediate string
            str.setLength(0); // Clear the intermediate string for the next iteration
            index++;
        } else if (ch == ']') {
            int count = countStack.pop(); // Get the count of repetitions
            StringBuilder temp = strStack.pop(); // Get the previous intermediate string
            for (int i = 0; i < count; i++) {
                temp.append(str); // Append the current intermediate string 'count' times
            }
            str = temp; // Update the current intermediate string
            index++;
        } else {
            str.append(ch); // Append characters to the intermediate string
            index++;
        }
    }

    return str.toString(); // Return the decoded string
}
}
