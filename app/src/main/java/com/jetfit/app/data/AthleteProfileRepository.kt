package com.jetfit.app.data

import com.jetfit.app.data.local.AthleteProfileDao
import com.jetfit.app.data.local.AthleteProfileMapper
import com.jetfit.app.domain.model.AthleteProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AthleteProfileRepository(
    private val dao: AthleteProfileDao,
    private val mapper: AthleteProfileMapper = AthleteProfileMapper()
) {
    fun observe(): Flow<AthleteProfile?> = dao.observe().map { entity ->
        entity?.let(mapper::toDomain)
    }

    suspend fun save(profile: AthleteProfile) {
        require(profile.name.isNotBlank()) { "نام ورزشکار الزامی است" }
        require(profile.weeklyTrainingDays in 0..7) {
            "تعداد روزهای تمرین باید بین صفر تا هفت باشد"
        }
        dao.upsert(mapper.toEntity(profile))
    }
}
