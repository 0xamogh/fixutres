package amoghjapps.com.worldymouldy;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities =  {ExampleItem.class},version = 1)
@TypeConverters({TypeConv.class})
    public abstract class AppDatabase extends RoomDatabase{
        public abstract DatabaseInterf databaseInterf();
        @Override
        protected InvalidationTracker createInvalidationTracker(){
            return null;
        }
        @Override
        protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config){
            return null;
        }

    }

