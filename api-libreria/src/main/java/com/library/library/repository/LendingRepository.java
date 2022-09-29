package com.library.library.repository;

import com.library.library.entity.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LendingRepository extends JpaRepository<LendingEntity, Long> {
}
