package mealplanner.controllers

import mealplanner.services.MealService
import mealplanner.services.WeekdayService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * The controller for the planner view.
 */
@Controller
@RequestMapping("/planner")
class MealPlannerController(val weekdayService: WeekdayService,
							val mealService: MealService) {

	/**
	 * Loads the weekday and meal entities to be displayed on the planner.
	 *
	 * @param model The interface object for transferring data to the view.
	 * @return The default route for this controller.
	 */
	@GetMapping
	fun getDays(model: Model) : String {

		val weekdays = weekdayService.getWeekdays()

		// Add weekdays into model
		model["days"] = weekdays

		// Add each meal for each weekday
		weekdays.forEach {
			model["day-${it.id}"] = mealService.getMealsForWeekdayId(it.id)
		}

		return "planner"
	}

}