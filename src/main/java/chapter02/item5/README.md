# 아이템5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라

> 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않다.

**의존 객체 주입이란 인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식이다.**  
이 방식의 변형으로 생성자에 자원 팩터리를 넘겨줄 수 있다.

**의존 객체 주입을 사용하면 클래스의 유연성, 재사용성, 테스트 용이성을 개선할 수 있다.**

예시에서 보듯이, 사용하는 사전(Dictionary)의 종류가 바뀔 수 있다. 또는, 테스트를 위해 생성하는 객체가 비용이 크거나 테스트용 객체를 사용하고 싶은데, 그렇지 못해 매우 비효율적이다.

그렇다면 다른 버전의 Dictionary를 테스트하려면 어떻게 해야할까?  
→ 다른 버전의 Dictionary 클래스를 생성해서 테스트?  
상속받아서 해당 클래스에서 다른 버전의 Dictionary 객체를 사용??

**의존 객체 주입을 사용하고 Dictionary가 인터페이스라면, 객체가 바뀌더라도 모든 코드를 재사용할 수 있다.**  
→ 인터페이스에 어떤 구현체가 오더라도 해당 인터페이스의 메서드는 변하지 않아 재사용가능하다.

<br/>

> 이 패턴의 쓸만한 변형으로 생성자에 자원 팩터리를 넘겨주는 방식이 있다.

생성자로 자원을 바로 받는 것이 아닌, 자원 만들어주는 팩터리를 받아서 팩터리를 통해서 자원을 가져오는 방식으로 한번 더 추상화 한다.

```java
public SpellChecker(Dictionary dictionary) {
	this.dictionary = dictionary;
}

public SpellChecker(DictionaryFactory dictionaryFactory) {
	this.dictionary = dictionaryFactory.get();
}
```

> Java 8 에서 소개한 Supplier<T> 인터페이스가 팩터리를 표현한 완벽한 예다.
> 
```java
public SpeelChecker(Supplier<Dictionary> dictionarySupplier) {
	this.dictionary = dictionarySupplier.get();
}
```

> 한정적 와일드카드 타입을 사용해 팩터리의 타입 매개변수를 제한해야 한다.

Supplier를 사용하면서 구체적인 타입이 아닌, 지정한 타입의 하위 타입을 가지는 팩터리도 사용할 수 있게 해준다. 하지만, 인터페이스로 상속받아 구현했다면 인터페이스 타입만 지정해도 하위타입 모두 사용가능하다!

```java
public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
    this.dictionary = dictionarySupplier.get();
}
```

## 팩터리 메서드 패턴

구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다.  
새로운 Product를 제공하는 팩터리를 추가하더라도, 팩터리를 사용하는 클라이언트 코드는 변경할 필요가 없다.

인터페이스 팩터리(DictionaryFactory)를 만들고, 생성자에서는 이 인터페이스 팩터리를 사용한다.  
인터페이스를 상속받아 구체적인 구현체를 만들어주는 구체적인 Factory에서 인스턴스를 생성해 리턴한다.  
이렇게하면 새로운 Factory가 생기더라도 클라이언트 코드는 전혀 변경하지 않고 확장될 수 있다.

**이는 확장에 열려있고, 변경에 닫혀있는 구조이다!**

## 스프링 IoC

Inversion of Control - 제어의 역전

- 자기 코드에 대한 제어권을 자기 자신이 가지고 있지 않고, 외부에서 제어하는 경우
- 제어권이란, 인스턴스를 만들거나, 메서드를 실행거나, 필요한 의존성을 주입받는 등의 활동

스프링 IoC 컨테이너 사용 장점

- 수많은 개발자에게 검증되었으며 자바 표준 스펙(@Inject)도 지원한다.
- 손쉽게 싱글턴 Scope을 사용할 수 있다.
- 객체 생성(Bean) 관련 라이프사이클 인터페이스를 제공한다.