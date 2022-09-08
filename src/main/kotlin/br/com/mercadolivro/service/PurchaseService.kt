package br.com.mercadolivro.service

import br.com.mercadolivro.model.PurchaseModel
import br.com.mercadolivro.repositoy.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(private val purchaseRepositoy: PurchaseRepository) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepositoy.save(purchaseModel)

    }
}
