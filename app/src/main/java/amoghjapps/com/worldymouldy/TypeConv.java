package amoghjapps.com.worldymouldy;

import android.arch.persistence.room.TypeConverter;
import android.net.Uri;

public class TypeConv {
    @TypeConverter
    public static String toStr(Uri uri){
        return uri == null?null:new String(uri.toString());
    }
    @TypeConverter
    public static Uri toUri(String str){
        return str == null? null : (Uri.parse(str));
    }
}
