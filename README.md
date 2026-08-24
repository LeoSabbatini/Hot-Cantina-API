# Hot-Cantina-API
## Estrutura do projeto

```
src/main/java/com/concessionaria
 config/       -> configuração do Swagger/OpenAPI
 controller/   -> endpoints da API (Lanche)
 model/        -> entidade JPA (Lanche)
 repository/   -> interfaces JpaRepository de acesso ao banco
```

## Como rodar o projeto

### Pré-requisitos
- Java 21 instalado
- MySQL rodando na sua máquina (ou em container)

### Passo a passo

1. O projeto cria o banco de dados sozinho, então n precisa se preocupar
2. Verifique o nome e senha do banco (por padrão está `root` / `root`).
3. Rode o projeto com o Maven Wrapper, direto na pasta do projeto:
```bash
 ./mvnw spring-boot:run
```
4. acessar: `http://localhost:8080`
5. Swagger: `http://localhost:8080/swagger-ui.html`

## Contextualização
No projeto anterior, foi desenvolvido um sistema simples de caixa para a cantina da escola,
permitindo registrar vendas, consultar o valor arrecadado e realizar o fechamento do dia. Com o
sistema em uso, a direção percebeu um novo problema: o cardápio da cantina muda com
frequência, novos lanches são incluídos, preços são reajustados e itens que saem de linha precisam
ser removidos. Hoje, qualquer alteração exige mexer diretamente no código, o que torna a
manutenção lenta e sujeita a erros.

Para resolver essa limitação, a próxima etapa do projeto é desenvolver uma API para o
gerenciamento dos lanches da cantina. Essa API será a base para que, futuramente, o sistema de
caixa consuma as informações dos produtos de forma dinâmica, sem depender de alterações no
código-fonte.

## Desafio
Desenvolver uma API REST utilizando Java, Spring Boot e MySQL para o gerenciamento do catálogo
de lanches de uma cantina escolar, dando continuidade ao sistema de caixa desenvolvido
anteriormente. A aplicação deve permitir o cadastro, listagem, consulta, atualização e remoção de
lanches, utilizando corretamente os verbos HTTP e retornando respostas em formato JSON com os
códigos de status adequados.

O sistema deve seguir o padrão REST, possuir separação em camadas (controller, service e
repository), realizar validações dos dados de entrada com Bean Validation, tratar erros como
recursos inexistentes ou requisições malformadas, persistir os dados no banco MySQL utilizando
Spring Data JPA, além de contar com versionamento completo do projeto utilizando Git e GitHub.

## Endpoints principais

### Lanche (`/HotCantina`)
- /HotCantina/Cadastrar - cadastra novo lanche (post)
- /HotCantina/Listar - lista todos os lanches com opcao de filtrar pelo nome (get)
- /HotCantina/Listar/{id} - busca pelo id (get)
- /HotCantina/Atualizar/{id} - atualiza o lanche (put)
- /HotCantina/Excluir/{id} - exclui o lanche (delete)
