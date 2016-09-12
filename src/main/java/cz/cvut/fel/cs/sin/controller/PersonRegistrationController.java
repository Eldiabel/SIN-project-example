package cz.cvut.fel.cs.sin.controller;

import cz.cvut.fel.cs.sin.entity.Person;
import cz.cvut.fel.cs.sin.service.PersonRegistration;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Model // See http://www.cdi-spec.org/faq/#accordion6
public class PersonRegistrationController {

    @Inject
    private PersonRegistration personRegistration;

    @Produces
    @Named
    private Person newPerson;

    @PostConstruct
    public void initNewPerson() {
        newPerson = new Person();
    }

    public void registerNewPerson() {
        personRegistration.register(newPerson);
        initNewPerson();
    }

}
