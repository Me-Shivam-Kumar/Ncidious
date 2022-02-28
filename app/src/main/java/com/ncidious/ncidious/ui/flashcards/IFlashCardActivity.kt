package com.ncidious.ncidious.ui.flashcards

import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse

interface IFlashCardActivity {
    fun onFlashCardListItemClick(flashCardItem:FlashCardTopicListResponse)
}