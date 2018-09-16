package com.ahmaddudayef.footballclub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ahmad Dudayef on 9/5/2018.
 */

@Parcelize
data class Item(val name: String, val image: Int, val description: String): Parcelable
