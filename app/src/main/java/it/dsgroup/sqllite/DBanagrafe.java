package it.dsgroup.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by utente9.academy on 05/12/2017.
 */

public class DBanagrafe extends SQLiteOpenHelper {



    public DBanagrafe(Context context) {
        super(context, "anagrafee.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "Create table paternita"+
                    "( cognome_padre text primary key, nome_padre text , nome_figlio text, cognome_figlio text)");

        db.execSQL(
                "Create table maternita"+
                        "( cognome_madre text primary key , nome_madre text , nome_figlio text, cognome_figlio text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }


    public boolean insert(String tabella, String nome, String cognome, String nFiglio, String cFiglio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (tabella.equals("paternita")){
            contentValues.put("nome_padre",nome);
            contentValues.put("cognome_padre",cognome);

        }

        else if (tabella.equals("maternita")){
            contentValues.put("nome_madre",nome);
            contentValues.put("cognome_madre",cognome);
        }

        contentValues.put("nome_figlio",nFiglio);
        contentValues.put("cognome_figlio",cFiglio);
        db.insert(tabella,null,contentValues);
        return true;
    }


    public Cursor getJoin(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select paternita.nome_padre, maternita.nome_madre from maternita  inner join paternita on paternita.cognome_figlio=maternita.cognome_figlio ",null);
        return res;
    }

}
