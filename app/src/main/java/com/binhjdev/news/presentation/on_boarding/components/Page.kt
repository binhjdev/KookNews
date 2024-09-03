package com.binhjdev.news.presentation.on_boarding.components

import androidx.annotation.DrawableRes
import com.binhjdev.news.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val img: Int
)

val pages = listOf(
    Page(
        title = "Lorem issum sumply dummy",
        description = "Lorem issum sumply dummy text of printing and typesetting industry",
        img = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem issum sumply dummy",
        description = "Lorem issum sumply dummy text of printing and typesetting industry",
        img = R.drawable.onboarding2
    ),
    Page(
        title = "Lorem issum sumply dummy",
        description = "Lorem issum sumply dummy text of printing and typesetting industry",
        img = R.drawable.onboarding3
    )
)
