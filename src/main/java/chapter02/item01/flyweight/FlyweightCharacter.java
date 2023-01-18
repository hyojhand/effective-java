package chapter02.item01.flyweight;

public class FlyweightCharacter {

    private char value;
    private String color;
    private Font font;

    public FlyweightCharacter(char value, String color, Font font) {
        this.value = value;
        this.color = color;
        this.font = font;
    }
}
