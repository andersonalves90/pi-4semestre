package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CadastroEnderecoActivity extends AppCompatActivity {
    private EditText CadEndLogradouro;
    private EditText CadEndNum;
    private EditText CadEndCompl;
    private EditText CadEndBairro;
    private EditText CadEndCidade;
    private EditText CadEndUf;
    private EditText CadEndCEP;
    private Button CadEndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

        CadEndLogradouro = (EditText) findViewById(R.id.CadEndLogradouro);
        CadEndNum = (EditText) findViewById(R.id.CadEndNum);
        CadEndCompl = (EditText) findViewById(R.id.CadEndCompl);
        CadEndBairro = (EditText) findViewById(R.id.CadEndBairro);
        CadEndCidade = (EditText) findViewById(R.id.CadEndCidade);
        CadEndUf = (EditText) findViewById(R.id.CadEndUf);
        CadEndCEP = (EditText) findViewById(R.id.CadEndCEP);
        CadEndButton = (Button) findViewById(R.id.CadEndButton);
    }
}
