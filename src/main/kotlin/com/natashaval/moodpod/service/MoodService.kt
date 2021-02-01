package com.natashaval.moodpod.service

import com.natashaval.moodpod.model.Mood
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface MoodService {
  fun findAll(): Flux<Mood>
  fun findById(id: String): Mono<Mood>
  fun deleteById(id: String): Mono<Boolean>
  fun updateById(id: String, mood: Mood): Mono<Mood>
  fun save(mood: Mood): Mono<Mood>
  fun findMoodByMonthYear(date: Date?): Flux<Mood>
  fun findMoodBetween(start: Date, end: Date): Flux<Mood>
}