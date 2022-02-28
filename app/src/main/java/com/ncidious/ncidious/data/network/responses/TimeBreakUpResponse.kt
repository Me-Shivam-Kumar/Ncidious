package com.ncidious.ncidious.data.network.responses

data class TimeBreakUpResponse(
    val timeTakenInPhysics:String,
    val timeTakenInMaths:String,
    val timeTakenInChemistry:String
)