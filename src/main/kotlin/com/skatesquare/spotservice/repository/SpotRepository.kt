package com.skatesquare.spotservice.repository

import com.skatesquare.spotservice.domain.Spot
import org.springframework.data.repository.PagingAndSortingRepository

interface SpotRepository : PagingAndSortingRepository<Spot, String>
