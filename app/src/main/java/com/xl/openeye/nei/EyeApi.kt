package com.xl.openeye.nei


import com.xl.openeye.dataclass.*
import com.xl.xl_base.api.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EyeApi {
    @GET("/api/v2/feed")
    suspend fun getHomeData(@Query("num") num: String): HomeInfo

    @GET("/api/v2/feed")
    suspend fun getNextHomePage(@Query("date") data: String, @Query("num") num: String): HomeInfo


    @GET("/api/v4/tabs/follow")
    suspend fun getFollow(
        @Query("start") start: String,
        @Query("num") num: String = "2",
        @Query("follow") follow: Boolean = false,
        @Query("startId") startId: String = "0"
    ): FollowInfo

    @GET("/api/v4/categories")
    suspend fun getType(): List<CategoryInfoItem>

    @GET("/api/v3/specialTopics")
    suspend fun getToppic(@Query("start") start: String, @Query("num") num: String = "10"): Toppics

    @GET("/api/v7/information/list")
    suspend fun getNews(
        @Query("vc") va: String = "6030000",
        @Query("deviceModel") deviceModel: String = "android",
        @Query("num") num: String = "10",
        @Query("start") start: String
    ): NewsInfo
}