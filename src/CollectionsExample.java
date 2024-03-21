import java.util.*;

public class CollectionsExample {

    public CollectionsExample() {
        ArrayList<String> c = new ArrayList<>( Arrays.asList("Geeks",
                "for",
                "Geeks"));
        c.replaceAll((element)->element.toUpperCase());
        System.out.println(c);

    }
    public static void main(String[] args) {

        List<Cars> c= new ArrayList<Cars>();
//     int[] ints = Arrays.stream(sc1.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt).toArray();
//        c.add(new Cars("honda",12));
//        c.add(new Cars("Access",10));
//        c.add(new Cars("Activa",20));
//        c.stream().sorted((x,y) -> Integer.compare(y.getPrice(), x.getPrice())).forEach((x) -> System.out.println(x.getPrice() +" "+ x.getName()));
//
//
//        System.out.println("Cars");
//        ListIterator<Cars> i = c.listIterator();
//        while(i.hasNext()){
//            Cars C = i.next();
//            System.out.print(C.getName()+" "+C.getPrice());
//
//        }

    }
}
