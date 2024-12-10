package br.com.blz.testjava;

import br.com.blz.testjava.controller.ProductController;
import br.com.blz.testjava.model.product.Product;
import br.com.blz.testjava.model.product.ProductRequest;
import br.com.blz.testjava.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJavaApplicationTests {

	String payloadProduct = "{\n" +
        "    \"sku\": 43264,\n" +
        "    \"name\": \"L'Oréal Professionnel Expert Absolut Repair Cortex Lipidium - Máscara de Reconstrução 500g\",\n" +
        "    \"inventory\": {\n" +
        "        \"quantity\": 15,\n" +
        "        \"warehouses\": [\n" +
        "            {\n" +
        "                \"locality\": \"SP\",\n" +
        "                \"quantity\": 12,\n" +
        "                \"type\": \"ECOMMERCE\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"locality\": \"MOEMA\",\n" +
        "                \"quantity\": 3,\n" +
        "                \"type\": \"PHYSICAL_STORE\"\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    \"isMarketable\": true\n" +
        "}";

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
	public void givenValidParameters_whenCallsCreateProductFromRepository_shouldReturnProduct() {
        final Integer expectedSku = 43264;
        final String expectedName = "L'Oréal Professionnel Expert Absolut Repair Cortex Lipidium - Máscara de Reconstrução 500g";

        productService.clear();
        ProductRequest input = createProduct();

        assertNotNull(input);
        assertDoesNotThrow(() -> {
            Product actualProduct = productService.createProduct(input);
            assertNotNull(actualProduct);
            assertEquals(expectedSku, actualProduct.getSku());
            assertEquals(expectedName, actualProduct.getName());
        });
	}

    @Test
    public void givenValidParameters_whenCallsCreateProductFromController_shouldReturn201() {
        final Integer expectedStatusCode = 201;

        productService.clear();
        ProductRequest input = createProduct();

        assertNotNull(input);

        int actualStatusCode = productController.createProduct(input).getStatusCode().value();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    private ProductRequest createProduct() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(payloadProduct, ProductRequest.class);
        } catch (Exception e) {
            return null;
        }
    }

}
