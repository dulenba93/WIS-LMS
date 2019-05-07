package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.University;
import wis.repository.UniversityRepository;

@Service
public class UniversityService {
	@Autowired
	UniversityRepository ur;

	public UniversityService() {
	}

	public Iterable<University> getUniversity() {
		return ur.findAll();
	}

	public Optional<University> getUniversity(Long id) {
		return ur.findById(id);
	}

	public void addUniversity(University university) {
		ur.save(university);
	}

	public void deleteUniversity(Long id) {
		Optional<University> university = ur.findById(id);
		ur.delete(university.get());
	}
	
	public void updateUniversity(Long id, University university) {
		Optional<University> unvs = ur.findById(id);
		if(unvs.isPresent()) {
			university.setId(unvs.get().getId());
			ur.save(university);
		}
	}
}