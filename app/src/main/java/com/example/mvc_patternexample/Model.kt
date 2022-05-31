package com.example.mvc_patternexample

import java.util.*
import kotlin.collections.ArrayList
import kotlin.jvm.Throws

/**
 * Model: Barcha ma’lumotlar va ularning vazifalarini ajratish uchun
 */
class Model : Observable() {

    val list : MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(the_index : Int) : Int{
        return list[the_index]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(th_index : Int){
        list[th_index] = list[th_index] + 1
        setChanged()// O'zgarishlarni saqlaydi
        notifyObservers() // O'zgarishlarni kuzatuvchilarga yetqazadi
    }

}