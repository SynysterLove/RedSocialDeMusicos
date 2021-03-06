package untref.lp4.redsocialdemusicos.redsocialdemusicos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button botonLoginInvitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Esto lo probe en Eclipse y funciona perfecto.
        Si hay algun problema probablemente sea como lo
        meti aca adentro, pero en teoría debería andar.
         */
        if(TesterConexion.testear("google.com", 80) == true) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        } else {
            Toast noHayInternet = Toast.makeText(getApplicationContext(), R.string.toast_no_internet , Toast.LENGTH_SHORT);
            noHayInternet.show();
            finish();
        }

        botonLoginInvitado = (Button)findViewById(R.id.botonLoginInvitado);

        botonLoginInvitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent loginInvitado = new Intent(MainActivity.this, ActivityInicio.class);
                startActivity(loginInvitado);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
