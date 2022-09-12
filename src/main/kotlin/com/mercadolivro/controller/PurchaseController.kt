package br.com.mercadolivro.controller

import br.com.mercadolivro.controller.mapper.PurchaseMapper
import br.com.mercadolivro.controller.request.PostPurchaseRequest
import br.com.mercadolivro.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("purchase")
class PurchaseController(private val purchaseService: PurchaseService,
                         private val purchaseMapper: PurchaseMapper) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request))
    }
}