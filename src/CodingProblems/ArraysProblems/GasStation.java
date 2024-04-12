package ArraysProblems;
//There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
//        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
//        Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
//        Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//        Output: 3
//        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//        Travel to station 4. Your tank = 4 - 1 + 5 = 8
//        Travel to station 0. Your tank = 8 - 2 + 1 = 7
//        Travel to station 1. Your tank = 7 - 3 + 2 = 6
//        Travel to station 2. Your tank = 6 - 4 + 3 = 5
//        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//        Therefore, return 3 as the starting index.
public class GasStation {
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int startIndex = -1;
//        int totalCost = 0; int j;
//        for (int i = 0; i < gas.length; i++) {
//            totalCost = 0 + gas[i];
//            j = (i + 1) % gas.length;
//            while(j != i){
//                totalCost = totalCost - ( j > 0 ? cost[j-1] : cost[cost.length - 1]) + gas[j];
//                if (totalCost < cost[j]){
//                    break;
//                }
//                j = (j + 1) % gas.length;
//            }
//            if ( i == j && cost[j] <= totalCost){
//                startIndex =  i;
//            }
//        }
//        return startIndex;
//    }
public  static int canCompleteCircuit(int[] gas, int[] cost) {
    int totalGas = 0;
    int totalCost = 0;
    int currentGas = 0;
    int startIndex = 0;

    for (int i = 0; i < gas.length; i++) {
        totalGas += gas[i];
        totalCost += cost[i];
        currentGas += gas[i] - cost[i];
        System.out.println(totalGas + " " + totalCost + " " + currentGas + " " + i);
        if (currentGas < 0) {
            currentGas = 0;
            startIndex = i + 1;
        }
    }

    return totalGas >= totalCost ? startIndex : -1;
}

    public static void main(String[] args){
        int[] gas = {1,1,3};
        int[] cost = {2,2,1};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
