package com.falconworks.wbsedclapp.tech.services;

import com.falconworks.wbsedclapp.tech.entities.Interruption;

import java.util.List;

public interface InterruptionService {
    public List<Interruption> findAll();
    public Interruption findById(int id);
    public void saveInterruption(Interruption interruption);
    public Interruption updateInterruption(Interruption interruption);
    public void deleteById(int id);
}
