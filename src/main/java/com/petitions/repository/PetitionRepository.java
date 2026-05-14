package com.petitions.repository;

import com.petitions.model.Petition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetitionRepository extends JpaRepository<Petition, Long> {

    List<Petition> findByAuthorIgnoreCase(String author);

    List<Petition> findByTitleContainingIgnoreCase(String keyword);
}