package wis.domain;

import java.util.Date;
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
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 50)
	private Date dateChosen;
	
	@Size(max = 50)
	private Date dateStop;
	
	
	@OneToOne(mappedBy = "title", cascade = CascadeType.ALL)
    private TitleType titleType;
	
	
	
	@OneToMany(mappedBy = "title", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })	
	private Set<StudyField> studyFields;
	

	
	
	//da li ovo treba ovako? promenio sam kako mislim da treba
	@ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
	
	public Title(Long id, @Size(max = 50) Date dateChosen, @Size(max = 50) Date dateStop) {
		super();
		this.id = id;
		this.dateChosen = dateChosen;
		this.dateStop = dateStop;
	}
	
	public Title() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateChosen() {
		return dateChosen;
	}

	public void setDateChosen(Date dateChosen) {
		this.dateChosen = dateChosen;
	}

	public Date getDateStop() {
		return dateStop;
	}

	public void setDateStop(Date dateStop) {
		this.dateStop = dateStop;
	}

	public Set<StudyField> getStudyFields() {
		return studyFields;
	}

	public void setStudyFields(Set<StudyField> studyFields) {
		this.studyFields = studyFields;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



		////
	@NotNull
	private Boolean deleted = false;
		
	@Version
	private int version = 0;
		////
		
	
	//bilo zaboravljeno	
	@Override
	public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Title object = (Title) o;
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
