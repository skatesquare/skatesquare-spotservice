package com.skatesquare.spotservice.controllers

import com.skatesquare.spotservice.domain.Spot
import com.skatesquare.spotservice.exceptions.NotFoundException
import com.skatesquare.spotservice.repository.SpotRepository
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("spots")
class SpotController(val repo: SpotRepository) {
    @GetMapping
    fun getAll(pageable: Pageable) = repo.findAll(pageable)

    @GetMapping("{id}")
    fun get(@PathVariable id: String): Spot = repo.findById(id).orElseThrow { NotFoundException(Spot::class, id) }

    @PostMapping
    fun create(@RequestBody body: Spot) = repo.save(Spot.from(body))

    @PutMapping("{id}")
    fun update(@PathVariable id: String, @RequestBody updatedSpot: Spot): Spot {
        return repo.save(
                repo.findById(id)
                        .map<Spot> { spot ->
                            spot.copyValuesFrom(updatedSpot)
                            spot
                        }
                        .orElseGet{
                            Spot.from(updatedSpot)
                        }
                        .also { spot -> spot.id = id })
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: String) = repo.deleteById(id)
}