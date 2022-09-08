package br.com.mercadolivro.controller.mapper

import br.com.mercadolivro.controller.request.PostPurchaseResquest
import br.com.mercadolivro.model.PurchaseModel
import br.com.mercadolivro.service.BookService
import br.com.mercadolivro.service.CustomerService
import org.springframework.stereotype.Component


@Component
class PurchaseMapper(private val bookService: BookService,
                     private val customerService: CustomerService) {

    fun toModel(request: PostPurchaseResquest): PurchaseModel{
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books,
            price = books.sumOf { it.price }

        )
    }

}