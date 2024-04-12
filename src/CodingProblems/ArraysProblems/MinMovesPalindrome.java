package ArraysProblems;

public class MinMovesPalindrome {
//    Check if the character in start and end index are same if yes then decrease the end by 1 and increase the start by 1
//    Otherwise search for the character similar to the starting index by decrementing the end
//    If it is seen that on decrementing the end it points to same index as start then swap the character with the character in the next index and increment the ans count
//    Otherwise check the last index pointer is less than the ending indx if yes then increase it as well as increase the ans and keep on swapping the last index pointer with its next position.
//
//
//    You are given a string s consisting only of lowercase English letters.
//    In one move, you can select any two adjacent characters of s and swap them.
//    Return the minimum number of moves needed to make s a palindrome.
//    Note that the input will be generated such that s can always be converted to a palindrome.
      public static int minMovesToMakePalindrome(String s) {
            int moves  = 0;
            int low= 0;
            int high = s.length()-1;
            char ch[] = s.toCharArray();
            while(low < high){
                if (ch[low] == ch[high]){
                    low++;
                    high--;
                    continue;
                }
                int r = high;
                while (ch[low] != ch[r]){
                    r--;
                }
                if(r == low){
                    swap(ch,low,low+1 );
                    moves++;
                }
                else {
                    while (r < high){
                        swap(ch, r, r+1);
                        r++;
                        moves++;
                    }
                }
            }
            return moves;
        }
        private static void swap (char[] array,int i, int j){
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        public static void main(String[] args){
            String s = "letelt";
            System.out.println(minMovesToMakePalindrome(s));
        }
    }

