package resto.com;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class dataMakMinAct extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	private SQLiteDatabase db = null;
	private Cursor dicCursor = null;
	private RadioGroup grup;
	private EditText kode, nama, harga;
	private RadioButton rMa, rMi;
	private Button btnSearch, simpan, edit, hapus;
	private MySqliteHelper dataSQL = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Membuat objek dari class DatabaseSQLite
		dataSQL = new MySqliteHelper(this, null, null, 0);
		db = dataSQL.getWritableDatabase();
		// Menjalankan method yang ada di class DatabaseSQLite
		dataSQL.createTable(db);

		setContentView(R.layout.main);
		rMa = (RadioButton)findViewById(R.id.radio0);
		rMi = (RadioButton)findViewById(R.id.radio1);
		kode = (EditText) findViewById(R.id.edkode);
		nama = (EditText) findViewById(R.id.ednama);
		harga = (EditText) findViewById(R.id.edharga);
		grup = (RadioGroup) findViewById(R.id.radioGroup1);
		grup.clearCheck();
		simpan = (Button) findViewById(R.id.btSimpan);
		simpan.setOnClickListener(this);
		btnSearch = (Button) findViewById(R.id.btCek);
		btnSearch.setOnClickListener(this);
		edit = (Button) findViewById(R.id.btEdit);
		edit.setOnClickListener(this);
		hapus = (Button) findViewById(R.id.btHapus);
		hapus.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String kode1 = kode.getText().toString();
		String nama1 = nama.getText().toString();
		String jenis ="";
		if (rMa.isChecked()){
			jenis="Makanan";
		}else if (rMi.isChecked()){
			jenis="Minuman";
		}
		String harga1 = harga.getText().toString();
		switch (arg0.getId()) {
		case R.id.btSimpan:
			if (kode1.equals("") || nama1.equals("") || harga.equals("")) {
				Toast.makeText(this, "Data masih kosong", Toast.LENGTH_SHORT)
						.show();
			} else {
				db.beginTransaction();
				try {
					db.execSQL("insert into tb_MakMin (Kode,Nama,Jenis,Harga) values('"
							+ kode1
							+ "','"
							+ nama1
							+ "','"
							+ jenis
							+ "','"
							+ harga1 + "')");
					db.setTransactionSuccessful();
					Toast.makeText(this, "Simpan Berhasil", Toast.LENGTH_SHORT)
							.show();

				} catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT)
							.show();
				}
				db.endTransaction();
				kode.setText("");
				nama.setText("");
				grup.clearCheck();
				harga.setText("");
			}
			break;
		case R.id.btEdit:
			if (kode1.equals("")) {
				Toast.makeText(this, "Kode masih kosong", Toast.LENGTH_SHORT)
						.show();
			} else {
				db.beginTransaction();
				try {
					db.execSQL("update tb_MakMin set Nama='" + nama1
							+ "',Jenis='" + jenis + "', Harga='" + harga1
							+ "' where Kode='" + kode1 + "'");
					db.setTransactionSuccessful();
					Toast.makeText(this, "Edit Berhasil", Toast.LENGTH_SHORT)
							.show();
				} catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT)
							.show();
				}
				db.endTransaction();
				kode.setText("");
				nama.setText("");
				grup.clearCheck();
				harga.setText("");
			}
			break;
		case R.id.btHapus:
			if (kode1.equals("")) {
				Toast.makeText(this, "Kode masih kosong", Toast.LENGTH_SHORT)
						.show();
			} else {
				db.beginTransaction();
				try {
					db.execSQL("delete from tb_MakMin where Kode='" + kode1
							+ "'");
					db.setTransactionSuccessful();
					Toast.makeText(this, "Hapus Berhasil", Toast.LENGTH_SHORT)
							.show();
				} catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT)
							.show();
				}

				db.endTransaction();
				kode.setText("");
				nama.setText("");
				grup.clearCheck();
				harga.setText("");
			}
			break;

		case R.id.btCek:
			db.beginTransaction();
			try {
				dicCursor = db.rawQuery("select * from tb_MakMin where Kode= '"
						+ kode1 + "'", null);
				if (dicCursor.moveToNext()) {
					nama.setText(dicCursor.getString(1));
					
					if(dicCursor.getString(2).equals("Makanan")){
						rMa.setChecked(true);						
					}else if(dicCursor.getString(2).equals("Minuman")){
						rMi.setChecked(true);
					}
					harga.setText(dicCursor.getString(3));
					Toast.makeText(this, "Data Sudah Ada", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(this, "Data Belum ADA", Toast.LENGTH_SHORT)
							.show();
				}
				db.setTransactionSuccessful();

			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			}

			db.endTransaction();
			break;
		default:
			break;
		}

	}
}