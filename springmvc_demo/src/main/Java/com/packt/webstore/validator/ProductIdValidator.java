package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by lixindi on 2017/1/3.
 */
public class ProductIdValidator implements ConstraintValidator<ProductId, String> {
    @Autowired
    private ProductService productService;

    public void initialize(ProductId constraintAnnotation) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product;
        try {
            product = productService.getProductById(value);
        } catch (ProductNotFoundException e) {
            return true;
        }
        return product == null;
    }
}
