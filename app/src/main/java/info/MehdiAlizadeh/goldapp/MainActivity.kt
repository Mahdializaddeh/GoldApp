package info.alirezaahmadi.goldapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import info.alirezaahmadi.goldapp.databinding.ActivityMainBinding
import info.alirezaahmadi.goldapp.remote.dataModel.ContentModel
import info.alirezaahmadi.goldapp.remote.dataModel.DateModel
import info.alirezaahmadi.goldapp.remote.dataModel.GoldModel
import info.alirezaahmadi.goldapp.remote.golds.GoldApiRepository
import info.alirezaahmadi.goldapp.remote.golds.GoldRequest
import info.alirezaahmadi.goldapp.remote.time.TimeApiRepository
import info.alirezaahmadi.goldapp.remote.time.TimeRequest

/**
 * Main activity of the GoldApp application.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val goldPrice = ArrayList<ContentModel>()
    private val currencyPrice = ArrayList<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve and display current time
        TimeApiRepository.instance.getTime(

            object : TimeRequest {

                override fun onSuccess(data: DateModel) {
                    val date = data.date
                    val text = "${date.l_value} ${date.j_value} ${date.F_value} ${date.Y_value}"
                    binding.txtTime.text = text
                }

                override fun onNotSuccess(message: String) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }

                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                }

            }

        )

        // Fetch gold and currency prices
        getPrice()

        // Set up RecyclerView
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // Handle tab clicks to switch between gold and currency prices
        binding.txtArz.setOnClickListener {
            binding.txtArz.setTextColor(Color.parseColor("#E7C376"))
            binding.txtTala.setTextColor(Color.parseColor("#787879"))
            setData(currencyPrice)
        }

        binding.txtTala.setOnClickListener {
            binding.txtArz.setTextColor(Color.parseColor("#787879"))
            binding.txtTala.setTextColor(Color.parseColor("#E7C376"))
            setData(goldPrice)
        }
    }

    /**
     * Fetches gold and currency prices from the API.
     */
    private fun getPrice() {
        GoldApiRepository.instance.getGolds(

            object : GoldRequest {

                override fun onSuccess(data: GoldModel) {
                    goldPrice.addAll(data.data.golds)
                    currencyPrice.addAll(data.data.currencies)
                    setData(goldPrice)
                }

                override fun onNotSuccess(message: String) {
                    // Handle case when request is not successful
                }

                override fun onError(error: String) {
                    // Handle error case
                }

            }

        )
    }

    /**
     * Sets data to the RecyclerView adapter.
     * @param data The data to be displayed in the RecyclerView.
     */
    private fun setData(data: ArrayList<ContentModel>) {
        binding.recyclerView.adapter =
            RecyclerMainAdapter(data)
    }

}
