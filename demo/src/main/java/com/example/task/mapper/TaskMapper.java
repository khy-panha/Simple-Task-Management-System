package com.example.task.mapper;

import com.example.task.model.Task;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper  // this is optional if you use @MapperScan at main app
public interface TaskMapper {
    List<Task> findAll();
    Task findById(Long id);
    int insert(Task task);
    int update(Task task);
    int delete(Long id);
}
