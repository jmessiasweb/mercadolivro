package br.com.mercadolivro.service

import br.com.mercadolivro.listener.PurchaseEvent
import br.com.mercadolivro.model.PurchaseModel
import br.com.mercadolivro.repositoy.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(private val purchaseRepositoy: PurchaseRepository,
                      private val applicationEventPublisher: ApplicationEventPublisher) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepositoy.save(purchaseModel)

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))

    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepositoy.save(purchaseModel)
    }
}
