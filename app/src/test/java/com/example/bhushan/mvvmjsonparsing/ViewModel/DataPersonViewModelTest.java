package com.example.bhushan.mvvmjsonparsing.ViewModel;

import com.example.bhushan.mvvmjsonparsing.Model.Person;
import com.example.bhushan.mvvmjsonparsing.PersonApplication;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Bhushan on 6/21/2017.
 */
public class DataPersonViewModelTest {
    private static final String PERSON_ID_TEST = "7";
    private static final String PERSON_FIRST_NAME_TEST = "Bhushan";
    private static final String PERSON_LAST_NAME_TEST = "Pawar";
    private static final String PERSON_IMAGE_TEST = "https://upload.wikimedia.org/wikipedia/en/0/02/HOMER_SIMPSON_2006.png";
    private PersonApplication personApplication;


    @Test
    public void getId() throws Exception {

        Person person = new Person();
        person.id = PERSON_ID_TEST;
        DataPersonViewModel dataPersonViewModel = new DataPersonViewModel(person,personApplication);
        assertEquals(person.id,dataPersonViewModel.getId());

    }

    @Test
    public void getFirstname() throws Exception {
        Person person = new Person();
        person.firstname = PERSON_FIRST_NAME_TEST;
        DataPersonViewModel dataPersonViewModel = new DataPersonViewModel(person,personApplication);
        assertEquals(person.firstname,dataPersonViewModel.getFirstname());

    }

    @Test
    public void getLastname() throws Exception {
        Person person = new Person();
        person.lastname = PERSON_LAST_NAME_TEST;
        DataPersonViewModel dataPersonViewModel = new DataPersonViewModel(person,personApplication);
        assertEquals(person.lastname,dataPersonViewModel.getLastname());

    }

    @Test
    public void getImage() throws Exception {
        Person person = new Person();
        person.image = PERSON_IMAGE_TEST;
        DataPersonViewModel dataPersonViewModel = new DataPersonViewModel(person,personApplication);
        assertEquals(person.image,dataPersonViewModel.getImage());

    }

    
}