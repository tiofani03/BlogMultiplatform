package com.tiooooo.blogmultiplatform.data

import com.tiooooo.blogmultiplatform.models.User

interface MongoRepository {
    suspend fun checkUserExistence(user: User) : User?

    suspend fun checkUserId(id: String): Boolean
}
