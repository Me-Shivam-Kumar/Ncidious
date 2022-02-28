package com.ncidious.ncidious.data.network.responses

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ExamsAttemptedResponse(
    val examName:String,
    val examDate:String,
    val rank:String,
    val marksSecured:String,
    val totalMarks:String
): Parcelable