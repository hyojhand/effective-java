package chapter02.item02.telescopingconstructor;

// 2-1 점층적 생성자 패턴 - 확장하기 어렵다!
public class NutritionFacts {
    private final int servingSize;  // (mL)            필수
    private final int servings;     // (per container) 필수

    private final int calories;     // (per serving)   선택
    private final int fat;          // (g/serving)     선택
    private final int sodium;       // (mg/serving)    선택
    private final int carbohydrate; // (g/serving)     선택

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola =
                new NutritionFacts(240, 8, 100, 0, 35, 27);
    }

}
