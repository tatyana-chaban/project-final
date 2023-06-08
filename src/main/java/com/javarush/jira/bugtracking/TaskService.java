package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.mapper.TaskMapper;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import com.javarush.jira.bugtracking.to.TaskTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class TaskService extends BugtrackingService<Task, TaskTo, TaskRepository> {
    public TaskService(TaskRepository repository, TaskMapper mapper) {
        super(repository, mapper);
    }

    public List<TaskTo> getAll() {
        return mapper.toToList(repository.getAll());
    }

    public Task setTag(TaskTo taskTo, String tag){
        log.debug("set tag {}, id = {}",tag, taskTo.id());
        Task dbTask = repository.getExisted(taskTo.id());
        dbTask.setTags(Set.of(tag));
        repository.save(dbTask);
        return dbTask;
    }

    public void deleteTag(TaskTo taskTo, String tag){
        log.debug("delete tag {}, id = {}",tag, taskTo.id());
        Task dbtask = repository.getExisted(taskTo.id());
        Set<String> tags = dbtask.getTags();
        tags.remove(tag);
        dbtask.setTags(tags);
        repository.save(dbtask);
    }
}
