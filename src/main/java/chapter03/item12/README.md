# 아이템12. toString을 항상 재정의하라

### “모든 하위 클래스에서 toString 메서드를 재정의하라”

toString의 일반 규약에 따르면 ‘**간결하면서 사람이 읽기 쉬운 형태의 유익한 정보**’를 반환해야 한다.  
toString을 잘 구현한 클래스는 사용하기에 훨씬 즐겁고, 그 클래스를 사용한 시스템은 디버깅하기 쉽다.

toString은 그 객체가 가진 주요 정보 모두를 반환하는게 좋다.  
**→ 책과는 다른 견해로 외부에 공개가능한 정보만 적는게 좋을 것 같다.**


### toString을 구현할 때면 반환값의 포맷을 문서화하는 것이 좋다.

포맷을 명시하면 그 객체는 표준적이고, 명확하고, 사람이 읽을 수 있게 된다. 따라서, 포맷을 명시하려면 아주 정확하게 해야한다.
또한, 명시한 포맷에 맞는 문자열과 객체를 상호 전환할 수 있는 정적 팩터리나 생성자를 함께 제공하면 좋다.

**포맷을 명시하든 아니든 의도는 명확히 밝혀야 한다.**

포맷 명시 여부와 상관없이 toString이 반환한 값에 포함된 정보를 얻어올 수 있는 API를 제공하자.

정적 유틸리티 클래스, 열거 타입은 Java가 이미 완벽한 toString을 제공하기 때문에 재정의하지 않아도 된다.  
하지만, 하위 클래스들이 공유해야 할 문자열 표현이 있는 추상 클래스라면 toString을 재정의해줘야 한다.
