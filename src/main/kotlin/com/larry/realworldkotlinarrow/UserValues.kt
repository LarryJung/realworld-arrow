package com.larry.realworldkotlinarrow

// presentation
data class UserResponse(val email: String, val token: String, val username: String, val bio: String, val image: String?)
data class LoginRequest(val detail: LoginRequestDetail)
data class LoginRequestDetail(val email: String, val password: String)
data class UserRegistrationRequest(val detail: UserRegistrationRequestDetail)
data class UserRegistrationRequestDetail(val userName: String, val email: String, val password: String)


data class User(val email: String, val password: String, val profile: Profile)
data class Profile(val username: String, val bio: String, val image: String?, val following: Boolean)