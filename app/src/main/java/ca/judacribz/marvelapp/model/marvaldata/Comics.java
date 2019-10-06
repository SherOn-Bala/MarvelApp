
package ca.judacribz.marvelapp.model.marvaldata;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comics implements Parcelable
{

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("comicItems")
    @Expose
    private List<ComicItems> comicItems = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;
    public final static Creator<Comics> CREATOR = new Creator<Comics>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Comics createFromParcel(Parcel in) {
            return new Comics(in);
        }

        public Comics[] newArray(int size) {
            return (new Comics[size]);
        }

    }
    ;

    protected Comics(Parcel in) {
        this.available = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.collectionURI = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.comicItems, (ComicItems.class.getClassLoader()));
        this.returned = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Comics() {
    }

    /**
     * 
     * @param comicItems
     * @param collectionURI
     * @param available
     * @param returned
     */
    public Comics(Integer available, String collectionURI, List<ComicItems> comicItems, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.comicItems = comicItems;
        this.returned = returned;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<ComicItems> getComicItems() {
        return comicItems;
    }

    public void setComicItems(List<ComicItems> comicItems) {
        this.comicItems = comicItems;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(available);
        dest.writeValue(collectionURI);
        dest.writeList(comicItems);
        dest.writeValue(returned);
    }

    public int describeContents() {
        return  0;
    }

}
