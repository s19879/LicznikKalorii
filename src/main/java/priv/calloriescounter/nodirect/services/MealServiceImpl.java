package priv.calloriescounter.nodirect.services;

import lombok.NonNull;
import priv.calloriescounter.nodirect.entities.Meal;
import priv.calloriescounter.nodirect.entities.MealProduct;
import priv.calloriescounter.nodirect.entities.MealType;
import priv.calloriescounter.nodirect.entities.Product;
import priv.calloriescounter.nodirect.repositories.MealProductRepository;
import priv.calloriescounter.nodirect.repositories.MealRepository;
import priv.calloriescounter.nodirect.repositories.ProductRepository;

import java.util.Date;
import java.util.List;

public class MealServiceImpl implements MealService{
    private final MealRepository mealRepository;
    private final MealProductRepository mealProductRepository;
    private final ProductRepository productRepository;

    public MealServiceImpl(){
        mealRepository = new MealRepository();
        mealProductRepository = new MealProductRepository();
        productRepository = new ProductRepository();
    }
    @Override
    public Meal addMeal(MealType mealType, Date date) {
        Meal mld = mealRepository.findByMealTypeAndDate(mealType, date);
        if(mealRepository.findByMealTypeAndDate(mealType, date) == null)
            return new Meal(mealType, date);
        return null;
    }


    @Override
    public Meal addProductToMeal(@NonNull Meal meal, @NonNull Product product, int amount) {
        MealProduct mealProduct = new MealProduct(meal, product, amount);
        meal.getMealProducts().add(mealProduct);
        product.getMealProducts().add(mealProduct);
        mealRepository.save(meal);
        productRepository.save(product);

        return meal;
    }

    @Override
    public boolean deleteMeal(Meal meal) {
        return mealRepository.delete(meal);
    }

    @Override
    public boolean deleteProductFromMeal(Meal meal, Product product) {
        return false;
    }
}
