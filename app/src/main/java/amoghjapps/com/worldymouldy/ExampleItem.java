package amoghjapps.com.worldymouldy;

import android.net.Uri;
import android.widget.ImageView;

public class ExampleItem {

    public String mvenue;
    public String mteam1;
    public String mteam2;
    public String mtiming;
    public String mdateg;
    public Uri mteam1i;
    public Uri mteam2i;
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

}
