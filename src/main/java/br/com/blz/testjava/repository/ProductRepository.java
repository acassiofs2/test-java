package br.com.blz.testjava.repository;

import br.com.blz.testjava.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductRepository implements Repository<Product, Integer> {

    private static final List<Product> products = new ArrayList<>();

    @Override
    public Product create(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(Integer sku, Product product) {
        Optional<Product> p = findById(sku);
        if (!p.isPresent()) {
            return null;
        } else {
            int index = products.indexOf(p.get());
            products.set(index, product);
        }
        return product;
    }

    @Override
    public Optional<Product> findById(Integer sku) {
        return products.stream().filter(p -> p.getSku().equals(sku)).findFirst();
    }

    @Override
    public void deleteById(Integer sku) {
        Optional<Product> product = findById(sku);
        product.ifPresent(products::remove);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    public void clear() {
        products.clear();
    }
}
