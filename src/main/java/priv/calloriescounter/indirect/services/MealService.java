package priv.calloriescounter.indirect.services;

import lombok.NonNull;
import priv.calloriescounter.indirect.entities.Meal;
import priv.calloriescounter.indirect.entities.MealType;
import priv.calloriescounter.indirect.entities.Product;

import java.util.Date;

public interface MealService {
    Meal addMeal(@NonNull MealType mealType, @NonNull Date date);
    Meal addProductToMeal(Meal meal, Product product, int amount);
    boolean deleteMeal(Meal meal);
    boolean deleteProductFromMeal(Meal meal, Product product);
}
