package org.example.crudproject.Repository;

import org.example.crudproject.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Students, Long> {

    Optional<Students> findByIdAndDeletedIsFalse(Long id);

    List<Students> findByDeletedIsFalse();

}
