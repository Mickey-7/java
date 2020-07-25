package com.example.multipledatabasewithtest;

import com.example.multipledatabasewithtest.product.data.ProductModel;
import com.example.multipledatabasewithtest.product.repo.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultipleDataSourcesProductTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("productTransactionManager")
    public void create_check_product(){
        ProductModel productModel = new ProductModel("228781","Running Shoes", 20.0);
        productModel = productRepository.save(productModel);

        Assert.assertNotNull(productRepository.findById(productModel.getId()));
    }
}
