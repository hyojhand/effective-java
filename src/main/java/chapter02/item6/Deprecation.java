package chapter02.item6;

public class Deprecation {

    // Javadoc으로 이유와 권장 방법을 알림
    /**
     * @deprecated in favor of
     * {@link #Deprecation(String)}
     */
    // @Deprecated // 컴파일러가 Annotation Processor 에서 어노테이션을 읽는다.
    // @Deprecated(forRemoval = true) // 삭제될 것이라는 강력한 경고
    @Deprecated(forRemoval = true, since = "1.2") // 삭제될 버전의 정보
    public Deprecation() {
    }

    private String name;

    public Deprecation(String name) {
        this.name = name;
    }
}
