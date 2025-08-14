package com.example.task.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Task {
    private Long id;

    @NotNull(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Status is required")
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters

    public Long getId() {
        return id;
    }
    private Long userId;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
