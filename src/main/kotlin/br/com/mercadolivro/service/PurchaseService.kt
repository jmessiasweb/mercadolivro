package br.com.mercadolivro.service

import br.com.mercadolivro.events.PurchaseEvent
import br.com.mercadolivro.model.PurchaseModel
import br.com.mercadolivro.repositoy.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(private val purchaseRepository: PurchaseRepository,
                      private val applicationEventPublisher: ApplicationEventPublisher) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        println("Disparando evento de compra")
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
        println("Finalização do processamento!")

    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
