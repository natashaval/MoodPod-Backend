package com.natashaval.moodpod.service.impl

import com.natashaval.moodpod.exception.NotFoundException
import com.natashaval.moodpod.model.Mood
import com.natashaval.moodpod.repository.MoodRepository
import com.natashaval.moodpod.service.MoodService
import com.natashaval.moodpod.utils.DateUtils.convertToLocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Service
class MoodServiceImpl constructor(
  @Autowired private val repository: MoodRepository
) : MoodService {

  override fun findAll(): Flux<Mood> {
    return repository.findAll(Sort.by(Sort.Direction.DESC, "date"))
  }

  //  https://stackoverflow.com/questions/45365791/spring-webflux-emit-exception-upon-null-value-in-spring-data-mongodb-reactive-r/45392930
  override fun findById(id: String): Mono<Mood> {
    return repository.findById(id).switchIfEmpty(Mono.error(NotFoundException("Mood not found!")))
  }

  override fun deleteById(id: String): Mono<Boolean> {
    return repository.existsById(id).flatMap { exists ->
      if (exists) {
        repository.deleteById(id).then(Mono.just(true))
      } else {
        Mono.just(false)
      }
    }
  }

  override fun save(mood: Mood): Mono<Mood> {
    return repository.save(mood)
  }

  override fun updateById(id: String, mood: Mood): Mono<Mood> {
    return repository.existsById(id).flatMap { exists ->
      if (exists) {
        save(mood)
      } else {
        Mono.error(NotFoundException("Mood not found!"))
      }
    }
  }

  //  https://stackoverflow.com/questions/3083781/start-and-end-date-of-a-current-month
  //  https://stackoverflow.com/questions/22223786/get-first-and-last-day-of-month-using-threeten-localdate
  override fun findMoodByMonthYear(date: Date?): Flux<Mood> {
    val localDate = date?.convertToLocalDate() ?: LocalDate.now()
    val firstDay = localDate.withDayOfMonth(1).atStartOfDay()
    val lastDay = localDate.withDayOfMonth(localDate.lengthOfMonth()).atTime(LocalTime.MAX)
    println("localDate: $localDate, firstDay: $firstDay, lastDay: $lastDay, lengthOfMonth: ${localDate.lengthOfMonth()}")
    return repository.findByDateBetween(firstDay, lastDay)
  }

  override fun findMoodBetween(start: Date, end: Date): Flux<Mood> {
    val startDay = start.convertToLocalDate().atStartOfDay()
    val endDay = end.convertToLocalDate().atTime(LocalTime.MAX)
    return repository.findByDateBetween(startDay, endDay)
  }
}