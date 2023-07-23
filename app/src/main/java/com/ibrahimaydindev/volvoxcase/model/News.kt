package com.ibrahimaydindev.volvoxcase.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity(
    tableName = "news"
)
data class News(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @SerializedName("description")
    val description: String?,
    @SerializedName("source")
    val source: Source?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?
) : Serializable
