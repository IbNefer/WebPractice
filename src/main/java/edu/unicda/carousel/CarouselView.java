/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unicda.carousel;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.primefaces.model.ResponsiveOption;

/**
 *
 * @author alexa
 */
@Named
@ViewScoped
public class CarouselView implements Serializable {

    private List<Product> products;
     private String searchTerm;
     
    private List<ResponsiveOption> responsiveOptions;

    @Inject
    private ProductService service;

    @PostConstruct
    public void init() {
        products = service.getProducts(6);
        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }
    
     public List<Product> getFilteredProducts() {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return products;
        }
        String lowerSearch = searchTerm.toLowerCase();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(lowerSearch))
                .collect(Collectors.toList());
    }

    // Getters y setters

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public List<ResponsiveOption> getResponsiveOptions() {
        return responsiveOptions;
    }

    public void setResponsiveOptions(List<ResponsiveOption> responsiveOptions) {
        this.responsiveOptions = responsiveOptions;
    }
}