package com.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emr.model.Practitioner;

@Repository
public interface PractitinoerRepository extends JpaRepository<Practitioner, Integer>{

}