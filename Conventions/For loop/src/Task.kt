class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var currentDate = start

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = currentDate
                currentDate = currentDate.followingDate()
                return result
            }
            override fun hasNext(): Boolean {
                return currentDate <= end
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}