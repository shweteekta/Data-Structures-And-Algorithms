package Strings;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDistinctSUbsequences {
        public static void main(String args[] ) throws Exception {
            Scanner s = new Scanner(System.in);
            int length = 4; // Use nextLine() after nextInt()
            String str ="aabb";
            //String[] limit = s.nextLine().split(" ");
            char start = 'a';
            char end = 'b';
            int query = 1;
            for(int i=0; i<query; i++){
                String[] substr = s.nextLine().split(" ");
                int slimit = Integer.parseInt(substr[0]);
                int elimit = Integer.parseInt(substr[1]);
                AtomicInteger count = new AtomicInteger(0);
                System.out.println(getTotalDistinctSubstrCount(str.substring(slimit, elimit + 1),start,end, count));
            }
            s.close();
        }

        public static AtomicInteger getTotalDistinctSubstrCount(String str,char start,char end, AtomicInteger count){
            getTotalCount(str,count,start,end,0,new StringBuilder());
            return count;
        }

        public static void getTotalCount(String str, AtomicInteger count, char start, char end, int index, StringBuilder sb){
            if(index == str.length()){
                if(index!=0 && sb.length() >1 && sb.charAt(0) == start && sb.charAt(sb.length()-1) == end){
                    count.incrementAndGet();
                }
                return ;
            }
            //include
            //getTotalCount(str,length,start,end,index+1,count,sb);
            sb.append(str.charAt(index));
            getTotalCount(str,count,start,end,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
            getTotalCount(str,count,start,end,index+1,sb);

        }
    }

