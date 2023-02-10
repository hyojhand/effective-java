# 아이템6. 불필요한 객체 생성을 피하라

**똑같은 기능의 객체를 매번 생성하기 보다는 객체 하나를 재사용하는 편이 나을 때가 많다.** ex) String 문자열  
생성자 대신 정적 팩터리 메서드를 사용해 불필요한 객체 생성을 피할 수 있다.

생성비용이 ‘비싼 객체’가 반복해서 필요하다면 캐싱하여 재사용하길 권한다.  
ex) 정규표현식용 Pattern 인스턴스는 한번 쓰고 버려져서 바로 가비지 컬렉션 대상이 된다. 입력받은 정규 표현식에 해당하는 유한 상태 머신(finite state machine)을 만들기 때문에 인스턴스 생성 비용이 높다.  
→ 불변인 Pattern 인스턴스를 클래스 초기화 과정에서 생성 후 캐싱해두고 재사용하여 성능을 개선한다.

**오토 박싱**  
오토박싱은 기본 타입과 그에 대응하는 박싱된 기본 타입의 구분을 흐려주지만, 완전히 없애주는 것은 아니다.  
박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치않은 오토박싱이 숨어들지 않도록 주의하자!

### 초기화 지연 기법 (item 83)

> 사용하지 않는 필드가 클래스 레벨에서 불필요한 초기화 되는 것을 막기 위해 지연 초기화(lazy initialization) 할 수 있지만, 이는 코드를 복잡하게 만들고 성능 개선에 큰 영향이 없을 때가 많다.
>

초기화하는 것을 인스턴스가 필요한 시점으로 최대한 미룬다.

### 방어적 복사 (item 50)

> 이번 item 6은 “기존 객체를 재사용해야 한다면 새로운 객체를 만들지 마라”
item 50. 방어적 복사(defensive copy)는 “새로운 객체를 만들어야 한다면 기존 객체를 재사용하지 마라”
방어적 복사가 필요한 상황에서 객체를 재사용했을 때의 피해가, 필요없는 객체를 반복 생성했을 때의 피해보다 훨씬 크다!
>

프로그램의 명확성, 간결성, 기능을 위해서 객체를 추가로 생성하는 것이라면 일반적으로 좋은 일이다.

### Deprecation, 사용 자제 API

사용 자제를 권장하고, 대안을 제시하는 방법이 있다.

**@Deprecated** : 컴파일 시 경고 메시지를 통해 사용 자제를 권장하는 API라는 것을 알려줄 수 있다.
`@Deprecated(forRemoval = true, since = "1.2")`

forRemoval = true : 삭제될 것이라는 강력한 경고  
since = “” : 삭제될 버전 정보

**@deprecated** : 문서화(Javadoc)에 사용하여, 왜 해당 API 사용을 지양하는지, 그 대신 권장하는 API를 표기할 수 있다.
```java
/**
 * @deprecated in favor of
 * {@link #Deprecation(String)}
 */
```
<img src="https://user-images.githubusercontent.com/87989933/218156541-7e11f384-0e61-4261-8ed6-83f21168db75.png">

### 정규 표현식

1. **matches**  
ex) PATTERN.matches(regex, value) // boolean  
matches() 메서드에 들어가는 문자열이 패턴으로 쓰인다.


2. **split 메서드**  
ex) Pattern.split(input)
<img src="https://user-images.githubusercontent.com/87989933/218157460-075d58d6-b50a-4494-b4af-e76a208ad939.png">
split할때 문자열이 하나라면 fastpath로 빠르게 처리되는데,
하나가 아니라면, 패턴을 생성하고 split을 내부적으로 호출하기 때문에 Pattern을 재사용 하는게 성능에 좋다.


3. **replaceAll, replaceFirst**  
해당 메서드의 첫번째 인자로 정규 표현식을 사용한다.  
ex) value.replaceAll(PATTERN.pattern(), “value2”)