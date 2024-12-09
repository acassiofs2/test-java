package br.com.blz.testjava.repository;

import br.com.blz.testjava.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository implements Repository<Product, Integer> {

    private static List<Product> products;

    @Override
    public Product create(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Integer sku) {
        return products.stream().filter(p -> p.getSku().equals(sku)).findFirst();
    }

    @Override
    public void deleteById(Integer sku) {
        Optional<Product> product = findById(sku);
        product.ifPresent(p -> products.remove(p));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
