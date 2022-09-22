package com.ecommerce.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.Message;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.impl.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	

  @Autowired
  private UserService userService;

 @Autowired
 private UploadController uploadController;

  @GetMapping("/")
  public Collection<User> getAllUsers()
  {
	  return userService.getAll();
	  
  }
  @GetMapping("/{id}")
  public User getUser(@PathVariable Long id)
  {
	
		return userService.getById(id);
  }
  
  @GetMapping("/count")
  public Integer getUsersCount()
  {
	
	  return userService.getAll().size();
  }
 
  
  @PostMapping("/")
  public User createUser(@RequestBody User user){
	  if(this.uploadController.getImage()!=null)
	  {
		  user.setProfileImage(this.uploadController.getImage());
		 this.uploadController.setImage(null);
	  }
    return this.userService.create(user);
  }

  @PutMapping("/{id}")
  //@PreAuthorize("@userAuthorizationService.canUpdate(principal.user.id, #id) or hasRole('ROLE_admin')")
  public User updateUser(@PathVariable long id, @RequestBody User user){
	  if(this.uploadController.getImage()!=null)
	  {
		  user.setProfileImage(this.uploadController.getImage());
		 this.uploadController.setImage(null);
	  }
    return this.userService.updateById(user,id);
  }
  @DeleteMapping("/{id}")
  public Message deleteById(@PathVariable Long id)
  {
	  return this.userService.deleteById(id);
  }
  
}
