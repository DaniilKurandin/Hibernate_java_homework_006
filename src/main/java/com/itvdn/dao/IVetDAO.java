package com.itvdn.dao;

import com.itvdn.entities.Vet;

import java.util.List;

public interface IVetDAO {
    void add(Vet vet);

    List<Vet> getAll();

    Vet getById(long id);

    void updateById(long id, Vet vet);

    void removeById(long id);
}
