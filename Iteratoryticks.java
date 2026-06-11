import java.util.*;

public class Iteratoryticks {
    public static String getStart(HashMap<String,String> tick){
        HashMap<String, String> revMap= new HashMap<>();
        for(String key: tick.keySet()){
            revMap.put(tick.get(key),key);
        }
        for(String key:tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    
    public static void main(String[] args){
        HashMap<String, String> tickets= new HashMap<>();
        tickets.put("chennai","bengalru");
        tickets.put("Mumbai","Delhi");
        tickets.put("goa","chennai");
        tickets.put("Delhi","goa");
        String start=getStart(tickets);

        while(tickets.containsKey(start)){
            System.out.print(start +"->");
            start=tickets.get(start);
        }
        System.out.print(start);

    }
    
}
