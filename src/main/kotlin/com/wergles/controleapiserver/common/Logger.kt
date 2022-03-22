package com.wergles.controleapiserver.common

import org.slf4j.LoggerFactory

class Logger<T>(
    clazz: Class<T>
) {
    private val classLogger = LoggerFactory.getLogger(clazz.canonicalName)

    fun info(msg: String) = classLogger.info(msg)
    fun error(msg: String) = classLogger.error(msg)
    fun error(msg: String, ex: Throwable) = classLogger.error(msg, ex)
}

fun <T : Any> T.logInfo(methodName: String = getMethodName(), msg: String) = getLogger().info("$methodName -> $msg")

fun <T : Any> T.logError(methodName: String = getMethodName(), msg: String) = getLogger().error("$methodName -> $msg")

fun <T : Any> T.logError(methodName: String = getMethodName(), msg: String, ex: Throwable) =

    getLogger().error("$methodName -> $msg", ex)

private fun <T : Any> T.getLogger() = LoggerFactory.getLogger(javaClass.canonicalName ?: javaClass.simpleName)

fun <T : Any> T.getMethodName(): String = runCatching {
    Thread.currentThread().stackTrace.first { it.isNotIgnoredClass() }.simpleClassMethodName()
}.getOrNull() ?: javaClass.simpleName

fun Exception.getMethodName(): String = this.stackTrace.first { it.isNotIgnoredClass() }.simpleClassMethodName()

private fun StackTraceElement.isNotIgnoredClass() = listOf(Logger::class.java, Thread::class.java)
    .none { className.contains(it.simpleName) }

private fun StackTraceElement.simpleClassMethodName() = "[${className.split(".").last()}#$methodName]"
