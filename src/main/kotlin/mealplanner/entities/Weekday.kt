package mealplanner.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("WEEKDAY")
data class Weekday(@Id val id: String, val name: String)
