package com.example.fakenews.presentation.recycler

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val author: String,
    val date: String, //дд.мм.гггг
    val topic: String, //Политика, Технологии, Игры, Экономика
    val text: String
):Parcelable