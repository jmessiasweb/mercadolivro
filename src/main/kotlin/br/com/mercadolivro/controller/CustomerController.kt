package com.mercadolivro.controller

import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.controller.response.CustomerResponse
import br.com.mercadolivro.extesion.toCustomerModel
import br.com.mercadolivro.extesion.toResponse
import br.com.mercadolivro.service.CustomerService
import com.mercadolivro.request.PostCustumerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customer")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun getAll(@RequestParam name: String?):List<CustomerResponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustumerRequest) {
        return customerService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        val customerSaved = customerService.findById(id)
        customerService.update(customer.toCustomerModel(customerSaved))

    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) {
        return customerService.delete(id)

    }



}