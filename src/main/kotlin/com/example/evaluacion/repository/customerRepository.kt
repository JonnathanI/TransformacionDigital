package com.example.evaluacion.repository

import com.example.evaluacion.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface customerRepository: JpaRepository<Customer, Long> {
fun findById(id: Long?): Customer?
}