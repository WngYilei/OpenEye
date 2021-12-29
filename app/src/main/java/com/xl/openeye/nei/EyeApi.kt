package com.xl.openeye.nei

import com.xl.openeye.dataclass.FollowInfo
import com.xl.openeye.dataclass.HomeInfo
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
}