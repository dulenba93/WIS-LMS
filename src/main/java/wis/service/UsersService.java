package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Users;
import wis.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepo;
	
	public UsersService() {}
	
	public Iterable<Users> getAllUsers(){
		return usersRepo.findAll();
	}
	
	public Optional<Users> getUsersById(Long id){
		return usersRepo.findById(id);
	}
	
	public void addUser(Users user) {
		usersRepo.save(user);
	}
	
	public void removeUser(Long id) {
		Optional<Users> user = usersRepo.findById(id);
		usersRepo.delete(user.get());
	}
	
	public void updateUser(Long id,Users user) {
		Optional<Users> u = usersRepo.findById(id);
		if(u.isPresent()){
			user.setId(u.get().getId());
			usersRepo.save(user);
		}
	}
}
