package com.task.searchrepo.model

import com.squareup.moshi.Json

data class SearchInfo(
    @Json(name = "total_count")
    var totalCount: Long,

    @Json(name = "incomplete_results")
    var incompleteResults: Boolean,

    @Json(name = "items")
    var items: List<Repo>?
)
