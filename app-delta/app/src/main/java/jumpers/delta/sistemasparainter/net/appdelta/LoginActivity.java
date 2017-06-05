package jumpers.delta.sistemasparainter.net.appdelta;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private TextView logLogin;
    private EditText logEmail = null;
    private EditText logSenha = null;
    private Button logEntra;
    private Button imCadastro;
    private CheckBox imaChek;
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logLogin = (TextView) findViewById(R.id.logLogin);
        logEmail = (EditText) findViewById(R.id.logEmail);
        logSenha = (EditText) findViewById(R.id.logSenha);
        logEntra = (Button) findViewById(R.id.logEntrar);
        imaChek = (CheckBox) findViewById(R.id.imaChek);
        imCadastro = (Button) findViewById(R.id.imCadastro);

        /**
        prefs = getSharedPreferences("logado", MODE_PRIVATE);
        String configuracao = prefs.getString("logado","true");

        if(configuracao.equals(true)){
            System.out.println(configuracao);
        }
         **/

        imCadastro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
                startActivity(intent);
            }
        }
        );

        logEntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = logEmail.getText().toString();
                String senha = logSenha.getText().toString();


                if (email.equals("")) {
                    logEmail.setError("campo obrigatório");
                    return;
                }
                if (senha.equals("")) {
                    logSenha.setError("campo obrigatório");
                    return;
                }

                NetworkCall myCall = new NetworkCall();

                myCall.execute ("http://deltaws.azurewebsites.net/g2/rest/cliente/" + email + "/" + senha );

                dialog = ProgressDialog.show(LoginActivity.this,"","Logando...", false,true);
                dialog.setIcon(R.drawable.ic_launcher);
                dialog.setCancelable(false);

            }
        });
    }

    public class NetworkCall extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(params[0]).openConnection();

                InputStream in = urlConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

                StringBuilder resultado = new StringBuilder();
                String linha = bufferedReader.readLine();
                while (linha != null) {
                    resultado.append(linha);
                    linha = bufferedReader.readLine();
                }

                String respostaCompleta = resultado.toString();

                return respostaCompleta;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                if (result.equals("true")) {

                    /**
                    if (imaChek.isChecked()) {

                        prefs = getSharedPreferences("login",
                                MODE_PRIVATE);

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("logado", "true");
                        editor.apply();
                    }
                     **/

                    Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                    startActivity(intent);

                } else {
                    AlertDialog.Builder builder = new
                            AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Você não está cadastrado!");
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
                    startActivity(intent);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
