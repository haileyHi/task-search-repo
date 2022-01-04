package com.task.searchrepo.model

import com.squareup.moshi.Json

data class License(
    @field:Json(name = "key")
    var key: String,

    @field:Json(name = "name")
    var name: String,

    @field:Json(name = "spdx_id")
    var spdxId: String,

    @field:Json(name = "url")
    var url: String,

    @field:Json(name = "node_id")
    var nodeId: String
)
