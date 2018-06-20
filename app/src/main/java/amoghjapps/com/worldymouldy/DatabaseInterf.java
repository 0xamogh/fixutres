package amoghjapps.com.worldymouldy;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import java.util.ArrayList;
import java.util.List;
@Dao
public interface DatabaseInterf {
    @Query("SELECT* FROM exampleitem")
    ArrayList<ExampleItem> getAllItems();
    @Insert
    void insertAll(ExampleItem eg);
}
