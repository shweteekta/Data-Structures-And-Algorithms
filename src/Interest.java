import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Interest {

    static ArrayList<Integer> Ostart = new ArrayList<Integer>();
    static ArrayList<Integer> Oend = new ArrayList<Integer>();
       static void findIntersection(int intervals[][], int N)
        {


            int l = intervals[0][0];
            int r = intervals[0][1];


            for (int i = 1; i < N; i++)
            {


                if (intervals[i][0] > r ||
                        intervals[i][1] < l)
                {
                    //System.out.println(-1);
                    return;
                }


                else
                {
                    l = Math.max(l, intervals[i][0]);
                    r = Math.min(r, intervals[i][1]);
                }
            }
            Ostart.add(l);
            Oend.add(r);
            System.out.println ("[" + l +", " + r + "]");
        }
        public static void main(String[] args) {
            int n;
            int totalAmount = 0;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the Amount: ");
            int amount = sc.nextInt();
            System.out.print("Enter the number of conditions: ");
            n=sc.nextInt();
            int[] rate = new int[n+1];
            int[] startDate = new int[n+1];
            int[] endDate = new int[n+1];

            System.out.println("Enter the rate of the loan: ");
            for(int i=0; i<n; i++)
            {
                rate[i]=sc.nextInt();
            }
            System.out.println("Enter the  start date  of the loan: ");
            for(int i=0; i<n; i++)
            {
                startDate[i]=sc.nextInt();
            }
            System.out.println("Enter the end date of the loan: ");
            for(int i=0; i<n; i++)
            {
                endDate[i]=sc.nextInt();
            }
            System.out.print("Enter the z: ");
            int z=sc.nextInt();
            int sDay = Integer.MAX_VALUE;
            int eDay = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){

                if(startDate[i] < sDay) {
                    sDay = startDate[i];
                }
                if (endDate[i] > eDay) {
                    eDay = endDate[i];
                }
            }
            int totalDays = (eDay - sDay) + 1 ;
            int currentRate;
            System.out.println(totalDays);
            for(int i=0; i<n; i++)
            {
                if (startDate[i]<startDate[i+1] && startDate[i+1]<endDate[i]){
                    if (rate[i]<z){
                        currentRate = rate[i];

                    }
                    else{
                        currentRate = z;
                    }
                    //int interest = (amount * (startDate[i+1]-startDate[i]) * currentRate)/365;
                    
                }

            }

            int intervals[][] = {{10,20},
                    {15,25},
            };
            int N = intervals.length;
            findIntersection(intervals, N);

        }
    }

