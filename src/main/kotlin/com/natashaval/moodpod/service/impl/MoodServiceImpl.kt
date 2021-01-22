package com.natashaval.moodpod.service.impl

import com.natashaval.moodpod.exception.NotFoundException
import com.natashaval.moodpod.model.Mood
import com.natashaval.moodpod.repository.MoodRepository
import com.natashaval.moodpod.service.MoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service class MoodServiceImpl constructor(
  @Autowired private val repository: MoodRepository
) : MoodService {

  override fun findAll(): Flux<Mood> {
    return repository.findAll()
  }

//  https://stackoverflow.com/questions/45365791/spring-webflux-emit-exception-upon-null-value-in-spring-data-mongodb-reactive-r/45392930
  override fun findById(id: String): Mono<Mood> {
    return repository.findById(id).switchIfEmpty(Mono.error(NotFoundException("Employee not found!")))
  }

  override fun deleteById(id: String): Mono<Boolean> {
    repository.deleteById(id)
    return Mono.just(true)
  }

  override fun save(mood: Mood): Mono<Mood> {
    return repository.save(mood)
  }

}