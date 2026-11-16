package com.example.day12api.service;

import com.example.day12api.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final ConcurrentHashMap<Long, Task> tasks =
            new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    public Task createTask(Task task) {
        Long id = idGenerator.getAndIncrement();

        task.setId(id);
        tasks.put(id, task);

        return task;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public Task getTaskById(Long id) {
        return tasks.get(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        if (!tasks.containsKey(id)) {
            return null;
        }

        updatedTask.setId(id);
        tasks.put(id, updatedTask);

        return updatedTask;
    }

    public boolean deleteTask(Long id) {
        return tasks.remove(id) != null;
    }
}
