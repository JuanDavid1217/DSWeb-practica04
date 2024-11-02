/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dsweb.practica04.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.uv.dsweb.practica04.Entyties.Sale;
import org.uv.dsweb.practica04.Entyties.SaleDetail;

/**
 *
 * @author juan
 */
public class SaleDAO implements IDAOGeneral<Sale, Long>{

    @Override
    public Sale save(Sale t) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        List<SaleDetail> details = t.getDetails();
        for (int i=0; i < details.size(); i++){
            SaleDetail detail = details.get(i);
            detail.setSale(t);
            details.set(i, detail);
        }
        t.setDetails(details);
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
        Sale sale = session.get(Sale.class, id);
        if (sale != null){
            session.remove(sale);
        }
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Sale update(Sale t, Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Sale sale = session.get(Sale.class, id);
        if (sale != null){
            t.setId(sale.getId());
            session.update(t);
        }
        transaction.commit();
        session.close();
        return t;
    }

    @Override
    public Sale find(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Sale sale = session.get(Sale.class, id);
        session.close();
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Sale> sales = session.createQuery("From Sale", Sale.class).getResultList();
        session.close();
        return sales;
    }
    
}
