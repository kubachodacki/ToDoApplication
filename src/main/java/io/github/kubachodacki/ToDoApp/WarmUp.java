package io.github.kubachodacki.ToDoApp;

import io.github.kubachodacki.ToDoApp.task.Task;
import io.github.kubachodacki.ToDoApp.taskGroup.TaskGroup;
import io.github.kubachodacki.ToDoApp.repositories.TaskGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Set;

class WarmUp implements ApplicationListener <ContextRefreshedEvent> {


    private static final Logger logger = LoggerFactory.getLogger(WarmUp.class);

    private final TaskGroupRepository groupRepository;

    WarmUp(final TaskGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

    logger.info("Application Warm-Ups after context being refreshed");
    final String description = "ApplicationContextEvent";
    if (!groupRepository.existsByDescription(description)){
    logger.info("Application has not found group! Please add one.");
    var group = new TaskGroup();
    group.setDescription(description);
    group.setTasks(Set.of(
            new Task("ContextClosedEvent", null, group),
            new Task("ContextRefreshedEvent", null, group),
            new Task("ContextStoppedEvent", null, group),
            new Task("ContextStartedEvent", null, group)
    ));
    groupRepository.save(group);

        }
    }
}
