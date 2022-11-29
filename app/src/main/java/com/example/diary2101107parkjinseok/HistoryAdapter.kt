import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diary2101107parkjinseok.R
import com.example.diary2101107parkjinseok.model.MyList

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private var data = listOf<MyList>()
    fun updateData(data:List<MyList>){
        this.data = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(v)
    }
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val record = data[position]
        holder.textViewTime.text = record.time
        holder.textViewFood.text = record.food
    }
    override fun getItemCount(): Int {
        return data.size
    }
    class HistoryViewHolder(v: View): RecyclerView.ViewHolder(v){
        val textViewTime: TextView = v.findViewById(R.id.textViewTime)
        val textViewFood:TextView = v.findViewById(R.id.textViewFood)
    }
}