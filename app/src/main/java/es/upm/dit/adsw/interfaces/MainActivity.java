package es.upm.dit.adsw.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsadoBoton(v);
            }
        });

        List<String> lista = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, lista);
        lista.add("Turno mañana");
        lista.add("Turno tarde");
        listView = (ListView) findViewById(R.id.itemsListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Turno mañana seleccionado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Turno tarde seleccionado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void pulsadoBoton (View v){
        EditText editor = (EditText) findViewById(R.id.editText);
        TextView texto  = (TextView) findViewById(R.id.textView);
        Spinner selector = (Spinner) findViewById(R.id.spinner);
        String[] nombres = getResources().getStringArray(R.array.nombres);
        String nombre = nombres[selector.getSelectedItemPosition()];
        texto.setText(editor.getText() + " matriculado en " + nombre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                EditText editor = (EditText) findViewById(R.id.editText);
                editor.setText("");
                return true;
            case R.id.item2:
                TextView texto  = (TextView) findViewById(R.id.textView);
                texto.setText("Inserte texto y pulse boton");
                return true;
            default:
                 return super.onOptionsItemSelected(item);
        }
    }
}
