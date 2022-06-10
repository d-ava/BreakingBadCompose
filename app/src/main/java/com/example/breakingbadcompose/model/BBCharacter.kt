package com.example.breakingbadcompose.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


//@Entity (tableName = "bb_table")
@Parcelize
@JsonClass(generateAdapter = true)
data class BBCharacter(
//    @PrimaryKey(autoGenerate = false)
    @Json(name = "char_id")
    val charId: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "birthday")
    val birthday: String,

    @Json(name = "occupation")

    val occupation: List<String>,
    @Json(name = "img")
    val img: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "nickname")
    val nickname: String,
    @Json(name = "appearance")

    val appearance: List<Int>,
    @Json(name = "portrayed")
    val portrayed: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "better_call_saul_appearance")

    val betterCallSaulAppearance: List<Int?>
):Parcelable

