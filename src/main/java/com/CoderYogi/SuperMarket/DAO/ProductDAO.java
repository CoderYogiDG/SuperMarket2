package com.CoderYogi.SuperMarket.DAO;

import com.CoderYogi.SuperMarket.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDAO implements ProductDAOInterface{
    //Define entity Manager
    private EntityManager entityManager;
    @Autowired
    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Product theProduct) {
        entityManager.persist(theProduct);
    }

    @Override
    public Product findById(int id) {
       Product theProduct=entityManager.find(Product.class,id);
        return theProduct;
    }

    @Override
    public List<Product> findByProductName(String prodLikeName) {
        TypedQuery theQuery=entityManager.createQuery("from Product where name=:proddata",Product.class);
        theQuery.setParameter("proddata",prodLikeName);
        List<Product> theList=theQuery.getResultList();
        return theList;
    }

    @Override
    public List<Product> findAll()
    {
        TypedQuery<Product> theQuery=entityManager.createQuery("from Product",Product.class);
        List<Product> theList= theQuery.getResultList();
        return theList;
    }

    @Override
    public List<Product> findByCode(String thecode) {
        TypedQuery<Product> theQuery=entityManager.createQuery("from Product WHERE code=:thedata",Product.class);
        theQuery.setParameter("thedata",thecode);
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void update(Product theProduct) {
    entityManager.merge(theProduct);
    }
    @Transactional
    @Override
    public List<Product> updateCondition(String cond) {
        TypedQuery<Product> theQuery=entityManager.createQuery("update Product set quantity=100 where brand=:thecond",Product.class);
        theQuery.setParameter("thecond",cond);
         return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void delete(int id) {
    Product theProduct=entityManager.find(Product.class,id);
    entityManager.remove(theProduct);
    }
    @Transactional
    @Override
    public int deleteAll() {
        int deletedRow=entityManager.createQuery("DELETE FROM Product").executeUpdate();
        return deletedRow;
    }


}
