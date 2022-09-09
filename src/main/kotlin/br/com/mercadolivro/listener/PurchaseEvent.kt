package br.com.mercadolivro.listener

import br.com.mercadolivro.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent(source: Any, val purchaseModel: PurchaseModel): ApplicationEvent(source)