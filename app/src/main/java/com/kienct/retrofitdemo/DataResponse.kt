package com.kienct.retrofitdemo

import com.google.gson.annotations.SerializedName

class DataResponse {
    @SerializedName("page")
    var page: String? = null

    @SerializedName("per_page")
    var perPage: String? = null

    @SerializedName("total")
    var total: String? = null

    @SerializedName("total_pages")
    var totalPages: String? = null

    @SerializedName("id")
    var id: String? = null

    @SerializedName("job")
    var job: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("createdAt")
    var createdAt: String? = null

    @SerializedName("updatedAt")
    var updatedAt: String? = null


//    @SerializedName("data")
//    var data: List<Data>? = null

}

//class Data {
//    @SerializedName("id")
//    var id: String? = null
//
//    @SerializedName("email")
//    var email: String? = null
//
//    @SerializedName("first_name")
//    var firstName: String? = null
//
//    @SerializedName("last_name")
//    var lastName: String? = null
//
//    @SerializedName("avatar")
//    var avatar: String? = null
//
//}
