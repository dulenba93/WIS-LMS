package wis.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 50)
	private String name;
	
	@NotNull
	private Boolean deleted = false;
	
	@Version
	private int version = 0;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private University university;
	
	
	@OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })	
	private Set<StudyProgram> studyProgram;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Teacher dekan;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Address address;
	
	
	public Faculty() {}
	
	public Faculty(Long id, String name, University university, Set<StudyProgram> studyProgram) {
		this.id = id;
		this.name = name;
		this.university = university;
		this.studyProgram = studyProgram;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Set<StudyProgram> getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(Set<StudyProgram> studyProgram) {
		this.studyProgram = studyProgram;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Faculty object = (Faculty) o;
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
