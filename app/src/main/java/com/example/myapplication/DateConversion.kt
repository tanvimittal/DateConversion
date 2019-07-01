/*
西暦和暦変換クラス
 */
package com.example.myapplication
import com.example.myapplication.meijiStartDate
import com.example.myapplication.meijiEndDate
import com.example.myapplication.showaStartDate
import com.example.myapplication.showaEndDate
import com.example.myapplication.taishoStartDate
import com.example.myapplication.taishoEndDate
import com.example.myapplication.heiseiStartDate
import com.example.myapplication.heiseiEndDate
import com.example.myapplication.reiwaStartDate
import com.example.myapplication.reiwaEndDate

import com.example.myapplication.MEIJI
import com.example.myapplication.TAISHO
import com.example.myapplication.SHOWA
import com.example.myapplication.HEISEI
import com.example.myapplication.REIWA

import com.example.myapplication.MONTH
import com.example.myapplication.DAY

public class DateConversion{

    fun seirekiToWareki(seirekiDate: String) : String{

        var warekiDate : String = ""
        var era : String = ""


        var seirekiRetDate : String
        seirekiRetDate   = seirekiDate.replace("/", "")

        // 年、月、日を取得する。
        var year : Int
        var month : Int
        var day : Int

        year = seirekiRetDate.substring(0,4).toInt()
        month = seirekiRetDate.substring(4,6).toInt()
        day = seirekiRetDate.substring(6).toInt()

        if (seirekiRetDate >= meijiStartDate && seirekiRetDate <= meijiEndDate)
        {
            era = MEIJI
            year = year-1868+1
        }
        else if (seirekiRetDate >= taishoStartDate && seirekiRetDate <= taishoEndDate)
        {
            era = TAISHO
            year = year-1912+1
        }
        else if (seirekiRetDate >= meijiStartDate && seirekiRetDate <= meijiEndDate)
        {
            era = SHOWA
            year = year-1926+1
        }
        else if (seirekiRetDate >= heiseiStartDate && seirekiRetDate <= heiseiEndDate)
        {
            era = HEISEI
            year = year-1989+1
        }
        else if (seirekiRetDate >= reiwaStartDate && seirekiRetDate <= reiwaEndDate)
        {
            era = REIWA
            year = year-2019+1
        }

        warekiDate = year.toString() + era+ month.toString() + MONTH + day.toString()+ DAY

        return warekiDate
    }
}
