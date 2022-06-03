package mealplanner.controllers

import mealplanner.entities.Weekday
import mealplanner.services.MealService
import mealplanner.services.WeekdayService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

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

	/**
	 * Deletes the weekday received through the path variable, along with any meal children.
	 *
	 * @param weekdayId The ID of the weekday to be deleted, passed in as a path variable.
	 * @return A redirect to the planner page.
	 */
	@PostMapping("/weekday/{id}/delete")
	fun deleteWeekday(@PathVariable("id") weekdayId: String) : String {
		// Find weekday to be deleted
		val weekdayToDelete = weekdayService.getWeekdayById(weekdayId)

		// Delete all meal children
		weekdayToDelete.meals?.forEach {
			mealService.deleteMeal(it)
		}

		// Delete the weekday itself
		weekdayService.deleteWeekday(weekdayToDelete)

		// Redirect back to the planner page
		return "redirect:/planner"
	}

}