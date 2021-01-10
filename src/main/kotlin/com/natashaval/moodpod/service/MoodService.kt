package com.natashaval.moodpod.service

import com.natashaval.moodpod.model.Mood

interface MoodService {
  fun findAll(): List<Mood>
  fun findById(id: Int): Mood
  fun deleteById(id: Int)
  fun save(mood: Mood): Mood
}