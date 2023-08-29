# 아이템21. 인터페이스는 구현하는 쪽을 생각해 설계하라

Java 8 이전에는 기존 구현체를 깨지 않고는 인터페이스에 메서드를 추가할 수 없었다.  
Java 8 이후에 기존 인터페이스에 디폴트 메서드 구현이 가능해졌지만, 이를 추가하는 것은 위험한 일이다.  
해당 인터페이스를 구현한 모든 클래스는 아무것도 모른 채 디폴트 메서드가 삽입되게 된다.

**하지만, 생각할 수 있는 모든 상황에서 불변식을 해치지 않는 디폴트 메서드 작성은 어려운 일이다.**

Java 8에서 Collection 인터페이스에 추가된 removeIf 메서드는 SynchronizedCollection 클래스 입장에서는 위험한 코드이다.  
동기화와 관련된 코드가 없어 안전하지 않은 컬렉션이 되며, ConcurrentModificationException이 발생할 수 있다.

따라서, 이러한 클래스들은 디폴트 메서드를 재정의하여 사용하지만, 써드파티 코드는 관리, 수정하기 어렵다.  
또한, 컴파일 에러가 발생하지 않아 클래스 관점에서 본다면 해가 될 수 있다.

**→ 디폴트 메서드를 인터페이스에 추가하는 일은 신중해야한다.**

### 디폴트 메서드는 (컴파일에 성공하더라도) 기존 구현체에 런타임 오류를 일으킬 수 있다.

```java
public class SuperClass {
    private void hello() {
        System.out.println("hello superclass");
    }
}

public interface TempInterface {
    default void hello() {
        System.out.println("hello interface");
    }
}

public class SubClass {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.hello();
    }
}
```

위와 같이 부모 클래스를 상속하고, 인터페이스를 구현한 자식 클래스가 있는 상황일 때, 런타임 에러가 발생한다.  
호출 순서는 클래스가 인터페이스보다 우선이기 때문에, superClass의 메서드는 private임에도 접근하려 하여 런타임 에러가 발생한다.

→ 새로운 인터페이스를 만든다면 표준적인 메서드 구현을 제공하는데 유용한 수단이지만,  
인터페이스를 설계할 때는 세심한 주의를 기울여야 한다.

## ConcurrentModificationException

현재 바뀌면 안 되는 것을 수정할 때 발생하는 예외로 멀티 스레드가 아닌 싱글 스레드 상황에서도 발생할 수 있다.  
ex) 컬렉션을 순회하는 중에 컬렉션을 변경하는 경우

```java
// ConcurrentModificationException 발생 - Iterator로 컬렉션을 순회하는 중에 remove 하는 경우
for (Integer number : numbers) {
    if (number == 3) {
        numbers.remove(number);
    }
}

// Iterator를 직접 사용해서 remove
for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
    Integer number = iterator.next();
    if (number == 3) {
        iterator.remove();
    }
}

// 인덱스 사용하기
for (int i = 0; i < numbers.size(); i++) {
    if (numbers.get(i) == 3) {
        numbers.remove(numbers.get(i));
    }
}

// removeIf
numbers.removeIf(number -> number == 3);
```

Iterator를 직접 사용해서 remove하거나, Iterator를 사용하지 않고 인덱스를 사용하거나,  
removeIf를 사용하면 ConcurrentModificationException이 발생하지 않는다.