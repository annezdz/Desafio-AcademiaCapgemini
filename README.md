# Anúncios-API

### Objetivos

Criar um sistema que permita o cadastro de anúncios contendo o nome do anúncio, o nome do cliente, a data de início e término do anúncio e o valor do investimento diário.


O sistema fornecerá os relatórios de cada anúncio contendo, podendo ser filtrados po intervalo de tempo e cliente.

- valor total investido

- quantidade máxima de visualizações

- quantidade máxima de cliques

- quantidade máxima de compartilhamentos


### Tecnologias utilizadas


Este projeto foi desenvolvido utilizando-se as seguintes tecnologias:

- Java 11
- Spring Boot 2.4.5
- Docker
- Maven 3.6.3
- My SQL 8.0
- GitHub

### Como utilizar

#### Para execução:

Para executar esta aplicação é preciso ter o Java versão 11 instalado na máquina. 
É recomendado utilizar uma IDE como VS Code ou IntelliJ IDEA, o que permite compilar o programa para versões 
diferentes do Java. 
Podem ocorrer erros caso sejam utilizadas versões inferiores 
ou superiores do Java.

A escolha do banco de dados a ser utilizado pode ficar a critério do utilizador.
Como o objetivo era apenas realizar o desenvolvimento da API, utilizei
banco de dados MySQL.

É necessário ter o Docker instalado para rodar  
o banco de dados. O mesmo pode ser baixado em:

`https://www.docker.com/products/docker-desktop`

Para rodar a imagem do MySQL em Docker é necessário executar o seguinte comando:

`docker run --name MySQL -p 3306:3306 -e MYSQL_ROOT_PASSWORD=sua-senha -d mysql:latest`

Na sequência é necessário clonar esse repositório e importar o projeto na IDE.

É preciso configurar as seguintes variáveis de ambiente:
- DB_URL=jdbc:mysql://localhost:3306/advertising
- DB_USER=root
- DB_PASSWORD=sua-senha

Utilizando sua IDE, executar AdvertisingApplication localizado em:

    classpath\src\main\java\br.com.capgemini.advertising/AdvertisingApplication


Com todos os requisitos e a API em execução, pode-se 
utilizar o Postman para fazer as requisições aos 
endpoints da API.

### Endpoints & Payloads

#### Endpoints

<table>
<thead>
<th>Ação</th>
<th>Endpoint</th>
<th>Método</th>
</thead>
<tbody>
<tr>
<td>Criar anúncio</td>
<td>/api/v1/ads</td>
<td>POST</td>
</tr>
<tr>
<td>Listar por cliente</td>
<td>/api/v1/ads?client={cliente}</td>
<td>GET</td>
</tr>
<tr>
<td>Listar por período</td>
<td>/api/v1/ads?startDate={ano-mês-dia}</td>
<td>GET</td>
</tr>
</tbody>
</table>

#### Payloads - (request & response)

POST - request (Criar anúncio)

    {
        "name":"name",
        "client":"client",
        "startDate":"2021-01-01",
        "endDate":"2021-02-01,"
        "amount":100.00
    }   

GET - ReportDto 


    {
        "id":1,
        "client":"client",
        "totalViews":10,
        "maxShares":"20"
        "maxkClicks":20,
        "totalInvestment":100.00
    }
 
