package com.xl.openeye.repository

import android.util.Log
import com.xl.openeye.annotation.RankingType
import com.xl.openeye.dataclass.HomeInfo
import com.xl.openeye.nei.EyeApi
import com.xl.xl_base.api.Response
import com.xl.xl_base.base.BaseRepository
import javax.inject.Inject

class DataRepository @Inject constructor(private val service: EyeApi) : BaseRepository() {
    suspend fun getHome(index: String) = service.getHomeData(index)

    suspend fun getNextHome(date: String, num: String) = service.getNextHomePage(date, num)


    suspend fun getFollow(num: String) = service.getFollow(start = num)

    suspend fun getType() = service.getType()

    suspend fun getToppic(index: Int) = service.getToppic(index.toString())

    suspend fun getNewInfo(index: Int) = service.getNews(start = index.toString())

    suspend fun getRecommend(index: String) = service.getRecommend(startScore = index)

    suspend fun getRanking(@RankingType type: String) = service.getRanking(type)


    suspend fun getVideoRecommend(id: String) = service.getVideoRecommend(id)
}