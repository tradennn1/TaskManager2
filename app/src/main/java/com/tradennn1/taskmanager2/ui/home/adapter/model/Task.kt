package com.tradennn1.taskmanager2.ui.home.adapter.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //2
data class Task(
    @PrimaryKey(autoGenerate = true) //1
    var id: Int? = null,
    var title: String? = null,
    var desc: String? = null
) : java.io.Serializable
