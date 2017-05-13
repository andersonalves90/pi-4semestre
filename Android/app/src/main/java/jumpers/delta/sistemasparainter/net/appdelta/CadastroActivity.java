package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    private EditText CadNome;
    private EditText CadCPF;
    private EditText CadEmail;
    private EditText CadSenha;
    private EditText CadCelular;
    private EditText CadTelResidencial;
    private EditText CadTelComercial;
    private Button CadButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        CadNome = (EditText) findViewById(R.id.CadNome);
        CadCPF = (EditText) findViewById(R.id.CadCPF);
        CadEmail = (EditText) findViewById(R.id.CadEmail);
        CadSenha = (EditText) findViewById(R.id.CadSenha);
        CadCelular = (EditText) findViewById(R.id.CadCelular);
        CadTelResidencial = (EditText) findViewById(R.id.CadTelRes);
        CadTelComercial = (EditText) findViewById(R.id.CadTelCom);
        CadButton = (Button) findViewById(R.id.CadButton);




    }
}
