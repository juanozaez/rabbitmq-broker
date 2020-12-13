package com.home.notification

import com.home.rabbitmq.DomainSubscriberRegistry
import com.home.rabbitmq.RabbitConsumer
import io.ktor.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    DomainSubscriberRegistry.register(UserCreatedEventSubscriber())
    RabbitConsumer().registerSubscribers()
}