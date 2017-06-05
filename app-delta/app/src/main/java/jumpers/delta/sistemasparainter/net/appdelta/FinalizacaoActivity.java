package jumpers.delta.sistemasparainter.net.appdelta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinalizacaoActivity extends AppCompatActivity {
    private Button finVoltarLoja;
    private ImageView finImageP;
    private ImageView finImagePt;
    private TextView finProdutoP;
    private TextView finProdutoPt;
    private TextView finPrecoP;
    private TextView finPrecoPt;
    private TextView finTotal;
    private TextView finPagamento;
    private TextView finXx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizacao);
        // fazer um array para lista os produtos
        //aprender proxima aula
        finImageP = (ImageView) findViewById(R.id.finImageP);
        finImagePt = (ImageView) findViewById(R.id.finImagePT);
        finProdutoP =(TextView) findViewById(R.id.finProdutoP);
        finProdutoPt =(TextView) findViewById(R.id.finProdutoPt);
        finPrecoP =(TextView) findViewById(R.id.finPrecoP);
        finPrecoPt =(TextView) findViewById(R.id.finPrecoPt);
        finTotal =(TextView) findViewById(R.id.finTotal);
        finPagamento =(TextView) findViewById(R.id.finPagamento);
        finXx =(TextView) findViewById(R.id.finXx);
        finVoltarLoja =(Button) findViewById(R.id.finVoltarLoja);


        finVoltarLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalizacaoActivity.this,DetalheActivity.class);
                startActivity(intent);
            }
        });
    }
}
