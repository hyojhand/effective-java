# 아이템3. private 생성자나 열거 타입으로 싱글턴임을 보증하라

어떤 인스턴스가 어플리케이션 내에서 하나만 있어도 되거나, 반드시 하나만 유지해야 하는 경우를 말한다.

## 첫번째 방법 : private 생성자 + public static final 필드

생성자는 private로 인스턴스를 직접 만들지 못하게 막아놓고, public static final 필드로 인스턴스를 만들어 놓고, 해당 인스턴스를 사용한다.

```java
public static final Elvis INSTANCE = new Elvis();
private Elvis() { }
```

**장점**

- 간결하고 싱글턴임을 API에 들어낼 수 있다. (javadoc을 만들었을때 쉽게 확인할 수 있다.)

**단점**

- 싱글턴을 사용하는 클라이언트 테스트하기 어려워진다.
- 리플렉션으로 private 생성자를 호출할 수 있다.
- 역직렬화 할 때 새로운

### 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기가 어려워질 수 있다!

> 타입을 인터페이스로 정의한 다음 그 인터페이스를 구현해서 만든 싱글턴이 아니라면, 싱글턴 인스턴스를 가짜(mock) 구현으로 대체할 수 없기 때문이다.

클라이언트 코드를 테스트하려는데, 생성되는 객체의 비용이 비싸거나 외부 API를 호출하거나 연산이 많아서 비효율적으로 비용이 들어가 테스트가 어려워질 수 있다.

이를 인터페이스를 구현해서 싱글턴 인스턴스를 가짜(mock)객체 구현으로 대체하여 테스트 할 수 있다.

### 리플렉션으로 싱글턴이 깨질 수 있다!

> 권한이 있는 클라이언트는 리플렉션 API인 AccessibleObject.setAccessible을 사용해 private 생성자를 호출할 수 있다.

**리플렉션을 사용하면 같은 타입의 인스턴스를 여러개 만들 수 있게 되어 싱글턴이 깨진다.**

리플렉션 API를 사용하여, 클래스로부터 얻어낸 정보를 통해서 **getDeclaredConstructor**()로 기본 생성자에 접근한다. (접근 제어자에 상관없이 선언되어 있는 생성자에 접근할 수 있다! getConstructor() 은 public한 생성자만 접근할 수 있다.)

**setAccessible(true)를** 하지않으면 private이기 때문에 생성자를 호출할 수 없게되어 IllegalAccessException이 발생한다.

이렇게 리플렉션을 사용하여 생성된 객체는 기존의 싱글턴 객체와 다른 새로운 객체를 계속 생성할 수 있게되어, 싱글턴이 깨지게 된다.

**해결방법**

리플렉션 공격까지 고려한다면, **인스턴스의 생성여부를 별도로 관리하여 인스턴스 생성을 막을 수 있다.**  
생성자가 두번째 객체가 생성되려 할 때 예외를 던져 인스턴스 생성을 막아주도록 처리한다.

### 역직렬화 시에 싱글턴이 깨질 수 있다!

> 직렬화된 인스턴스를 역직렬화할 때마다 새로운 인스턴스가 만들어진다.

역직렬화 할 때 **readResolve()** 메서드가 사용되는데, 이 메서드를 원래의 인스턴스를 리턴하도록 직접 정의하여 기존의 인스턴스를 사용하게 한다.

역직렬화 과정에서 자동으로 호출되는 readObject 메서드가 있더라도 readResolve 메서드에서 반환한 인스턴스로 대체된다. readObject 메서드를 통해 만들어진 인스턴스는 가비지 컬렉션 대상이 된다.

```java
private Object readResolve() {
    return INSTANCE;
}
```

## 두번째 방법 : private 생성자 + 정적 팩터리 메서드

생성자는 private로 인스턴스를 직접 만들지 못하게 막아놓고, private static final 필드로 인스턴스를 만들어 놓고, 정적 팩터리 메서드인 getInstance()로 인스턴스를 사용한다.

```java
private static final Elvis INSTANCE = new Elvis();
private Elvis() { }
public static Elvis getInstance() { return INSTANCE; }
```

**장점**

- API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
- 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
- 정적 팩터리의 메서드 참조를 공급자(Supplier)로 사용할 수 있다.

**단점**은 첫번째 방법과 동일하다.

### API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다!

클라이언트 코드를 변경하지 않고(getInstance()를 그대로) 싱글턴 동작을 바꿀 수 있게 된다.

### 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다!

제네릭한 타입으로 싱글턴 인스턴스를 사용하고 싶을 때, 제네릭 싱글턴 팩터리를 사용한다.
인스턴스는 동일하지만, 원하는 타입으로 바꿔서 사용할 수 있다.

equals 비교는 true지만, 타입이 다르기 때문에 == 비교는 불가능하다.

### 정적 팩터리의 메서드 참조를 공급자(Supplier)로 사용할 수 있다!

**Supplier 란?**

Java 8에 추가된 Functional Interface를 말한다.
@FunctionalInterface이 들어간 기본적인 function들을 제공한다.

**Supplier 인터페이스만 만족하면, 어떠한 메서드든 Supplier Functional 타입으로 사용할 수 있다!**
(인자 없는 메서드를 호출해서 무언가 하나를 리턴해주는 메서드가 Supplier에 준하는 메서드가 된다.)

여기서는 정적 팩터리 메서드인 getInstance() 메서드의 참조를 공급자(Supplier)로 사용할 수 있다.

## 세번째 방법 : 열거 타입

가장 간결한 방법이며 직렬화와 리플렉션에도 안전하다.

