package com.petitions.service;

import com.petitions.model.Petition;
import com.petitions.model.Vote;
import com.petitions.repository.PetitionRepository;
import com.petitions.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetitionService {

    private final PetitionRepository petitionRepository;
    private final VoteRepository voteRepository;

    public List<Petition> findAll() {
        return petitionRepository.findAll();
    }

    public Petition findById(Long id) {
        return petitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Петицію не знайдено: " + id));
    }

    @Transactional
    public Petition create(Petition petition) {
        return petitionRepository.save(petition);
    }

    @Transactional
    public void delete(Long id) {
        Petition petition = findById(id);
        petitionRepository.delete(petition);
    }

    @Transactional
    public String vote(Long petitionId, String voterName) {
        if (voteRepository.existsByPetitionIdAndVoterNameIgnoreCase(petitionId, voterName)) {
            throw new IllegalStateException(
                    "Користувач \"" + voterName + "\" вже голосував за цю петицію.");
        }

        Petition petition = findById(petitionId);

        Vote vote = new Vote();
        vote.setPetition(petition);
        vote.setVoterName(voterName.trim());
        voteRepository.save(vote);

        return petition.getVoteUrl();
    }

    public String generateVoteUrl(Long petitionId, String baseUrl) {
        return baseUrl + "/petitions/" + petitionId + "/vote";
    }
}