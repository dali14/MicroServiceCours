package org.sid.coursservice.repository;

import org.sid.coursservice.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoursRepository extends JpaRepository<Cours,Long> {
}
