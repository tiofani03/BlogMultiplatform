package com.tiooooo.blogmultiplatform.components

import androidx.compose.runtime.Composable
import com.tiooooo.blogmultiplatform.models.Theme
import com.tiooooo.blogmultiplatform.navigation.Screen
import com.tiooooo.blogmultiplatform.styles.NavigationItemStyle
import com.tiooooo.blogmultiplatform.utils.Constants.FONT_FAMILY
import com.tiooooo.blogmultiplatform.utils.Constants.SIDE_PANEL_WIDTH
import com.tiooooo.blogmultiplatform.utils.Id
import com.tiooooo.blogmultiplatform.utils.Res
import com.tiooooo.blogmultiplatform.utils.logout
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun SidePanel() {
    val context = rememberPageContext()

    Column(
        modifier = Modifier
            .padding(leftRight = 40.px, topBottom = 50.px)
            .width(SIDE_PANEL_WIDTH.px)
            .height(100.vh)
            .position(Position.Fixed)
            .backgroundColor(Theme.Secondary.rgb)
            .zIndex(9)
    ) {
        Image(
            modifier = Modifier.margin(bottom = 50.px),
            src = Res.Image.logo,
            description = "Image Logo"
        )
        SpanText(
            modifier = Modifier
                .margin(bottom = 30.px)
                .fontFamily(FONT_FAMILY)
                .color(Theme.HalfWhite.rgb)
                .fontSize(14.px),
            text = "Dashboard"
        )

        NavigationItem(
            modifier = Modifier.margin(bottom = 24.px),
            title = "Home",
            selected = context.route.path == Screen.AdminHome.route,
            icon = Res.PathIcon.home,
            onClick = {
                context.router.navigateTo(Screen.AdminHome.route)
            }
        )

        NavigationItem(
            modifier = Modifier.margin(bottom = 24.px),
            title = "Create Post",
            selected = context.route.path == Screen.AdminCreate.route,
            icon = Res.PathIcon.create,
            onClick = {
                context.router.navigateTo(Screen.AdminCreate.route)
            }
        )

        NavigationItem(
            modifier = Modifier.margin(bottom = 24.px),
            title = "My Post",
            selected = context.route.path == Screen.AdminPosts.route,
            icon = Res.PathIcon.posts,
            onClick = {
                context.router.navigateTo(Screen.AdminPosts.route)
            }
        )

        NavigationItem(
            modifier = Modifier.margin(bottom = 24.px),
            title = "Logout",
            icon = Res.PathIcon.logout,
            onClick = {
                logout()
                context.router.navigateTo(Screen.AdminLogin.route)
            }
        )
    }
}

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    title: String,
    icon: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = NavigationItemStyle.toModifier()
            .then(modifier)
            .cursor(Cursor.Pointer)
            .onClick { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        VectorIcon(
            modifier = Modifier.margin(right = 10.px),
            pathData = icon,
            selected = selected,
        )
        SpanText(
            modifier = Modifier
                .id(Id.navigationText)
                .fontFamily(FONT_FAMILY)
                .fontSize(16.px)
                .thenIf(
                    condition = selected,
                    other = Modifier.color(Theme.Primary.rgb)
                ),
            text = title,
        )
    }
}

@Composable
fun VectorIcon(
    modifier: Modifier = Modifier,
    pathData: String,
    selected: Boolean,
) {
    Svg(
        attrs = modifier
            .id(Id.svgParent)
            .width(24.px)
            .height(24.px)
            .toAttrs {
                attr("viewBox", "0 0 24 24")
                attr("fill", "none")
            }
    ) {
        Path(
            attrs = Modifier
                .id(Id.vectorIcon)
                .thenIf(
                    condition = selected,
                    other = Modifier.styleModifier {
                        property("stroke", Theme.Primary.hex)
                    }
                )
                .toAttrs {
                    attr("d", pathData)
                    attr("stroke-width", "2")
                    attr("stroke-linecap", "round")
                    attr("stroke-linejoin", "round")

                }
        )

    }

}
