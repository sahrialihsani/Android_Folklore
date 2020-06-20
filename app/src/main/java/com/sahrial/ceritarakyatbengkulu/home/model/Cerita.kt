package com.sahrial.ceritarakyatbengkulu.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@Parcelize
data class Cerita(
    var judul: String ?="",
    var see: Int ?=0,
    var asal: String ?="",
    var poster: String ?="",
    var cerita: String ?="",
    var poster_daerah: String?=""
): Parcelable
