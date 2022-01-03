package com.task.searchrepo.model

import com.squareup.moshi.Json

data class SearchInfo(
    @field:Json(name = "total_count")
    var totalCount: Long,

    @field:Json(name = "incomplete_results")
    var incompleteResults: Boolean,

    @field:Json(name = "items")
    var items: List<Repo>?
)
