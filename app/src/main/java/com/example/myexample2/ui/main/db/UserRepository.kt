package com.example.myexample2.ui.main.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams


class UserRepository(context: Context) {
    private var userTableDao: UserTableDao

    init {
        val dbInstance = AppDatabase.getInstance(context)
        userTableDao = dbInstance.userTableDao()
    }

    fun getAllUsers(): List<User> =
         userTableDao.getAll()

    fun insertUserData(user: User) =
        userTableDao.insertUser(user)

    fun getUserData(userIdList: List<Int>): LiveData<MutableList<User>> =
        LiveDataReactiveStreams.fromPublisher(userTableDao.getByIds(userIdList))
}