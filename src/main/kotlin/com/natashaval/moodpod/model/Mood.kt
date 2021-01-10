package com.natashaval.moodpod.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Mood(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Int,
  val name: String? = null,
  val message: String? = null,
  val createdAt: Date? = null
)
