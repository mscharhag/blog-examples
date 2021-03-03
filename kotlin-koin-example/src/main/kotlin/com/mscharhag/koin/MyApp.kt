package com.mscharhag.koin

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MyApp : KoinComponent {
    private val userService by inject<UserService>()

    init {
        userService.createUser("John", Address("Cool Str.", "Testingen", "1234"))
        println("created user john")
    }
}