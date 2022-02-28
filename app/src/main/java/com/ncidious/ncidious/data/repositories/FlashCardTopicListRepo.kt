package com.ncidious.ncidious.data.repositories

import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse

class FlashCardTopicListRepo {
    private lateinit var flashCardTopicList:List<FlashCardTopicListResponse>

    fun getFlashCardTopicList():List<FlashCardTopicListResponse>{
        flashCardTopicList=ArrayList()

        (flashCardTopicList as ArrayList<FlashCardTopicListResponse>).add(FlashCardTopicListResponse(
            "Maths",
            "Quadratic Equation"
        ))
        (flashCardTopicList as ArrayList<FlashCardTopicListResponse>).add(FlashCardTopicListResponse(
            "Physics",
            "Kinematics"
        ))
        (flashCardTopicList as ArrayList<FlashCardTopicListResponse>).add(FlashCardTopicListResponse(
            "Chemistry",
            "Chemical Bonding"
        ))
        (flashCardTopicList as ArrayList<FlashCardTopicListResponse>).add(FlashCardTopicListResponse(
            "Maths",
            "Straight Line"
        ))
        (flashCardTopicList as ArrayList<FlashCardTopicListResponse>).add(FlashCardTopicListResponse(
            "Maths",
            "Circle"
        ))
        return flashCardTopicList
    }
}