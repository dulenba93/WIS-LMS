package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.StudentYear;
import wis.repository.StudentYearRepository;

@Service
public class StudentYearService {
	@Autowired
	StudentYearRepository sr;

	public StudentYearService() {
	}

	public Iterable<StudentYear> getStudentYear() {
		return sr.findAll();
	}

	public Optional<StudentYear> getStudentYear(Long id) {
		return sr.findById(id);
	}

	public void addStudentYear(StudentYear studentYear) {
		sr.save(studentYear);
	}

	public void deleteStudentYear(Long id) {
		Optional<StudentYear> studentYear = sr.findById(id);
		sr.delete(studentYear.get());
	}
	
	public void updateStudentYear(Long id, StudentYear studentYear) {
		Optional<StudentYear> stdnty = sr.findById(id);
		if(stdnty.isPresent()) {
			studentYear.setId(stdnty.get().getId());
			sr.save(studentYear);
		}
	}
}
