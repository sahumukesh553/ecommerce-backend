package com.ecommerce.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.ForgotPasswordModel;
import com.ecommerce.model.Message;
import com.ecommerce.model.User;
import com.ecommerce.service.impl.EmailService;
import com.ecommerce.service.impl.UserService;


import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/password")
@CrossOrigin("http://localhost:4200/")
public class ForgotPasswordController {
   
     
    @Autowired
    private UserService userService;
     
  
 
    @GetMapping("/forgot_password")
    public ResponseEntity<Message> processForgotPassword(@RequestParam ("email") String email,HttpServletRequest request) {
    	  
    	    String token = RandomString.make(30);
    	     
    	    try {
    	        userService.updateResetPasswordToken(token, email);
    	        String resetPasswordLink ="http://localhost:4200/forgot-password/reset-password?token=" + token;
    	        sendEmail(email, resetPasswordLink);
    	       // model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
    	         
    	    } catch (RuntimeException ex) {
    	     ex.printStackTrace();
    	     return new ResponseEntity<>(new Message(" no account  exist with given  mail"),HttpStatus.NOT_FOUND);
    	    } catch (UnsupportedEncodingException | MessagingException e) {
    	      e.printStackTrace();
    	      return new ResponseEntity<>( new Message("unble to share  password link  to your mail"),HttpStatus.BAD_REQUEST);
    	    }
    	         
    	    return new ResponseEntity<>(new Message("reset password link sent to your mail"),HttpStatus.OK);
    }
     
    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
    	    String content = "Hello \n"
                + "You have requested to reset your password"
                + "\n Click the link below to change your password:"
                + "\n  "+ link + ""
                + ""
                + "\n Ignore this email if you do remember your password, "
                + " \n or you have not made the request.";
         
       EmailService.sendEmail(content,recipientEmail);
         
    
    }
     
     
    @GetMapping("/reset_password")
    public String showResetPasswordForm(@RequestParam(value = "token") String token) {
        User customer = userService.getByResetPasswordToken(token);
       
        if (customer == null) {
         
            return "false";
        }
         
        return "true" ;
    }
     
    @PostMapping("/reset_password")
    public ResponseEntity<Message> processResetPassword(@RequestBody ForgotPasswordModel forgotPasswordModel) {
        
         
        User customer = userService.getByResetPasswordToken(forgotPasswordModel.getToken());
     
         
        if (customer == null) {
          
            return new ResponseEntity<>(new Message("password link has been expired"),HttpStatus.NOT_FOUND);
        } else {           
            userService.updatePassword(customer,forgotPasswordModel.getPassword());
             
            
        }
         
        return new ResponseEntity<>(new Message("your password has been reset successfully"),HttpStatus.OK);
    }
}

