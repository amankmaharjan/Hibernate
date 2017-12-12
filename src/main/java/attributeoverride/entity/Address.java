package attributeoverride.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class  Address {

    @Column(name = "student_country")
	private String country;
	@Column(name = "student_city")
	private String city;
	
	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + "]";
	}

	public Address(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}

	public Address() {
		super();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	

}