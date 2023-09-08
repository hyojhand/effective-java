# 아이템25. 톱레벨 클래스는 한 파일에 하나만 담으라

하나의 소스 파일에 톱레벨 클래스를 여러개 선언해도 컴파일러는 문제없지만, 중복 정의 했을 경우 컴파일 오류가 발생한다.

또한, 어느 것을 사용할 지는 소스 파일을 어떤 순서로 컴파일 하냐에 따라 결과가 달라진다.  
javac Main.java Utensil.java 명령어로 컴파일하면, Utensil 클래스의 내용이 출력되고,  
javac Main.java Dessert.java 명령어로 컴파일하면, Dessert 클래스의 내용이 출력된다.

### 톱레벨 클래스들을 서로 다른 소스 파일로 분리하자!

여러 톱레벨 클래스를 한 파일에 담고 싶다면 정적 멤버 클래스(아이템 24)를 사용할 수 있다.  
가독성이 좋아지고, private으로 선언하면 접근 범위도 최소로 관리할 수 있다.

```jsx
// 정적 멤버 클래스 사용
public class Main {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}
```