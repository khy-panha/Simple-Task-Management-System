package com.example.task.service;

import com.example.task.mapper.TaskMapper;
import com.example.task.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> getAllTasks() {
        return taskMapper.findAll();
    }

    public Task getTaskById(Long id) {
        Task task = taskMapper.findById(id);
        if (task == null) {
            throw new RuntimeException("Task not found with id " + id);
        }
        return task;
    }

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        taskMapper.insert(task);
        return task;
    }

    public Task updateTask(Long id, Task taskUpdate) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(taskUpdate.getTitle());
        existingTask.setDescription(taskUpdate.getDescription());
        existingTask.setStatus(taskUpdate.getStatus());
        existingTask.setUpdatedAt(LocalDateTime.now());
        taskMapper.update(existingTask);
        return existingTask;
    }

    public void deleteTask(Long id) {
        Task existingTask = getTaskById(id);
        taskMapper.delete(existingTask.getId());
    }
}
