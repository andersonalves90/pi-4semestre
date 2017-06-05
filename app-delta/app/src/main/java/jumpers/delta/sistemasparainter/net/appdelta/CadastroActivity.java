package jumpers.delta.sistemasparainter.net.appdelta;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;

import jumpers.delta.sistemasparainter.net.appdelta.entities.Cliente;
import jumpers.delta.sistemasparainter.net.appdelta.entities.ClienteSingleton;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Mask;
import jumpers.delta.sistemasparainter.net.appdelta.material.DateDialog;

public class CadastroActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private JSONObject jsonCliente = new JSONObject();
    private TextView cadCadastro;
    private EditText cadNome = null;
    private EditText cadEmail = null;
    private EditText cadSenha = null;
    private EditText cadCpf = null;
    private EditText cadCelular;
    private EditText cadComercial;
    private EditText cadResidencial;
    private EditText cadDatNasc;
    private CheckBox cadOpcao;
    private Button cadBtnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cadCadastro = (TextView) findViewById(R.id.cadCadastro);
        cadNome = (EditText) findViewById(R.id.cadNome);
        cadEmail = (EditText) findViewById(R.id.cadEmail);
        cadSenha = (EditText) findViewById(R.id.cadSenha);
        cadCpf = (EditText) findViewById(R.id.cadCpf);
        cadCpf.addTextChangedListener(Mask.insert("###.###.###-##", cadCpf));

        cadCelular = (EditText) findViewById(R.id.cadCelular);
        cadCelular.addTextChangedListener(Mask.insert("(##)####-#####", cadCelular));
        //até 20caracteres
        cadComercial = (EditText) findViewById(R.id.cadComercial);
        cadComercial.addTextChangedListener(Mask.insert("(##)####-#####", cadComercial));
        //até 20caracteres
        cadResidencial = (EditText) findViewById(R.id.cadResidencial);
        cadResidencial.addTextChangedListener(Mask.insert("(##)####-#####", cadResidencial));
        //até 20caracteres
        cadDatNasc = (EditText) findViewById(R.id.cadDatNasc);
        //cadDatNasc.addTextChangedListener(Mask.insert("##/##/####", cadDatNasc));
        //até 3 caracteres
        cadOpcao = (CheckBox) findViewById(R.id.cadOpcao);
        cadBtnCadastrar = (Button) findViewById(R.id.cadBtnCadastrar);

        cadBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = cadNome.getText().toString();
                String email = cadEmail.getText().toString();
                String senha = cadSenha.getText().toString();
                String cpf = cadCpf.getText().toString();
                String celular = cadCelular.getText().toString();
                String telComercial = cadResidencial.getText().toString();
                String telResidencial = cadComercial.getText().toString();
                String dataNac = cadDatNasc.getText().toString();
                String dataFormatada = "";
                String newLesttter = cadOpcao.getText().toString();
                Cliente cliente = new Cliente();

                if (nome.equals("")) {
                    cadNome.setError("campo obrigatório");
                    return;
                } else {
                    cliente.setNomeCompletoCliente(nome);
                }

                if (email.equals("")) {
                    cadEmail.setError("campo obrigatório");
                    return;
                } else {
                    cliente.setEmailCliente(email);
                }
                if (senha.equals("")) {
                    cadSenha.setError("campo obrigatório");
                    return;
                } else {
                    cliente.setSenhaCliente(senha);
                }
                if (cpf.equals("") && (cpf.length() > 14)) {
                    cadCpf.setError("campo obrigatório");
                    return;
                } else {
                    String cpfCusto = cpf.replaceAll("[^0-9]+", "");
                    cliente.setCPFCliente(cpfCusto);
                }
                if (cadOpcao.isChecked()) {
                    cliente.setRecebeNewsLetter("1");
                } else {
                    cliente.setRecebeNewsLetter("0");
                }
                String celularCusto = celular.replaceAll("[^0-9]+", "");
                cliente.setCelularCliente(celularCusto);

                String telComercialCusto = telComercial.replaceAll("[^0-9]+", "");
                cliente.setTelComercialCliente(telComercialCusto);

                String telResidencialCusto = telResidencial.replaceAll("[^0-9]+", "");
                cliente.setTelResidencialCliente(telResidencialCusto);


                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date data = formato.parse(dataNac);
                    formato.applyPattern("yyyy/MM/dd");
                    dataFormatada = formato.format(data);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String dataNacCusto = dataFormatada.replaceAll("[^0-9]+", "");
                cliente.setDtNascCliente(dataNacCusto);


                try {
                    jsonCliente.put("nomeCompletoCliente", cliente.getNomeCompletoCliente());
                    jsonCliente.put("emailCliente", cliente.getEmailCliente());
                    jsonCliente.put("senhaCliente", cliente.getSenhaCliente());
                    jsonCliente.put("cpfCliente", cliente.getCPFCliente());
                    jsonCliente.put("celularCliente", cliente.getCelularCliente());
                    jsonCliente.put("telComercialCliente", cliente.getTelComercialCliente());
                    jsonCliente.put("telResidencialCliente", cliente.getTelResidencialCliente());
                    jsonCliente.put("dtNascCliente", cliente.getDtNascCliente());
                    jsonCliente.put("recebeNewsLetter", cliente.getRecebeNewsLetter());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                NetworkCall myCall = new NetworkCall();
                myCall.execute((String) null);

                System.out.println(jsonCliente);
                dialog = ProgressDialog.show(CadastroActivity.this, "", "Cadastrando...", false, true);
                dialog.setIcon(R.drawable.ic_launcher);
                dialog.setCancelable(false);

            }
        });
    }

    public void onStart() {
        super.onStart();

        EditText cadDatNasc = (EditText) findViewById(R.id.cadDatNasc);

        cadDatNasc.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) {
                                                    if (hasFocus) {
                                                        DateDialog dialog = new DateDialog(v);
                                                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                                                        dialog.show(ft, "Escolher data");
                                                    }

                                                }
                                            }

        );


    }

    public class NetworkCall extends AsyncTask<String, Void, String> {

        private int resultCode = 0;

        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL("http://192.168.0.5:8080/WSECommerce/rest/cliente");

                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
                out.write(jsonCliente.toString());

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
                    respostaSnack = "Cliente Cadastrado com sucesso!";

                    JSONObject json = new JSONObject(result);
                    String resposta = json.getString("idCliente");

                    ClienteSingleton singleton = ClienteSingleton.getInstance();
                    singleton.setIdCliente(resposta);


                }else if(resultCode == 500){
                    respostaSnack = "Erro ao cadastrar, tente novamente";
                }

                Snackbar snackbar = Snackbar
                        .make(cadBtnCadastrar, respostaSnack, Snackbar.LENGTH_LONG);
                snackbar.show();

                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            Thread.sleep(3000);
                            Intent i = new Intent(getApplicationContext(), CadastroEnderecoActivity.class);
                            startActivity(i);
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

