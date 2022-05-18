package mealplanner.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MEAL")
data class Meal(
	@Id val id: String,
	val weekday_id: Weekday,

	val name: String,

	val kcal: Int,
	val protein: Int,
	val sat_fat: Int,
	val fiveADay: Int,
	val cost: Int
)
