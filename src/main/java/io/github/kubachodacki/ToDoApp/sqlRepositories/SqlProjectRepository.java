package io.github.kubachodacki.ToDoApp.sqlRepositories;

import io.github.kubachodacki.ToDoApp.project.Project;
import io.github.kubachodacki.ToDoApp.repositories.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("from Project p join fetch p.steps")
    List<Project> findAll();

}
