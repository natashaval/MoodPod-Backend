package com.natashaval.moodpod.repository

import com.natashaval.moodpod.model.Mood
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MoodRepository : CrudRepository<Mood, Int>