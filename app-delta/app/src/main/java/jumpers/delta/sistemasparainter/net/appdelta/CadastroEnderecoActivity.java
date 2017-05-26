package jumpers.delta.sistemasparainter.net.appdelta;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import jumpers.delta.sistemasparainter.net.appdelta.entities.Endereco;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Mask;

public class CadastroEnderecoActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private TextView cedCadastro;
    private EditText cedBairro;
    private EditText cedLogradouro;
    private EditText cedNumero;
    private EditText cedCep;
    private EditText cedComplemento=null;
    private EditText cedCidade;
    private EditText cedPais=null;
    private EditText cedUf=null;
    private Button cedBtnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);
        cedBairro = (EditText) findViewById(R.id.cedBairro);
        cedBairro.addTextChangedListener(Mask.insert("##################", cedBairro));

        cedLogradouro = (EditText) findViewById(R.id.cedLogradouro);
        cedLogradouro.addTextChangedListener(Mask.insert("#################", cedLogradouro));

        cedNumero = (EditText) findViewById(R.id.cedNumero);
        cedNumero.addTextChangedListener(Mask.insert("#####", cedNumero));

        cedCep = (EditText) findViewById(R.id.cedCep);
        cedCep.addTextChangedListener(Mask.insert("###-##-###", cedCep));

        cedComplemento = (EditText) findViewById(R.id.cedComplemento);

        cedCidade = (EditText) findViewById(R.id.cedCidade);
        cedCidade.addTextChangedListener(Mask.insert("###-##-###", cedCidade));

        cedPais = (EditText) findViewById(R.id.cedPais);

        cedUf = (EditText) findViewById(R.id.cedUf);
        cedUf.addTextChangedListener(Mask.insert("##", cedUf));

        cedCadastro = (TextView) findViewById(R.id.cedCadastro);
        cedBtnCadastrar= (Button)findViewById(R.id.cedBtnCadastrar);

        cedBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cep = cedCep.getText().toString();
                String lougradouro = cedLogradouro.getText().toString();
                String numero = cedNumero.getText().toString();
                String complemento = cedComplemento.getText().toString();
                String bairro = cedBairro.getText().toString();
                String cidade= cedCidade.getText().toString();
                String pais = cedPais.getText().toString();
                String uf = cedUf.getText().toString();

                Endereco endereco = new Endereco();

                if (cep.equals("")&&(cep.length() > 9)) {
                    cedCep.setError("campo obrigatório");
                    return;
                } else {
                    String cepCusto = cep.replaceAll("[^0-9]+","");
                    endereco.setCEPEndereco(cepCusto);
                }
                if (lougradouro.equals("")) {
                    cedLogradouro.setError("campo obrigatório");
                    return;
                } else {
                    String logCusto = lougradouro.replaceAll("[^0-9]+","");
                    endereco.setLogradouroEndereco(logCusto);
                }

                if (numero.equals("")&& (numero.length() > 10)) {
                    cedNumero.setError("campo obrigatório");
                    return;
                } else {
                    String numeroCusto = numero.replaceAll("[^0-9]+","");
                    endereco.setNumeroEndereco(numeroCusto);
                }

                if (bairro.equals("")) {
                    cedBairro.setError("campo obrigatório");
                    return;
                } else {
                    String bairrCusto = bairro.replaceAll("[^0-9]+","");
                    endereco.setNomeEndereco(bairrCusto);
                }

                if (cidade.equals("")) {
                    cedCidade.setError("campo obrigatório");
                    return;
                } else {
                    endereco.setCidadeEndereco(cidade);
                }
                    endereco.setComplementoEndereco(complemento);
                    endereco.setPaisEndereco(pais);
                  String ufCusto = uf.replaceAll("[^0-9]+","");
                    endereco.setUFEndereco(ufCusto );

                JSONObject json = new JSONObject();
                try {
                    json.put("nomeEndereco",endereco.getNomeEndereco());
                    json.put("logradouroEndereco",endereco.getLogradouroEndereco());
                    json.put("numeroEndereco",endereco.getNumeroEndereco());
                    json.put("CEPEndereco",endereco.getCEPEndereco());
                    json.put("complementoEndereco",endereco.getComplementoEndereco());
                    json.put("cidadeEndereco",endereco.getCidadeEndereco());
                    json.put("paisEndereco",endereco.getPaisEndereco());
                    json.put("UFEndereco",endereco.getUFEndereco());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                dialog = ProgressDialog.show(CadastroEnderecoActivity.this,"","Cadastrando!!", false, true);
                dialog.setIcon(R.drawable.ic_launcher);
                dialog.setCancelable(false);
                System.out.println(json);
            }
        });
    }
}
