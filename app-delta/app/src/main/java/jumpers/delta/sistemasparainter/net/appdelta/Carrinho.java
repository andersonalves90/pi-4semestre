package jumpers.delta.sistemasparainter.net.appdelta;


import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import java.math.BigDecimal;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import jumpers.delta.sistemasparainter.net.appdelta.entities.CarrinhoSingleton;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Produto;
import jumpers.delta.sistemasparainter.net.appdelta.entities.*;

public class Carrinho extends android.support.v4.app.Fragment{
    private ViewGroup mensagens;
    private Button continuar;
    private Button finalizar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carrinho_fragment,
                container, false);

        mensagens = (ViewGroup) view.findViewById(R.id.container);
        continuar = (Button) view.findViewById(R.id.carContCompra);
        finalizar = (Button) view.findViewById(R.id.carPagamento);

        finalizar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PagamentoActivity.class);
                startActivity(intent);
            }
        });

        continuar.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }

        });


        for (Produto produto: CarrinhoSingleton.getInstance().getProdutosNoCarrinho()) {
            addItem(produto.getNomeProduto(), produto.getPrecProduto(), DetalheActivity.getQuant(), inflater);
        }


        return view;

    }

    private void addItem (String textoDoTitulo, BigDecimal valor, Integer quanti, LayoutInflater layoutInflater){
        CardView cardView = (CardView) layoutInflater.from(getContext()).inflate(R.layout.carrinho, mensagens, false);

        TextView titulo = (TextView) cardView.findViewById(R.id.tituloProdutoCar);
        TextView preco =  (TextView) cardView.findViewById(R.id.precoProdutoCar);
        TextView quant = (TextView) cardView.findViewById(R.id.quantProdutoCar);

        titulo.setText(textoDoTitulo);
        preco.setText((CharSequence) valor);
        quant.setText(quanti);

        mensagens.addView(cardView);

    }
}
