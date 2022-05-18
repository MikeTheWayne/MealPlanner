package mealplanner.services

import mealplanner.entities.Meal
import mealplanner.repositories.MealRepository
import org.springframework.stereotype.Service

@Service
class MealService(val mealRepository: MealRepository) {

	/**
	 * Gets and returns a list of Meal entities for a given weekday from the database.
	 *
	 * @param id The ID of the weekday for which meals are to be returned.
	 * @return A list of meals related to the given weekday.
	 */
	fun getMealsForWeekdayId(id: String) : List<Meal> {
		return mealRepository.findAllByWeekdayId(id)
	}

}