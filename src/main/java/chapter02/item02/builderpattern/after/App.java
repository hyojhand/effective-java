package chapter02.item02.builderpattern.after;

import chapter02.item02.builderpattern.TourPlan;

public class App {
    public static void main(String[] args) {
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan = director.osakaTrip();
        TourPlan tourPlan1 = director.tokyoTrip();
    }
}
