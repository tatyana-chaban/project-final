package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.to.TaskTo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = TaskController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class TaskController {

    static final String REST_URL = "/task";
    TaskService taskService;

    @PutMapping("/tag")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Task setTag(@RequestBody TaskTo taskTo, @RequestParam String tag) {
        return taskService.setTag(taskTo, tag);
    }

    @DeleteMapping("/tag")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@RequestBody TaskTo taskTo, @RequestParam String tag) {
        taskService.deleteTag(taskTo, tag);
    }
}
