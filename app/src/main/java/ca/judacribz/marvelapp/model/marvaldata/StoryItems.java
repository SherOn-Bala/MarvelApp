
package ca.judacribz.marvelapp.model.marvaldata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoryItems implements Parcelable
{

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    public final static Creator<StoryItems> CREATOR = new Creator<StoryItems>() {


        @SuppressWarnings({
            "unchecked"
        })
        public StoryItems createFromParcel(Parcel in) {
            return new StoryItems(in);
        }

        public StoryItems[] newArray(int size) {
            return (new StoryItems[size]);
        }

    }
    ;

    protected StoryItems(Parcel in) {
        this.resourceURI = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public StoryItems() {
    }

    /**
     * 
     * @param resourceURI
     * @param name
     * @param type
     */
    public StoryItems(String resourceURI, String name, String type) {
        super();
        this.resourceURI = resourceURI;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(resourceURI);
        dest.writeValue(name);
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
