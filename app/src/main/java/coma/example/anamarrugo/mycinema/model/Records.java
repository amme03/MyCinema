package coma.example.anamarrugo.mycinema.model;

/**
 * Created by ana.marrugo on 12/12/2017.
 */
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Created by ana.marrugo on 11/12/2017.
 */

public class Records  implements Serializable {
    @Root(name="records", strict=false)


    @Attribute(name="date")
    private String date;

    @ElementList(entry = "movieinfo", inline = true, required = false)
    private ArrayList<MovieInfo> movies;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<MovieInfo> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<MovieInfo> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Records{" +
                "date='" + date + '\'' +
                ", movies=" + movies +
                '}';
    }
}
