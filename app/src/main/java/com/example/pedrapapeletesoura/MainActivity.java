package com.example.pedrapapeletesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void pedraSelecionado(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void papelSelecionado(View view) {
        this.opcaoSelecionada("papel");
    }

    public void tesouraSelecionado(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = { "pedra", "papel", "tesoura" };
        String escolhaApp = opcoes[numero];

        switch ( escolhaApp ) {
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ) {
            textoResultado.setText("Você perdeu ):");
        } else if (
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ) {
            textoResultado.setText("Você ganhou (:");
        } else {
            textoResultado.setText("Empatamos /:");
        }

        System.out.println("item clicado " + escolhaApp);
        


    }
}