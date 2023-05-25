package com.CoderYogi.SuperMarket.DAO;

import com.CoderYogi.SuperMarket.Entity.Product;

import java.util.List;

public interface ProductDAOInterface {
    public void save(Product theProduct);
    public List<Product> findAll();
    public List<Product> findByCode(String code);

    public Product findById(int id);
    public List<Product> findByProductName(String prodLikeName);
    public void update(Product theProduct);
    public List<Product> updateCondition(String cond);
    public void delete(int id);
    public int deleteAll();

}
