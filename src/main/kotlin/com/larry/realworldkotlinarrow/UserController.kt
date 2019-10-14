package com.larry.realworldkotlinarrow

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/users")
@RestController
class UserController(val userService: UserService) {

    // no auth
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): Map<String, UserResponse> {
        return mapOf("user" to UserResponse(
                email = loginRequest.detail.email,
                token = "token bebe",
                username = "userName",
                bio = "I work at statefarm",
                image = null
        ))
    }

    // no auth
    @PostMapping
    fun registration(@RequestBody userRegistrationRequest: UserRegistrationRequest): Map<String, UserResponse> {
        return mapOf("user" to userService.regist(userRegistrationRequest.detail))
    }

}

