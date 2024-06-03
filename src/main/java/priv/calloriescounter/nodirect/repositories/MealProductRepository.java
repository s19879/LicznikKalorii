package priv.calloriescounter.nodirect.repositories;

import priv.calloriescounter.nodirect.entities.MealProduct;

public class MealProductRepository extends AbstractRepository<MealProduct, Long> {
    public MealProductRepository(){super(MealProduct.class);}
}
