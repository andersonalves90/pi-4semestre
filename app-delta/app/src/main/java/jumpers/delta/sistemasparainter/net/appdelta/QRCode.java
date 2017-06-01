package jumpers.delta.sistemasparainter.net.appdelta;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCode extends AppCompatActivity {
    private ZXingScannerView viewScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewScan = new ZXingScannerView(QRCode.this);
        setContentView(viewScan);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewScan.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(QRCode.this);
                builder.setTitle("Scan Result");
                builder.setMessage(result.getText());

                final ZXingScannerView.ResultHandler rh = this;
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewScan.resumeCameraPreview(rh);
                    }
                });

                AlertDialog alert1 = builder.create();
                alert1.show();
            }
        });
        viewScan.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewScan.stopCamera();
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_DENIED) {
                Toast toast = Toast.makeText(QRCode.this, "Não é possível utilizar a aplicação " +
                        "sem permissão de acesso a câmera. Saindo...", Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        }
    }
}