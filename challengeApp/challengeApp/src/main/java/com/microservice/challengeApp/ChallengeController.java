package com.microservice.challengeApp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;

    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    @PostMapping
    public String addChallenge(@RequestBody Challenge challenge) {
        challengeService.addChallenge(challenge);
        return "Challenge added successfully";
    }

    @GetMapping("/{month}")
    public Challenge getByMonth(@PathVariable String month) {
        return challengeService.getByMonth(month);
    }

    @PutMapping("/{id}")
    public String updateChallenge(@PathVariable Long id, @RequestBody Challenge challenge) {
        challenge.setId(id);
        boolean isUpdated = challengeService.updateChallenge(challenge);
        return isUpdated ? "Challenge updated successfully" : "Challenge not found";
    }

    @DeleteMapping("/{id}")
    public String deleteChallenge(@PathVariable Long id) {
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        return isChallengeDeleted ? "Success" : "Fail";
    }
}
