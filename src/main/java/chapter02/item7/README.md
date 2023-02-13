# 아이템7. 다 쓴 객체 참조를 해제하라

**어떤 객체에 대한 참조(reference)가 남아있다면 해당 객체는 가비지 컬렉션의 대상이 되지 않는다.**

객체들의 다 쓴 참조들을 그대로 가지고 있기 때문에, 객체 참조 하나를 살려두면 가비지 컬렉터는 그 객체 뿐만 아니라 그 객체가 참조하는 모든 객체를 회수해가지 못한다.

**자기 메모리를 직접 관리하는 클래스라면 메모리 누수에 주의해야 한다. ex) 스택, 캐시, 리스너 or 콜백**

### 메모리 누수 해결방법 3가지

1. 해당 참조를 다 썼을 때 **null 처리(참조 해제)하면 된다.**

하지만, **객체 참조를 null 처리하는 일은 예외적인 경우이며,  
가장 좋은 방법은 그 참조를 담은 변수를 유효 범위 (scope) 밖으로 밀어내는 것이다.**

```java
public Object pop() {
    if (size == 0)
        throw new EmptyStackException();
    Object result = elements[--size];
    elements[size] = null; // 다 쓴 참조 해제
    return result;
}
```

2. **WeakHashMap**

Weak reference를 key로 가지는 Map이다.

key가 더이상 참조되지 않으면, 그 key로 가지고 있는 value를 Map에서 사라진다.  
strong reference가 없다면, GC를 통해 해당 데이터가 사라진다.

3. **백그라운드 스레드**를 활용해 주기적으로 cleanup

ScheduledThreadPoolExecutor 같은 백그라운드 스레드를 활용해 캐시에 새 엔트리를 추가할 때 부수 작업으로 수행하는 방법이다.

## NullPointerException

메서드에서 null을 리턴하면서 null 체크를 하지 않으면 NPE을 만난다.  
Java8에 추가된 optional을 활용해서 NPE를 최대한 피하자!

- optional은 파라미터 타입이 아닌 리턴 타입으로만 사용하자!
- 컬렉션을 optional로 감쌀 이유가 없다.
- optional을 선언했는데 null을 사용하면 안된다.

## WeakHashMap

더이상 사용하지 않는 객체를 GC 할 때 자동으로 삭제해주는 Map이다.

- Key가 더이상 강하게 레퍼런스되는 곳이 없다면, 해당 엔트리를 제거한다.
- Map의 엔트리를 Map의 value가 아니라 **key에 의존해야 하는 경우에 사용할 수 있다.**
- 캐시를 구현하는데 사용할 수 있지만, 캐시를 직접 구현하는 것은 권장하지 않는다.

**Reference 종류 - Strong, Soft, Weak, Phantom**

- **Strong reference** - 객체를 만들면 strong 참조가 되며, scope 내에서 유효하다.  
  해당 대상을 null로 바꾸면, 그 객체를 바라보는 대상이 없기 때문에 GC의 대상이 된다.
- **Soft reference** - Strong reference가 없고 soft만 있으면서, 메모리가 필요한 상황만 GC의 대상이 된다.
- **Weak reference** - Strong reference가 없고, weak만 있다면 GC의 대상이 된다.
- **Phantom reference** - ReferenceQueue를 생성자의 2번째 매개변수로 필요하다.
  Strong reference가 사라지면, Phantom reference를 ReferenceQueue에 넣어준다.  
1.자원 정리용도(finalizer < phantom reference < try-resource)  
2.언제 객체의 메모리가 해제되는지 알 수 있다.(큐에 담기는 시점으로) 메모리가 큰 객체에 관심이 많을 때 사용할 수 있겠다.
