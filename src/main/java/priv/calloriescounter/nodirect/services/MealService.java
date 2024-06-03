package priv.calloriescounter.nodirect.services;

import lombok.NonNull;
import priv.calloriescounter.nodirect.entities.Meal;
import priv.calloriescounter.nodirect.entities.MealType;
import priv.calloriescounter.nodirect.entities.Product;

import java.util.Date;
import java.util.List;

public interface MealService {
    Meal addMeal(@NonNull MealType mealType, @NonNull Date date);
    Meal addProductToMeal(Meal meal, Product product, int amount);
    boolean deleteMeal(Meal meal);
    boolean deleteProductFromMeal(Meal meal, Product product);
}
