package com.jetfit.app

import android.app.Application
import androidx.room.Room
import com.jetfit.app.data.local.JetFitDatabase

class JetFitApplication : Application() {
    val database: JetFitDatabase by lazy {
        Room.databaseBuilder(this, JetFitDatabase::class.java, "jetfit.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
