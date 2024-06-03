package priv.calloriescounter.nodirect.services;

import lombok.NonNull;
import priv.calloriescounter.nodirect.entities.*;

import java.util.List;

public interface ProductService{
    LiquidProduct createLiquidProduct(@NonNull String name, @NonNull String producer,
                                      double kcalAmount, @NonNull NutritionalValues nutritionalValues,
                                      boolean isSuitableForMixing, boolean isSauce);
    SolidProduct createSolidProduct(@NonNull String name, @NonNull String producer,
                                    double kcalAmount, @NonNull NutritionalValues nutritionalValues,
                                    boolean isShortTerm);

    void addProductToMeal(@NonNull Meal meal, @NonNull Product product);
    boolean updateProduct(@NonNull Product product);
    Product getProductByName(@NonNull String name);
    Product getProductById(@NonNull Long id);
    List<Product> getAllProducts();
    void deactivateProduct(@NonNull Product product);
}
