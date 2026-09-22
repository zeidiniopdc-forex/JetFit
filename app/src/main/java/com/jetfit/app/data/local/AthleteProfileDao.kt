package com.jetfit.app.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AthleteProfileDao {
    @Query("SELECT * FROM athlete_profiles WHERE id = 1")
    fun observe(): Flow<AthleteProfileEntity?>

    @Upsert
    suspend fun upsert(profile: AthleteProfileEntity)
}
