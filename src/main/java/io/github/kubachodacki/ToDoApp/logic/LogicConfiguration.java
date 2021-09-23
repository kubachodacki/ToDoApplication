package io.github.kubachodacki.ToDoApp.logic;

import io.github.kubachodacki.ToDoApp.task.TaskConfigurationProperties;
import io.github.kubachodacki.ToDoApp.project.ProjectService;
import io.github.kubachodacki.ToDoApp.repositories.ProjectRepository;
import io.github.kubachodacki.ToDoApp.repositories.TaskGroupRepository;
import io.github.kubachodacki.ToDoApp.repositories.TaskRepository;
import io.github.kubachodacki.ToDoApp.taskGroup.TaskGroupService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LogicConfiguration {

    ProjectService projectService(
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskGroupService taskGroupService,
            final TaskConfigurationProperties config
    ) {
        return new ProjectService (repository, taskGroupRepository, taskGroupService, config);
    }

    @Bean
    TaskGroupService taskGroupService(
            final TaskGroupRepository taskGroupRepository,
            final TaskRepository taskRepository
    ) {
        return new TaskGroupService(taskGroupRepository, taskRepository);
    }
}
