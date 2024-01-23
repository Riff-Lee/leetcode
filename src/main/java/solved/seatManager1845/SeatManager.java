package solved.seatManager1845;

import java.util.Arrays;

public class SeatManager {
    int[] seats;
    int current;
    int total;
    public SeatManager(int n) {
        seats = new int[n+1];
        Arrays.fill(seats, 1);
        current = 1;
        total = n;
    }

    public int reserve() {
        int res = current;
        seats[current] = 0;
        total--;
        if (total > 0) {
            for (int i = current + 1; i < seats.length; i++) {
                if (seats[i] == 1) {
                    current = i;
                    break;
                }
            }
        } else {
            current = Integer.MAX_VALUE;
        }

        return res;
    }

    public void unreserve(int seatNumber) {
        total++;
        seats[seatNumber] = 1;
        if (current > seatNumber) {
            current = seatNumber;
        }
    }

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(2);
        System.out.println(seatManager.reserve());
        seatManager.unreserve(1);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        seatManager.unreserve(1);
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
    }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */