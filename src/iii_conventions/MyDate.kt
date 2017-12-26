package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val yearDiff = this.year - other.year
        return if (yearDiff == 0) {
            val monthDiff = this.month - other.month
            if (monthDiff == 0) {
                this.dayOfMonth - other.dayOfMonth
            } else monthDiff
        } else yearDiff
    }


    operator fun plus(that: TimeInterval): MyDate = this.addTimeIntervals(that, 1)
    operator fun plus(that: TimeIntervals): MyDate = this.addTimeIntervals(that.timeInterval, that.howMany)
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(multiplier: Int): TimeIntervals = TimeIntervals(this, multiplier)
}

data class TimeIntervals(val timeInterval: TimeInterval, val howMany: Int)

class DateRange(override val start: MyDate,
                override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var cursor: MyDate = start
            override fun hasNext(): Boolean = cursor <= endInclusive
            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException("No more date in this DateRange")
                val current = cursor
                cursor = cursor.nextDay()
                return current
            }
        }
    }
}

