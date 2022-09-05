package br.com.mercadolivro.repositoy

import br.com.mercadolivro.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : JpaRepository<CustomerModel, Int> {
    fun findByNameContaining(name: String): List<CustomerModel>
}