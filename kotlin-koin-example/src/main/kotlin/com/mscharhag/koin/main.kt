package com.mscharhag.koin

import org.koin.core.context.startKoin
import org.koin.dsl.module

class OtherService(addressValidator: AddressValidatorImpl) {
    init {
        println("pther " + addressValidator)
    }
}

class MyComponent(str: String) {
    init {
        println("str: " + str)
    }
}

fun main() {

    val myModule = module {
        single<AddressValidator> { AddressValidatorImpl() }
        single(createdAtStart = true) { UserService(get()) }
        single(createdAtStart = true) { ConfigurableComponent(getProperty("foo.bar"), getProperty("other")) }
    }

    val app = startKoin {
        // loads properties from koin.properties
        fileProperties()

        // loads properties from custom property file
        fileProperties("/other.properties")

        // loads module myModule
        modules(myModule)
    }

    // retrieve userService via app.koin.get
    val userService = app.koin.get<UserService>()
    val address = Address("Cool Str.", "Testingen", "1234")
    userService.createUser("john", address)

    // MyApp implements KoinComponent and uses "by inject" to retrieve dependencies
    MyApp()
}
