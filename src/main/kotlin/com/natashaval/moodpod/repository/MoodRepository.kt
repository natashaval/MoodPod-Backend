package com.natashaval.moodpod.repository

import com.natashaval.moodpod.model.Mood
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MoodRepository : ReactiveMongoRepository<Mood, String>