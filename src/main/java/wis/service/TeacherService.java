package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Teacher;
import wis.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository tr;

	public TeacherService() {
	}

	public Iterable<Teacher> getTeacher() {
		return tr.findAll();
	}

	public Optional<Teacher> getTeacher(Long id) {
		return tr.findById(id);
	}

	public void addTeacher(Teacher teacher) {
		tr.save(teacher);
	}

	public void deleteTeacher(Long id) {
		Optional<Teacher> teacher = tr.findById(id);
		tr.delete(teacher.get());
	}
	
	public void updateTeacher(Long id, Teacher teacher) {
		Optional<Teacher> tchr = tr.findById(id);
		if(tchr.isPresent()) {
			teacher.setId(tchr.get().getId());
			tr.save(teacher);
		}
	}
} 