package com.xl.openeye.annotation;

import static com.xl.openeye.annotation.RankingType.MONTH;
import static com.xl.openeye.annotation.RankingType.TOTAL;
import static com.xl.openeye.annotation.RankingType.WEEK;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(SOURCE)
@Target({PARAMETER})
@StringDef(value = {WEEK, MONTH, TOTAL})
public @interface RankingType {

    String WEEK = "weekly";
    String MONTH = "monthly";
    String TOTAL = "historical";
}
