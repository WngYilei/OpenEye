package com.xl.openeye.nei

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
}