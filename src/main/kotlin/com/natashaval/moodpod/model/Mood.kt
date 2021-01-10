package com.natashaval.moodpod.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "moods")
@Data
@NoArgsConstructor
@AllArgsConstructor
data class Mood(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int,
  val name: String? = null,
  val message: String? = null,
  val createdAt: Date? = null
)
