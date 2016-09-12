package cz.cvut.fel.cs.sin.service;

import cz.cvut.fel.cs.sin.dao.PersonDAO;
import cz.cvut.fel.cs.sin.entity.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonRegistration {

    @Inject
    private PersonDAO personDAO;

    public void register(Person person) {
        personDAO.save(person);
        // TODO: logging
        // TODO: event triggering
    }

}
