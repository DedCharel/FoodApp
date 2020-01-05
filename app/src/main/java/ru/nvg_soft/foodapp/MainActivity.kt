package ru.nvg_soft.foodapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_tiket.view.*

class MainActivity : AppCompatActivity() {

    var listOfFood = ArrayList<Food>()
    var adapter:FoodAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load list
        listOfFood.add(Food("Coffee","Описание содержащее множество букв для того чтобы клиент все понял",R.drawable.coffee_pot))
        listOfFood.add(Food("Espresso","Описание содержащее множество букв для того чтобы клиент все понял",R.drawable.espresso))
        listOfFood.add(Food("French fries","Описание содержащее множество букв для того чтобы клиент все понял",R.drawable.french_fries))
        listOfFood.add(Food("Honey","Описание содержащее множество букв для того чтобы клиент все понял",R.drawable.honey))
        listOfFood.add(Food("Strawberry","Описание содержащее множество букв для того чтобы клиент все понял",R.drawable.strawberry_ice_cream))
        listOfFood.add(Food("sugar cubes","Описание содержащее множество букв для того чтобы клиент все понял",R.drawable.sugar_cubes))

        adapter = FoodAdapter(this, listOfFood)
        gvListFood.adapter = adapter
    }

    class FoodAdapter: BaseAdapter {
        var context:Context? = null
        var listOfFood = ArrayList<Food>()

        constructor(context: Context, listOfFood:ArrayList<Food>){
            this.listOfFood = listOfFood
            this.context = context

        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = listOfFood[p0]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflater.inflate(R.layout.food_tiket,null)
            foodView.ivFood.setImageResource(food.image!!)
            foodView.ivFood.setOnClickListener{
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.tvName.text = food.name
            return foodView
        }

        override fun getItem(p0: Int): Any {
           return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
           return p0.toLong()
        }

        override fun getCount(): Int {
          return listOfFood.size
        }

    }
}
