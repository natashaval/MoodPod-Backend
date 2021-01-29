package com.natashaval.moodpod.controller

import com.natashaval.moodpod.model.Song
import com.natashaval.moodpod.service.SongService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/song")
class SongController constructor(
  @Autowired private val service: SongService
) {
  @GetMapping("")
  fun findSongs(): Flux<Song> {
    return service.findAll()
  }

  @PostMapping("")
  fun saveSong(@RequestBody song: Song): Mono<Song> {
    return service.save(song)
  }

  @GetMapping("/search")
  fun findSongByTitle(@RequestParam(name = "title", defaultValue = "") title: String): Flux<Song> {
    return service.findByTitle(title)
  }

  @GetMapping("/{id}")
  fun findSongById(@PathVariable("id") id: String): Mono<Song> {
    return service.findById(id)
  }

  @PutMapping("/{id}")
  fun updateSong(@PathVariable("id") id: String, @RequestBody song: Song): Mono<Song> {
    song.id = id
    return service.updateById(id, song)
  }

  @DeleteMapping("/{id}")
  fun deleteById(@PathVariable("id") id: String): Mono<Boolean> {
    return service.deleteById(id)
  }
}