package br.com.mercadolivro.extesion

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.controller.request.PutBookRequest
import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.controller.response.BookResponse
import br.com.mercadolivro.controller.response.CustomerResponse
import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.enums.CustomerStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.controller.request.PostCustumerRequest

fun PostCustumerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO,
    )
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previousValue.id,
        name = this.name,
        email = this.email,
        status = previousValue.status

    )

}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer

    )

}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.nome ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer


    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status

    )

}


fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status

    )

}