package com.tiooooo.blogmultiplatform.utils

import com.tiooooo.blogmultiplatform.models.User
import com.tiooooo.blogmultiplatform.models.UserWithoutPassword
import com.varabyte.kobweb.browser.api
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend fun checkUserExistence(user: User): UserWithoutPassword? {
    return try {
        val result = window.api.tryPost(
            apiPath = "usercheck",
            body = Json.encodeToString(user).encodeToByteArray()
        )

        result?.decodeToString()?.let { Json.decodeFromString<UserWithoutPassword>(it) }

    } catch (e: Exception) {
        println(e.message)
        null
    }
}

suspend fun checkUserId(id: String): Boolean {
    return try {
        val result = window.api.tryPost(
            apiPath = "checkuserid",
            body = Json.encodeToString(id).encodeToByteArray()
        )
        result?.decodeToString()?.let { Json.decodeFromString<Boolean>(it) } ?: false
    } catch (e: Exception) {
        println(e.message.toString())
        false
    }
}
