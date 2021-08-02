package com.demirli.a9dollarstocent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var amountOfDollar: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convert_btn.setOnClickListener {
            if (dollar_et.text.toString() != ""){
                amountOfDollar = dollar_et.text.toString().toDouble()

                var dollarToCents = amountOfDollar!!*100
                dollar_cent_tv.text = "Total Cents: " + dollarToCents.roundToInt().toString()

                val calculateObject = CalculateCoins(dollarToCents)

                setTexts(quarters_tv,calculateObject.quarters!!)
                setTexts(dimes_tv,calculateObject.dimes!!)
                setTexts(nickels_tv,calculateObject.nickels!!)
                setTexts(pennies_tv,calculateObject.pennies!!)
            }
        }
    }

    class CalculateCoins(dollarCents: Double) {

        var quarters: Double? = null
        var dimes: Double? = null
        var nickels: Double? = null
        var pennies: Double? = null

        var balance: Double? = null

        init {

            quarters= Math.floor(dollarCents / 25)
            balance = dollarCents % 25

            dimes = Math.floor(balance!! / 10)
            balance = balance!! % 10

            nickels = Math.floor(balance!! / 5)
            balance = balance!! % 5

            pennies= Math.round(balance!!).toDouble()
        }
    }

    fun setTexts(textView: TextView, result: Double){
        textView.text = result.toString()
    }
}
