package com.casestudyserver.repos;

import com.casestudyserver.entities.PlanSubscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanSubscriptionRepo extends JpaRepository<PlanSubscription,Long> {


    List<PlanSubscription> findAllByUserId(Long userId);
}
