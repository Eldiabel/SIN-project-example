package cz.cvut.fel.cs.sin.service;


import cz.cvut.fel.cs.sin.dao.PersonDAO;
import cz.cvut.fel.cs.sin.entity.Person;
import cz.cvut.fel.cs.sin.util.Resource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Test;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RunWith(Arquillian.class)
public class PersonRegistrationTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Person.class.getPackage())
                .addPackage(PersonDAO.class.getPackage())
                .addClass(PersonRegistration.class)
                .addClass(Resource.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    PersonRegistration personRegistration;

    @Test
    public void testRegister() {
        Person newPerson = new Person();
        newPerson.setFirstName("John");
        newPerson.setLastName("Doe");
        newPerson.setEmail("john.doe@example.com");
        newPerson.setAddress("Hlavní 1");
        personRegistration.register(newPerson);
        Assert.assertNotNull(newPerson.getId());
    }

    @Test(expected = EJBException.class)
    public void testRegisterWithoutRequiredData() {
        Person newPerson = new Person();
        personRegistration.register(newPerson);
    }

}
