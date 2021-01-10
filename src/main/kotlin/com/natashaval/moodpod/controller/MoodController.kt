package com.natashaval.moodpod.controller

import com.natashaval.moodpod.model.Mood
import com.natashaval.moodpod.service.MoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/mood"], produces = [MediaType.APPLICATION_JSON_VALUE])
class MoodController constructor(@Autowired private val service: MoodService) {

  @GetMapping("")
  fun getMoods(): List<Mood> {
    return service.findAll()
  }

  @PostMapping("")
  fun saveMood(@RequestBody mood: Mood): Mood {
    return service.save(mood)
  }

  @PutMapping("/{id}")
  fun updateMood(@PathVariable("id") id: Int, @RequestBody mood: Mood): Mood {
    mood.id = id
    return service.save(mood)
  }

  @DeleteMapping("/{id}")
  fun deleteMood(@PathVariable("id") id: Int) {
    return service.deleteById(id)
  }
}