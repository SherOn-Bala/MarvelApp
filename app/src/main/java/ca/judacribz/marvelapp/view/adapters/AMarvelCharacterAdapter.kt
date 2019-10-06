package ca.judacribz.marvelapp.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.judacribz.marvelapp.R
import ca.judacribz.marvelapp.model.marvaldata.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_marvel_character.view.*

class AMarvelCharacterAdapter(private val results: ArrayList<Result>) :
    RecyclerView.Adapter<AMarvelCharacterAdapter.CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder =
        CharacterHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_marvel_character,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bindViews(results[position])

    }

    class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(result: Result) {
            Picasso
//                .with(itemView.context)
                .get()
                .load(
                    String.format(
                        "%s.%s",
                        result.thumbnail.path,
                        result.thumbnail.extension
                    )
                )
                .into(itemView.ivCharacter)

            itemView.tvName.text = result.name
        }
    }
}