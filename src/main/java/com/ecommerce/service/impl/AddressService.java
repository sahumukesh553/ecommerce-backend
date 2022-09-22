package com.ecommerce.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Address;
import com.ecommerce.model.Message;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.service.CommonServiceImpl;
@Service
public class AddressService extends CommonServiceImpl<Address> {
@Autowired
private AddressRepository addressRepository;
@Autowired
private UserService userService;
	@Override
	public Collection<Address> getAll() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	@Override
	public Address getById(Long id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id).get();
	}

	@Override
	public Address create(Address t) {
		if(t.getUserId()!=null)
		{  
			t.setUser(userService.getById(t.getUserId()));
		}
		
		return addressRepository.save(t);
	}

	@Override
	public Address updateById(Address t, Long id) {
		
		Address address=getById(id);
		if(t.getUserId()!=null)
		{ 
			address.setUser(userService.getById(t.getUserId()));
		}
		if(t.getCity()!=null)
		{
			address.setCity(t.getCity());
		}
		if(t.getCountry()!=null)
		{
			address.setCountry(t.getCountry());
		}
		if(t.getPincode()!=null)
		{
			address.setPincode(t.getPincode());
		}
		if(t.getState()!=null)
		{
			address.setState(t.getState());
		}
		if(t.getLandMark()!=null)
			address.setLandMark(t.getLandMark());
		return addressRepository.save(address);
	}

	@Override
	public Message deleteById(Long id) {
		// TODO Auto-generated method stub
		addressRepository.deleteById(id);
		return new Message("Address Deleted Successfully",HttpStatus.OK);
	}

}
