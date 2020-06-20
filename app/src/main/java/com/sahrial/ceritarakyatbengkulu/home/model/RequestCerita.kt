package com.sahrial.ceritarakyatbengkulu.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class RequestCerita(
    var judul: String ?="",
    var asal: String ?=""
){
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "judul" to judul,
            "asal" to asal
        )
    }
}