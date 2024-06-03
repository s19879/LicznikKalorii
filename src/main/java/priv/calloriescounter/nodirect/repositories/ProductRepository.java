package priv.calloriescounter.nodirect.repositories;

import priv.calloriescounter.nodirect.entities.Product;

public class ProductRepository extends AbstractRepository<Product, Long> {
    public ProductRepository(){super(Product.class);}
}
