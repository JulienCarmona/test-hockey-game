package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByYear(long year);

}
