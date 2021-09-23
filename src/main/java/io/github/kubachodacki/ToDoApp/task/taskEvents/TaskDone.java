package io.github.kubachodacki.ToDoApp.task.taskEvents;

import io.github.kubachodacki.ToDoApp.task.Task;

import java.time.Clock;

public class TaskDone extends TaskEvent {
    TaskDone(final Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
