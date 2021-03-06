package io.github.kubachodacki.ToDoApp.sqlRepositories;

import io.github.kubachodacki.ToDoApp.task.Task;
import io.github.kubachodacki.ToDoApp.repositories.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SqlTaskRepository extends TaskRepository, JpaRepository <Task, Integer> {

    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from tasks where id=:id")
    boolean existsById(@Param("id") Integer id);

    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);
}