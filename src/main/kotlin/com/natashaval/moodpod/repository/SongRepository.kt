package com.natashaval.moodpod.repository

import com.natashaval.moodpod.model.Song
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface SongRepository : ReactiveMongoRepository<Song, String> {
  fun findByTitle(title: String): Flux<Song>
}