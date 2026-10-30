package org.example.crudproject.Repository;

import org.example.crudproject.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students, Long> {

}
