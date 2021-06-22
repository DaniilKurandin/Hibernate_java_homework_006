package com.itvdn.dao;

import com.itvdn.entities.Aviary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AviaryDAO implements IAviaryDAO{
    @Override
    public void add(Aviary aviary) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();
        session.save(aviary);
        session.flush();
        session.getTransaction().commit();
        session.close();
        sf.close();
    }

    @Override
    public List<Aviary> getAll() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();

        List<Aviary> list = session.createQuery("from Aviary", Aviary.class).list();

        session.close();
        sf.close();
        return list;
    }

    @Override
    public Aviary getById(long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Aviary aviary = sf.openSession().get(Aviary.class, id);

        sf.close();
        return aviary;
    }

    @Override
    public void updateById(long id, Aviary aviary) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        if (sf.openSession().get(Aviary.class, id) != null) {
            Session session = sf.openSession();

            session.beginTransaction();
            aviary.setId(id);
            session.update(aviary);
            session.flush();
            session.getTransaction().commit();
            session.close();
        }

        sf.close();
    }

    @Override
    public void removeById(long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Aviary aviary = sf.openSession().get(Aviary.class, id);

        if (aviary != null) {
            Session session = sf.openSession();
            session.beginTransaction();

            session.delete(aviary);
            session.flush();
            session.getTransaction().commit();
            session.close();
        }

        sf.close();
    }
}
