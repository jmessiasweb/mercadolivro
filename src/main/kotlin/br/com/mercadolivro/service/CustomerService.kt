package br.com.mercadolivro.service

import br.com.mercadolivro.enums.CustomerStatus
import br.com.mercadolivro.enums.Errors
import br.com.mercadolivro.exeption.NotFoundException
import br.com.mercadolivro.repositoy.CustomerRepository
import br.com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository,
                      val bookService: BookService) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return  customerRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
      val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO

        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
       return !customerRepository.existsByEmail(email)

    }
}