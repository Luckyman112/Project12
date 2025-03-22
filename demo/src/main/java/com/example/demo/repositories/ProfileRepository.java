package com.example.demo.repositories;

import com.example.demo.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

  @Query("SELECT p FROM Profile p WHERE p.bio LIKE %:keyword% AND p.user.username = :username")
  List<Profile> findByBioAndUsername(@Param("keyword") String keyword,
                                     @Param("username") String username);
}
