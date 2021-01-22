package com.natashaval.moodpod.service

import com.natashaval.moodpod.model.Mood
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MoodService {
  fun findAll(): Flux<Mood>
  fun findById(id: String): Mono<Mood>
  fun deleteById(id: String): Mono<Boolean>
  fun save(mood: Mood): Mono<Mood>
}