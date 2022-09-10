package br.com.mercadolivro.repositoy

import br.com.mercadolivro.model.PurchaseModel
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository: JpaRepository<PurchaseModel, Int> {

}
