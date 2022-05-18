package mealplanner.services

import mealplanner.entities.Meal
import mealplanner.entities.Weekday
import mealplanner.repositories.MealRepository
import mealplanner.repositories.WeekdayRepository
import org.springframework.stereotype.Service

@Service
class WeekdayService(val weekdayRepository: WeekdayRepository) {

	fun getWeekdays() : List<Weekday> {
		return weekdayRepository.findAllWeekdays()
	}

}