package amoghjapps.com.worldymouldy;

import android.widget.ImageView;

public class ExampleItem {

    public String mvenue;
    public String mteam1;
    public String mteam2;
    public String mtiming;
    public String mdateg;
    public int mteam1i;
    public int mteam2i;
    public int mbgcolor;
    public ExampleItem(String venue,String team1,String team2,String timing,String dateg,int team1i,int team2i,int bgcolor){
        mteam1i=team1i;
        mteam2i=team2i;
        mteam2=team2;
        mteam1=team1;
        mtiming=timing;
        mvenue=venue;
        mdateg=dateg;
        mbgcolor=bgcolor;

    }

    public int getMteam1i() {
        return mteam1i;
    }

    public int getMteam2i() {
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
