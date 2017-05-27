package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroEnderecoActivity extends AppCompatActivity {
    private EditText cedCep;
    private TextView cedCadastro;
    private EditText cedLogradouro;
    private EditText cedEstado;
    private EditText cedNumero;
    private EditText cedBairro;
    private EditText cedComplemento;
    private EditText cedCidade;
    private EditText cedUf;
    private Button cedBtnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);
        cedCep = (EditText) findViewById(R.id.cedCep);
        cedCadastro = (TextView) findViewById(R.id.cedCadastro);
        cedLogradouro = (EditText) findViewById(R.id.cedLogradouro);
        cedEstado = (EditText) findViewById(R.id.cedEstado);
        cedNumero = (EditText) findViewById(R.id.cedNumero);
        cedBairro = (EditText) findViewById(R.id.cedBairro);
        cedComplemento = (EditText) findViewById(R.id.cedComplemento);
        cedCidade = (EditText) findViewById(R.id.cedCidade);
        cedUf = (EditText) findViewById(R.id.cedUf);
        cedBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cep = cedCep.getText().toString();
                String lougradouro = cedLogradouro.getText().toString();
                String numero = cedNumero.getText().toString();
                String complemento = cedComplemento.getText().toString();
                String bairro = cedBairro.getText().toString();
                String cidade= cedCidade.getText().toString();
                String estado = cedEstado.getText().toString();
                String uf = cedUf.getText().toString();

            }
        });
    }
}
