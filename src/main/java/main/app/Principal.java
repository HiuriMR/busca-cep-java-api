package main.app;

import main.client.ConsultaCep;
import main.model.Endereco;
import main.util.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        try (Scanner leitura = new Scanner(System.in)) {

            ConsultaCep consultaCep = new ConsultaCep();
            GeradorDeArquivo gerador = new GeradorDeArquivo();

            while (true) {

                System.out.print("Digite um CEP (ou 'sair'): ");
                String cep = leitura.nextLine();

                if ("sair".equalsIgnoreCase(cep)) {
                    System.out.println("Encerrando...");
                    break;
                }

                try {
                    processarConsulta(cep, consultaCep, gerador);
                } catch (RuntimeException | IOException e) {
                    System.out.println("Não foi possível consultar o CEP: " + e.getMessage());
                }
            }
        }
    }

    private static void processarConsulta(String cep, ConsultaCep consultaCep, GeradorDeArquivo gerador)
            throws IOException {

        Endereco endereco = consultaCep.buscaEndereco(cep);
        System.out.println(endereco);
        gerador.gerarArquivoJson(endereco);
    }
}