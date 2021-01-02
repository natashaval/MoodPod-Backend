package com.natashaval.moodify

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MoodifyApplication

fun main(args: Array<String>) {
	runApplication<MoodifyApplication>(*args)
}
