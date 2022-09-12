package br.com.mercadolivro.repositoy

import br.com.mercadolivro.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>

    fun existsByEmail(email: String): Boolean
}