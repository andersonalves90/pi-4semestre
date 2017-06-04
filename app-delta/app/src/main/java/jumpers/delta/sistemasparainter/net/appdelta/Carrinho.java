package jumpers.delta.sistemasparainter.net.appdelta;

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

        /**
        for (Produto produto: SingletonCarrinho.getInstace().getCar()) {
            addItem(produto.getNome(), produto.getNome(), produto.getNome(), inflater);
        }
         **/

        return view;

    }

    private void addItem (String textoDoTitulo, String valor, String quantidade, LayoutInflater layoutInflater){
        CardView cardView = (CardView) layoutInflater.from(getContext()).inflate(R.layout.carrinho, mensagens, false);

        TextView titulo = (TextView) cardView.findViewById(R.id.tituloProdutoCar);
        TextView preco = (TextView) cardView.findViewById(R.id.preçoProdutoCar);
        TextView quant = (TextView) cardView.findViewById(R.id.quantProdutoCar);

        titulo.setText(textoDoTitulo);
        preco.setText(valor);
        quant.setText(quantidade);

        mensagens.addView(cardView);

    }
}
