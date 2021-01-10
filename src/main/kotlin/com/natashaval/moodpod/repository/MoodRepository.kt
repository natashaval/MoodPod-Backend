package com.natashaval.moodpod.repository

import com.natashaval.moodpod.model.Mood
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MoodRepository : JpaRepository<Mood, Int>