package com.devcommunity.app.repository;

import com.devcommunity.app.entity.Developer;
import com.devcommunity.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
    Optional<Developer> findByUser(User user);
    List<Developer> findByReputation(Integer reputation);
    List<Developer> findByStatusIgnoreCase(String status);
}