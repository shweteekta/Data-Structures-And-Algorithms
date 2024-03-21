package Strings;

public class MinimumLenStringAfterDelete {
    public int minimumLength(String s) {
        int low = 0;
        int high = s.length() - 1;
        while ((low < high) && s.charAt(low) == s.charAt(high)){
            char current = s.charAt(low);
            while(low <= high && s.charAt(low) == current){
                low++;
            }
            while(low <= high && s.charAt(high) == current){
                high--;
            }
        }
        return high - low + 1;
    }
}
   