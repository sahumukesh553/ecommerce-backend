package com.ecommerce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Address;
import com.ecommerce.model.Address;
import com.ecommerce.model.Message;
import com.ecommerce.service.impl.AddressService;
@RestController
@RequestMapping("/address")
@CrossOrigin("http://localhost:4200/")
public class AddressController {
@Autowired
private AddressService addressService;

@GetMapping("/")
public Collection<Address> getAllAddress(){
	return addressService.getAll();
}

@PostMapping("/")
public Address saveAddress(@RequestBody Address address) {
	return addressService.create(address);
}

@GetMapping("/{id}")
public Address getAddressById(@PathVariable("id") Long id)
{
	   return addressService.getById(id);
}

@PutMapping("/{id}")
public Address updateAddress(@PathVariable("id") Long id,@RequestBody Address Address)
{
	   return this.addressService.updateById(Address, id);
}

@DeleteMapping("/{id}")
public Message deleteAddress(@PathVariable("id") Long id)
{
	   return this.addressService.deleteById(id);
}


}
