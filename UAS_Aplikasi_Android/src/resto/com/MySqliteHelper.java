package resto.com;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteHelper extends SQLiteOpenHelper {

	// code mendeklarasikan nama database
	private static final String DATABASE_NAME = "resto";
	// deklarasi Field
	public static final String Kode = "Kode";
	public static final String Nama = "NamaMakMin";
	public static final String Jenis = "Jenis";
	public static final String Harga = "Harga";

	public MySqliteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	// Tabel tb_MakMin
	public void createTable(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE if not exists tb_MakMin (Kode text PRIMARY KEY, Nama TEXT, " +
				"Jenis TEXT, Harga integer)");
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
