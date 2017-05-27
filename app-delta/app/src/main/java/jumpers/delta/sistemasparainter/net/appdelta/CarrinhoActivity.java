package jumpers.delta.sistemasparainter.net.appdelta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CarrinhoActivity extends android.support.v4.app.Fragment {
    private TextView carCarrinho;
    private ImageView carImagemP;
    private ImageView carImagemPT;
    private TextView carProdutoP;
    private TextView carPrecoP;
    private TextView carProdutoPT;
    private TextView carPrecoPT;
    private EditText carRecebePrecoP;
    private EditText carRecebePrecoPT;
    private TextView carTotal;
    private TextView carPrecoTotal;
    private Button carContCompra;
    private Button carPagamento;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_carrinho, container, false);
        carCarrinho= (TextView) view.findViewById(R.id.carCarrinho);
        carImagemP=(ImageView) view.findViewById(R.id.carImagemP);
        carImagemPT=(ImageView) view.findViewById(R.id.carImagemPT);
        carProdutoP= (TextView) view.findViewById(R.id.carProdutoP);
        carPrecoP= (TextView) view.findViewById(R.id.carPrecoP);
        carProdutoPT= (TextView) view.findViewById(R.id.carProdutoPT);
        carPrecoPT= (TextView) view.findViewById(R.id.carPrecoPT);
        carRecebePrecoP=(EditText) view.findViewById(R.id.carRecebePrecoP);
        carRecebePrecoPT=(EditText) view.findViewById(R.id.carRecebePrecoPT);
        carTotal= (TextView) view.findViewById(R.id.carTotal);
        carPrecoTotal= (TextView) view.findViewById(R.id.carPrecoTotal);
        carContCompra=(Button) view.findViewById(R.id.carContCompra);
        carPagamento=(Button) view.findViewById(R.id.carPagamento);

        return view;
    }
}
