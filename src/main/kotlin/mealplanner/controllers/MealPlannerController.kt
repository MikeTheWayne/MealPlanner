package mealplanner.controllers

import mealplanner.entities.Weekday
import mealplanner.services.MealService
import mealplanner.services.WeekdayService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
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
		model["weekdays"] = weekdays
		// Add a blank weekday object, to be populated using a form on the frontend
		model["weekday"] = Weekday(null, "", setOf())

		return "planner"
	}

	/**
	 * Saves the weekday received from the view's form to the database. Redirects back to the main planner page once
	 * the new entity has been persisted.
	 *
	 * @param weekday The weekday object received from the view as a model attribute.
	 * @return A redirect route back to the main planner page.
	 */
	@PostMapping("/weekday")
	fun addWeekday(@ModelAttribute weekday: Weekday) : String {
		// Save the weekday received from the model
		weekdayService.saveWeekday(weekday)

		// Redirect back to the planner page
		return "redirect:/planner"
	}

}