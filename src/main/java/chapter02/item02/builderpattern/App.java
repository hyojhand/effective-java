package chapter02.item02.builderpattern;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        TourPlan shortTrip = new TourPlan();
        shortTrip.setTitle("여행");
        shortTrip.setStartDate(LocalDate.of(2023, 1, 11));

        TourPlan tourPlan = new TourPlan();
        tourPlan.setTitle("투어 여행");
        tourPlan.setNights(2);
        tourPlan.setDays(3);
        tourPlan.setStartDate(LocalDate.of(2023, 2, 22));
        tourPlan.setWhereToStay("리조트");
    }
}
