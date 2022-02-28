package com.ncidious.ncidious.data.network.responses


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class FlashCardTopicListResponse(
    val subject: String,
    val topicName:String
) : Parcelable
