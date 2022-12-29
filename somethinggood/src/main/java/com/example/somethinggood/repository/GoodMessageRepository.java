package com.example.somethinggood.repository;

import com.example.somethinggood.domain.User;
import com.example.somethinggood.domain.GoodMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GoodMessageRepository extends CrudRepository<GoodMessage, Long>, JpaRepository<GoodMessage, Long> {

    @Override
    long count();

     List<GoodMessage> findByAuthor (String username);
    List <GoodMessage> findByAuthorNot (User user);
    List <GoodMessage> findByAuthorNotOrAuthorIn (User user, List <GoodMessage> list);



}
