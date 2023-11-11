package com.devcommunity.app.repository;

import com.devcommunity.app.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
    List<Response> findByDeveloper_Id(Integer id);
    List<Response> findByPost_PostId(Integer postId);
}