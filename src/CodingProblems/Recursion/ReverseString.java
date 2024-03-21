package Recursion;

public class ReverseString {
    public static String reverse(String s) {

        if(s.equals("")) return s;

        return reverse(s.substring(1)) + s.charAt(0);
    }
    public static void main(String[] args) {
        System.out.println(reverse("shweta"));
    }
}
