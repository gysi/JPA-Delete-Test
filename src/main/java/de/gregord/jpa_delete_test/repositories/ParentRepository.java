package de.gregord.jpa_delete_test.repositories;

import de.gregord.jpa_delete_test.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
