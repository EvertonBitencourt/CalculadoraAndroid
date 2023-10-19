package com.example.calculadora;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultadoTextView;
    private String numeroAtual = "";
    private String operadorAtual = "";
    private double resultado = 0;
    private boolean novoNumero = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultadoTextView = findViewById(R.id.txtResultado);
        AppCompatButton botaoC = findViewById(R.id.limpar);
        AppCompatButton botaoSoma = findViewById(R.id.adicao);
        AppCompatButton botaoLimparTudo = findViewById(R.id.limparTudo);
        AppCompatButton botaoPorcentagem = findViewById(R.id.porcentagem);
        AppCompatButton botaoDivisao = findViewById(R.id.divisao);
        AppCompatButton botaoSete = findViewById(R.id.sete);
        AppCompatButton botaoOito = findViewById(R.id.oito);
        AppCompatButton botaoNove = findViewById(R.id.nove);
        AppCompatButton botaoMultiplicacao = findViewById(R.id.multiplicacao);
        AppCompatButton botaoQuatro = findViewById(R.id.quatro);
        AppCompatButton botaoCinco = findViewById(R.id.cinco);
        AppCompatButton botaoSeis = findViewById(R.id.seis);
        AppCompatButton botaoSubtracao = findViewById(R.id.subtracao);
        AppCompatButton botaoUm = findViewById(R.id.um);
        AppCompatButton botaoDois = findViewById(R.id.dois);
        AppCompatButton botaoTres = findViewById(R.id.tres);
        AppCompatButton botaoMaisOuMenos = findViewById(R.id.mais_ou_menos);
        AppCompatButton botaoZero = findViewById(R.id.zero);
        AppCompatButton botaoVirgula = findViewById(R.id.virgula);
        AppCompatButton botaoIgual = findViewById(R.id.igual);

        botaoZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("0");
            }
        });
        botaoUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("1");
            }
        });
        botaoDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("2");
            }
        });

        botaoTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("3");
            }
        });

        botaoQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("4");
            }
        });

        botaoCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("5");
            }
        });

        botaoSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("6");
            }
        });

        botaoSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("7");
            }
        });

        botaoOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("8");
            }
        });

        botaoNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarNumero("9");
            }
        });
        botaoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroAtual = "0"; // Limpa o número atual
                resultado = 0;    // Reseta o resultado
                operadorAtual = ""; // Limpa o operador atual
                novoNumero = true;  // Define como um novo número
                atualizarVisor();
            }
        });
        botaoVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!numeroAtual.contains(".")) {
                    numeroAtual += "."; // Adiciona uma vírgula ao número atual
                    atualizarVisor();
                }
            }
        });
        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operadorAtual = "+"; // Define o operador atual como adição
                realizarCalculo();   // Chama a função para realizar o cálculo
                novoNumero = true;    // Um novo número será digitado após a operação
            }
        });
        botaoIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarCalculo();
                novoNumero = true; // Um novo número será digitado após o cálculo
            }
        });
    }

    private void atualizarVisor(){
        resultadoTextView.setText(numeroAtual);
    }

    /*Aqui, o método adicionarNumero verifica se um novo número está sendo digitado ou se está sendo continuado um número existente.
    Ele atualiza a variável numeroAtual e chama o método atualizarVisor para mostrar o número atualizado no visor.*/
    private void adicionarNumero(String digito){
        if(novoNumero) {
            numeroAtual = digito;
            novoNumero = false;
        }else{
            numeroAtual += digito;
        }
        atualizarVisor();
    }

    private void realizarCalculo() {
        if (!numeroAtual.isEmpty()) {
            double numeroDigitado = Double.parseDouble(numeroAtual);
                resultado += numeroDigitado;
        }
        // Atualize o visor com o resultado
        numeroAtual = String.valueOf(resultado);
        atualizarVisor();
    }

}