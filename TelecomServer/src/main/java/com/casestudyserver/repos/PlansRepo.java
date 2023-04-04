package com.casestudyserver.repos;

import com.casestudyserver.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlansRepo extends JpaRepository<Plan,Long> {

}
