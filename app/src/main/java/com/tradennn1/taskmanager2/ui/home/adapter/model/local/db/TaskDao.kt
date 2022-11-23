package com.tradennn1.taskmanager2.ui.home.adapter.model.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tradennn1.taskmanager2.ui.home.adapter.model.Task

@Dao
interface TaskDao {

    @Query("SElECT * FROM task")
    fun getAllTask():List<Task>

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)
}