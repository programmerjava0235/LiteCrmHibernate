package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adress extends AbstractEntity {
	

	private String city;
	private String nameStreet;
	private int numberStreet;
	private int homeNumber;
	private int postaCode;



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNameStreet() {
		return nameStreet;
	}

	public void setNameStreet(String nameStreet) {
		this.nameStreet = nameStreet;
	}

	public int getNumberStreet() {
		return numberStreet;
	}

	public void setNumberStreet(int numberStreet) {
		this.numberStreet = numberStreet;
	}

	public int getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(int homeNumber) {
		this.homeNumber = homeNumber;
	}

	public int getPostaCode() {
		return postaCode;
	}

	public void setPostaCode(int postaCode) {
		this.postaCode = postaCode;
	}

}
