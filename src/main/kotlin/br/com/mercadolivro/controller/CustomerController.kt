package com.mercadolivro.controller

import br.com.mercadolivro.extesion.toCustomerModel
import br.com.mercadolivro.request.PutCustomerRequest
import br.com.mercadolivro.service.CustomerService
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.PostCustumerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customer")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun getCustomer(@RequestParam name: String?):List<CustomerModel> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustumerRequest) {
        return customerService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return customerService.getById(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        customerService.update(customer.toCustomerModel(id))

    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) {
        return customerService.delete(id)

    }



}