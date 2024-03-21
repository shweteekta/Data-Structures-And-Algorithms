package LambdaReverseString;

public class LambdaReverseString {
    public static void main(String[] args) {
        ReverseString reverse = (str) -> {
            StringBuilder result = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                result.append(str.charAt(i));
            }
            return result.toString();
        };
        System.out.println(reverse.doReverse("Hello"));
    }
}