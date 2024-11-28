package com.example.somethinggood.repository;

import com.example.somethinggood.domain.GoodMessage;
import com.example.somethinggood.domain.User;
import org.apache.logging.log4j.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodMessageRepository extends  JpaRepository<GoodMessage, Long> {

    List<GoodMessage> findByAuthor(String username);
    List<GoodMessage> findByAuthorNotOrAuthorIn(User user, List<GoodMessage> list);

    @Query (value = "SELECT * FROM good_message where author_id != :id order by rand() limit 1", nativeQuery = true)
    GoodMessage  getRandomMessage(@Param("id") Long id);
}