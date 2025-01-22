package com.example.flowchart_22041039

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Flowchart(
    val namaFlowchart: String,
    val gambarFlowchart: Int
) : Parcelable
