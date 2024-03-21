package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        char fromRod = 'A';
        char toRod = 'C';
        char auxRod = 'B';

        System.out.println("Steps to solve Tower of Hanoi with " + n + " disks:");
        towerOfHanoi(n, fromRod, toRod, auxRod);
    }

    public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }

        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }
}
