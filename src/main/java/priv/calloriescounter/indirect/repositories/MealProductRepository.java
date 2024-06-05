package priv.calloriescounter.indirect.repositories;

import priv.calloriescounter.indirect.entities.MealProduct;

public class MealProductRepository extends AbstractRepository<MealProduct, Long> {
    public MealProductRepository(){super(MealProduct.class);}
}
