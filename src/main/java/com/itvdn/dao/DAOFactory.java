package com.itvdn.dao;

public class DAOFactory implements IDAOFactory{

    @Override
    public IAnimalDAO getAnimalDAO() {
        return new AnimalDAO();
    }

    @Override
    public IVetDAO getVetDAO() {
        return new VetDAO();
    }

    @Override
    public IAviaryDAO getAviaryDAO() {
        return new AviaryDAO();
    }
}
