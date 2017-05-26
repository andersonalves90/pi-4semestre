package jumpers.delta.sistemasparainter.net.appdelta;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "Preferences";
    private ProgressDialog dialog;
    TextView logLogin;
    EditText logEmail = null;
    EditText logSenha = null;
    Button logEntra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logLogin = (TextView) findViewById(R.id.logLogin);
            logEmail = (EditText) findViewById(R.id.logEmail);
            logSenha = (EditText) findViewById(R.id.logSenha);
            logEntra = (Button) findViewById(R.id.logEntrar);




        logEntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = logEmail.getText().toString();
                String senha = logSenha.getText().toString();

                //Restaura as preferencias gravadas
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                logEmail.setText(settings.getString("LogEmail", "email"));

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

        // Esse é o método que executa a tarefa em segundo plano
        @Override
        protected String doInBackground(String... params) {
            try {
                // Cria o objeto de conexão
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(params[0]).openConnection();

                // Executa a requisição pegando os dados
                InputStream in = urlConnection.getInputStream();

                // Cria um leitor para ler a resposta
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

                StringBuilder resultado = new StringBuilder();
                String linha = bufferedReader.readLine();

                // Lê linha a linha a resposta e armazena no StringBuilder
                while (linha != null) {
                    resultado.append(linha);
                    linha = bufferedReader.readLine();
                }

                // Transforma o StringBuilder em String, que contém a resposta final
                String respostaCompleta = resultado.toString();

                // Retorna a string final contendo a resposta retornada
                return respostaCompleta;

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Caso tenha dado algum erro, retorna null
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);


            try {
                if (result.equals("true")) {

                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("email", logEmail.getText().toString());
                    //Confirma a gravação dos dados
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, ProdutoActivity.class);
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

