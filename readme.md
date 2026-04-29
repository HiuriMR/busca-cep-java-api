# 📦 busca-cep-java-api

![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-3.8.2-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Build](https://img.shields.io/badge/Build-passing-brightgreen)

Projeto em Java para consulta de endereços a partir de um CEP, utilizando a API [ViaCEP](https://viacep.com.br) e integração com a biblioteca **Gson** para manipulação de JSON.

## 🚀 Funcionalidades
- Consulta de informações de endereço a partir de um CEP.
- Validação de CEP antes da requisição.
- Retorno estruturado em objetos Java usando **records** (`CepResponse`) e classes imutáveis (`Endereco`).
- Geração de arquivo JSON com os dados do endereço (`GeradorDeArquivo`).
- Interface de linha de comando (`Principal`) para interação com o usuário.
- Uso de `HttpClient` (Java 11+) para requisições HTTP.

## 🛠 Tecnologias
- **Java 17**
- **Maven** para gerenciamento de dependências
- **Gson** (2.10.1) para serialização/deserialização de JSON
- **IntelliJ IDEA** como IDE de desenvolvimento

## 📂 Estrutura do projeto

src/

└── main/

└── java/

└── main/

├── app/      # Principal (entrada do programa)

├── client/   # ConsultaCep (requisições HTTP)

├── model/    # Endereco e CepResponse (record)

└── util/     # GeradorDeArquivo (exporta JSON)


## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/busca-cep-java-api.git

2. Entre na pasta do projeto:
   cd busca-cep-java-api
3. Compile e rode com Maven:
   mvn clean install
   mvn exec:java -Dexec.mainClass="main.app.Principal"

## 📖 Exemplo de uso

Ao rodar o programa, você poderá digitar um CEP no terminal:
Digite um CEP (ou 'sair'): 01001-000

## Saída no console:

CEP: 01001-000
Logradouro: Praça da Sé
Bairro: Sé
Cidade: São Paulo
UF: SP

## Arquivo gerado:

Um arquivo 01001-000.json será criado na pasta do projeto com o conteúdo:
{
"cep": "01001-000",
"logradouro": "Praça da Sé",
"bairro": "Sé",
"localidade": "São Paulo",
"uf": "SP"
}

Se digitar sair, o programa encerra:

Digite um CEP (ou 'sair'): sair
Encerrando...

## 🤝 Contribuição
Faça um fork do projeto

Crie uma branch para sua feature (git checkout -b minha-feature)

Commit suas alterações (git commit -m 'Adiciona minha feature')

Faça push para a branch (git push origin minha-feature)

Abra um Pull Request

## 📜 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.



