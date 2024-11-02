/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dsweb.practica04.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.uv.dsweb.practica04.Entyties.Client;

/**
 *
 * @author juan
 */
public class ClientDAO implements IDAOGeneral<Client, Long>{

    @Override
    public Client save(Client t) {
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
        Client client = session.get(Client.class, id);
        if (client != null) {
            session.delete(client);
        }
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Client update(Client t, Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        if (client != null) {
            t.setId(client.getId());
            session.update(t);
        }
        transaction.commit();
        session.close();
        return t;
    }

    @Override
    public Client find(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public List<Client> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("From Client", Client.class).getResultList();
        session.close();
        return clients;
    }
    
}
