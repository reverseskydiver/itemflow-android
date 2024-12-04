package rs.edu.kg.asss.itemflow.util;

public final class Constants {
    private Constants(){
    }
    public static final String DATABASE_NAME = "inventory.db";
    public static final int DATABASE_VERSION = 1;

    public static final class Table {
        private Table(){

        }
        public static final String TABLE_NAME = "inventory";
        public static final String COLUMN_ITEM_ID = "item_id";
        public static final String COLUMN_ITEM_NAME = "item_name";
        public static final String COLUMN_ITEM_LOCATION = "item_location";
        public static final String COLUMN_QUANTITY = "item_quantity";
    }
}
