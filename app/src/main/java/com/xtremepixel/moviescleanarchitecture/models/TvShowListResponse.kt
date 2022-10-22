package com.xtremepixel.moviescleanarchitecture.models


import com.google.gson.annotations.SerializedName

data class TvShowListResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tvShowList: List<TvShowItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)