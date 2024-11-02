/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dsweb.practica04.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.uv.dsweb.practica04.Entyties.Product;

/**
 *
 * @author juan
 */
public class ProductDAO implements IDAOGeneral<Product, Long>{

    @Override
    public Product save(Product t) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
        return t;
    }

    @Override
    public boolean delete(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null){
            session.delete(product);
        }
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Product update(Product t, Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null){
            t.setId(product.getId());
            session.update(t);
        }
        transaction.commit();
        session.close();
        return t;
    }

    @Override
    public Product find(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("From Product", Product.class).getResultList();
        session.close();
        return products;
    }
    
}
