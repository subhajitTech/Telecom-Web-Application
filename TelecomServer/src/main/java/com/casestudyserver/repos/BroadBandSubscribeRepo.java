package com.casestudyserver.repos;

import com.casestudyserver.entities.BroadBandSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BroadBandSubscribeRepo extends JpaRepository<BroadBandSubscription,Long> {
    List<BroadBandSubscription> findAllByUserId(Long userId);
}
