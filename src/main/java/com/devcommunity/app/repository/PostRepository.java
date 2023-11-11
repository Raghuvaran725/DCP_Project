package com.devcommunity.app.repository;

import com.devcommunity.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTopicContainsIgnoreCase(String topic);
    List<Post> findByQueryContains(String query);
    List<Post> findByDeveloper_Id(Integer id);
}