package com.example.hw1.repository;

import com.example.hw1.model.MethodExecution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface MethodExecutionRepository extends JpaRepository<MethodExecution, Long> {

    Optional<MethodExecution> findById(@NonNull Long id);

    @Query("SELECT e FROM MethodExecution e WHERE e.duration = (SELECT MAX(e2.duration) FROM MethodExecution e2)")
    MethodExecution findMethodExecutionsWithMaxDuration();

    @Query("select e from MethodExecution e where e.duration = (SELECT MIN(e2.duration) FROM MethodExecution e2)")
    MethodExecution findMethodExecutionsWithMinDuration();

    @Query("SELECT AVG(e.duration) FROM MethodExecution e")
    Double findAverageDuration();
}
