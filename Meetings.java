package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Meetings extends AbstractEntity {

	private java.sql.Date date;
	private boolean beenPerformed;
	private String findings;

	@ManyToMany
	@JoinTable(name = "clients_meetings", joinColumns = { @JoinColumn(name = "id_meetings") }, inverseJoinColumns = {
			@JoinColumn(name = "id_client") })
	private List<Client> client;
	@ManyToMany
	@JoinTable(name = "contactPerson_meetings", joinColumns = {
			@JoinColumn(name = "id_meetings") }, inverseJoinColumns = { @JoinColumn(name = "id_personContact") })
	private List<ContactPersons> contactPersons;
	@ManyToMany
	private List<Users> users;

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public boolean isBeenPerformed() {
		return beenPerformed;
	}

	public void setBeenPerformed(boolean beenPerformed) {
		this.beenPerformed = beenPerformed;
	}

	public String getFindings() {
		return findings;
	}

	public void setFindings(String findings) {
		this.findings = findings;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public List<ContactPersons> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPersons> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}
