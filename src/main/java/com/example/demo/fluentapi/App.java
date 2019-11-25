package com.example.demo.fluentapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

    private static LocalDateTime dateTime = LocalDateTime.of(2019, 5, 1, 0, 0);

    public static void main(String[] args) {
        Venue venue = init();

        System.out.println(venue.getCity());
        System.out.println(venue.getVenueName());
        venue.getShows()
                .stream()
                .forEach(
                        s ->
                        {
                            System.out.println(s.getShowName());
                            s.getEvents()
                                    .stream()
                                    .forEach(
                                            e -> System.out.println(e.getDateTime())
                                    );
                        }
                );

        System.out.println("---------------------------------------");
        System.out.println(dateTime);
        System.out.println("---------------------------------------");

        Predicate<Event> p1 = e -> e.getDateTime().isEqual(dateTime);

        List<Show> collect = venue.getShows()
                .stream()
                .filter(s -> s.getEvents().stream().anyMatch(p1))
                .limit(5)
                .collect(Collectors.toList());

        collect.stream()
                .forEach(s ->
                    System.out.println(s.getShowName()));

    }

    private static Venue init() {
        Venue venue = new Venue();
        venue.setCity("London");
        venue.setVenueName("Name");
        venue.setShows(initShows());

        return venue;
    }

    private static List<Show> initShows() {
        List<Show> showsList = new ArrayList<>();
        Show show1 = new Show("show1");
        show1.setEvents(initEvents(1, LocalDateTime.of(2019, 1, 1, 0, 0)));
        Show show2 = new Show("show2");
        show2.setEvents(initEvents(2, LocalDateTime.of(2019, 5, 1, 0, 0)));
        Show show3 = new Show("show3");
        show3.setEvents(initEvents(3, LocalDateTime.of(2019, 5, 1, 0, 0)));
        Show show4 = new Show("show4");
        show4.setEvents(initEvents(4, LocalDateTime.of(2019, 5, 1, 0, 0)));
        Show show5 = new Show("show5");
        show5.setEvents(initEvents(5, LocalDateTime.of(2019, 5, 1, 0, 0)));
        Show show6 = new Show("show6");
        show6.setEvents(initEvents(6, LocalDateTime.of(2019, 6, 1, 0, 0)));
        Show show7 = new Show("show7");
        show7.setEvents(initEvents(7, LocalDateTime.of(2019, 7, 1, 0, 0)));
        Show show8 = new Show("show8");
        show8.setEvents(initEvents(8, LocalDateTime.of(2019, 8, 1, 0, 0)));
        Show show9 = new Show("show9");
        show9.setEvents(initEvents(9, LocalDateTime.of(2019, 9, 1, 0, 0)));
        Show show10 = new Show("show10");
        show10.setEvents(initEvents(0, LocalDateTime.of(2019, 5, 1, 0, 0)));

        showsList.add(show1);
        showsList.add(show2);
        showsList.add(show3);
        showsList.add(show4);
        showsList.add(show5);
        showsList.add(show6);
        showsList.add(show7);
        showsList.add(show8);
        showsList.add(show9);
        showsList.add(show10);
        return showsList;
    }

    private static List<Event> initEvents(int elements, LocalDateTime localDateTime) {
        List<Event> eventList = new ArrayList<>();

        for (int ii = 0; ii < elements; ii++) {
            Event event = new Event(localDateTime.plusDays(ii));

            eventList.add(event);
        }

        return eventList;
    }
}
