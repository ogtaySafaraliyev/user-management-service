package com.looyt.usermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiInfoController {
    
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getApiInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("service", "User Management Service");
        info.put("version", "1.0.0");
        info.put("description", "RESTful API for managing users");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("GET /api/info", "API information");
        endpoints.put("GET /api/users/health", "Health check");
        endpoints.put("POST /api/users", "Create user");
        endpoints.put("GET /api/users", "Get all users (supports pagination: ?page=0&size=10)");
        endpoints.put("GET /api/users/{id}", "Get user by ID");
        endpoints.put("GET /api/users/search?email={email}", "Search user by email");
        endpoints.put("PUT /api/users/{id}", "Update user");
        endpoints.put("DELETE /api/users/{id}", "Delete user");
        
        info.put("endpoints", endpoints);
        
        return ResponseEntity.ok(info);
    }
}