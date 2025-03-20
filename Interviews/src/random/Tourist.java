package random;

import java.util.*;

public class Tourist {

    /*
    Question: Compute Restaurant Gains Based on Guest Arrivals and Departures

A restaurant offers an all-you-can-eat buffet, where guests pay when they leave. The restaurant has limited seating (nbSeats), and guests may need to wait in a queue if all seats are occupied.

Rules:
	1.	The restaurant starts empty at the beginning of the day.
	2.	Guests arrive and take a seat if one is available.
	3.	If no seats are available, the guest waits in a queue until a seat is free.
	4.	Guests leave after dining, freeing up a seat and paying their respective amount.
	5.	When a seat is freed, the next guest in line (FIFO order) gets the seat.
	6.	A guest always leaves after they have arrived.
	7.	Compute the total earnings of the restaurant at the end of the day.
    * */
    public Tourist(){

    }

    int computeDayGains(int nbSeats, ArrayList<Integer> payingGuest, ArrayList<Integer> guestMovements){
        int guestCounter = 0;
        int sum = 0;
        Set<Integer> seats = new java.util.HashSet<>();
        Queue<Integer> queueSeat = new LinkedList<>();

        for (int guest : guestMovements) {

            if (!queueSeat.isEmpty() && (nbSeats>guestCounter)){
                seats.add(queueSeat.poll());
            }

            if ((nbSeats>guestCounter) || (seats.contains(guest))){
                if (seats.contains(guest)){
                    seats.remove(guest);
                    guestCounter--;
                    sum += payingGuest.get(guest);
                }
                else{
                    seats.add(guest);
                    guestCounter++;
                }
            }else{
                queueSeat.add(guest);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Tourist tourist = new Tourist();
        System.out.println(tourist.computeDayGains(2, new ArrayList<>(Arrays.asList(10, 20, 30, 40)), new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 1, 2, 3))));
        System.out.println(tourist.computeDayGains(3, new ArrayList<>(Arrays.asList(15, 20, 10)), new ArrayList<>(Arrays.asList(0, 1, 2,0,1,2))));
        System.out.println(tourist.computeDayGains(2, new ArrayList<>(Arrays.asList(25, 30, 20, 15)), new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 1, 2, 3))));
        System.out.println(tourist.computeDayGains(1, new ArrayList<>(Arrays.asList(10, 25)), new ArrayList<>(Arrays.asList(0, 1, 0))));
        System.out.println(tourist.computeDayGains(2, new ArrayList<>(Arrays.asList(30, 40, 20, 25, 35)), new ArrayList<>(Arrays.asList(0, 1, 2, 3, 0, 4, 1, 3, 2, 4))));
        System.out.println(tourist.computeDayGains(3, new ArrayList<>(Arrays.asList(12, 18, 25, 30, 10)), new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 0, 1, 2, 3))));
    }

    //nbSeats = 2
    //payingGuests = [10, 20, 30, 40]  # Guests 0, 1, 2, 3
    //guestMovements = [0, 1, 2, 0, 3, 1, 2, 3]
}
