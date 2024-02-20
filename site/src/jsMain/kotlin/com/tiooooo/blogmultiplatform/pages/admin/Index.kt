package com.tiooooo.blogmultiplatform.pages.admin

import androidx.compose.runtime.Composable
import com.tiooooo.blogmultiplatform.utils.IsUserLoggedIn
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomeScreen() {
    IsUserLoggedIn {
        HomePage()
    }
}

@Composable
fun HomePage() {
    println("Admin Homepage")
}
