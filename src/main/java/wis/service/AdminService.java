package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Admin;

import wis.repository.*;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;

	public AdminService() {}
	
	public Iterable<Admin> getAllUsers(){
		return adminRepo.findAll();
	}
	
	public Optional<Admin> getUsersById(Long id){
		return adminRepo.findById(id);
	}
	
	public void addUser(Admin admin) {
		adminRepo.save(admin);
	}
	
	public void removeUser(Long id) {
		Optional<Admin> admin = adminRepo.findById(id);
		adminRepo.delete(admin.get());
	}
	
	public void updateUser(Long id,Admin admin) {
		Optional<Admin> u = adminRepo.findById(id);
		if(u.isPresent()){
			admin.setId(u.get().getId());
			adminRepo.save(admin);
		}
	}
}
