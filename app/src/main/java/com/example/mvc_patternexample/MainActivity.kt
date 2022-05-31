package com.example.mvc_patternexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvc_patternexample.databinding.ActivityMainBinding
import java.util.*

/**
 * MainActivity faylida View va Controller funksiyalarini tashkil qilish
 *
 * Bu class View va Model o’rtasidagi aloqani o’rnatadi.
 * Model tomonidan taqdim etilgan ma’lumotlar View tomonidan ishlatiladi va tegishli o’zgartirishlar kiritiladi.
 */
class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    // creating object of Model class
    var myModel: Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         *creating relationship between the observable Model and the observer Activity
         */
        myModel = Model()
        initViews()
    }

    private fun initViews() {
        myModel?.addObserver(this)

        binding.button.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun update(o: Observable?, arg: Any?) {
        binding.button.text = "Count: " + myModel?.getValueAtIndex(0)
        binding.button2.text = "Count: " + myModel?.getValueAtIndex(1)
        binding.button3.text = "Count: " + myModel?.getValueAtIndex(2)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button -> myModel?.setValueAtIndex(0)
            R.id.button2 -> myModel?.setValueAtIndex(1)
            R.id.button3 -> myModel?.setValueAtIndex(2)
        }

    }
}