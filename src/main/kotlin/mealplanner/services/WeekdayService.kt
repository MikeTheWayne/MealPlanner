package mealplanner.services

import mealplanner.entities.Weekday
import mealplanner.repositories.WeekdayRepository
import org.springframework.stereotype.Service

@Service
class WeekdayService(val weekdayRepository: WeekdayRepository) {

	fun getWeekdays() : List<Weekday> {
		return weekdayRepository.findAllWeekdays()
	}

	fun saveWeekday(weekday: Weekday) {
		weekdayRepository.save(weekday)
	}

}