package de.gregord.jpa_delete_test;

import de.gregord.jpa_delete_test.entities.Child;
import de.gregord.jpa_delete_test.entities.Parent;
import de.gregord.jpa_delete_test.entities.ParentChild;
import de.gregord.jpa_delete_test.services.ChildService;
import de.gregord.jpa_delete_test.services.ParentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class MyTestIT {

    @Autowired
    private ParentService parentService;
    @Autowired
    private ChildService childService;

    @Test
    public void contextLoads() {
    }

    @Test
    void testSaveAndFindParent() {
        Child child1 = new Child();
        child1.setName("child1");
        Child child2 = new Child();
        child2.setName("child2");

        Child savedChild1 = childService.save(child1);
        Child savedChild2 = childService.save(child2);

        Parent parent = new Parent();
        parent.setName("Test Parent");

        Parent savedParent = parentService.save(parent);
        Optional<Parent> foundParent = parentService.findById(savedParent.getId());

        assertThat(foundParent.isPresent()).isTrue();

        Set<ParentChild> parentChilds = new HashSet<>();

        ParentChild parentChild1 = new ParentChild();
        parentChild1.setParent(foundParent.get());
        parentChild1.setChild(savedChild1);
        parentChild1.setAttribute("parentChild1");
        parentChilds.add(parentChild1);

        ParentChild parentChild2 = new ParentChild();
        parentChild2.setParent(foundParent.get());
        parentChild2.setChild(savedChild2);
        parentChild2.setAttribute("parentChild2");
        parentChilds.add(parentChild2);

        foundParent.get().setParentChild(parentChilds);
        savedParent = parentService.save(foundParent.get());
        foundParent = parentService.findById(savedParent.getId());

        assertThat(foundParent).isPresent();
        assertThat(foundParent.get().getName()).isEqualTo("Test Parent");
        assertThat(foundParent.get().getParentChild().size()).isEqualTo(2);

        foundParent.get().getParentChild().clear();
        savedParent = parentService.save(foundParent.get());

        foundParent = parentService.findById(savedParent.getId());
        assertThat(foundParent).isPresent();
        assertThat(foundParent.get().getName()).isEqualTo("Test Parent");
        assertThat(foundParent.get().getParentChild().size()).isEqualTo(0);
    }
}
