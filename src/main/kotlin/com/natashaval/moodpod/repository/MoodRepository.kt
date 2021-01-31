package com.natashaval.moodpod.repository

import com.natashaval.moodpod.model.Mood
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Repository
interface MoodRepository : ReactiveMongoRepository<Mood, String> {
  fun findByDateBetween(startDate: LocalDateTime, endDate: LocalDateTime): Flux<Mood>
}