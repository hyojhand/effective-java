package chapter02.item02.hierarchicalbuilder;

// 2-4 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴

// 참고 : 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
// 빌더뿐 아니라 임의의 유동적인 계층구조를 허용한다.

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        /*
        this를 리턴해서 Builder 자기 자신의 타입을 리턴한다면, Builder를 사용할때 빌더 타입을 casting 해주어야 한다.
        또한, Pizza에 있는 Builder의 메서드만 사용가능하다!
        따라서, 하위 빌더의 메서드를 쓰려면 하위 클래스의 빌더를 리턴해주어야 하므로 self()메서드로 하위 클래스 타입의 빌더를 사용한다
        */
//        public Builder<T> addTopping(Topping topping) {
//            toppings.add(Objects.requireNonNull(topping));
//            return this;
//        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding)하여 "this"를 반환하도록 해야 한다.
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}