package com.looyt.usermanagement.controller;

import com.looyt.usermanagement.dto.UserRequestDTO;
import com.looyt.usermanagement.dto.UserResponseDTO;
import com.looyt.usermanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	// Create User
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO requestDTO) {
		UserResponseDTO response = userService.createUser(requestDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Get User by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
		UserResponseDTO response = userService.getUserById(id);
		return ResponseEntity.ok(response);
	}

//    // Get All Users
//    @GetMapping
//    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
//        List<UserResponseDTO> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }

	// Get All Users with Pagination
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		Page<UserResponseDTO> userPage = userService.getAllUsers(page, size);

		Map<String, Object> response = new HashMap<>();
		response.put("users", userPage.getContent());
		response.put("currentPage", userPage.getNumber());
		response.put("totalItems", userPage.getTotalElements());
		response.put("totalPages", userPage.getTotalPages());

		return ResponseEntity.ok(response);
	}

	// Update User
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,
			@Valid @RequestBody UserRequestDTO requestDTO) {
		UserResponseDTO response = userService.updateUser(id, requestDTO);
		return ResponseEntity.ok(response);
	}

	// Delete User
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	// Health Check Endpoint
	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return ResponseEntity.ok("User Management Service is running!");
	}

	// Search User by Email
	@GetMapping("/search")
	public ResponseEntity<UserResponseDTO> getUserByEmail(@RequestParam String email) {
		UserResponseDTO response = userService.getUserByEmail(email);
		return ResponseEntity.ok(response);
	}

}