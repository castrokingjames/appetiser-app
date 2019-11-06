package au.com.appetiser.itunes.domain

import java.util.*

fun Usage.ago(): String {
    val today = Calendar.getInstance()
    val currentDay = today.get(Calendar.DAY_OF_YEAR)
    val currentHour = today.get(Calendar.HOUR_OF_DAY)
    val currentMinute = today.get(Calendar.MINUTE)
    val currentSecond = today.get(Calendar.SECOND)

    val elapsed = Calendar.getInstance()
    elapsed.time = date
    val day = elapsed.get(Calendar.DAY_OF_YEAR)
    val hour = elapsed.get(Calendar.HOUR_OF_DAY)
    val minute = elapsed.get(Calendar.MINUTE)
    val second = elapsed.get(Calendar.SECOND)

    val elapsedDay = currentDay - day
    val elapsedHour = currentHour - hour
    val elapsedMinute = currentMinute - minute
    val elapseSecond = currentSecond - second

    var ago = ""

    if (elapsedDay <= 0) {
        if (elapsedHour <= 0) {
            if (elapsedMinute <= 0) {
                ago += elapseSecond
                ago += " "
                ago += "second"
                if (elapseSecond > 1)
                    ago += "s"
                ago += " "
                ago += "ago"
            } else {
                ago += elapsedMinute
                ago += " "
                ago += "minute"
                if (elapsedMinute > 1)
                    ago += "s"
                ago += " "
                ago += "ago"
            }
        } else {
            ago += elapsedHour
            ago += " "
            ago += "hour"
            if (elapsedHour > 1)
                ago += "s"
            ago += " "
            ago += "ago"
        }
    } else {
        ago += elapsedDay
        ago += " "
        ago += "day"
        if (elapsedDay > 1)
            ago += "s"
        ago += " "
        ago += "ago"
    }

    return ago
}