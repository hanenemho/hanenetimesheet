package tn.esprit.spring.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;


import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeServiceImplTest {
//try pushh trigger
static int id_added;

@Autowired
EmployeServiceImpl emp_sev;

@Test
public void testAddEmploye()  {


Employe emp = new Employe("BH", "Hanene","",true, Role.INGENIEUR);
Employe empAdded = emp_sev.addEmploye(emp);
id_added = empAdded.getId();
assertNotNull(empAdded.getId());

}
@Test

public void TestRetreiveEmploye(){
Employe RetreivedEmp = emp_sev.retrieveEmploye(id_added);
Assert.assertNotNull(RetreivedEmp);
}

@Test

public void testModifyEmployee() throws ParseException {

Employe emp = emp_sev.retrieveEmploye(id_added);
Employe emp_modifyed = emp;
emp_modifyed.setNom("hanene123");
Employe EmployeUpdated  = emp_sev.updateEmploye(emp);

Assert.assertTrue(0==emp.getNom().compareTo(EmployeUpdated.getNom()));
}


@Test

public void testretrieveAllEmployes(){
assertTrue(emp_sev.retrieveAllEmployes().size()>=1);


}



}
