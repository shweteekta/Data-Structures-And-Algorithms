package Strings;

public class LexSmallStringWithCons {
    public static String getSmallestString(String s, int k) {
        StringBuilder result = new StringBuilder();
        int min = 0;  int sum = 0; boolean flag = false; char res = '0';
        for (char ch: s.toCharArray()){
            int value = ch - 97;
            int i = 0;
            res = ch;
            int temp = k;
            while (true){
                i++;
                k = k - i;
                int newValue = (value + i) % 26;
                char newChar = (char) (newValue + 'a');
                if(k < 0){
                    break;
                }
                if(k == 0){
                    res = newChar;
                    break;
                }
                else {
                    res = newChar;
                }
            }
            result.append(res);
        }
        return result.toString();
    }
    public static void main(String[] args){
        System.out.println(getSmallestString("xaxcd",4));
    }
}
