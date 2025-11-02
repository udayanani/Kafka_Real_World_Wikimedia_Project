package com.example.repository;


import com.example.entity.WikimediaChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaChangesRepository extends JpaRepository<WikimediaChanges, Long> {
}
