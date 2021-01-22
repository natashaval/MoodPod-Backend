package com.natashaval.moodpod.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "moods")
data class Mood(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int,
  val name: String? = null,
  val message: String? = null,
  val createdAt: Date? = null
)
