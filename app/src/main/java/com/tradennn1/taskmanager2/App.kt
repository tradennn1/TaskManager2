package com.tradennn1.taskmanager2
import android.app.Application
import androidx.room.Room
import com.tradennn1.taskmanager2.ui.home.adapter.model.local.db.AppDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "task-db"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}