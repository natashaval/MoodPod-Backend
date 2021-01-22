package com.natashaval.moodpod.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
@RequestMapping("/hello")
//https://jstobigdata.com/spring/getting-started-with-spring-webflux/
class HelloController {
  @GetMapping("")
  fun getHello(): ResponseEntity<String> {
    return ResponseEntity.ok().body("Hello, World!")
  }

  @GetMapping("/mono")
  fun getHelloMono(): ResponseEntity<Mono<String>> {
    return ResponseEntity.ok(Mono.just("Hello, World Mono!"))
  }

  @GetMapping(path = ["/flux"], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
  fun getHelloFlux(): ResponseEntity<Flux<String>> {
    return ResponseEntity.ok(Flux.just("Hello, ", "World ", "Flux!").delayElements(Duration.ofSeconds(1)))
  }
}