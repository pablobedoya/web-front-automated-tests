# web-front-automated-tests

Este projeto contém testes automatizados para a funcionalidade de login de um [website de ecommerce](http://automationpractice.com).
 
  ### Tecnologias utilizadas:
  * Java
  * Maven
  * Selenium WebDriver
  * Junit
  * Cucumber
  * Cluecumber Report
  * Java Faker

  ### Destaques:
  * Uso de Page Objects para criar um repositório de objetos para elementos de UI do website.
  * Uso de Test Data Factory para criação de dados aleatórios utilizados para os testes.
  * Cenários concebidos seguindo os princípios [BRIEF](https://cucumber.io/blog/bdd/keep-your-scenarios-brief/) como um boa prática.
 
## Execução

### Pré-requisitos
* Clonar o repositório do projeto: `git clone https://github.com/pablobedoya/web-front-automated-tests.git`
* Rodar o comando Maven para resolver as dependências: `mvn clean install -DskipTests`

### Rodar os testes
* Rodar o comando Maven: `mvn test`

### Gerar relatório de execução dos testes
* Após a execução dos testes, rodar o comando Maven: `mvn cluecumber-report:reporting`

**Nota:** Após a execução do comando de geração do relatório de execução dos testes, o relatório estará acessível dentro do projeto, no caminho `/target/generated-report/index.html`.
