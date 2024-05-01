package com.example.evaluacion.model

import jakarta.persistence.*


@Entity
@Table(name = "customer")
class Customer {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
@Column(updatable = false)
    var id: Long? = null
    var name: String? = null
    @Column(name = "lastname")
    var lastName: String? = null
    var age: Int? = null
    var email: String? = null
}