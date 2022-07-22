package com.alamin_tanveer.supplychain.repositories;

import com.alamin_tanveer.supplychain.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AttachmentRepo extends JpaRepository<Attachment, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Attachment a " +
            "SET a.attachmentName = ?2 WHERE a.id = ?1")
    int updateAttachmentById(Long id, String attachmentName);
}
