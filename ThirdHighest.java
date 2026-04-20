// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.Comparator;
class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .skip(2)
            .findFirst()
            .ifPresent(System.out::println);
    }
}
