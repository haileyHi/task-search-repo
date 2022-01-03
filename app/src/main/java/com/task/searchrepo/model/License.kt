package com.task.searchrepo.model

import com.squareup.moshi.Json

data class License(
    @Json(name = "key")
    var key: String,

    @Json(name = "name")
    var name: String,

    @Json(name = "spdx_id")
    var spdxId: String,

    @Json(name = "url")
    var url: String,

    @Json(name = "node_id")
    var nodeId: String
)
