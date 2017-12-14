package coma.example.anamarrugo.mycinema.model;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;

@Root(name="movieinfo", strict=false)
public class MovieInfo implements Serializable {

    @Path("info") @Element(name="title")
    private String title;

    @Path("info") @Element(name="description")
    private String description;

    @Path("info") @Element(name="rating")
    private String rating;

    @Path("cast") @ElementList(entry = "name", inline = true, required = false)
    private ArrayList<String> cast;

    @Path("poster") @Element(name="location")
    private String poster;

    @Path("poster") @Element(name="xlarge")
    private String posterLarge;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPosterLarge() {
        return posterLarge;
    }

    public void setPosterLarge(String posterLarge) {
        this.posterLarge = posterLarge;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", cast=" + cast +
                ", poster='" + poster + '\'' +
                ", posterLarge='" + posterLarge + '\'' +
                '}';
    }
}
