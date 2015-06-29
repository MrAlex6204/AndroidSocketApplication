package clientapplication.oavera.com.clientapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.TextView;


import java.net.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button cmdConectar =  (Button)$(R.id.cmdConectar);

        //Agregar evento click.
        cmdConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText txtMsg = ((EditText)$(R.id.txtMsg));
                        txtMsg.append("2.-Connectando...*\n");
                        Thread thr = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    Socket client = new Socket("172.16.0.82",5000);
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                                    String msg = reader.readLine() + "\n";

                                    txtMsg.append(msg+"\n");
                                    client.close();

                                }catch(Exception ex){
                                    txtMsg.append("Se genero el sig. error:\n"+ex.toString()+"\n");
                                    //lblMsg.append(ex.getMessage()+"\n");
                                }finally {
                                    //cmd.setText("Conectar");
                                    //cmd.setEnabled(true);
                                }
                            }
                        });
                        thr.start();
            }
        });

    }
    private android.view.View $(int id){
        return findViewById(id);
    }

}


