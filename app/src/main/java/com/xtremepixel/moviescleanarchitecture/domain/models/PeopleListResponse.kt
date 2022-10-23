package com.xtremepixel.moviescleanarchitecture.domain.models


import com.google.gson.annotations.SerializedName

data class PeopleListResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val peopleList: List<PeopleItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)