/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unicda.carousel;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author alexa
 */
@Named
@ApplicationScoped
public class ProductService {

    private List<Product> products;

    @PostConstruct
    public void init() {
     products = new ArrayList<>();
products.add(new Product(1019, "mnb5mb2m5", "T-bone Steak", "Product Description", "tbone.jpeg", 79,
        "T-Bone Steak", 63, InventoryStatus.INSTOCK, 4));
products.add(new Product(1020, "r23fwf2w3", "Steak", "Product Description", "steak.jpeg", 110,
        "Steak", 0, InventoryStatus.OUTOFSTOCK, 4));
products.add(new Product(1021, "pxpzczo23", "Tomahawk-Steak", "Product Description", "tomahawk.jpeg", 79,
        "Tomahawk-Steak", 6, InventoryStatus.LOWSTOCK, 3));
products.add(new Product(1022, "2c42cb5cb", "Ground Beef", "Product Description", "ground.jpeg", 45,
        "Ground Beef", 62, InventoryStatus.INSTOCK, 4));
products.add(new Product(1023, "5k43kkk23", "Pork", "Product Description", "pork.jpeg", 49,
        "Pork", 2, InventoryStatus.LOWSTOCK, 5));
products.add(new Product(1024, "lm2tny2k4", "Goat Meat", "Product Description", "goat.jpeg", 64,
        "Goat", 0, InventoryStatus.INSTOCK, 4));


    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Product> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(products.subList(0, size));
        }

    }

    public List<Product> getClonedProducts(int size) {
        List<Product> results = new ArrayList<>();
        List<Product> originals = getProducts(size);
        for (Product original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (Product product : results) {
            product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }
}
