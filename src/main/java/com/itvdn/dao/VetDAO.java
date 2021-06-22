package com.itvdn.dao;

import com.itvdn.entities.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class VetDAO implements IVetDAO {
    @Override
    public void add(Vet vet) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.getCurrentSession();

        session.beginTransaction();
        session.save(vet);
        session.flush();

        session.getTransaction().commit();

        session.close();
        sf.close();
    }

    @Override
    public List<Vet> getAll() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.getCurrentSession();

        List<Vet> list = session.createQuery("from Vet", Vet.class).list();

        session.close();
        sf.close();
        return list;
    }

    @Override
    public Vet getById(long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Vet vet = sf.openSession().get(Vet.class, id);

        sf.close();

        return vet;
    }

    @Override
    public void updateById(long id, Vet vet) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        if (sf.openSession().get(Vet.class, id) != null) {
            Session session = sf.openSession();

            session.beginTransaction();

            vet.setId(id);

            session.update(vet);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        sf.close();
    }

    @Override
    public void removeById(long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Vet vet = sf.openSession().get(Vet.class, id);

        if (vet != null) {
            Session session = sf.openSession();

            session.beginTransaction();

            session.delete(vet);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        sf.close();
    }
}
