package Strings;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while(low<high){
            if(!Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(high))){
                high--;
            }
            else if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)) ){
                return false;
            }
            else {
                low++;
                high--;
            }
        }
        return true;
    }
    public static  void main(String[] args){
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
