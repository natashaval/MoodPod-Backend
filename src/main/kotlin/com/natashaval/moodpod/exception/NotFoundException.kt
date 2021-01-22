package com.natashaval.moodpod.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

// https://stackoverflow.com/questions/43575538/what-is-the-right-way-to-handle-errors-in-spring-webflux
class NotFoundException(message: String): ResponseStatusException(HttpStatus.NOT_FOUND, message)