package br.com.mercadolivro.events.listener

import br.com.mercadolivro.events.PurchaseEvent
import br.com.mercadolivro.service.BookService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component


@Component
class UpdateSoldBookListener(private val bookService: BookService) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        println("Atualizando status dos livros")
        bookService.purchase(purchaseEvent.purchaseModel.books)

    }
}