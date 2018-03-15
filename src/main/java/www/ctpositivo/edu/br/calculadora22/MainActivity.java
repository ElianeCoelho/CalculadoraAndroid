package www.ctpositivo.edu.br.calculadora22;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private Calculadora calc;
    private boolean usuarioDigitando;
    private boolean separadorDecimalDigitado;

    private TextView txtVisor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("App Calculadora");
                alerta.setIcon(R.mipmap.ic_aviso).setMessage("App desenvolvido por: Eliane Coelho").setCancelable(false)
                        .setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), ":)", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog= alerta.create();
                alertDialog.show();;

            }
        });

        calc = new Calculadora();
        usuarioDigitando = false;
        separadorDecimalDigitado = false;
        txtVisor = findViewById(R.id.txtVisor);


        txtVisor.setText("");


    }



    public void onClickNumeros(View v){
        //capturando a informação do botão capturado na interface
        Button botaoClicado = (Button) v;
        String digito = botaoClicado.getText().toString();
        String textoVisor = txtVisor.getText().toString();

        if(!usuarioDigitando || textoVisor.equals("0")){
            txtVisor.setText(digito);
            if(!digito.equals("0")){
                usuarioDigitando = true;
            }

        }else{
            txtVisor.setText(textoVisor + digito);
        }

    }






    public void onClickOperacoes(View v){

        Button botaoClicado = (Button) v;
        String operacao = botaoClicado.getText().toString();

        if(operacao.equals(",") && !separadorDecimalDigitado){

            separadorDecimalDigitado = true;

            if(!usuarioDigitando){
                txtVisor.setText("0,");
            }else{
                txtVisor.setText(txtVisor.getText().toString() + ",");
            }

            usuarioDigitando = true;
        }else if(!operacao.equals(",")){

            String modificaVirgula = txtVisor.getText().toString().replace(',','.');

            calc.setNum(Double.parseDouble(modificaVirgula));
            calc.realizarOperacao(operacao);

            String resultado = String.valueOf(calc.getNum());

            if(resultado.endsWith(".0")){

                resultado = resultado.substring(0, resultado.length()-2);
            }

            txtVisor.setText(resultado.replace('.',','));
            usuarioDigitando = false;
            separadorDecimalDigitado = false;
        }




    }



}
