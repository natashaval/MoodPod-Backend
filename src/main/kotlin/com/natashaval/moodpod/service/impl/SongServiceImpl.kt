package com.natashaval.moodpod.service.impl

import com.natashaval.moodpod.model.Song
import com.natashaval.moodpod.repository.SongRepository
import com.natashaval.moodpod.service.SongService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service class SongServiceImpl constructor(
  @Autowired private val repository: SongRepository
) : SongService {

  override fun findAll(): Flux<Song> {
    return repository.findAll()
  }

  override fun findById(id: String): Mono<Song> {
    return repository.findById(id)
  }

  override fun findByTitle(title: String): Flux<Song> {
    return repository.findByTitle(title)

  }

  override fun save(song: Song): Mono<Song> {
    return repository.save(song)
  }

  override fun deleteById(id: String): Mono<Boolean> {
    repository.deleteById(id)
    return Mono.just(true)
  }

}