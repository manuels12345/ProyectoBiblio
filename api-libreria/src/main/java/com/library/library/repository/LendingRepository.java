package com.library.library.repository;

import com.library.library.entity.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LendingRepository extends JpaRepository<LendingEntity, Long> {
    Optional<LendingEntity> findById(@Param("id")Long idLending);
}
