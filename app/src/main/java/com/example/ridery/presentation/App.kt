package com.example.ridery.presentation

import android.app.Application
import android.content.Context
import android.os.Environment
import androidx.room.Room
import com.example.ridery.data.room.RideryDb

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        instance = this
        room = Room
            .databaseBuilder(this, RideryDb::class.java, "ridery")
            .build()
    }

    companion object{
        private lateinit var instance :App
        private lateinit var room: RideryDb

        fun getContext(): Context {
            return instance
        }

        fun getDbInstance(): RideryDb{
            return room
        }
    }

    private fun getDatabasePath(): String {
        val dir = Environment.getDataDirectory()
        val packageId = this.packageName
        return "/data/$dir/$packageId/databases"
    }

}