package com.tiooooo.blogmultiplatform.pages

import androidx.compose.runtime.Composable
import com.tiooooo.blogmultiplatform.pages.admin.LoginScreen
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.TextInput

@Page
@Composable
fun HomePage() {
    LoginScreen()
}
