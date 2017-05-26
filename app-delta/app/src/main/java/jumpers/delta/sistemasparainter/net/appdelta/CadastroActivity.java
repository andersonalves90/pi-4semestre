package jumpers.delta.sistemasparainter.net.appdelta;

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

import jumpers.delta.sistemasparainter.net.appdelta.entities.Cliente;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Mask;

public class CadastroActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    JSONObject jsonCliente =new JSONObject();
    TextView cadCadastro;
    EditText cadNome = null;

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
        cadDatNasc.addTextChangedListener(Mask.insert("##/##/####", cadDatNasc));
        //até 3 caracteres
        cadOpcao = (CheckBox) findViewById(R.id.cadOpcao);
        cadBtnCadastrar = (Button) findViewById(R.id.cadBtnCadastrar);


        cadBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = cadNome.getText().toString();
                String celular = cadCelular.getText().toString();
                String telComercial = cadResidencial.getText().toString();
                String telResidencial = cadComercial.getText().toString();
                String dataNac = cadDatNasc.getText().toString();

            }
        });
    }
}


