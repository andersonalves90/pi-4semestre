package jumpers.delta.sistemasparainter.net.appdelta;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

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
                //Intent intent = new Intent(LoginActivity.this,ProdutoActivity.class);
                //startActivity(intent);

                String email = logEmail.getText().toString();
                String senha = logSenha.getText().toString();

                if (logEmail.equals("")) {
                    logEmail.setError("campo obrigatório");
                    return;
                }
                if (logSenha.equals("")) {
                    logSenha.setError("campo obrigatório");
                    return;
                }
                if ((!logEmail.equals(null)) && (!logSenha.equals(null))) {

                    NetworkCall myCall = new NetworkCall();
                    myCall.execute("http://viacep.com.br/ws/" + cep + "/json/");

                  myCall.execute ("http://deltaws.azurewebsites.net/g2/rest/cliente/" + email + "/" + senha );
                }

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
                if(result.equals(true)){
                    Intent intent = new Intent(LoginActivity.this,ProdutoActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Snackbar.make(v, msgStatus, Snackbar.LENGTH_SHORT).setAction("Ação", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setCancelable(false);
                            builder.setTitle("Ação da Snackbar");
                            builder.setMessage("Usuário ou senha incorretos");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                            // Create the AlertDialog object and return it
                            builder.create().show();
                        }
                    }).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
