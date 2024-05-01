package com.example.evaluacion.controller

import com.example.evaluacion.model.Customer
import com.example.evaluacion.service.customerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class customerController {
@Autowired
lateinit var customerService: customerService

@GetMapping
fun list():List<Customer>{
    return customerService.list()
}
    @PostMapping
    fun save(@RequestBody customer: Customer):Customer{
        return customerService.save(customer)
    }
    @PutMapping
    fun update(@RequestBody customer: Customer): ResponseEntity<Customer> {
        return ResponseEntity( customerService.update(customer), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody customer: Customer): ResponseEntity<Customer> {
        return ResponseEntity( customerService.updateName(customer), HttpStatus.OK)
    }
}