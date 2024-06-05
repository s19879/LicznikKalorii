package priv.calloriescounter.indirect.repositories;

import priv.calloriescounter.indirect.entities.Product;

import java.util.List;

public interface IProductRepository extends ICrudRepository<Product, Long>{
    List<Product> findAllActiveProducts();
}
