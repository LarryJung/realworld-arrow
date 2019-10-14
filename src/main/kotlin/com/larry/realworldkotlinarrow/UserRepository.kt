package com.larry.realworldkotlinarrow

import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    override fun findById(id: Long): User? {
        return null
    }
}

interface UserRepository {
    fun findById(id: Long): User?
}