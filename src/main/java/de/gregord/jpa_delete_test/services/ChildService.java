package de.gregord.jpa_delete_test.services;

import de.gregord.jpa_delete_test.entities.Child;
import de.gregord.jpa_delete_test.repositories.ChildRepository;
import org.springframework.stereotype.Service;

@Service
public class ChildService {

    ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public Child save(Child child) {
        return childRepository.save(child);
    }
}
