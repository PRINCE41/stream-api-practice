import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Grapes", "Kewi", "Guawa");
        Map<Character, String> map = list.stream()
        .collect(Collectors.groupingBy(
        s -> s.charAt(0),
        Collectors.collectingAndThen(
            Collectors.toList(),
            l -> l.get(0)
        )
    ));
    map.forEach((k,v) -> {
        System.out.println(k+":"+v);
    });
    map.entrySet().stream()
        .findFirst()
        .ifPresent(System.out::println);
    }
}
