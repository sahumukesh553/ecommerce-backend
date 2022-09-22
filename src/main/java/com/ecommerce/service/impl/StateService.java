package com.ecommerce.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Message;
import com.ecommerce.model.State;
import com.ecommerce.repository.StateRepository;
import com.ecommerce.service.CommonServiceImpl;
@Service
public class StateService extends CommonServiceImpl<State>{
@Autowired
private StateRepository stateRepository;
	@Override
	public Collection<State> getAll() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}

	@Override
	public State getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State create(State t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State updateById(State t, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
