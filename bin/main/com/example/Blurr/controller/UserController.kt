package com.example.Blurr.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.example.Blurr.service.UserService
import com.example.Blurr.dto.user.UserResponseDto
import com.example.Blurr.dto.user.UserRegisterDto
import com.example.Blurr.dto.user.UserUpdateDto

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserResponseDto> {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/register")
    fun register(@RequestBody dto: UserRegisterDto): ResponseEntity<UserResponseDto> {
        return ResponseEntity(userService.register(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody updateDto: UserUpdateDto
    ): ResponseEntity<UserResponseDto> {
        return ResponseEntity.ok(userService.update(id, updateDto));
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity(userService.deleteById(id), HttpStatus.NO_CONTENT);
    }
}