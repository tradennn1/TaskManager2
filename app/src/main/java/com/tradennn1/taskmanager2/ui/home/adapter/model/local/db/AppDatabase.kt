package com.tradennn1.taskmanager2.ui.home.adapter.model.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tradennn1.taskmanager2.ui.home.adapter.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
abstract fun taskDao():TaskDao
}