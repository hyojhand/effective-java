package chapter02.item02.hierarchicalbuilder;

import static chapter02.item02.hierarchicalbuilder.NyPizza.Size.SMALL;
import static chapter02.item02.hierarchicalbuilder.Pizza.Topping.*;

// 계층적 빌더 사용
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();

        // Builder를 사용할때 빌더 타입을 casting 해주어야 한다.
//        NyPizza pizza = (NyPizza) new NyPizza.Builder(SMALL)
//                .addTopping(SAUSAGE).addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}
