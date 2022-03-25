package com.example.myexample2.ui.main.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface UserTableDao {
    @Query("SELECT * FROM userTable")
    fun getAll(): List<User>

    @Query("SELECT * FROM userTable WHERE id IN (:userIds)")
    fun getByIds(userIds: List<Int>): Flowable<MutableList<User>>

    @Insert
    fun insertUser(vararg userEntities: User)

    @Delete
    fun delete(userEntity: User)
}