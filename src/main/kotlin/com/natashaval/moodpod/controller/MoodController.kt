package com.natashaval.moodpod.controller

import com.natashaval.moodpod.model.Mood
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/mood"], produces = [MediaType.APPLICATION_JSON_VALUE])
class MoodController {

  @GetMapping("")
  fun getMood(@RequestParam(value = "name", defaultValue = "World")name: String): Mood {
    return Mood(1, "Hello, $name")
  }
}