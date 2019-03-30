package ba.unsa.etf.rma.VJ_18194;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button dugme;
    EditText tekst;
    ArrayList<Muzicar> unosi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dugme = (Button) findViewById(R.id.button);
        final ListView lista = (ListView) findViewById(R.id.listView);
        tekst = (EditText) findViewById(R.id.editText);
        unosi = new ArrayList<Muzicar>();
        ArrayList<String> listaPjesama=new ArrayList<>();
        ArrayList<String> listaPjesama2=new ArrayList<>();
        ArrayList<String> listaPjesama3=new ArrayList<>();

        Muzicar marija= new Muzicar("Marija Šerifović", "Pop", "https://en.wiki" +
                "pedia.org/wiki/Marija_%C5%A0erifovi%C4%87", "Serbian singer. Initially rose" +
                " to prominence as the talented daughter of Serbian folk singer Verica Šerifović, " +
                "Marija is now recognised as one of the best vocalists in Serbia. She is best known " +
                "for winning the Eurovision Song Contest 2007 with the ballad 'Molitva', making her" +
                " Serbia's only Eurovision winner to date.", "pop");
        Muzicar marcelo= new Muzicar("Marko Šelić", "Rap", "https://en.wikipedia." +
                "org/wiki/Mar%C4%8Delo", "Serbian recording artist and writer, known for his" +
                " socially conscious lyrics and eclectic approach to musical arrangements through " +
                "hip-hop music. A Paraćin native, he moved to Belgrade, where he has had great success" +
                " over the years, and became one of the most prominent Serbian hip hop artists." +
                " He graduated Serbian language and literature at the University of Belgrade" +
                " Faculty of Philology.", "rap");
        Muzicar dugme = new Muzicar("Bijelo dugme", "Rock", "https://en.wikipedia" +
                ".org/wiki/Bijelo_Dugme", "Bijelo Dugme is widely considered to have been the " +
                "most popular band ever to exist in the former Socialist Federal Republic of Yugoslavia" +
                " and one of the most important acts of the Yugoslav rock scene. Bijelo Dugme was officially " +
                "formed in 1974, although the members of the default lineup, guitarist Goran Bregović, " +
                "vocalist Željko Bebek, drummer Ipe Ivandić, keyboardist Vlado Pravdić and bass guitarist" +
                " Zoran Redžić, were previously active under the name Jutro. The band's debut album " +
                "Kad bi bio bijelo dugme, released in 1974, brought them nationwide popularity with its" +
                " Balkan folk-influenced hard rock sound.", "rock");
        listaPjesama.add("Molitva");listaPjesama.add("11");listaPjesama.add("Pametna i luda");
        listaPjesama.add("U nedelju");listaPjesama.add("Ne volis je znam");
        marija.setTopLista(listaPjesama);
        listaPjesama2.add("Sveti bes");         listaPjesama2.add("Jedan");
        listaPjesama2.add("De Facto");
        listaPjesama2.add("Komplikovani");
        listaPjesama2.add("Tunel");
        marcelo.setTopLista(listaPjesama2);
        listaPjesama3.add("Ako mozes zaboravi");         listaPjesama3.add("Djurdjevdan");
        listaPjesama3.add("Kad bih bio bijelo dugme");
        listaPjesama3.add("Ne spavaj mala moja");
        listaPjesama3.add("A i ti me iznevjeri");
        dugme.setTopLista(listaPjesama3);
unosi.add(marija); unosi.add(marcelo); unosi.add(dugme);
        final MuzicarAdapter adapter;
        Resources res = getResources();
        adapter = new MuzicarAdapter(this, unosi, res);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
                myIntent.putExtra("ime", unosi.get(position).getImeIPrezime());
                myIntent.putExtra("zanr", unosi.get(position).getZanr());
                myIntent.putExtra("biografija", unosi.get(position).getBiografija());
                myIntent.putExtra("stranica", unosi.get(position).getWebStranica());
                myIntent.putExtra("top5", unosi.get(position).getTopLista());
                MainActivity.this.startActivity(myIntent);
            }
        });
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            }
        }

    }
    MyBroadcastReceiver risiver=new MyBroadcastReceiver();
    private IntentFilter filter= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(risiver, filter);
    }

    @Override
    protected void  onPause(){
        super.onPause();
        unregisterReceiver(risiver);
    }

    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            tekst.setText(sharedText);
        }
    }
}
