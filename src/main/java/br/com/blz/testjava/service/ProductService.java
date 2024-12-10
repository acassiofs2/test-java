package br.com.blz.testjava.service;

import br.com.blz.testjava.model.product.Product;
import br.com.blz.testjava.model.product.ProductRequest;
import br.com.blz.testjava.model.warehouse.Warehouse;
import br.com.blz.testjava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest) throws Exception {
        if (getProduct(productRequest.getSku()) != null) {
            throw new Exception("Já existe um produto com o sku informado!");
        }
        return productRepository.create(Product.from(productRequest));
    }

    public Product updateProduct(Integer sku, ProductRequest productRequest) {
        return productRepository.update(sku, Product.from(productRequest));
    }

    public Product retrieveProduct(Integer sku) {
        Product product = getProduct(sku);
        calculateQuantity(product);
        verifyIfMarketable(product);
        return product;
    }

    private void calculateQuantity(Product product) {
        if (product.getInventory() != null && product.getInventory().getWarehouses() != null) {
            int sum = product.getInventory().getWarehouses().stream().mapToInt(Warehouse::getQuantity).sum();
            product.getInventory().setQuantity(sum);
        }
    }

    private void verifyIfMarketable(Product product) {
        if (product.getInventory() != null && product.getInventory().getQuantity() != null) {
            product.setIsMarketable(product.getInventory().getQuantity() > 0);
        }
    }

    public Product getProduct(Integer sku) {
        return productRepository.findById(sku).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Integer sku) {
        productRepository.deleteById(sku);
    }

    public void clear() {
        productRepository.clear();
    }
}
