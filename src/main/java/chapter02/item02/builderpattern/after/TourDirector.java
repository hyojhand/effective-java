package chapter02.item02.builderpattern.after;

import chapter02.item02.builderpattern.TourPlan;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan osakaTrip() {
        return tourPlanBuilder.title("오사카 여행")
                .nightsAndDays(3, 4)
                .startDate(LocalDate.of(2023, 1, 22))
                .whereToStay("게스트하우스")
                .addPlan(0, "체크인")
                .addPlan(1, "여행")
                .getPlan();
    }

    public TourPlan tokyoTrip() {
        return tourPlanBuilder.title("도쿄 여행")
                .nightsAndDays(4, 5)
                .startDate(LocalDate.of(2023, 2, 22))
                .getPlan();
    }
}
