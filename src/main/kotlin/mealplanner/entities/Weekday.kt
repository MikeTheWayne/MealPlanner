package mealplanner.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table

@Table("WEEKDAYS")
data class Weekday(@Id val id: String?,
				   val name: String,
				   @MappedCollection(idColumn = "WEEKDAY_ID", keyColumn = "WEEKDAY_ID") val meals: Set<Meal>?)
