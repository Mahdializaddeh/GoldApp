package info.alirezaahmadi.goldapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import info.MehdiAlizadeh.goldapp.util.Extension.formatAsPrice
import info.alirezaahmadi.goldapp.databinding.RecyclerMainItemBinding
import info.alirezaahmadi.goldapp.remote.dataModel.ContentModel

/**
 * RecyclerView adapter for displaying gold or currency data.
 * @property allData The list of gold or currency data to be displayed.
 */
class RecyclerMainAdapter(
    private val allData: ArrayList<ContentModel>
) : RecyclerView.Adapter<RecyclerMainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            RecyclerMainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData(allData[position])
    }

    /**
     * ViewHolder class for RecyclerView items.
     * @param binding The binding object for the item layout.
     */
    inner class MainViewHolder(
        private val binding: RecyclerMainItemBinding
    ) : ViewHolder(binding.root) {

        /**
         * Sets data to the item views.
         * @param data The ContentModel object containing data to be displayed.
         */
        fun setData(data: ContentModel) {
            val price = (data.price).formatAsPrice() // Format price using extension function
            binding.txtLabel.text = data.label
            binding.txtPrice.text = price
        }
    }
}
