package priv.calloriescounter.nodirect.repositories;

import priv.calloriescounter.nodirect.entities.Meal;
import priv.calloriescounter.nodirect.entities.MealType;

import java.util.Date;
import java.util.List;

public interface IMealRepository extends ICrudRepository<Meal, Long> {
    Meal findByMealTypeAndDate(MealType mealType, Date date);
    List<Meal> findAllByDate(Date date);
}
