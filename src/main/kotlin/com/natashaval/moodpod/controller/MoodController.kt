package com.natashaval.moodpod.controller

import com.natashaval.moodpod.model.Mood
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MoodController {
  @GetMapping("/mood")
  fun getMood(@RequestParam(value = "name", defaultValue = "World")name: String): Mood {
    return Mood(1, "Hello, $name")
  }
}