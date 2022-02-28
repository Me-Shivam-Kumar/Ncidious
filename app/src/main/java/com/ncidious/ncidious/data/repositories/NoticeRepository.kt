package com.ncidious.ncidious.data.repositories

import com.ncidious.ncidious.data.network.responses.NoticeResponse
import java.util.ArrayList

class NoticeRepository {
    private lateinit var list:List<NoticeResponse>
    suspend fun getNotices():List<NoticeResponse>{
        list= ArrayList<NoticeResponse>()
        (list as ArrayList<NoticeResponse>).add(
            NoticeResponse(
                "https://www.motachashma.com/images/nta-logo-neet-min.jpg",
                "12/04/2021",
                "Toomorow is your JEE MAINS TEST",
            )
        )
        (list as ArrayList<NoticeResponse>).add(
            NoticeResponse(
                "https://www.motachashma.com/images/nta-logo-neet-min.jpg",
                "12/04/2021",
                "Toomorow is your JEE MAINS TEST",
            )
        )
        (list as ArrayList<NoticeResponse>).add(
            NoticeResponse(
                "https://www.motachashma.com/images/nta-logo-neet-min.jpg",
                "12/04/2021",
                "Toomorow is your JEE MAINS TEST",
            )
        )
        return list
    }
}