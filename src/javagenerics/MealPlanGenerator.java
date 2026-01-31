
interface MealPlan {
    String getMealType();
}


class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }
}

public class MealPlanGenerator {

    public static <T extends MealPlan> void generateMeal(T meal) {
        System.out.println("Generated Meal Plan: " + meal.getMealType());
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                new Meal<>(new VegetarianMeal());

        Meal<VeganMeal> veganMeal =
                new Meal<>(new VeganMeal());

        Meal<KetoMeal> ketoMeal =
                new Meal<>(new KetoMeal());

        generateMeal(vegMeal.getMeal());
        generateMeal(veganMeal.getMeal());
        generateMeal(ketoMeal.getMeal());
    }
}
