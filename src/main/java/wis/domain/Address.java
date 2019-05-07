package wis.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String street;

	@Size(max = 50)
	private String number;

	////
	@NotNull
	private Boolean deleted = false;
	
	@Version
	private int version = 0;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Place place;
	
	
	@OneToOne(fetch = FetchType.LAZY)	
	private University university;
	
	@OneToOne(fetch = FetchType.LAZY)	
	private University teacher;
	
	@OneToOne(fetch = FetchType.LAZY)	
	private University student;
	
	
	@OneToOne(fetch = FetchType.LAZY)		
	private Faculty faculty;
	
	public Address() {}
	
	public Address(Long id, String street, String number, Place place, University university ,Faculty faculty) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.place = place;
		this.university = university;
		this.faculty = faculty;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address object = (Address) o;
		if (object.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, object.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
