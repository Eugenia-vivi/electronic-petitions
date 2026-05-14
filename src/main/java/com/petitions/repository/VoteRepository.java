package com.petitions.repository;

import com.petitions.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByPetitionIdAndVoterNameIgnoreCase(Long petitionId, String voterName);

    Optional<Vote> findByPetitionIdAndVoterNameIgnoreCase(Long petitionId, String voterName);
}