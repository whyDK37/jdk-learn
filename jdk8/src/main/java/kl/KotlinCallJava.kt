package kl

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {    // 包级可见的函数，接受一个字符串数组作为参数

    val list = ArrayList<String>() // 非空（构造函数结果）
    list.add("Item")
    val size = list.size // 非空（原生 int）
    val item = list[0] // 推断为平台类型（普通 Java 对象）
    item.substring(1) // 允许，如果 item == null 可能会抛出异常

    val nullable: String? = item // 允许，没有问题
    val notNull: String = item // 允许，运行时可能失败
}

fun demo(source: List<Int>) {
    val list = ArrayList<Int>()
    // “for”-循环用于 Java 集合：
    for (item in source) {
        list.add(item)
    }
    // 操作符约定同样有效：
    for (i in 0..source.size - 1) {
        list[i] = source[i] // 调用 get 和 set
    }
}

fun calendarDemo() {
    val calendar = Calendar.getInstance()
    if (calendar.firstDayOfWeek == Calendar.SUNDAY) {  // 调用 getFirstDayOfWeek()
        calendar.firstDayOfWeek = Calendar.MONDAY      // 调用ll setFirstDayOfWeek()
    }
    if (!calendar.isLenient) {                         // 调用 isLenient()
        calendar.isLenient = true                      // 调用 setLenient()
    }
}