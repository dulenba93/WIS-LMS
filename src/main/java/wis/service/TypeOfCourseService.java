package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.TypeOfCourse;
import wis.repository.TypeOfCourseRepository;

@Service
public class TypeOfCourseService {
	@Autowired
	TypeOfCourseRepository tr;

	public TypeOfCourseService() {	}

	public Iterable<TypeOfCourse> getTypeOfCourse() {
		return tr.findAll();
	}

	public Optional<TypeOfCourse> getTypeOfCourse(Long id) {
		return tr.findById(id);
	}

	public void addTypeOfCourse(TypeOfCourse typeOfCourse) {
		tr.save(typeOfCourse);
	}

	public void deleteTypeOfCourse(Long id) {
		Optional<TypeOfCourse> typeOfCourse = tr.findById(id);
		tr.delete(typeOfCourse.get());
	}
	
	public void updateTypeOfCourse(Long id, TypeOfCourse typeOfCourse) {
		Optional<TypeOfCourse> tpoc = tr.findById(id);
		if(tpoc.isPresent()) {
			typeOfCourse.setId(tpoc.get().getId());
			tr.save(typeOfCourse);
		}
	}
}