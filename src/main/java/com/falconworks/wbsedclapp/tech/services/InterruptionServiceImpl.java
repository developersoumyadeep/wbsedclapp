package com.falconworks.wbsedclapp.tech.services;

import com.falconworks.wbsedclapp.tech.repositories.InterruptionRepository;
import com.falconworks.wbsedclapp.tech.entities.Interruption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InterruptionServiceImpl implements InterruptionService {

    private final InterruptionRepository interruptionRepository;

    @Autowired
    public InterruptionServiceImpl(InterruptionRepository interruptionRepository) {
        this.interruptionRepository = interruptionRepository;
    }

    @Override
    public List<Interruption> findAll() {
        return interruptionRepository.findAll();
    }

    @Override
    public Interruption findById(int id) {
        Optional<Interruption> result = interruptionRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void saveInterruption(Interruption interruption) {
        interruptionRepository.save(interruption);
    }

    @Override
    public Interruption updateInterruption(Interruption interruption) {
        return interruptionRepository.save(interruption);
    }

    @Override
    public void deleteById(int id) {
        interruptionRepository.deleteById(id);
    }
}
