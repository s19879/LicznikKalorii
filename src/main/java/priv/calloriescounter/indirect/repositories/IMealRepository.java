package priv.calloriescounter.indirect.repositories;

import priv.calloriescounter.indirect.entities.Meal;
import priv.calloriescounter.indirect.entities.MealType;

import java.util.Date;
import java.util.List;

public interface IMealRepository extends ICrudRepository<Meal, Long> {
    Meal findByMealTypeAndDate(MealType mealType, Date date);
    List<Meal> findAllByDate(Date date);
}
