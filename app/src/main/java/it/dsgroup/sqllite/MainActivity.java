package it.dsgroup.sqllite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DBanagrafe dBanagrafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dBanagrafe = new DBanagrafe(getApplicationContext());




        /*dBanagrafe.insert("paternita","cesare","maldini","paolo","mald");
        dBanagrafe.insert("paternita","cesare","cannavaro","michele","cannavaro");

        dBanagrafe.insert("maternita","fabiana","maldini","paolo","maldini");
        dBanagrafe.insert("maternita","alessandra","cannavaro","michele","cannavaro");*/

        Cursor c = dBanagrafe.getJoin();
        c.moveToFirst();

        while (c.isAfterLast()==false){
            String s = c.getString(c.getColumnIndex("nome_figlio"));
            c.moveToNext();
        }

    }
}
