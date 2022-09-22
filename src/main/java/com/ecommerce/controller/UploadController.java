package com.ecommerce.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.Message;

@RestController
@RequestMapping("/upload")
@CrossOrigin("http://localhost:4200/")
public class UploadController {
	private byte[] profileImage;
	public byte[] getImage()
	{
		return this.profileImage;
	}
	public void setImage(byte[] image)
	{
		this.profileImage=image;
	}
	@PostMapping("/")
	public Message uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.profileImage = file.getBytes();
		return new Message("image uploaded sucessfully",HttpStatus.OK);
	}

}
