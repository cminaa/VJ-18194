package ba.unsa.etf.rma.VJ_18194;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MuzicarAdapter {
    private Activity activity;
    private ArrayList<Muzicar> data=null;
    private static LayoutInflater inflater=null;
    public Resources res;

    public MuzicarAdapter(Activity a, ArrayList d,Resources resLocal) {
        activity = a;
        data=d;
        res = resLocal;
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{

        public TextView ime;
        public TextView zanr;
        public ImageView image;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            vi = inflater.inflate(R.layout.element_liste, null);


            holder = new ViewHolder();
            holder.ime = (TextView) vi.findViewById(R.id.ime);
            holder.zanr=(TextView)vi.findViewById(R.id.zanr);
            holder.image=(ImageView)vi.findViewById(R.id.ikona);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.ime.setText(" ");

        }
        else
        {
            Muzicar tempValues=null;
            tempValues = ( Muzicar ) data.get( position );


            holder.ime.setText( tempValues.getImeIPrezime() );
            holder.zanr.setText( tempValues.getZanr() );
            holder.image.setImageResource(
                    res.getIdentifier(
                            "com.androidexample.customlistview:drawable/"+tempValues.getIkona()
                            ,null,null));


        }
        return vi;
    }
/*
    @Override
    public void onClick(View v) {
        Log.v("MuzicarAdapter", " ");
    }

    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

       @Override
        public void onClick(View arg0) {


            CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;


            sct.onItemClick(mPosition);
        }*/
}

