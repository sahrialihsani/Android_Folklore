package com.sahrial.ceritarakyatbengkulu.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@Parcelize
data class Daerah(
    var asal: String ?="",
    var poster_daerah: String?=""
): Parcelable
