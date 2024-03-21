import java.util.ArrayList;
import java.util.List;

public class GenericClassExample<T> {
private List<T> values = new ArrayList<>();
 public void add(T value){
     values.add(value);
 }
 public T get(int index){
     return values.get(index);
 }
    public static void main(String args[])
    {
     GenericClassExample gc = new GenericClassExample<>();
     gc.add("hello");
        gc.add(2);
     System.out.println(gc.get(1));
    }
}
