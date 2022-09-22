package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
