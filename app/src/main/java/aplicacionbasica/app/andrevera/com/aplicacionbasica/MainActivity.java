package aplicacionbasica.app.andrevera.com.aplicacionbasica;

import android.media.MediaPlayer;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvnombre;
    EditText etnombre;
    Button btnpresionar;
    //opciones
    TextView tvopciones;
    Button btnopciones;
    RadioButton rbpaypal,rbvisa;
    CheckBox cbmastercard,cbbcp;
    //spinner
    Spinner spinopciones;
    //para los sonidos del boton
    MediaPlayer mp;
    Button btnpersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * Al querer compartir el proyecto a github VCS-import into version -share github
        * y sale error de usuario o algo asi se tiene que ejecutar los comandos que indica en el error
        * y aplicarlos o ejecutarlos en la terminal en la parte inferior de android studio
        *
        * */
        tvnombre=(TextView)findViewById(R.id.tvnombre);
        etnombre=(EditText)findViewById(R.id.etnombre);
        btnpresionar=(Button)findViewById(R.id.btnpresionar);

        btnpresionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=etnombre.getText().toString();
                tvnombre.setText("Hola "+nombre);
            }
        });

        tvopciones=(TextView)findViewById(R.id.tvopcion);
        btnopciones=(Button)findViewById(R.id.btnopciones);
        rbpaypal=(RadioButton)findViewById(R.id.rbpaypal);
        rbvisa=(RadioButton)findViewById(R.id.rbvisa);
        cbmastercard=(CheckBox)findViewById(R.id.cbmastercard);
        cbbcp=(CheckBox)findViewById(R.id.cbbcp);
/*
* Aquí habrá un temita ya que los radiobuttons se quedarán seleccionados y no se podrá ver
* el funcionamiento para los chekcbox a noser que se vuelva a ejecutar la aplicación
* y se empiece probando por los checkbox
* */
        btnopciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbpaypal.isChecked()){
                    tvopciones.setText(rbpaypal.getText().toString());
                }else{
                    if(rbvisa.isChecked()){
                        tvopciones.setText(rbvisa.getText());
                    }else{
                        if (cbbcp.isChecked()){
                            //rbvisa.setChecked(false);
                            //rbpaypal.setChecked(false);
                            tvopciones.setText(cbbcp.getText());
                        }else{
                            if (cbmastercard.isChecked()){
                                //rbvisa.setChecked(false);
                                //rbpaypal.setChecked(false);
                                tvopciones.setText(cbmastercard.getText());
                            }else {
                                tvopciones.setText("No seha seleccionado nada");
                            }
                        }
                    }
                }
            }
        });
        /*
        * Funcionamiento de spinner
        * */
        spinopciones=(Spinner)findViewById(R.id.spinopciones);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.opcionesspiner,android.R.layout.simple_spinner_item);
        spinopciones.setAdapter(adapter);

        //boton sonidos
        mp = MediaPlayer.create(this,R.raw.sonido);// creo el recurso
        btnpersonalizado = (Button)findViewById(R.id.btnpersonalizado);
        btnpersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();//reproduce el sonido
            }
        });
    }
}
