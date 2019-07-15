package com.cs544.user.user.repository;

import com.cs544.user.user.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface IResturantRepository extends JpaRepository<Restaurant,Integer> {

}


