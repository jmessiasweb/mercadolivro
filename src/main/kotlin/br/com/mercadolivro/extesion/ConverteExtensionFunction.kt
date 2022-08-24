package br.com.mercadolivro.extesion

import br.com.mercadolivro.request.PutCustomerRequest
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