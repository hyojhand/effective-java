# 아이템 14. Comparable을 구현할지 고민하라

Comparable 인터페이스의 compareTo는 Object equals와 비슷하지만 순서를 비교할 수 있으며 제네릭을 지원하는 차이점이 있다. 순서를 정의해주는 방법을 구현할 수 있으며, 제네릭 타입을 가지고 있어 컴파일 시점에 타입 체크를 할 수 있다. 따라서 매개변수의 타입을 신경쓰지 않아도 된다.

### compareTo 메서드의 일반 규약

이 객체와 주어진 객체의 순서를 비교한다. 객체가 주어진 객체보다 자그면 음수, 같으면 0, 크면 양수를 반환한다.

- 반사성 : A.compareTo(A) = 0
- 대칭성 : A.compreTo(B) = -(B.compareTo(A))
- 추이성 : C.compareTo(A) > 0 && A.compareTo(B) 라면, C.compareTo(B) > 0
- 일관성 : 다른 인스턴스지만, 같은 값을 비교할 때 결과는 같아야 한다.
- **compareTo로 비교했을 때 같다면, equals로 비교해도 같아야 한다.**  
  이는  권고는 아니지만 지키는게 좋은 규칙이며, 만약 이 규칙을 지킬 수 없다면 명시해야 한다!


 **equals 메서드에 명시된 내용**
![image](https://user-images.githubusercontent.com/87989933/232518148-3ef5cd0c-acc5-495b-b8d5-82aec1607842.png)

상속 관계에서 Comparable을 구현한 클래스를 상속하면, 하위 클래스에서 Comparable을 새로 구현할 수 없다.   
따라서, 내부에서 Comparator를 정의하여 비교해야 한다. 이는 추천하지 않는 방법으로 상속보다는 컴포지션을 사용하자!  
컴포지션을 사용해 내부에 객체를 가지고 있으면 Comparable을 구현해 해당 객체끼리 비교가 가능하고 확장된 필드의 값도 함께 비교할 수 있다.

### Comparator 인터페이스 활용 방법

Comparator 인터페이스가 제공하는 static 메서드를 사용해서 Comparator 인스턴스를 생성할 수 있다.  
compareTo 메서드를 구현하는데 간결하게 사용할 수 있지만, 약간의 성능 저하가 있을 수 있다.