package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class WizardRepository implements WizardDao {

    private static List<Wizard> wizards = new ArrayList<>(
            Arrays.asList(
                    new Wizard(1L, "Harry", "Potter", new Date(80, 6, 31), "London", "", false)
            )
    );

    @Override
    public void save(Wizard wizard) {

        wizard.setId((long) (wizards.size() + 1));
        wizards.add(wizard);
    }

    @Override
    public Wizard findById(Long id) {

        for (Wizard wizard : wizards) {
            if (wizard.getId().equals(id)) {
                return wizard;
            }
        }
        return null;
    }

    @Override
    public List<Wizard> findAll() {

        return wizards;
    }

    @Override
    public void update(Wizard wizard) {

        for (Wizard update : wizards) {
            if (update.getId().equals(wizard.getId())) {
                update.setFirstName(wizard.getFirstName());
                update.setLastName(wizard.getLastName());
                update.setBirthday(wizard.getBirthday());
                update.setBirthPlace(wizard.getBirthPlace());
                update.setBiography(wizard.getBiography());
                update.setMuggle(wizard.isMuggle());

                return;
            }
        }
    }

    @Override
    public void deleteById(Long id) {

        for (Wizard wizard : wizards) {
            if (wizard.getId().equals(id)) {
                wizards.remove(wizard);
                break;
            }
        }
    }
}
