package com.mercadolivro.model

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Role
import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,

    @Column
    val password: String,

    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_role", joinColumns = [JoinColumn(name = "customer_id")])
    var roles: Set<Role> = setOf()
)