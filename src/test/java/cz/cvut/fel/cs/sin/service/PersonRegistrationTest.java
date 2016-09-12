package cz.cvut.fel.cs.sin.service;


import cz.cvut.fel.cs.sin.dao.PersonDAO;
import cz.cvut.fel.cs.sin.entity.Person;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@RunWith(Arquillian.class)
public class PersonRegistrationTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
//                .addPackage(PersonRegistration.class.getPackage())
//                .addPackage(PersonDAO.class.getPackage())
//                .addPackage(Person.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//                .addAsManifestResource(EmptyAsset.INSTANCE, "persistence.xml");
    }

//    @Inject
//    PersonRegistration personRegistration;

    @Test
    public void should_fail() {
        Assert.assertTrue(true);
    }

}
