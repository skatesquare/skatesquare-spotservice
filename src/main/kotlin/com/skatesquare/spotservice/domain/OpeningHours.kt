package com.skatesquare.spotservice.domain

import java.time.LocalTime

/**
 * @param day zero-based starting from Monday = 0 to Sunday = 6
 */
data class OpeningHours(val day: Int, val open: LocalTime, val close: LocalTime)