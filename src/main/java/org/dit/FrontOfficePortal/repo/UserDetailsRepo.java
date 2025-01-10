package org.dit.FrontOfficePortal.repo;

import org.dit.FrontOfficePortal.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer> {
    Optional<UserDetails> findByEmail(String email);
}
