package br.com.mercadolivro.extesion

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.request.PostBookRequest
import br.com.mercadolivro.request.PutCustomerRequest
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.PostCustumerRequest

fun PostCustumerRequest.toCustomerModel(): CustomerModel {
    return  CustomerModel(
        name = this.name,
        email = this.email
    )
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return com.mercadolivro.model.CustomerModel(
        id = id,
        name = this.name,
        email = this.email

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