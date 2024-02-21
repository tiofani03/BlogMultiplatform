package com.tiooooo.blogmultiplatform.navigation

sealed class Screen(val route: String) {
    object AdminHome : Screen(route = "/admin/")
    object AdminLogin : Screen(route = "/admin/login")
    object AdminCreate : Screen(route = "/admin/create")
    object AdminPosts : Screen(route = "/admin/posts")
}
