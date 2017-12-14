package coma.example.anamarrugo.mycinema.views.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import coma.example.anamarrugo.mycinema.R;
import coma.example.anamarrugo.mycinema.views.activities.MovieDetailActivity;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class CastDetalleAdapter  extends ArrayAdapter<String> {
    private ArrayList<String> castArrayList;
    private Activity context;
    private String name;
    private TextView item_cast_name;
    public CastDetalleAdapter(MovieDetailActivity movieDetailActivity, int director_listView, ArrayList<String> castArrayList) {

        super(movieDetailActivity, director_listView, castArrayList);
        this.context = context;
        this.castArrayList = castArrayList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_item, parent, false);
        this.name = this.castArrayList.get(position);
        loadView(convertView);
        return convertView;
    }

    private void loadView(View convertView){
        item_cast_name = (TextView) convertView.findViewById(R.id.item_cast_name);
        item_cast_name.setText( this.name);
    }
}


