package com.ecommerce.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Message;
import com.ecommerce.model.Role;
import com.ecommerce.model.User;
import com.ecommerce.repository.RoleRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.CommonServiceImpl;
@Service
public class UserService extends CommonServiceImpl<User> {
@Autowired
private UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private RoleService roleService;
@Autowired
private RoleRepository roleRepository;
	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getById(Long id) {
		User user=userRepository.findById(id).get();
		return user ;
	}

	@Override
	public User create(User t) {
		t.setPassword(passwordEncoder.encode(t.getPassword()));
		if(t.getRoleId()==null)
		{
			t.setRole(this.roleRepository.findByRoleName("NORMAL"));
		}
		User save = userRepository.save(t);
		return save;
	}

	@Override
	public User updateById(User t, Long id) {
		// TODO Auto-generated method stub
		User user = this.userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
		if(t.getName()!=null)
			user.setName(t.getName());
		
		if(t.getNumber()!=null)
			user.setNumber(t.getNumber());
		
		if(t.getEmail()!=null)
			user.setEmail(t.getEmail());
		if(t.getPassword()!=null && !t.getPassword().isBlank())
		user.setPassword(passwordEncoder.encode(t.getPassword()));
		if(t.getProfileImage()!=null)
		user.setProfileImage(t.getProfileImage());
		if(t.getRoleId()!=null)
		{
			Role role=roleService.getById(t.getRoleId());
			user.setRole(role);
			user.setRoleId(role.getId());
		}
		if(t.getGender()!=null)
		{
			user.setGender(t.getGender());
		}
		
		return this.userRepository.saveAndFlush(user);
	}

	@Override
	public Message deleteById(Long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
		return new Message(HttpStatus.OK,"userDeleted successfully");
	}
	
	public void updateResetPasswordToken(String token, String email) throws RuntimeException {
        User customer = userRepository.findByEmail(email);
        if (customer != null) {
            customer.setResetPasswordToken(token);
            userRepository.save(customer);
        } else {
            throw new RuntimeException("Could not find any customer with the email " + email);
        }
    }
     
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User customer, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        customer.setPassword(encodedPassword);
         
        customer.setResetPasswordToken(null);
        userRepository.save(customer);
    }

}
