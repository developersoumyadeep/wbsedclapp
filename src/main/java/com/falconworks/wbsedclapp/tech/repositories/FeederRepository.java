package com.falconworks.wbsedclapp.tech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falconworks.wbsedclapp.tech.entities.Feeder;


public interface FeederRepository extends JpaRepository<Feeder, Integer> {

    //  @Query("from Feeder f where f.feederCode= :feederCode")
    public Feeder findByFeederCode(String feederCode);

    //	@Query("select f from Feeder f inner join f.substation s where s.officeCode= :officeCode")
    public List<Feeder> findBySubstationOfficeCode(String officeCode);

    //  @Query("select f from Feeder f inner join f.substation s where s.officeCode like :officeCode")
    public List<Feeder> findBySubstationOfficeCodeStartingWith(String officeCode);

}
 