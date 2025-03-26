# Jogo de Cartas

## Descrição
Este é um servidor de tempo, onde duas máquinas comunicam-se para demonstrar o funcionamento real do serviço. Uma máquina atua como o cliente, solicitando a requisição de tempo, enquanto a outra serve como o servidor, oferecendo o serviço de tempo.
## Tecnologia Utilizada
- Java

## Como funciona
1. O servidor deve ser executado em uma máquina conectada a uma rede.
2. O cliente deve ser executado em outra máquina na mesma rede que o servidor.
3. O cliente deve fornecer o IP do servidor ao solicitar a atualização do horário.
4. Quando o cliente clica no botão de "atualizar", ele envia uma requisição ao servidor, utilizando o protocolo TCP ou UDP, conforme a escolha do tipo de socket pelo usuário. O servidor, por sua vez, responde com a hora atual.

## Como Executar o Projeto
```bash
# Clone o repositório
git clone https://github.com/hugoobotelho/Servidor-de-tempo.git

# Acesse a pasta do projeto
cd Servidor-de-tempo

# Compile e rode o servidor em uma maquina
cd socketTCP
cd servidor
javac Principal.java
java Principal

# Compile e rode o cliente em outra maquina
cd socketTCP
cd cliente
javac Principal.java
java Principal
```

## Funcionamento
![Funcionamento](https://github.com/hugoobotelho/Servidor-de-tempo/raw/main/funcionamento.gif)

## Contribuição
Se quiser contribuir com melhorias, fique à vontade para abrir um Pull Request.

## Licença
Este projeto está sob a licença MIT.

