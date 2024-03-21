package streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1,4,3,2, 4,5,-5);
        List<String> integers2 = Arrays.asList("hello","red");

        Stream<Integer> integerStream
                = Stream.of(1,2,3,4);
        System.out.println(integers);
        // fnd sum using reduce
        int sum = integers.stream()
                .reduce(0, Integer::sum);
        int min = integers.stream().min(Integer::compareTo).get();
        System.out.println("min" + min);
        // Sort in descending order
//        Arrays.sort(nums, Comparator.reverseOrder());
//        var one = integers.stream().map((x) -> x*x).collect(Collectors.toList());
//        one.stream().forEach((x) -> System.out.println(x));
//
//
//        var two = integers.stream().map((x) -> {
//            return "some string";
//        }).collect(Collectors.toList());
//        two.stream().forEach((x -> System.out.println(x)));


//        var three = integers.stream().distinct().collect(Collectors.toList());
//        three.stream().forEach((x)->System.out.println(x));

        var four = integers.stream().dropWhile(x -> (x < 0)).collect(Collectors.toList());
        //four.stream().forEach((x)->System.out.println(x));
        integers.stream().filter(x -> x%2 == 0).map(x -> x * 3).distinct().sorted((a,b) -> Integer.compare(b,a)).forEach(System.out::println);
        integers2.stream().map(String :: toUpperCase).forEach(System.out::println);
        Runnable	java8Runner	=	()	->	{
            System.out.println("I	am	running");	};
        java8Runner.run();

//        Collections.sort(charList, (a, b) -> {
//            int freqCompare = map.get(b) - map.get(a);
//            if (freqCompare == 0) {
//                return a - b; // Sort alphabetically when frequencies are equal
//            }
//            return freqCompare;
//        });

//        Comparator<Pair<Integer, String>> comparator = (pair1, pair2) -> pair1.getValue().compareTo(pair2.getValue());
//        // Priority queue with custom comparator
//        PriorityQueue<Pair<Integer, String>> pq = new PriorityQueue<>(comparator);
    }
}
