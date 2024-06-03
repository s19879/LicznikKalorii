package priv.calloriescounter.nodirect.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import priv.calloriescounter.nodirect.entities.*;
import priv.calloriescounter.nodirect.repositories.NutritionalValuesRepository;
import priv.calloriescounter.nodirect.repositories.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final NutritionalValuesRepository nutritionalValuesRepository;

    public ProductServiceImpl(){
        productRepository = new ProductRepository();
        nutritionalValuesRepository = new NutritionalValuesRepository();
    }

//    public <T extends Product> void addProduct(T product){
//        productRepository.save(product);
//    }

    @Override
    public LiquidProduct createLiquidProduct(String name, String producer, double kcalAmount, NutritionalValues nutritionalValues, boolean isSuitableForMixing, boolean isSauce){
        LiquidProduct liquidProduct = new LiquidProduct(name,producer,kcalAmount,nutritionalValues,isSuitableForMixing,isSauce);
        productRepository.save(liquidProduct);
        return liquidProduct;
    }

    @Override
    public SolidProduct createSolidProduct(String name, String producer, double kcalAmount, NutritionalValues nutritionalValues, boolean isShortTerm){
        SolidProduct solidProduct = new SolidProduct(name, producer, kcalAmount, nutritionalValues, isShortTerm);
        nutritionalValues.setProduct(solidProduct);
        productRepository.save(solidProduct);
        return solidProduct;
    }

    @Override
    public void addProductToMeal(@NonNull  Meal meal, @NonNull Product product) {

    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.save(product) != null;
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByFieldName("NAME", name);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deactivateProduct(Product product) {
        product.setActive(false);
        productRepository.save(product);
    }

//    @AllArgsConstructor
//    public static class ProductBuilder{
//        private String name;
//        private String producer;
//        private double kcalAmount;
//        private NutritionalValues nutritionalValues;
//
//        public LiquidProduct buildLiquidProduct(boolean isSuitableForMixing, boolean isSauce){
//            return new LiquidProduct(name,producer,kcalAmount,nutritionalValues,isSuitableForMixing,isSauce);
//        }
//
//        public SolidProduct buildSolidProduct(boolean isShortTerm){
//            return new SolidProduct(name, producer, kcalAmount, nutritionalValues, isShortTerm);
//        }
//    }
}
