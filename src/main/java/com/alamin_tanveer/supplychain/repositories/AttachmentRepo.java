package com.alamin_tanveer.supplychain.repositories;

import com.alamin_tanveer.supplychain.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepo extends JpaRepository<Attachment, Long> {
}
