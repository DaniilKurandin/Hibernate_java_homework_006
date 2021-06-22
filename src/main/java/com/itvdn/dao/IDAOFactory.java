package com.itvdn.dao;

public interface IDAOFactory {
    IAnimalDAO getAnimalDAO();
    IVetDAO getVetDAO();
    IAviaryDAO getAviaryDAO();
}
