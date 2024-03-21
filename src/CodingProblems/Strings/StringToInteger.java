package Strings;
//Read in and ignore any leading whitespace.
//        Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//        Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
//        Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//        If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//        Return the integer as the final result.
public class StringToInteger {
    public static long  myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int number = 0;
        int sign = 1;
        int index = 0;
        while(index < s.length() && s.charAt(index) == ' '){
            index++;
        }
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
            index++;
        }
        return number * sign;
    }
    public static  void main(String[] args){
        String  s = "-2147483648";
        System.out.println(myAtoi(s));
    }
}
