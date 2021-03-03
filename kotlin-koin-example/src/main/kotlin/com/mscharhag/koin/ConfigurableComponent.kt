package com.mscharhag.koin

class ConfigurableComponent(
        private val first: String,
        private val second: String
) {
    init {
        println("ConfigurableComponent: $first, $second")
    }
}