package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements IEmployeService {

private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
@Autowired
EmployeRepository emp_rep;

@Override
public List<Employe> retrieveAllEmployes() {

List<Employe> Employes = null;
try {

l.info("In retrieveAllUsers() : ");
Employes = (List<Employe>) emp_rep.findAll();  
for (Employe emp : Employes) {
l.debug("user +++ : " + emp);
}
l.info("Out of retrieveAllUsers() : ");
}catch (Exception e) {
l.error("Error in retrieveAllUsers() : " + e);
}

return Employes;
}

@Override
public Employe addEmploye(Employe emp) {

try{
l.info("Adding Employe To Data Base :");
return emp_rep.save(emp);
}catch (Exception e) {
return emp_rep.save(emp);
}
}

@Override
public void deleteEmploye(int id) {
try{
l.info("Finding Employe with id = %d",id);
emp_rep.deleteById(id);
l.info("Employe Deleted Successfuly ");
}catch (Exception e) {

l.error("The emp with id = %d does not Exist",id);
}

}

@Override
public Employe updateEmploye(Employe emp) {

emp_rep.save(emp);
return emp;
}

@Override
public Employe retrieveEmploye(int id) {
l.info("in  retrieveUser id = " + id);
//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
//int i = 1/0;
Employe e =  emp_rep.findById(id).orElse(null);
l.info("Employe found : " + e);
return e;
}
}
