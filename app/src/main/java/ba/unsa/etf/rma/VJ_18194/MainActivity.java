package ba.unsa.etf.rma.VJ_18194;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dugme = (Button) findViewById(R.id.button);
        final ListView lista  = (ListView) findViewById(R.id.listView);
        final EditText tekst = (EditText) findViewById(R.id.editText);
        final ArrayList<Muzicar> unosi = new ArrayList<Muzicar>();
        unosi.add(new Muzicar("Marija Šerifović", "Pop","https://en.wiki" +
                "pedia.org/wiki/Marija_%C5%A0erifovi%C4%87","Serbian singer. Initially rose" +
                " to prominence as the talented daughter of Serbian folk singer Verica Šerifović, " +
                "Marija is now recognised as one of the best vocalists in Serbia. She is best known " +
                "for winning the Eurovision Song Contest 2007 with the ballad 'Molitva', making her" +
                " Serbia's only Eurovision winner to date.","pop", "Najslusanije pjesme:\nMolitva" +
                "\n11\nPametna i luda\nSvoja i tvoja\nU nedelju"));
        unosi.add(new Muzicar("Marko Šelić","Rap","https://en.wikipedia." +
                "org/wiki/Mar%C4%8Delo", "Serbian recording artist and writer, known for his" +
                " socially conscious lyrics and eclectic approach to musical arrangements through " +
                "hip-hop music. A Paraćin native, he moved to Belgrade, where he has had great success" +
                " over the years, and became one of the most prominent Serbian hip hop artists." +
                " He graduated Serbian language and literature at the University of Belgrade" +
                " Faculty of Philology.","rap","Najslusanije pjesme:\nJedan\nSveti bes\n" +
                "Komplikovani\nPonos\nDe Facto"));
        unosi.add(new Muzicar("Bijelo dugme", "Rock","https://en.wikipedia" +
                ".org/wiki/Bijelo_Dugme","Bijelo Dugme is widely considered to have been the " +
                "most popular band ever to exist in the former Socialist Federal Republic of Yugoslavia" +
                " and one of the most important acts of the Yugoslav rock scene. Bijelo Dugme was officially " +
                "formed in 1974, although the members of the default lineup, guitarist Goran Bregović, " +
                "vocalist Željko Bebek, drummer Ipe Ivandić, keyboardist Vlado Pravdić and bass guitarist" +
                " Zoran Redžić, were previously active under the name Jutro. The band's debut album " +
                "Kad bi bio bijelo dugme, released in 1974, brought them nationwide popularity with its" +
                " Balkan folk-influenced hard rock sound.", "rock","Najslusanije pjesme:\nKad bih bio bijelo dugme\n" +
                "Ako mozes zaboravi\nA i ti me iznevjeri\nDjurdjevdan\nKad ostaris"));
        final MuzicarAdapter adapter;
        Resources res =getResources();
        adapter = new MuzicarAdapter(this, unosi, res);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
                myIntent.putExtra("imeIzvodjaca", unosi.get(position).getImeIPrezime());
                myIntent.putExtra("zanrIzvodjaca", unosi.get(position).getZanr());
                myIntent.putExtra("biografijaIzvodjaca", unosi.get(position).getBiografija());
                myIntent.putExtra("stranicaIzvodjaca", unosi.get(position).getWebStranica());
                myIntent.putExtra("top5Izvodjaca", unosi.get(position).getTopLista());
                MainActivity.this.startActivity(myIntent);
            }
        });
        }

}
