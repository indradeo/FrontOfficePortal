package org.dit.FrontOfficePortal.repo;

import org.dit.FrontOfficePortal.entity.EnquiryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnquiryStatusRepo extends JpaRepository<EnquiryStatus, Integer > {

    @Query("SELECT e.status FROM EnquiryStatus e")
    List<String> findByStatus();
}
