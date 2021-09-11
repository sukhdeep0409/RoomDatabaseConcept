package com.example.roomdatabaseconcept.data

import androidx.lifecycle.LiveData

class UserRepository
constructor(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUSer(user)
    }
}