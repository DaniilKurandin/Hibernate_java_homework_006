package com.itvdn;

import com.itvdn.entities.Animal;
import com.itvdn.entities.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Vet vet = new Vet("Galina", "8(982)22-22-222", "Gerkules");

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

//        Vet vet = new Vet("Maria", "8(982)11-11-111", "Voron");
//
//        IVetDAO vetDAO = new DAOFactory().getVetDAO();
//
//        vetDAO.add(vet);

//        Aviary aviary = new Aviary("biome", 3.14);
//
//        IAviaryDAO aviaryDAO = new DAOFactory().getAviaryDAO();
//
//        aviaryDAO.add(aviary);

        Animal animal = new Animal("Voron", 5, false);

        vet.setId(1);

        animal.setVet(vet);

        session.save(animal);
        session.flush();

        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
