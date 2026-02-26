import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> calendar;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        // 1. Check if the new interval intersects with any existing DOUBLE-booked zone
        for (int[] interval : overlaps) {
            // Overlap condition: max(s1, s2) < min(e1, e2)
            if (Math.max(startTime, interval[0]) < Math.min(endTime, interval[1])) {
                return false; // Adding this would create a triple booking
            }
        }

        // 2. If safe from triple booking, find new double-bookings
        // Compare with every single-booked event already in the calendar
        for (int[] event : calendar) {
            if (Math.max(startTime, event[0]) < Math.min(endTime, event[1])) {
                // Calculate the intersection and add it to the 'overlaps' list
                int overlapStart = Math.max(startTime, event[0]);
                int overlapEnd = Math.min(endTime, event[1]);
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        // 3. Finally, add the event to the primary calendar
        calendar.add(new int[]{startTime, endTime});
        return true;
    }
}
