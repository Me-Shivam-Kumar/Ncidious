package com.ncidious.ncidious.ui.flashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ncidious.ncidious.R
import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse


class FlashCards : AppCompatActivity(), IFlashCardActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_cards)
        val flashCardTopicListFragment = ListAllFlashCardsSubjects()
        supportFragmentManager.beginTransaction()
            .add(R.id.flash_card_container, flashCardTopicListFragment).commit()
    }

    override fun onFlashCardListItemClick(flashCardItem: FlashCardTopicListResponse) {
        val fragment = FlashCardDetailsFragment()
        var bundle = Bundle()
        bundle.putParcelable("flashCard_key", flashCardItem)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().addToBackStack("Flash Card Details Fragment")
            .replace(R.id.flash_card_container, fragment).commit()
    }
}