package de.gregord.jpa_delete_test.repositories;

import de.gregord.jpa_delete_test.entities.ParentChild;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentChildRepository extends JpaRepository<ParentChild, Long> {

}
