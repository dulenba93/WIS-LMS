package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Faculty;
import wis.repository.FacultyRepository;

@Service
public class FacultyService {
	@Autowired
	FacultyRepository fr;

	public FacultyService() {
	}

	public Iterable<Faculty> getFaculty() {
		return fr.findAll();
	}

	public Optional<Faculty> getFaculty(Long id) {
		return fr.findById(id);
	}

	public void addFaculty(Faculty faculty) {
		fr.save(faculty);
	}

	public void deleteFaculty(Long id) {
		Optional<Faculty> faculty = fr.findById(id);
		fr.delete(faculty.get());
	}
	
	public void updateFaculty(Long id, Faculty faculty) {
		Optional<Faculty> fclt = fr.findById(id);
		if(fclt.isPresent()) {
			faculty.setId(fclt.get().getId());
			fr.save(faculty);
		}
	}
}
