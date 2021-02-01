package com.natashaval.moodpod.controller

import com.natashaval.moodpod.model.Mood
import com.natashaval.moodpod.service.MoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

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

  //  https://www.baeldung.com/spring-date-parameters
  @GetMapping("/history") fun findMoodByMonthYear(
    @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    date: Date?
  ): Flux<Mood> {
    return service.findMoodByMonthYear(date)
  }

  @GetMapping("/history/range") fun findMoodBetween(
    @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) start: Date,
    @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) end: Date
  ): Flux<Mood> {
    return service.findMoodBetween(start, end)
  }
}