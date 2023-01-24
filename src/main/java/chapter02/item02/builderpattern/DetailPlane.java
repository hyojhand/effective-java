package chapter02.item02.builderpattern;

public class DetailPlane {

    private int day;
    private String plan;

    public DetailPlane(int day, String plan) {
        this.day = day;
        this.plan = plan;
    }

    public int getDay() {
        return day;
    }

    public String getPlan() {
        return plan;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "DetailPlane{" +
                "day=" + day +
                ", plan='" + plan + '\'' +
                '}';
    }
}
