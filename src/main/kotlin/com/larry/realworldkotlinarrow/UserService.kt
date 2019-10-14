package com.larry.realworldkotlinarrow

import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun regist(detail: UserRegistrationRequestDetail): UserResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}