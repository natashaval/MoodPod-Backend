package com.natashaval.moodpod.service.impl

import com.natashaval.moodpod.exception.NotFoundException
import com.natashaval.moodpod.model.Mood
import com.natashaval.moodpod.repository.MoodRepository
import com.natashaval.moodpod.service.MoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service class MoodServiceImpl constructor(
  @Autowired private val repository: MoodRepository
) : MoodService {

  override fun findAll(): List<Mood> {
    return repository.findAll()
  }

  override fun findById(id: Int): Mood {
    return repository.findById(id).orElseThrow { NotFoundException("Employee not found!") }
  }

  override fun deleteById(id: Int) {
    return repository.deleteById(id)
  }

  override fun save(mood: Mood): Mood {
    return repository.save(mood)
  }

}