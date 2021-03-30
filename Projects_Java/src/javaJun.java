package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class FlightBuilder {
    static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                //A normal flight with two hour duration
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                //A normal multi segment flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                //A flight departing in the past
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                //A flight that departs before it arrives
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                //A flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                //Another flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}

class Flight {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}

class Segment {
    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }

    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}

class Filter
{
    FlightBuilder flights = new FlightBuilder();
     List<Flight> fl1 = flights.createFlights();
    public List<Flight> filter1() {
    List<Flight> filter = new ArrayList<>();
    for (int i = 0; i < fl1.size(); i++) {
        if (LocalDateTime.now().isAfter(fl1.get(i).getSegments().get(0).getDepartureDate()) == false)
            filter.add(fl1.get(i));
    }
    return (filter);
    }
    public List<Flight> filter2() {
        List<Flight> filter2 = new ArrayList<>();
        for (int i = 0; i < fl1.size(); i++)
        {
            int flag = 0;
            for (int j = 0; j <fl1.get(i).getSegments().size(); j++) {
                if (fl1.get(i).getSegments().get(0).getArrivalDate()
                        .isBefore(fl1.get(i).getSegments().get(0).getDepartureDate()) == true)
                    flag++;
            }
            if (flag == 0)
                filter2.add(fl1.get(i));
        }
        return (filter2);
    }
    public List<Flight> filter3() {
        List<Flight> filter3 = new ArrayList<>();
        for (int i = 0; i < fl1.size(); i++)
        {
            int sum = 0;
            for (int j = 0; j <fl1.get(i).getSegments().size() - 1; j++) {
                if (fl1.get(i).getSegments().get(j).getArrivalDate().getDayOfYear() <
                        fl1.get(i).getSegments().get(j + 1).getDepartureDate().getDayOfYear()) {
                    sum += 24 - fl1.get(i).getSegments().get(j).getArrivalDate().getHour()
                            + fl1.get(i).getSegments().get(j + 1).getDepartureDate().getHour();
                } else {
                    sum += fl1.get(i).getSegments().get(j + 1).getDepartureDate().getHour() -
                            fl1.get(i).getSegments().get(j ).getArrivalDate().getHour();
                }
            }
            if (sum <= 2)
                filter3.add(fl1.get(i));
        }
        return (filter3);
    }
}

public class javaJun{
    public static void main(String[] args) {
        FlightBuilder flights = new FlightBuilder();
        List<Flight> fl1 = flights.createFlights();
        Filter filter4 = new Filter();
        System.out.println(fl1);
        System.out.println(filter4.filter1());
        System.out.println(filter4.filter2());
        System.out.println(filter4.filter3());
    }
}