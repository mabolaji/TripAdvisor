package com.cs544.repository;

import com.cs544.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResturantRepository extends JpaRepository<Restaurant,Integer> {

}


