package br.com.blz.testjava;

import br.com.blz.testjava.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
	public void contextLoads() {
        final Integer expectedSku = 43264;
        final String expectedName = "L'Oréal Professionnel Expert Absolut Repair Cortex Lipidium - Máscara de Reconstrução 500g";
        final Integer expectedQuantity = 15;

        Product actualProduct = createProduct();
	}

    private Product createProduct() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(payloadProduct, Product.class);
        } catch (Exception e) {
            return null;
        }
    }

}
