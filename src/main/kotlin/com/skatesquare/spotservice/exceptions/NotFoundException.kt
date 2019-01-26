package com.skatesquare.spotservice.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import kotlin.reflect.KClass

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(type: KClass<*>, id: String) : Exception("Resource of type $type with id $id not found")