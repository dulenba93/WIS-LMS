package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.YearOfStudy;
import wis.repository.YearOfStudyRepository;

@Service
public class YearOfStudyService {
	@Autowired
	YearOfStudyRepository yr;

	public YearOfStudyService() {
	}

	public Iterable<YearOfStudy> getYearOfStudy() {
		return yr.findAll();
	}

	public Optional<YearOfStudy> getYearOfStudy(Long id) {
		return yr.findById(id);
	}

	public void addYearOfStudy(YearOfStudy yearOfStudy) {
		yr.save(yearOfStudy);
	}

	public void deleteYearOfStudy(Long id) {
		Optional<YearOfStudy> yearOfStudy = yr.findById(id);
		yr.delete(yearOfStudy.get());
	}
	
	public void updateYearOfStudy(Long id, YearOfStudy yearOfStudy) {
		Optional<YearOfStudy> yros = yr.findById(id);
		if(yros.isPresent()) {
			yearOfStudy.setId(yros.get().getId());
			yr.save(yearOfStudy);
		}
	}
}
