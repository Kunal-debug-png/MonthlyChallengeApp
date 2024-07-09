package com.microservice.challengeApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepo extends JpaRepository<Challenge,Long> {
}
