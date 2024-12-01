package assignments.assignment_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Marathon {
    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };

        HashMap<String, Integer> bostonMarathon = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            bostonMarathon.put(names[i], times[i]);
        }

        fastestRunner(bostonMarathon);
        secondFastestRunner(bostonMarathon);
    }

    public static void fastestRunner(HashMap<String, Integer> bostonMarathon) {
        Integer timing = bostonMarathon.values().stream().min(Integer::compareTo).orElseThrow();
        Set<String> runners = getKeys(bostonMarathon, timing);
        System.out.println("The fastest is/are " + runners + " which runs at " + timing + " minutes.");
    }

    public static void secondFastestRunner(HashMap<String, Integer> bostonMarathon) {
        List<Integer> sortTimings = bostonMarathon.values().stream().distinct().sorted().toList();

        if (sortTimings.size() < 2) {
            System.err.println("There is no second-fastest runner.");
            return;
        }
        Integer timing = sortTimings.get(1);
        Set<String> runners = getKeys(bostonMarathon, timing);
        System.out.println("The second fastest is/are " + runners + " which runs at " + timing + " minutes.");
    }

    public static <K, V> Set<K> getKeys(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
} 