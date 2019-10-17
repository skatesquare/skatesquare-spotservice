package com.skatesquare.spotservice.repository

import com.skatesquare.spotservice.domain.Spot
import org.springframework.data.repository.JpaRepository

interface SpotRepository : JpaRepository<Spot, String>
