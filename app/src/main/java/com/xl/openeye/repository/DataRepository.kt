package com.xl.openeye.repository

import com.xl.openeye.annotation.RankingType
import com.xl.openeye.nei.EyeApi
import com.xl.xl_base.base.BaseRepository
import javax.inject.Inject

class DataRepository @Inject constructor(private val service: EyeApi) : BaseRepository() {
    suspend fun getHome(index: String) = service.getHomeData(index)

    suspend fun getNextHome(date: String) = service.getNextHomePage(date)

    suspend fun getFollow(num: String) = service.getFollow(start = num)

    suspend fun getType() = service.getType()

    suspend fun getToppic(index: Int) = service.getToppic(index.toString())

    suspend fun getNewInfo(index: Int) = service.getNews(start = index.toString())

    suspend fun getRecommend(index: String) = service.getRecommend(startScore = index)

    suspend fun getRanking(@RankingType type: String) = service.getRanking(type)

    suspend fun getVideoRecommend(id: String) = service.getVideoRecommend(id)

    suspend fun getSpecialDetail(id: String) = service.getSpecialDetail(id)

    suspend fun getSearch(query: String) = service.getSearch(query)
}