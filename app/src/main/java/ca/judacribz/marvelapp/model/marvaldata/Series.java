
package ca.judacribz.marvelapp.model.marvaldata;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Series implements Parcelable
{

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<SeriesItems> items = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;
    public final static Creator<Series> CREATOR = new Creator<Series>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Series createFromParcel(Parcel in) {
            return new Series(in);
        }

        public Series[] newArray(int size) {
            return (new Series[size]);
        }

    }
    ;

    protected Series(Parcel in) {
        this.available = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.collectionURI = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.items, (SeriesItems.class.getClassLoader()));
        this.returned = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Series() {
    }

    /**
     * 
     * @param items
     * @param collectionURI
     * @param available
     * @param returned
     */
    public Series(Integer available, String collectionURI, List<SeriesItems> items, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
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

    public List<SeriesItems> getItems() {
        return items;
    }

    public void setItems(List<SeriesItems> items) {
        this.items = items;
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
        dest.writeList(items);
        dest.writeValue(returned);
    }

    public int describeContents() {
        return  0;
    }

}
