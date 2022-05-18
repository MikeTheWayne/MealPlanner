package mealplanner.repositories

import mealplanner.entities.Weekday
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WeekdayRepository : CrudRepository<Weekday, String> {

	@Query("SELECT * FROM WEEKDAYS")
	fun findAllWeekdays() : List<Weekday>

}