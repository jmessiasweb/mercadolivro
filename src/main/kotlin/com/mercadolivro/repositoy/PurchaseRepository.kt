package com.mercadolivro.repositoy

import com.mercadolivro.model.PurchaseModel
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository: JpaRepository<PurchaseModel, Int>
