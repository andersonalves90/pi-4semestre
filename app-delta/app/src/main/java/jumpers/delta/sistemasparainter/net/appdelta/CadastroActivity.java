package jumpers.delta.sistemasparainter.net.appdelta;

import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {
    private TextView cadCadastro;
    private EditText cadNome;
    private EditText cadCpf;
    private EditText cadEmail;
    private EditText cadSenha;
    private Button  cadBtnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cadCadastro=(TextView) findViewById(R.id.cadCadastro);
        cadNome=(EditText) findViewById(R.id.cadNome);
        cadCpf=(EditText) findViewById(R.id.cadCpf);
        cadEmail=(EditText) findViewById(R.id.cadEmail);
        cadSenha=(EditText) findViewById(R.id.cadSenha);
        cadCadastro=(Button) findViewById(R.id.cadBtnCadastrar);
        cadBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = cadNome.getText().toString();
                String cppf = cadCpf.getText().toString();
                String email = cadEmail.getText().toString();
                String senha = cadSenha.getText().toString();

                if(cadNome.equals("")){
                    cadNome.setError("campo obrigatório");
                    return;
                }
                if(cadCpf.equals("")){
                    cadCpf.setError("campo obrigatório");
                    return;
                }
                if(cadEmail.equals("")){
                    cadEmail.setError("campo obrigatório");
                    return;
                }
                if(cadSenha.equals("")){
                    cadSenha.setError("campo obrigatório");
                    return;
                }
                if((!cadNome.equals(null) && !cadCpf.equals(null)&& !cadEmail.equals(null) && !cadSenha.equals(null))){




                }
            }
        });

    }
}
