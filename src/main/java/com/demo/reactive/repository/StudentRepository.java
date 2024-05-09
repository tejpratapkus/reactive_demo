package com.demo.reactive.repository;

import com.demo.reactive.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

    Flux<Student> findAllByFirstNameIgnoreCase(String firstName);
}
