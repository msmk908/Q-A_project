package com.codeqna.repository;

import com.codeqna.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Logs, Long> {
}
