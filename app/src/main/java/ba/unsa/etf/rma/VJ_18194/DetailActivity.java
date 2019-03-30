package ba.unsa.etf.rma.VJ_18194;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalji_muzicar);
        final TextView ime = (TextView)findViewById(R.id.ime);
        ime.setText(getIntent().getStringExtra("ime"));
        TextView zanr = (TextView)findViewById(R.id.zanr);
        zanr.setText(getIntent().getStringExtra("zanr"));
        TextView web = (TextView)findViewById(R.id.web);
        web.setText(getIntent().getStringExtra("stranica"));
        final TextView bio = (TextView)findViewById(R.id.bio);
        bio.setText(getIntent().getStringExtra("biografija"));
        final ListView topLista = (ListView)findViewById(R.id.top5);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getIntent().getStringArrayListExtra("top5"));
        topLista.setAdapter(ad);

        //odgovor na klik na stranicu, preusmjeravanje
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                String url = getIntent().getStringExtra("stranica");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        //slanje kliknute pjesme na pretragu na yt
        topLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.google.android.youtube");
                intent.putExtra("query", ime.getText()+" "+topLista.getItemAtPosition(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        // klikom na dugme nudi se sharovanje teksta
        final Button dugmeZaSlanje = (Button) findViewById(R.id.slanje);
        dugmeZaSlanje.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String textMessage=ime.getText()+"\n" + bio.getText();
                sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
                sendIntent.setType("text/plain");
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });

    }
}
