package amoghjapps.com.worldymouldy;

import android.arch.persistence.room.TypeConverter;
import android.net.Uri;
import android.widget.ImageView;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
@Entity
public class ExampleItem {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "venue")
    public String mvenue;
    @ColumnInfo(name = "team1name")
    public String mteam1;
    @ColumnInfo(name = "team2name")
    public String mteam2;
    @ColumnInfo(name = "timing")
    public String mtiming;
    @ColumnInfo(name = "date")
    public String mdateg;
    @ColumnInfo(name = "t1i")
    public Uri mteam1i;

    @ColumnInfo(name = "t2i")
    public Uri mteam2i;
    @ColumnInfo(name = "color")
    public int mbgcolor;

    public ExampleItem(String venue,String team1,String team2,String timing,String dateg,Uri team1i,Uri team2i,int bgcolor){
        mteam1i=team1i;
        mteam2i=team2i;
        mteam2=team2;
        mteam1=team1;
        mtiming=timing;
        mvenue=venue;
        mdateg=dateg;
        mbgcolor=bgcolor;

    }

    public Uri getMteam1i() {
        return mteam1i;
    }

    public Uri getMteam2i() {
        return mteam2i;
    }

    public String getMdateg() {
        return mdateg;
    }

    public String getMteam1() {
        return mteam1;
    }

    public String getMteam2() {
        return mteam2;
    }

    public String getMtiming() {
        return mtiming;
    }

    public String getMvenue() {
        return mvenue;
    }
    public int getBG(){
        return  mbgcolor;
    }
    public void setselectedBG(int color){
        mbgcolor=color;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
