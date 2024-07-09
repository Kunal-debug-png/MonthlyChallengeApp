package com.microservice.challengeApp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepo challengeRepo;

    public Challenge getByMonth(String month) {
        return challengeRepo.findAll().stream()
                .filter(challenge -> month.equals(challenge.getChallengeMonth()))
                .findFirst()
                .orElse(null);
    }

    public List<Challenge> getAllChallenges() {
        return challengeRepo.findAll();
    }

    public boolean addChallenge(Challenge challenge) {
        challengeRepo.save(challenge);
        return true;
    }

    public boolean updateChallenge(Challenge challenge) {
        if (challengeRepo.existsById(challenge.getId())) {
            challengeRepo.save(challenge);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        if (challengeRepo.existsById(id)) {
            challengeRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
