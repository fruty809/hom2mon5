import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.hom2mon5.LoveCalculatorApi
import com.example.hom2mon5.LoveCalculatorResponse
import com.example.hom2mon5.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoveCalculatorActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var secondNameEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    private val BASE_URL = "https://love-calculator.p.rapidapi.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love_calculator)

        firstNameEditText = findViewById(R.id.firstNameEditText)
        secondNameEditText = findViewById(R.id.secondNameEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val secondName = secondNameEditText.text.toString()

            val retrofit = getRetrofitInstance()

            val loveCalculatorApi = retrofit.create(LoveCalculatorApi::class.java)

            loveCalculatorApi.getPercentage(firstName, secondName).enqueue(object : Callback<LoveCalculatorResponse> {
                override fun onResponse(
                    call: Call<LoveCalculatorResponse>,
                    response: Response<LoveCalculatorResponse>
                ) {
                    val percentage = response.body()?.percentage

                    if (percentage != null) {
                        val result = "Your love percentage is: $percentage%"
                        resultTextView.text = result
                    } else {
                        resultTextView.text = "Error getting love percentage"
                    }
                }

                override fun onFailure(call: Call<LoveCalculatorResponse>, t: Throwable) {
                    resultTextView.text = "Error getting love percentage"
                }
            })
        }
    }

    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
