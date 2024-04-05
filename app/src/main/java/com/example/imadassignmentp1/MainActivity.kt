package com.example.imadassignmentp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {

    //List of Historical figures
    enum class HistoricalFigures(val year: Int, val description: String) {
        Figure_1(1918, "Birth of Nelson Rolihlahla Mandela. Who fought for equal right for South African"),
        Figure_2(1931, "Birth of Desmond Tutu. Who's known for his opposition to Apartheid in South Africa"),
        Figure_3(1961, "Birth of Barack Obama. The first black president of United States"),
        Figure_4(1969, "Bith of Alexander McQueen, known as one of the best fashion designer"),
        Figure_5(1967, "Birth of Kenneth Block, known as Ken Block, one the best rally racers, and the founder of Hoonigan"),
        Figure_6(1978, "Birth of Kolbe Bryant, known for his skillful talent in basket ball (NBA)"),
        Figure_7(1974, "Birth of Chris Kyle. He served his country in the Navy Seal, and went on to be known as one of the best snipers."),
        Figure_8(1940, "Birth of Edson Arantes Do Nascimento, known as Pele one of history's best soccer player"),
        Figure_9(1971, "Birth of Joost van der Westhuizen, former Springbok scrumhalf, known for his great performance in rugby"),
        Figure_10(1973, "Birth of Paul Walker, a famous actor known for his role as Bryan O Conner in the Fast and furious franchise."),
        Figure_11(1889, "Birth of Adolf Hitler, a Austrian-born German politician, who became a leader of the Nazi Party."),
        Figure_12(1930, "Birth of Neil Armstrong, the commander of the Apollo 11 spacecraft, and first man to set foot on the moon."),
        Figure_13(1806, "Birth of William Webb Ellis, at the age of 16 William invented rugby when he caught the ball instead of putting it on the ground."),
        Figure_14(1844, "Birth of Karl Benz. Karl Benz was the person who invented the first automobile."),
        Figure_15(1923, "Birth of Carroll Shelby, Mr. Shelby was the person who helped Ford win Le Man race in 1966, and help in the creation of the Mustang and Cobra AC."),
        Figure_16(1898, "Birth of Enzo Ferrari. Enzo was a Italian automobile manufacturer and designer, but mainly he was the founder of the famous supercar brand, Ferrari, in the year of 1939"),
        Figure_17(1916, "Birth of Ferruccio Lamborghini, the founder of the famous italian supercar brand, Lamborghini, in the year 1963"),
        Figure_18(1922, "Birth of Christiaan Barnard. Christiaan is a South African surgeon who performed the world's first heart transplant in 1967 in Groote Schuur Hospital in South Africa"),
        Figure_19(1940, "Birth of Kunimitsu Takahashi. He invented what we know as drifting, the breaking of traction in a vehicle and controlling it throughout a corner or curve."),
        Figure_20(1926, "Birth of Martin Cooper. The man responsible for the invention of the first ever cellphone in 1973")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Getting layout components
        val edtBirthYear = findViewById<TextView>(R.id.edtYear)
        val btnProceed = findViewById<Button>(R.id.btnProceed)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        //When user presses the Proceed Button
        btnProceed?.setOnClickListener()
        {
            val birthYear = edtBirthYear.text.toString().toInt()


            if (birthYear != null && birthYear in 1500 .. 2024) {
                // Grabbing the values of the years in the list of Historical figures
                val eventYear = HistoricalFigures.values().map {  it.year }

                val events = when (birthYear)
                {
                    //This Statement will be displayed if birth year matches exactly the year of Historical figure
                    in eventYear -> {
                        val events = HistoricalFigures.values().find { it.year == birthYear }
                        listOf("In $birthYear: ${events?.description ?: "event"}")
                    }
                    //This statement will be displayed when the year is not the same or close to the event years
                    else -> listOf("No historical figure was born in that $birthYear.")
                }
                txtResult.text = events.joinToString("\n")
            }
            else
            {
                txtResult.text = "No historical figure was present during that year"
            }
        }
    }
}