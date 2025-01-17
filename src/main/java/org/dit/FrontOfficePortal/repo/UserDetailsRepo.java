package org.dit.FrontOfficePortal.repo;

import org.dit.FrontOfficePortal.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer> {
    Optional<UserDetails> findByEmail(String email);

    UserDetails findByEmailAndPassword(String email, String password);

    @Query("Select u.name from UserDetails u where u.userId=:userId")
    String findByName(@Param("userId") Integer userId);
}
