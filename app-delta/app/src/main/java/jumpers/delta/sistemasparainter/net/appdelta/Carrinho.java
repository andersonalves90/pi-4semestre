package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Carrinho extends android.support.v4.app.Fragment{
    private ViewGroup mensagens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carrinho_fragment,
                container, false);

        mensagens = (ViewGroup) view.findViewById(R.id.container);
        addItem("teste 1", inflater);
        addItem("teste 2", inflater);
        return view;

    }

    private void addItem (String textoDoTitulo, LayoutInflater layoutInflater){
        CardView cardView = (CardView) layoutInflater.from(getContext()).inflate(R.layout.carrinho, mensagens, false);

        TextView titulo = (TextView) cardView.findViewById(R.id.tituloProdutoCar);

        titulo.setText(textoDoTitulo);

        mensagens.addView(cardView);

    }
}
