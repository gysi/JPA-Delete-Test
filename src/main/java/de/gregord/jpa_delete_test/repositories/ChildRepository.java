package de.gregord.jpa_delete_test.repositories;

import de.gregord.jpa_delete_test.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
