package priv.calloriescounter.indirect.repositories;

import priv.calloriescounter.indirect.entities.Product;

import java.util.List;

public class ProductRepository extends AbstractRepository<Product, Long> implements IProductRepository{
    public ProductRepository(){super(Product.class);}

    @Override
    public List<Product> findAllActiveProducts() {
        return null;
    }
}
