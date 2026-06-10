import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Hashmap {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Delhi", 120);
        map.put("Nagpur", 30);
        map.put("China", 90);

        System.out.println(map);

        map.remove("China");
        System.out.println(map);

        if (map.containsKey("Nagpur")) {
            System.out.println("Key present in the map");
        } else {
            System.out.println("Key does not exist in the map");
        }

        int[] arr = {1, 2, 3, 4};

        for (int val : arr) {
            System.out.println(val);
        }

        // Iterate through HashMap
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() +"->"+e.getValue());
            
        }
        Set<String> keys= map.keySet();
        for(String key: keys){
            System.out.println(key+ "->"+map.get(key));
        }
    }
}