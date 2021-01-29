package com.natashaval.moodpod.controller

import com.natashaval.moodpod.model.Mood
import com.natashaval.moodpod.service.MoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["/mood"], produces = [MediaType.APPLICATION_JSON_VALUE])
class MoodController constructor(@Autowired private val service: MoodService) {

  @GetMapping("")
  fun getMoods(): Flux<Mood> {
    return service.findAll()
  }

  @PostMapping("")
  fun saveMood(@RequestBody mood: Mood): Mono<Mood> {
    return service.save(mood)
  }

  @GetMapping("/{id}")
  fun getMoodById(@PathVariable("id") id: String): Mono<Mood> {
    return service.findById(id)
  }

  @PutMapping("/{id}")
  fun updateMood(@PathVariable("id") id: String, @RequestBody mood: Mood): Mono<Mood> {
    mood.id = id
    return service.updateById(id, mood)
  }

  @DeleteMapping("/{id}")
  fun deleteMood(@PathVariable("id") id: String): Mono<Boolean> {
    return service.deleteById(id)
  }
}