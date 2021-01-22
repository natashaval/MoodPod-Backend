package com.natashaval.moodpod.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "songs")
data class Song(
  @Id
  var id: String?,
  val title: String? = null,
  val artist: String? = null,
  val url: String? = null
)