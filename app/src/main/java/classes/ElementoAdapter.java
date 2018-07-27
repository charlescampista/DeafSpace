package classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.charlescampista.deafspace.R;

import java.util.ArrayList;

public class ElementoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Elemento> lista;

    public ElementoAdapter(Context context, ArrayList<Elemento> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Elemento elemento = lista.get(position);
        View layout;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.adapter_elemento, null);
        }
        else{
            layout = convertView;
        }

        ImageView ivElementoImagem = (ImageView) layout.findViewById(R.id.ivElementoImagem);
        ivElementoImagem.setImageResource(elemento.getImagem());

        return layout;
    }

}
