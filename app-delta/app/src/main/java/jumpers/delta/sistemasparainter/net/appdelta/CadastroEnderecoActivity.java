package jumpers.delta.sistemasparainter.net.appdelta;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jumpers.delta.sistemasparainter.net.appdelta.entities.Endereco;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Mask;

public class CadastroEnderecoActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private EditText editTextTipoEndereco;
    private EditText editTextCEP;
    private EditText editTextLogradouro;
    private EditText editTextNumero;
    private EditText editTextComplemento;
    private EditText editTextCidade;
    private EditText editTextUf;
    private Button cedBtnCadastrar;
    private JSONObject jsonEnderecoCliente = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

        editTextTipoEndereco = (EditText) findViewById(R.id.editTextTipoEndereco);
        editTextCEP = (EditText) findViewById(R.id.editTextCEP);
        editTextCEP.addTextChangedListener(Mask.insert("######-###", editTextCEP));
        editTextLogradouro = (EditText) findViewById(R.id.editTextLogradouro);
        editTextNumero = (EditText) findViewById(R.id.editTextNumero);
        editTextComplemento = (EditText) findViewById(R.id.editTextComplemento);
        editTextCidade = (EditText) findViewById(R.id.editTextCidade);
        editTextUf = (EditText) findViewById(R.id.editTextUf);
        editTextUf.addTextChangedListener(Mask.insert("##", editTextUf));


        cedBtnCadastrar = (Button) findViewById(R.id.cedBtnCadastrar);

        cedBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipoEndereco = editTextTipoEndereco.getText().toString();
                String cep = editTextCEP.getText().toString();
                String logradouro = editTextLogradouro.getText().toString();
                String numero = editTextNumero.getText().toString();
                String complemento = editTextComplemento.getText().toString();
                String cidade = editTextCidade.getText().toString();
                String uf = editTextUf.getText().toString();

                Endereco endereco = new Endereco();

                endereco.setIdCliente(1);

                if (tipoEndereco.equals("")) {
                    editTextTipoEndereco.setError("Campo obrigatório");
                    return;
                } else {
                    endereco.setNomeEndereco(tipoEndereco);
                }

                if (cep.equals("")) {
                    editTextCEP.setError("Campo obrigatório");
                    return;
                } else {
                    String cepCustom = cep.replaceAll("[^0-9]+", "");
                    endereco.setCEPEndereco(cepCustom);
                }

                if (logradouro.equals("")) {
                    editTextLogradouro.setError("Campo obrigatório");
                    return;
                } else {
                    endereco.setLogradouroEndereco(logradouro);
                }

                if (numero.equals("")) {
                    editTextNumero.setError("Campo obrigatório");
                    return;
                } else {
                    endereco.setNumeroEndereco(numero);
                }


                endereco.setComplementoEndereco(complemento);

                if (cidade.equals("")) {
                    editTextCidade.setError("Campo obrigatório");
                    return;
                } else {
                    endereco.setCidadeEndereco(cidade);
                }

                if (uf.equals("")) {
                    editTextUf.setError("Campo obrigatório");
                    return;
                } else {
                    endereco.setUFEndereco(uf);
                }

                jsonEnderecoCliente = new JSONObject();

                try {
                    jsonEnderecoCliente.put("idCliente",endereco.getIdCliente());
                    jsonEnderecoCliente.put("nomeEndereco",endereco.getNomeEndereco());
                    jsonEnderecoCliente.put("logradouroEndereco",endereco.getLogradouroEndereco());
                    jsonEnderecoCliente.put("numeroEndereco",endereco.getNumeroEndereco());
                    jsonEnderecoCliente.put("cepEndereco",endereco.getCEPEndereco());
                    jsonEnderecoCliente.put("complementoEndereco",endereco.getComplementoEndereco());
                    jsonEnderecoCliente.put("cidadeEndereco",endereco.getCidadeEndereco());
                    jsonEnderecoCliente.put("paisEndereco",endereco.getPaisEndereco());
                    jsonEnderecoCliente.put("ufEndereco",endereco.getUFEndereco());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                NetworkCall myCall = new NetworkCall();
                myCall.execute((String) null);

                dialog = ProgressDialog.show(CadastroEnderecoActivity.this,"","Cadastrando!!", false, true);
                dialog.setIcon(R.drawable.ic_launcher);
                dialog.setCancelable(false);

                System.out.print(jsonEnderecoCliente);
            }
        });
    }

    public class NetworkCall extends AsyncTask<String, Void, String> {

        private int resultCode = 0;

        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL("http://192.168.0.5:8080/WSECommerce/rest/endereco");

                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());

                out.write(jsonEnderecoCliente.toString());

                out.close();

                resultCode = con.getResponseCode();
                System.out.println(con.getResponseCode());
                InputStream in = con.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

                StringBuilder resultado = new StringBuilder();
                String linha = bufferedReader.readLine();

                while (linha != null) {
                    resultado.append(linha);
                    linha = bufferedReader.readLine();
                }

                String respostaCompleta = resultado.toString();

                return respostaCompleta;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            String respostaSnack = null;

            try {

                dialog.dismiss();

                if (resultCode == 200){
                    respostaSnack = "Endereço Cadastrado com sucesso!";

                }else if(resultCode == 500){
                    respostaSnack = "Erro ao cadastrar endereço. Tente novamente";
                }

                Snackbar snackbar = Snackbar
                        .make(cedBtnCadastrar, respostaSnack, Snackbar.LENGTH_LONG);
                snackbar.show();

                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            Thread.sleep(3000);


                            Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(i);
                            dialog.dismiss();
                            finish();
                        }
                        catch (InterruptedException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }).start();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
