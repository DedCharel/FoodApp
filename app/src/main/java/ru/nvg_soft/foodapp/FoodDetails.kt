package ru.nvg_soft.foodapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.food_tiket.*
import kotlinx.android.synthetic.main.food_tiket.ivFood
import kotlinx.android.synthetic.main.food_tiket.tvName

class FoodDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val bundle = intent.extras
        ivFood.setImageResource(bundle.getInt("image"))
        tvName.text = bundle.getString("name")
        tvDescription.text = bundle.getString("des")
    }
}
