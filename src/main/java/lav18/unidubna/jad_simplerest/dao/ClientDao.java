package lav18.unidubna.jad_simplerest.dao;


import lav18.unidubna.jad_simplerest.model.Client;
import lav18.unidubna.jad_simplerest.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {
    public Client findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }

    public void save(Client user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Client user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Client user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }


    public List<Client> findAll() {
        List<Client> users = (List<Client>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select * from clients").list();
        return users;
    }
}
