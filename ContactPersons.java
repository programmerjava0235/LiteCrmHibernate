package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ContactPersons extends AbstractEntity {

	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "contactPersons")
	List<TasksAndActivities> tasks = new ArrayList<>();
	@ManyToMany(mappedBy = "contactPersons")
	List<Meetings> meetings = new ArrayList<>();

	@OneToOne(targetEntity = Phones.class)
	@JoinColumn(name = "id_phones")
	private Phones phones;

	@OneToOne(targetEntity = Emails.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "id_emails")
	private Emails emails;

	@ManyToOne(targetEntity = Client.class)
	@JoinColumn(name = "id_client")
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<TasksAndActivities> getTasks() {
		return tasks;
	}

	public void setTasks(List<TasksAndActivities> tasks) {
		this.tasks = tasks;
	}

	public List<Meetings> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meetings> meetings) {
		this.meetings = meetings;
	}

	public Phones getPhones() {
		return phones;
	}

	public void setPhones(Phones phones) {
		this.phones = phones;
	}

	public Emails getEmails() {
		return emails;
	}

	public void setEmails(Emails emails) {
		this.emails = emails;
	}

}
