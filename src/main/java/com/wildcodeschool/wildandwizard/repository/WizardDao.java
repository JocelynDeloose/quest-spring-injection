package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.Wizard;

import java.util.List;

public interface WizardDao {

    void save(Wizard entity);

    Wizard findById(Long id);

    List<Wizard> findAll();

    void update(Wizard entity);

    void deleteById(Long id);
}