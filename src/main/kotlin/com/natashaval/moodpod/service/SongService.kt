package com.natashaval.moodpod.service

import com.natashaval.moodpod.model.Song
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface SongService {
  fun findAll(): Flux<Song>
  fun findById(id: String): Mono<Song>
  fun findByTitle(title: String): Flux<Song>
  fun save(song: Song): Mono<Song>
  fun deleteById(id: String): Mono<Boolean>
}