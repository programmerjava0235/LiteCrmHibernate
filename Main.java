package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorialdb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Adress adressObject = new Adress();
		adressObject.setCity("New York");
		adressObject.setHomeNumber(26);
		adressObject.setNameStreet("str. Bollewar");
		adressObject.setNumberStreet(4);
		adressObject.setPostaCode(2192);

		List<Adress> adressArray = new ArrayList<>();
		adressArray.add(adressObject);

		Phones phonesObj = new Phones();
		phonesObj.setPhoneNumber("12345678");
		phonesObj.setType("Mobile");

		List<Phones> phonesArray = new ArrayList<>();
		phonesArray.add(phonesObj);

		Emails email = new Emails();
		email.setEmailName("office@bi.com");

		List<Emails> emailsArray = new ArrayList<>();
		emailsArray.add(email);

		
		
		Phones phonePersonObj = new Phones();
		phonePersonObj.setType("mobile");
		phonePersonObj.setPhoneNumber("1233333333");
		List<Phones> phonePersonList = new ArrayList<>();
		phonePersonList.add(phonePersonObj);

		

		Emails emailPersonObj = new Emails();
		emailPersonObj.setEmailName("john@bi.com");
		List<Emails> emailsPersonList = new ArrayList<>();
		emailsPersonList.add(emailPersonObj);
		

		
		ServiceContracts contract = new ServiceContracts();
		contract.setDateStart(java.sql.Date.valueOf("2017-11-15"));
		contract.setDateEnd(java.sql.Date.valueOf("2018-11-15"));
		contract.setHoursContract(160.00F);
		contract.setContract(true);

		ImplementationAgreements im = new ImplementationAgreements();
		im.setDateStart(java.sql.Date.valueOf("2017-12-15"));
		im.setDateEnd(java.sql.Date.valueOf("2017-12-31"));
		im.setHoursContract(20.00F);
		im.setContract(true);

		ContactPersons contactPersonObj = new ContactPersons();
		contactPersonObj.setFirstName("john");
		contactPersonObj.setLastName("smith");
		contactPersonObj.setPhones(phonePersonObj);
		contactPersonObj.setEmails(emailPersonObj);
		List<ContactPersons> contactPersonsList = new ArrayList<>();
		contactPersonsList.add(contactPersonObj);

		ClientsGroups cg = new ClientsGroups();
		cg.setNameGroup("Construction Company");
		
		TasksAndActivities tasks = new TasksAndActivities();
		tasks.setContactPersons(contactPersonsList);
		tasks.setHoursTask(2.30F);
		tasks.setPriority(2);
		tasks.setAcctivities("Data Base implementation");
		
		List<TasksAndActivities> tasksList = new ArrayList<>();
		tasksList.add(tasks);
		
		Users user = new Users();
		user.setFirstName("Adam");
		user.setLastName("Novotny");
		user.setTasks(tasksList);
		
		List<Users> usersList = new ArrayList<>();
		usersList.add(user);
		
		tasks.setUsers(usersList);
		tasks.setContactPersons(contactPersonsList);
		
		Meetings meeting = new Meetings();
		meeting.setBeenPerformed(true);
		meeting.setContactPersons(contactPersonsList);
		meeting.setUsers(usersList);
		meeting.setFindings("customer contact to arrange tasks");
		List <Meetings> meetingsList = new ArrayList<>();
		meetingsList.add(meeting);
		
		user.setMeetings(meetingsList);
		
		RoleUsers roleUser = new RoleUsers();
		roleUser.setName("Account Manager");
		roleUser.setUsers(usersList);
		
		Client client = new Client.Builder()
				.companyName("Budment Investment")
				.nip("1234567890")
				.adress(adressArray)
				.phones(phonesArray)
				.emails(emailsArray)
				.contactPersons(contactPersonsList)
				.serviceContracts(contract)
				.agreements(im).build();

		List<Client> clientsList = new ArrayList<>();
		clientsList.add(client);
		phonePersonObj.setClient(client);
		emailPersonObj.setClient(client);
		phonesObj.setClient(client);
		email.setClient(client);		
		contactPersonObj.setClient(client);
		cg.setClient(clientsList);
		tasks.setClient(clientsList);
		user.setClient(clientsList);
		meeting.setClient(clientsList);
		
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.persist(adressObject);
		entityManager.persist(phonesObj);
		entityManager.persist(email);
		entityManager.persist(phonePersonObj);
		entityManager.persist(emailPersonObj);
		entityManager.persist(contactPersonObj);
		entityManager.persist(contract);
		entityManager.persist(im);
		entityManager.persist(cg);
		entityManager.persist(tasks);
		entityManager.persist(user);
		entityManager.persist(meeting);
		entityManager.persist(roleUser);
		entityManager.getTransaction().commit();

		entityManager.refresh(client);

		entityManager.close();
		entityManagerFactory.close();

	}

}
