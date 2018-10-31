package eccgo.jonathansilvaviana.com.br.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private WebView webView = null;

    //instanciando a webview
    WebView S_C;

    /*String baseUrl    = "http://google.com.br";
    String data       = "Relative Link";
    String mimeType   = "text/html";
    String encoding   = "UTF-8";
    String historyUrl = "http://google.com.br";*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //desabilita a barra de texto
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        S_C = (WebView)findViewById(R.id.website_content);


        ConnectivityManager CN = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (CN.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED
                || CN.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {

            //boas vindas
            Toast.makeText(this, "Bem-vindo(a)", Toast.LENGTH_SHORT).show();

            //habilitando javascript
            S_C.getSettings().setJavaScriptEnabled(true);

            S_C.setWebViewClient(new MyWebViewClient(this));

            //site à carregar
            String site = "http://google.com.br";

            S_C.loadUrl(site);

           // S_C.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);

            //WebView webView = new WebView(this);

            //setContentView(webView);

        }
        else if (CN.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED
                || CN.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED)
            {

                Toast.makeText(this, "Sem internet suficiente", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Problemas de rede");
                alertDialogBuilder
                        .setMessage("Clique em sim para fechar")
                        .setCancelable(false)
                        .setPositiveButton("Sim",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        moveTaskToBack(true);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                    }
                                })

                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();



            }

            else
                {

                    Toast.makeText(this, "Sem rede", Toast.LENGTH_SHORT).show();
                    System.exit(1);
                }



                //metodo do botão de trás


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.S_C.canGoBack()) {
            this.S_C.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
