package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CarrinhoActivity extends AppCompatActivity {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);
        carCarrinho= (TextView) findViewById(R.id.carCarrinho);
        carImagemP=(ImageView)findViewById(R.id.carImagemP);
        carImagemPT=(ImageView)findViewById(R.id.carImagemPT);
        carProdutoP= (TextView) findViewById(R.id.carProdutoP);
        carPrecoP= (TextView) findViewById(R.id.carPrecoP);
        carProdutoPT= (TextView) findViewById(R.id.carProdutoPT);
        carPrecoPT= (TextView) findViewById(R.id.carPrecoPT);
        carRecebePrecoP=(EditText) findViewById(R.id.carRecebePrecoP);
        carRecebePrecoPT=(EditText) findViewById(R.id.carRecebePrecoPT);
        carTotal= (TextView) findViewById(R.id.carTotal);
        carPrecoTotal= (TextView) findViewById(R.id.carPrecoTotal);
        carContCompra=(Button) findViewById(R.id.carContCompra);
        carPagamento=(Button) findViewById(R.id.carPagamento);
    }
}
