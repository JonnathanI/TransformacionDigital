package com.example.evaluacion.service

import com.example.evaluacion.model.Customer
import com.example.evaluacion.repository.customerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class customerService {
    @Autowired
lateinit var customerRepository: customerRepository

    fun list():List<Customer>{
        return customerRepository.findAll()
    }

    fun save(customer: Customer):Customer{
        return customerRepository.save(customer)
    }

    fun update(customer: Customer):Customer{
        try {


            customerRepository.findById(customer.id) ?: throw Exception("Ya existe este ID")
            return customerRepository.save(customer)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(customer: Customer):Customer{
        try {

            var response = customerRepository.findById(customer.id) ?: throw Exception("Ya existe este ID")
            response.apply {
                name=customer.name

            }
            return customerRepository.save(response)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            val customer = customerRepository.findById(id).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado con ID: $id") }
            customerRepository.delete(customer)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el cliente", ex)
        }
    }



}