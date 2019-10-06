package ca.judacribz.marvelapp.view.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ca.judacribz.marvelapp.R;
import ca.judacribz.marvelapp.model.marvaldata.Result;

public class MarvelCharacterAdapter extends
        RecyclerView.Adapter<MarvelCharacterAdapter.CharacterHolder> {
    ArrayList<Result> results;

    public MarvelCharacterAdapter(ArrayList<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_marvel_character,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {
        holder.bindViews(results.get(position));
        Log.d("TAG", getItemCount() + "");
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void addCharacters(ArrayList<Result> characters) {
        results.addAll(characters);
        notifyDataSetChanged();
    }

    class CharacterHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView ivCharacter;

        public CharacterHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            ivCharacter = itemView.findViewById(R.id.ivCharacter);
        }

        void bindViews(Result result) {
            Picasso
//                .with(itemView.context)
                    .get()
                    .load(
                            String.format(
                                    "%s.%s",
                                    result.getThumbnail().getPath(),
                                    result.getThumbnail().getExtension()
                            )
                    )
                    .into(ivCharacter);

            tvName.setText(result.getName());
        }
    }
}
