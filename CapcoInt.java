// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Grapes", "Kewi", "Guawa");
        // first way
        Map<Character, String> map1 = list.stream()
            .collect(Collectors.groupingBy(
            s -> s.charAt(0),
            Collectors.collectingAndThen(
                Collectors.toList(),
                l -> l.get(0)
            )
        ));
        // sec way
        Map<Character,String> map2 = list.stream()
            .collect(Collectors.toMap(
                s -> s.charAt(0),
                s -> s,
                (o,n) -> o
                )
                
        );
        // third way
        Map<Character, String> map3 = new LinkedHashMap<>();
        list.forEach(x -> map3.putIfAbsent(x.charAt(0), x));
        // fourth way
        Map<Character,String> map4 = list.stream()
            .collect(HashMap::new,
            (k,v) -> k.putIfAbsent(v.charAt(0), v), // firstone gets printed
            Map::putAll);
        
        
        // printing
        // map1.forEach((k,v) -> {
        //     System.out.println(k+":"+v);
        // });
        // map2.forEach((k,v) -> {
        //     System.out.println(k+":"+v);
        // });
        map4.forEach((k,v) -> {
            System.out.println(k+":"+v);
        });
    }
}
