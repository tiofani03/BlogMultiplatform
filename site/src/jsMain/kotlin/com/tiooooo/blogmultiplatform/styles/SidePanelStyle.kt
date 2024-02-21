package com.tiooooo.blogmultiplatform.styles

import com.tiooooo.blogmultiplatform.models.Theme
import com.tiooooo.blogmultiplatform.utils.Id
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.ms

val NavigationItemStyle by ComponentStyle {
    cssRule(" > #${Id.svgParent} > #${Id.vectorIcon} ") {
        Modifier
            .transition(
                CSSTransition(
                    property = TransitionProperty.All,
                    duration = 300.ms,
                )
            )
            .styleModifier {
                property("stroke", Theme.White.hex)
            }
    }

    cssRule(":hover >  #${Id.svgParent} > #${Id.vectorIcon} ") {
        Modifier
            .transition(
                CSSTransition(
                    property = TransitionProperty.All,
                    duration = 300.ms,
                )
            )
            .styleModifier {
                property("stroke", Theme.Primary.hex)
            }
    }

    cssRule(":hover > #${Id.navigationText}") {
        Modifier
            .transition(
                CSSTransition(
                    property = TransitionProperty.All,
                    duration = 300.ms,
                )
            )
            .color(Theme.Primary.rgb)
    }

    cssRule(" > #${Id.navigationText}") {
        Modifier.color(Theme.White.rgb)
    }
}