enum은 컴파일된 코드를 보면 private 생성자가 존재하지만, 열거형이기 때문에 new 인스턴스로 만들 수 없다.  
따라서, 리플렉션 API getDeclaredConstructor로 생성자를 가져올 수 없기 때문에 리플렉션에 안전하다.

또한, 역직렬화를 해도 동일한 인스턴스를 반환한다.

하지만, 테스트가 불편해진다면 인터페이스를 도입해서 클라이언트 코드가 인터페이스 타입을 사용하도록 하고,  
테스트 시에는 인터페이스의 별도 구현체를 사용해서 대체하도록 한다.

대부분의 상황에서는 원소가 하나뿐인 열거타입이 싱글턴을 만드는 가장 좋은 방법이다.

## 메서드 참조

> 정적 팩터리의 메서드 참조를 공급자(supplier)로 사용할 수 있다.

**람다 표현식 안에서 하는 일이 오로지 하나의 메서드를 호출**하는 일이라면, 메서드 참조로 줄여서 사용할 수 있다.

- **static 메서드 참조** : static 메서드이기 때문에, 클래스 참조를 통해 사용할 수 있다.
- **인스턴스 메서드 참조** : 인스턴스 메서드이기 때문에, 인스턴스를 만들어서 이를 통해서 접근해야한다.
- **임의 객체의 인스턴스 메서드 참조** : 메서드를 static 하지 않게 인스턴스로 사용하면서, 불필요한 인스턴스를 생성하지 않기 위해, 이 메서드의 첫번째 인자는 자기 자신이다.
- **생성자 참조** : 생성자를 생성할때도 하나의 메서드를 호출하는 것과 동일하기 때문에 생성자 참조로 사용할 수 있다.  
ex) **dates.stream().map(Person::new).collect(Collectors.toList());**  
→ **! 하지만, 비어있는 생성자와 파라미터를 받는 생성자가 둘다 있을때, 비어있는 생성자를 선택하고 싶다면 어떻게 해야할까? ⇒ 함수형 인터페이스 Supplier를 사용하면 매개변수가 없는 생성자를 사용할 수 있다!**

## 함수형 인터페이스

- 함수형 인터페이스는 람다 표현식과 메서드 참조에 대한 “타겟 타입”을 제공한다.
- 타겟 타입은 변수 할당, 메서드 호출, 타입 변환에 활용할 수 있다.

### **함수형 인터페이스 정의 방법**

**인터페이스 안에 오직 하나의 메서드만 선언**해야 **@FunctionalInterface** 어노테이션을 선언할 수 있다. 어노테이션이 붙지 않아도 함수형 인터페이스로 간주하지만, 어노테이션을 선언함으로써 함수형 인터페이스임을 컴파일 단계에서 확인할 수 있다. * **어노테이션 프로세서**

### **Java에서 제공하는 기본 함수형 인터페이스**

java.util.function 패키지 안에 있다.

- **Function<input타입, output타입>** : input을 받아서 output을 리턴해준다.  
  \* stream의 map은 Function 타입을 받아 새로운 요소로 매핑해준다.
- **Supplier<output타입>** : 매개변수로 받는 것은 없지만, 나오기만 하는 경우

```java
// 매개변수가 없는 생성자 참조로 사용
Supplier<Person> personSupplier = Person::new;
// LocalDate를 매개변수로 받는 생성자 참조로 사용
Function<LocalDate, Person> personFunction = Person::new;
```

- **Consumer<input타입>** : 매개변수로 받는 것은 있지만 return이 없는 void 메서드 ex) sysout
- **Predicate<input타입>** : 매개변수를 받아서 boolean을 리턴한다.  
\* stream의 filter는 조건을 필요로 하기 때문에 Predicate 타입을 받는다.

## 객체 직렬화

객체를 바이트 스트림으로 상호 변환하는 기술로, 바이트 스트림으로 변환한 객체를 파일로 저장하거나 네트워크를 통해 다른 시스템으로 전송할 수 있다.

- **Serializable** 인터페이스 구현 필요
- **transient**를 사용해서 직렬화 하지 않을 필드 선언하기
- **serialVersionUID**는 왜 사용하는가?  
  → 직렬화 이후에 클래스에 변경이 있으면 역직렬화 시 에러가 발생하는데,
  명시하지 않으면 런타임시에 자동으로 생성해준다. (클래스가 변경되면 새로운 serialVersionUID를 생성)
  serialVersionUID를 직접 관리해서 직렬화할 때와 같다면, 변경된 내용을 제외하고 역직렬화가 가능하다.

### Externalizable vs Serializable

![image](https://user-images.githubusercontent.com/87989933/215793532-44fdfa8b-140b-4afd-b196-79a371fdb858.png)

**Externalizable** 인터페이스는 Serializable 인터페이스의 자식 클래스로, 객체를 읽고 쓸 때 내부의 내용을 자유롭게 조작하면서 원하는 내용을 출력할 수 있도록 도와준다. Externalizable는 **readExternal**(ObjectInput in) 과 **writeExternal**(ObjectOutput out) 을 구현해어야 한다.

Serializable 은 object 의 모든 변수들을(transient 제외) 자동으로 직렬화 하지만,
**Externalizable** 은 직렬화할 대상을 직접 **writeExternal()** 메소드에 구현해야 한다. (transient 변수도 직렬화하여 전송가능) 마찬가지로, 역직렬화를 할 때에도 **readExternal()** 메소드에서 직렬화 순서에 맞게 하나하나 받은 데이터를 변수에 넣어줘야 한다.  
*Externalizable로 작업하는 동안 기본 생성자는 public이어야하며, 아닐시 예외가 발생한다.