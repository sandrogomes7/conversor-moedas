# Conversor de Moedas

Um simples aplicativo de linha de comando em Java para converter entre várias moedas usando a API ExchangeRate-API.

## Funcionalidades

- Conversão entre as seguintes moedas:
  - Dólar (USD) para Real (BRL)
  - Real (BRL) para Dólar (USD)
  - Euro (EUR) para Real (BRL)
  - Real (BRL) para Euro (EUR)
  - Won sul-coreano (KRW) para Real (BRL)
  - Real (BRL) para Won sul-coreano (KRW)
  - Peso Argentino (ARS) para Real (BRL)
  - Real (BRL) para Peso Argentino (ARS)
- Exibição do histórico de conversões realizadas.

## Pré-requisitos

- Java 11 ou superior
- Maven para compilação e gerenciamento de dependências

## Como usar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas.git
   ```

2. Compile o projeto:

   ```bash
   mvn clean install
   ```

3. Execute o aplicativo:

   ```bash
   java -jar target/conversor-moedas.jar
   ```

4. Selecione a opção desejada no menu exibido e siga as instruções para realizar conversões ou visualizar o histórico.

## Configuração da API

Este projeto utiliza a API ExchangeRate-API para obter as taxas de câmbio em tempo real. Você precisará de uma chave de API válida para utilizar o serviço. Substitua a \`key\` na classe \`PegaCotacao\` pelo seu token de acesso.

```java
String key = "sua-chave-api";
```

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE.md](LICENSE.md) para mais detalhes.
EOF
