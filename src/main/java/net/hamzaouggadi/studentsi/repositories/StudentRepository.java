package net.hamzaouggadi.studentsi.repositories;

import net.hamzaouggadi.studentsi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Boolean existsByEmailIgnoreCase(String email);

}
