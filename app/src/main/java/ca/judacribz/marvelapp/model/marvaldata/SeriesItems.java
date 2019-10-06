
package ca.judacribz.marvelapp.model.marvaldata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeriesItems implements Parcelable
{

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<SeriesItems> CREATOR = new Creator<SeriesItems>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SeriesItems createFromParcel(Parcel in) {
            return new SeriesItems(in);
        }

        public SeriesItems[] newArray(int size) {
            return (new SeriesItems[size]);
        }

    }
    ;

    protected SeriesItems(Parcel in) {
        this.resourceURI = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public SeriesItems() {
    }

    /**
     * 
     * @param resourceURI
     * @param name
     */
    public SeriesItems(String resourceURI, String name) {
        super();
        this.resourceURI = resourceURI;
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(resourceURI);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
