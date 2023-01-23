package chapter02.item02.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder // (builderClassName = "Builder") 생성되는 Builder의 이름을 설정
@AllArgsConstructor(access = AccessLevel.PRIVATE)
// lombok의 @Builder로 인해 모든 파라미터를 받는 생성자가 생기는데, 이러한 생성자를 허용하고 싶지 않을 경우 Accesslevel을 private으로 설정해준다.
public class NutritionFactsAnnotation {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static void main(String[] args) {
        NutritionFactsAnnotation nutritionFacts = new NutritionFactsAnnotationBuilder()
                .servingSize(100)
                .servings(10)
                .build();

//        NutritionFactsAnnotation cocaCola = NutritionFactsAnnotation.builder()
//                .servingSize(100)
//                .servings(10)
//                .build();
    }
}
