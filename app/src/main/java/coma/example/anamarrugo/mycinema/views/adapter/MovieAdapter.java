package coma.example.anamarrugo.mycinema.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import coma.example.anamarrugo.mycinema.R;
import coma.example.anamarrugo.mycinema.model.MovieInfo;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class MovieAdapter extends BaseAdapter {

    private List<MovieInfo> movieList;
    private Context mContext;

    public MovieAdapter(List<MovieInfo> movieList, Context mContext) {
        this.movieList = movieList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return Math.max(movieList.size(),1);
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if( rowView == null ) {
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
        }
        TextView name = (TextView) rowView.findViewById(R.id.label);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);

        MaterialRatingBar ratingBar= (MaterialRatingBar) rowView.findViewById(R.id.ratingBar_Material);
        int minX = 0;
        float maxX =6;
        Random rand = new Random();
        float finalX = ((int)(rand.nextFloat() * (maxX - minX)) );
        float finalDec = ((int)(rand.nextFloat() * (maxX - minX)) )>2.5?1f:0.5f;
        finalX=finalX+finalDec;


        ratingBar.setRating(finalX);
        if( i<movieList.size() ) {
            Picasso.with(mContext).load(movieList.get(i).getPoster()).into(image);
            name.setText(movieList.get(i).getTitle());
        }
        return rowView;
    }
}
