package com.jetfit.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AthleteProfileEntity::class],
    version = 1,
    exportSchema = true
)
abstract class JetFitDatabase : RoomDatabase() {
    abstract fun athleteProfileDao(): AthleteProfileDao
}
