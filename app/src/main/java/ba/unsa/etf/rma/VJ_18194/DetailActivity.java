package ba.unsa.etf.rma.VJ_18194;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView ime = (TextView)findViewById(R.id.ime);
        ime.setText(getIntent().getStringExtra("imeIzvodjaca"));
        TextView zanr = (TextView)findViewById(R.id.zanr);
        ime.setText(getIntent().getStringExtra("zanrIzvodjaca"));
        TextView web = (TextView)findViewById(R.id.web);
        ime.setText(getIntent().getStringExtra("webIzvodjaca"));
        TextView bio = (TextView)findViewById(R.id.biografija);
        ime.setText(getIntent().getStringExtra("biografijaIzvodjaca"));
        TextView topLista = (TextView)findViewById(R.id.ime);
        ime.setText(getIntent().getStringExtra("top5Izvodjaca"));
    }


}
