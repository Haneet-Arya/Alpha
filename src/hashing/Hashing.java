package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashing {
    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<> () ;
        tickets.put ("Chennai","Bengaluru");
        tickets.put ("Mumbai", "Delhi");
        tickets.put ("Goa", "Chennai");
        tickets.put ("Delhi", "Goa");
        itinerary(tickets);
    }

    // find itinerary from tickets
    public static void itinerary(Map<String, String> map) {
        List<String> to = new ArrayList<>(map.values());
        String start = "";
        for (String e : map.keySet()) {
            if (!to.contains(e)) {
                start = e;
                break;
            }
        }
        System.out.print(start +"->" +map.get(start));
        for (int i = 0; i < map.size()-2;i++) {
            start = map.get(map.get(start));
            System.out.print("->" + start);
        }
    }
}
