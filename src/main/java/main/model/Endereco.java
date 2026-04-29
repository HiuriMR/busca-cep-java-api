package main.model;

public class Endereco {

    private final String cep;
    private final String logradouro;
    private final String bairro;
    private final String localidade;
    private final String uf;

    private Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public static Endereco from(CepResponse response) {
        return new Endereco(
                response.cep(),
                response.logradouro(),
                response.bairro(),
                response.localidade(),
                response.uf()
        );
    }

    public String getCep(){ return cep; }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return String.format("""
                    CEP: %s
                    Logradouro: %s
                    Bairro: %s
                    Cidade: %s
                    UF: %s
                    """,
                    cep, logradouro, bairro, localidade, uf);
    }
}
