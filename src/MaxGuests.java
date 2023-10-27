import java.util.*;

//  1-2,1-3,2-4,2-3

public class MaxGuests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(",");
        List<Pair> guests = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            String[] days = a[i].split("-");
            guests.add(new Pair(Integer.parseInt(days[0]), Integer.parseInt(days[1])));
        }
        System.out.println(findMaxGuestsDay(guests));
    }

    static class Pair {
        public int startDay;
        public int endDay;

        public Pair(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }
    }

    private static int findMaxGuestsDay(List<Pair> guests) {
        Map<Integer, Integer> arrivals = new TreeMap<>();
        Map<Integer, Integer> departures = new TreeMap<>();

        for (Pair pair: guests) {
            arrivals.put(pair.startDay, arrivals.getOrDefault(pair.startDay, 0) + 1);
            departures.put(pair.endDay, departures.getOrDefault(pair.endDay, 0) + 1);
        }

        int maxGuests = 0;
        int current = 0;

        Set<Integer> allDays = new TreeSet<>();
        allDays.addAll(arrivals.keySet());
        allDays.addAll(departures.keySet());
        for (Integer day: allDays) {
            current += arrivals.getOrDefault(day, 0);
            current -= departures.getOrDefault(day, 0);
            maxGuests = Math.max(maxGuests, current);
        }

        return maxGuests;
    }
}
