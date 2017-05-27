package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class PagamentoActivity extends AppCompatActivity {
    private TextView pagPagamento;
    private RadioButton pagPaypal;
    private RadioButton pagCartão;
    private RadioButton pagPagseguro;
    private RadioButton pagBoleto;
    private Button pagFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        pagPagamento=(TextView) findViewById(R.id.pagPagamento);
        pagPaypal=(RadioButton) findViewById(R.id.pagPaypal);
        pagCartão=(RadioButton) findViewById(R.id.pagCartão);
        pagPagseguro=(RadioButton) findViewById(R.id.pagPagseguro);
        pagBoleto=(RadioButton) findViewById(R.id.pagBoleto);
        pagFinalizar=(Button) findViewById(R.id.pagFinalizar);
    }
}
