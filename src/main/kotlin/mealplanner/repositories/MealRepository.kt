package mealplanner.repositories

import mealplanner.entities.Meal
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MealRepository : CrudRepository<Meal, String> {

	@Query("SELECT * FROM MEALS WHERE weekday_id = :id")
	fun findAllByWeekdayId(@Param("id") id: String) : List<Meal>

}