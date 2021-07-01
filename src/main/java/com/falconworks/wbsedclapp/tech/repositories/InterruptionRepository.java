package com.falconworks.wbsedclapp.tech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falconworks.wbsedclapp.tech.entities.Interruption;

public interface InterruptionRepository extends JpaRepository<Interruption, Integer> {

}
