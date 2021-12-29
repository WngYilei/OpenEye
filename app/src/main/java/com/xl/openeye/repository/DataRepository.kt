package com.xl.openeye.repository

import android.util.Log
import com.xl.openeye.dataclass.HomeInfo
import com.xl.openeye.nei.EyeApi
import com.xl.xl_base.api.Response
import com.xl.xl_base.base.BaseRepository
import javax.inject.Inject

class DataRepository @Inject constructor(private val service: EyeApi) : BaseRepository() {
    suspend fun getHome(index: String) = service.getHomeData(index)

    suspend fun getNextHome(date: String, num: String) = service.getNextHomePage(date, num)


    suspend fun getFollow(num: String) = service.getFollow(start = num)
}