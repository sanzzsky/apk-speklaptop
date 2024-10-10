package com.sanzzsky.speklaptop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Laptop(
    val name: String,
    val description: String,
    val specs: String,
    val imageResId: Int,
    val displaySize: String,
    val battery: String
) : Parcelable
