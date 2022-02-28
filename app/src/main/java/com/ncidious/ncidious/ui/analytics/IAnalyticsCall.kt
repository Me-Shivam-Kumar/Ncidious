package com.ncidious.ncidious.ui.analytics

import com.ncidious.ncidious.data.network.responses.ExamsAttemptedResponse

interface IAnalyticsCall {
    fun onAttemptedTestOnClick(attemmptedTestItem:ExamsAttemptedResponse)
}