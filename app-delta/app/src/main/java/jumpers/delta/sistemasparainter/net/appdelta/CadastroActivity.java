package jumpers.delta.sistemasparainter.net.appdelta;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CadastroActivity extends AppCompatActivity {

    TextView cadCadastro;
    EditText cadNome = null;
    EditText cadCpf = null;
    EditText cadEmail = null;
    EditText cadSenha = null;
    EditText cadCelular = null;
    EditText cadComercial = null;
    EditText cadResidencial = null;
    EditText cadDatNasc = null;
    Button cadBtnCadastrar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cadCadastro = (TextView) findViewById(R.id.cadCadastro);
        cadNome = (EditText) findViewById(R.id.cadNome);
        cadCpf = (EditText) findViewById(R.id.cadCpf);
        cadEmail = (EditText) findViewById(R.id.cadEmail);
        cadSenha = (EditText) findViewById(R.id.cadSenha);
        cadCelular = (EditText) findViewById(R.id.cadCelular);
        cadComercial = (EditText) findViewById(R.id.cadComercial);
        cadResidencial = (EditText) findViewById(R.id.cadResidencial);
        cadDatNasc = (EditText) findViewById(R.id.cadDatNasc);
        cadBtnCadastrar = (Button) findViewById(R.id.cadBtnCadastrar);


        cadBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = cadNome.getText().toString();
                String cpf = cadCpf.getText().toString();
                String email = cadEmail.getText().toString();
                String senha = cadSenha.getText().toString();
                String celular = cadCelular.getText().toString();
                String telComercial = cadResidencial.getText().toString();
                String telResidencial = cadComercial.getText().toString();
                String dataNac = cadDatNasc.getText().toString();

                if (cadNome.equals("")) {
                    cadNome.setError("campo obrigatório");
                    return;
                }
                if (cadCpf.equals("")) {
                    cadCpf.setError("campo obrigatório");
                    return;
                }
                if (cadEmail.equals("")) {
                    cadEmail.setError("campo obrigatório");
                    return;
                }
                if (cadSenha.equals("")) {
                    cadSenha.setError("campo obrigatório");
                    return;
                }
                if (cadCelular.equals("")) {
                    cadCelular.setError("campo obrigatório");
                    return;
                }
                if (cadComercial.equals("")) {
                    cadComercial.setError("campo obrigatório");
                    return;
                }
                if (cadResidencial.equals("")) {
                    cadResidencial.setError("campo obrigatório");
                    return;
                }
                if (cadDatNasc.equals("")) {
                    cadDatNasc.setError("campo obrigatório");
                    return;
                }

                if (!cadNome.equals(null) && (!cadCpf.equals(null) && (!cadEmail.equals(null) && (!cadSenha.equals(null) && (!cadCelular.equals(null) && (!cadComercial.equals(null) && (!cadResidencial.equals(null) && (!cadDatNasc.equals(null))))))))) {
/*
                  CadastroActivity.NetworkCall myCall = new NetworkCall();

                  myCall.execute("http://deltaws.azurewebsites.net/g2/rest/cliente/" + nome + "/" + cpf + "/" + email + "/" + senha + "/" + celular + "/" + telComercial + "/" + telResidencial + "/" + dataNac);
*/
                }

            }
        });
    }
}


