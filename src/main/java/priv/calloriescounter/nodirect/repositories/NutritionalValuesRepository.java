package priv.calloriescounter.nodirect.repositories;

import priv.calloriescounter.nodirect.entities.NutritionalValues;
import priv.calloriescounter.nodirect.entities.Product;

public class NutritionalValuesRepository extends AbstractRepository<NutritionalValues, Long> {
    public NutritionalValuesRepository(){super(NutritionalValues.class);}
}
