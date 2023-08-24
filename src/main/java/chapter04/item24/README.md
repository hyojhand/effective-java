# 아이템24. 멤버 클래스는 되도록 static으로 만들라

**비정적 멤버 클래스보다는 정적 멤버 클래스를 사용하라!**

### 중첩 클래스(nested class)란?

다른 클래스 안에 정의된 클래스로, 자신을 감싼 바깥 클래스에서만 쓰여야 하며, 그 외의 쓰임새가 있다면 톱 레벨 클래스로 만들어야 한다.

### 정적 멤버 클래스

다른 클래스 안에 선언되고, 바깥 클래스의 private 멤버에도 접근할 수 있다는 점만 제외하고 일반 클래스와 같다.  
바깥 클래스와 함께 쓰일 때만 유용한 public 도우미 클래스 ex) Calculator.**Operation**.PLUS

### 비정적 멤버 클래스

바깥 클래스의 인스턴스와 암묵적으로 연결되며, 어댑터를 정의할 때 자주 쓴다.  
**멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면, 무조건 static을 붙여서 정적 멤버 클래스로 만들자!**

특정 InnerClass가 OutterClass에 참조하는 경우가 많다면 비정적 멤버 클래스로 적합하다.  
비정적 멤버 클래스의 인스턴스 메서드에서 정규화된 this를 사용해 바깥 인스턴스의 메서드를 호출하거나 바깥 인스턴스의 참조를 가져올 수 있다. (정규화된 this란 **클래스명.this형태**로 바깥 클래스의 이름을 명시하는 용법을 말한다.)

### 익명 클래스

바깥 클래스의 멤버가 아니며, 쓰이는 시점과 동시에 인스턴스가 만들어진다.  
선언한 지점에서만 인스턴스를 만들 수 있고, instanceof 검사나 클래스의 이름이 필요한 작업은 수행할 수 없다.

비정적인 문맥에서 사용될 때만 바깥 클래스의 인스턴스를 참조할 수 있으며, Java에서 람다를 지원하기 전에 즉석에서 작은 함수 객체나 처리 객체를 만들 때 사용했다.

### 지역 클래스

가장 드물게 사용되며, 가독성을 위해 짧게 작성해야 한다.  
지역 변수를 선언하는 곳이면 어디든 지역 클래스를 정의해 사용할 수 있다.

### 어댑터 패턴

기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴이다.  
클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 재사용할 수 있게 해준다.