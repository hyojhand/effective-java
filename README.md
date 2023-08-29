## 이펙티브 자바 목표

**“확실하게 이해하고 근거있게 사용하자”**

- 완벽히 이해할 때까지 복습
- item 적용을 고려하면서 학습
- 천천히 꾸준하게 읽자
- item 내용 리드미에 정리

### [2장 객체 생성과 파괴](./src/main/java/chapter02)

- [아이템1. 생성자 대신 정적 팩터리 메서드를 고려하라](./src/main/java/chapter02/item01)
- [아이템2. 생성자에 매개변수가 많다면 빌더를 고려하라](./src/main/java/chapter02/item02)
- [아이템3. private 생성자나 열거 타입으로 싱글턴임을 보증하라](./src/main/java/chapter02/item3)
- [아이템4. 인스턴스화를 막으려거든 private 생성자를 사용하라](./src/main/java/chapter02/item4)
- [아이템5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라](./src/main/java/chapter02/item5)
- [아이템6. 불필요한 객체 생성을 피하라](./src/main/java/chapter02/item6)
- [아이템7. 다 쓴 객체 참조를 해제하라](./src/main/java/chapter02/item7)
- [아이템8. finalizer와 cleaner 사용을 피하라](./src/main/java/chapter02/item8)

### [3장 모든 객체의 공통 메서드](./src/main/java/chapter03) 
- [아이템10. equals는 일반 규약을 지켜 재정의하라](./src/main/java/chapter03/item10)
- [아이템11. equals를 재정의하려거든 hashCode도 재정의하라](./src/main/java/chapter03/item11)
- [아이템12. toString을 항상 재정의하라](./src/main/java/chapter03/item12)
- [아이템14. Comparable을 구현할지 고민하라](./src/main/java/chapter03/item14)

### [4장 클래스와 인터페이스](./src/main/java/chapter04)
- [아이템15. 클래스와 멤버의 접근 권한을 최소화하라](./src/main/java/chapter04/item15)
- [아이템16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라](./src/main/java/chapter04/item16)
- [아이템17. 변경 가능성을 최소화하라](./src/main/java/chapter04/item17)
- [아이템18. 상속보다는 컴포지션을 사용하라](./src/main/java/chapter04/item18)
- [아이템21. 인터페이스는 구현하는 쪽을 생각해 설계하라](./src/main/java/chapter04/item21)
- [아이템24. 멤버 클래스는 되도록 static으로 만들라](./src/main/java/chapter04/item24)

### [6장 열거 타입과 애너테이션](./src/main/java/chapter06)
- [아이템37. ordinal 인덱싱 대신 EnumMap을 사용하라](./src/main/java/chapter06/item37)