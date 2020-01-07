package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emails extends AbstractEntity {
	@Id
	@GeneratedValue
	private long id;

	private String emailName;

	@ManyToOne(targetEntity = Client.class)
	@JoinColumn(name = "client_id")
	private Client client;

	public String getEmailName() {
		return emailName;
	}

	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
