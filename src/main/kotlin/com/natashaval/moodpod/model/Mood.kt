package com.natashaval.moodpod.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "moods")
data class Mood(
  @Id
  var id: String?,
  val mood: String? = null,
  val message: String? = null,
  val date: Date? = null
)
