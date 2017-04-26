package firebase.elfrarep.cursoandroid.com.projetofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    Button btnUm;
    Button btnDois;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        texto = (TextView) findViewById(R.id.textoId);
        btnUm = (Button) findViewById(R.id.emailOneID);
        btnDois = (Button) findViewById(R.id.emailTwoId);


        firebase = new Firebase("https://fir-34be9.firebaseio.com/nome");



        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensagem = dataSnapshot.getValue(String.class);
                texto.setText(mensagem);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

//        Firebase fire = new Firebase ("https://projeto-firebase-ba6f0.firebaseio.com/");
//
//        fire.child("message").setValue("Hello");
    }
}
