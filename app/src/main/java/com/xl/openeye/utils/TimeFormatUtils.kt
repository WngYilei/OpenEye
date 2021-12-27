package com.xl.openeye.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeFormatUtils {

    fun getHHmm(time: Int) = SimpleDateFormat("HH:mm").format(Date((time.toLong())))
}