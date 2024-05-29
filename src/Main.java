import java.util.*;

public class Main {

    public static int maxPointsInsideSquare(int[][] points, String s) {
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(Math.abs(a[0]), Math.abs(b[0]));
        });
        // System.out.println(Arrays.toString(points));
        Set<Character> set = new HashSet<>();
        int max = 0;
        int prevX = 0;
        int prevY = 0;
        int curr = 0;
        for (int idx =0; idx <points.length; idx++){
            int x = points[idx][0];
            int y = points[idx][1];
            if(set.contains(idx)){
                return curr;
            }
            if( idx == points.length - 1 || (Math.max(x,y) != Math.max(points[idx + 1][0], points[idx + 1][1]) && !set.contains(s.charAt(idx))))
            {
                max = curr;
            }
            if(Math.max(x,y) > Math.max(prevX, prevY) && !set.contains(s.charAt(idx))){
                curr = Math.max(x,y);
            }
            set.add(s.charAt(idx));


        }
        return max;
    }

    public static void main(String[] args){
        int[] A = {4, 1, 4, 3, 3, 2, 5, 2};
        int points[][] = {{1,1},{-2,-2},{-2,2}};
        String s = "abb";
        System.out.println(maxPointsInsideSquare(points, s));
//        System.out.println("Total Order");
//        Cars merce = new Cars("Mercedes",50);
//        Cars maruti = new Cars("Maruti-Szuki",20);
//        Cars tata = new Cars("Tata",25);
//        Collection<Cars> cars = List.of(merce,maruti,tata);
//        double totalOrder = totalPrice(cars);
//        System.out.println(totalOrder);
//        ImplementInterface implementInterface = new ImplementInterface();
//        implementInterface.extend();
//        ArrayList<String> c = new ArrayList<>( Arrays.asList("Geeks",
//                "for",
//                "Geeks"));
//        c.replaceAll((element)->element.toUpperCase());
//        c.set(0,"10");
//        String s ="red";
//
//        System.out.println(c);


    }

//    private static double totalPrice(Collection<Cars> cars) {
//       // return cars.stream().mapToDouble(c->c.getPrice()).count();
//    }
}
