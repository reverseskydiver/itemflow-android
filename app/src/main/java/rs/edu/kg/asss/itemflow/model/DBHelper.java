package rs.edu.kg.asss.itemflow.model;

import static rs.edu.kg.asss.itemflow.util.Constants.DATABASE_NAME;
import static rs.edu.kg.asss.itemflow.util.Constants.DATABASE_VERSION;
import static rs.edu.kg.asss.itemflow.util.Constants.Table.COLUMN_ITEM_ID;
import static rs.edu.kg.asss.itemflow.util.Constants.Table.COLUMN_ITEM_LOCATION;
import static rs.edu.kg.asss.itemflow.util.Constants.Table.COLUMN_ITEM_NAME;
import static rs.edu.kg.asss.itemflow.util.Constants.Table.COLUMN_QUANTITY;
import static rs.edu.kg.asss.itemflow.util.Constants.Table.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = String.format("CREATE TABLE %s (", TABLE_NAME) +
                String.format("%s INTEGER PRIMARY KEY AUTOINCREMENT, ", COLUMN_ITEM_ID) +
                String.format("%s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", COLUMN_ITEM_NAME, COLUMN_ITEM_LOCATION, COLUMN_QUANTITY);

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_NAME));
        onCreate(db);
    }

    public long insertInventoryItem(InventoryItem inventoryItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_NAME, inventoryItem.getName());
        values.put(COLUMN_ITEM_LOCATION, inventoryItem.getLocation());
        values.put(COLUMN_QUANTITY, inventoryItem.getQuantity());
        return db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAllInventoryItems(){
        return this.getReadableDatabase().rawQuery(String.format("SELECT * FROM %s", TABLE_NAME), null);
    }

    public int updateItem(int id, InventoryItem inventoryItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_NAME, inventoryItem.getName());
        values.put(COLUMN_ITEM_LOCATION, inventoryItem.getLocation());
        values.put(COLUMN_QUANTITY, inventoryItem.getQuantity());
        return db.update(TABLE_NAME, values, COLUMN_ITEM_ID.concat(" = ?"), new String[]{String.valueOf(id)});
    }

    public int deleteInventoryItem(int id) {
        return this.getWritableDatabase().delete(TABLE_NAME, COLUMN_ITEM_ID.concat(" = ?"), new String[]{String.valueOf(id)});
    }


}
