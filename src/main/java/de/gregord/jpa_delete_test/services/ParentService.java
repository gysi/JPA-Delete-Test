package de.gregord.jpa_delete_test.services;

import de.gregord.jpa_delete_test.entities.Parent;
import de.gregord.jpa_delete_test.repositories.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParentService {

    ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    public Optional<Parent> findById(Long id) {
        return parentRepository.findById(id);
    }
}
