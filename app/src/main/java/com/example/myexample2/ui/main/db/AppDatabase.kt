package com.example.myexample2.ui.main.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userTableDao(): UserTableDao
    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "mydatabase")
                    //.addMigrations(MIGRATION_1_2)
                    .build()
            }
            return instance!!
        }
        /*private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE userTable ADD COLUMN first_name TEXT")
            }
        }*/
    }
}