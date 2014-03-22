package com.idocv.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.idocv.po.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

}