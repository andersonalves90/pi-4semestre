package jumpers.delta.sistemasparainter.net.appdelta;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import jumpers.delta.sistemasparainter.net.appdelta.entities.CarrinhoSingleton;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Produto;

public class MainActivity extends  android.support.v4.app.Fragment {

    private ProgressDialog dialog;
    private ViewGroup produtos;
    JSONArray jsonArrayDetalhes = null;

    Produto produto = new Produto();
    CardView cardView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,
                container, false);

        produtos = (ViewGroup) view.findViewById(R.id.container);

        dialog = ProgressDialog.show(MainActivity.this.getContext(),"","Carregando...", false,true);
        dialog.setIcon(R.drawable.ic_launcher);
        dialog.setCancelable(true);

        try {
            NetworkCallProduto myCallProduto = new NetworkCallProduto();
            myCallProduto.execute("http://192.168.0.5:8080/WSECommerce/rest/produto");
        }catch (Exception e){
            e.getMessage();
        }

        try{

                NetworkCall myCall = new NetworkCall();
                myCall.execute("http://192.168.0.5:8080/WSECommerce/rest/image/");



        }catch (Exception e){
            e.getMessage();
        }


        return view;
    }

    public class NetworkCallProduto extends AsyncTask<String, Void, String> {

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
                jsonArrayDetalhes = new JSONArray(result);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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
            dialog.dismiss();
            JSONArray jsonArray = null;

            try {
                jsonArray = new JSONArray(result);

                System.out.print(jsonArray);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 1; i <= jsonArray.length(); i++) {

                try {

                    cardView = (CardView) LayoutInflater.from(MainActivity.this.getContext()).inflate(R.layout.activity_cardview, produtos, false);
                    ImageView maiImageP = (ImageView) cardView.findViewById(R.id.maiImageP);
                    TextView textViewNomeProduto = (TextView) cardView.findViewById(R.id.textViewNomeProduto);
                    TextView textViewDescProduto = (TextView) cardView.findViewById(R.id.textViewDescProduto);
                    TextView textViewPrecoProduto = (TextView) cardView.findViewById(R.id.textViewValorProduto);
                    TextView textViewPrecoProdutoText = (TextView) cardView.findViewById(R.id.textViewPrecoProduto);


                    //TextView textViewNomeProduto = (TextView) cardView.findViewById(R.id.textViewNomeProduto);

                        try {
                            JSONObject jsonobject = jsonArrayDetalhes.getJSONObject(i);
                            textViewNomeProduto.setText(jsonobject.getString("nomeProduto"));
                            textViewDescProduto.setText(jsonobject.getString("descProduto"));

                            Double precoProduto = Double.parseDouble(jsonobject.getString("precProduto"));
                            Double descontoProduto = Double.parseDouble(jsonobject.getString("descontoPromocao"));
                            Locale meuLocal = new Locale( "pt", "BR" );

                            if(!(descontoProduto.intValue() <= 0) && (descontoProduto < precoProduto)){

                                    Double valorFinal = precoProduto - descontoProduto;

                                    NumberFormat nf = NumberFormat.getCurrencyInstance(meuLocal);
                                    String formatadoFinal = nf.format (valorFinal);

                                    NumberFormat nf1 = NumberFormat.getCurrencyInstance(meuLocal);
                                    String formatadoDesconto = nf1.format (descontoProduto);

                                    textViewPrecoProdutoText.setText("Preço (Com desconto de: "+ formatadoDesconto +")");
                                    textViewPrecoProduto.setText(formatadoFinal.toString());


                            }else if(precoProduto.intValue() <= 0){

                                NumberFormat nf = NumberFormat.getCurrencyInstance(meuLocal);
                                String formatadoFinal = nf.format (precoProduto);

                                textViewPrecoProduto.setText(formatadoFinal.toString());

                            }else {
                                NumberFormat nf = NumberFormat.getCurrencyInstance(meuLocal);
                                String formatadoFinal = nf.format (precoProduto);
                                textViewPrecoProduto.setText(formatadoFinal.toString());
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    JSONObject obj = (JSONObject)jsonArray.get(i);

                    String imageString = obj.get("imagem").toString();

                    byte[] imageAsBytes = Base64.decode(imageString, Base64.DEFAULT);
                    Bitmap imageBitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
                    maiImageP.setImageBitmap(imageBitmap);
                    produto.setImagem(imageAsBytes);

                    Button maiEntrar = (Button) cardView.findViewById(R.id.maiEntrar);
                    MainActivity.this.produtos.addView(cardView);

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
    }
}


