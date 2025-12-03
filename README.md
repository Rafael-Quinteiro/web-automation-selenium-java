# 🚀 Web Automation Selenium Java

Framework profissional de **Automação de Testes Web em Java com Selenium**, desenvolvido com foco em **qualidade, escalabilidade, organização arquitetural e boas práticas de mercado**.  
Este projeto faz parte do meu **portfólio profissional como QA Engineer / SDET**.

---

## 🎯 Objetivo do Projeto

Este projeto foi criado para demonstrar, na prática, como estruturar um **framework de automação web robusto e profissional**, aplicando:

- Arquitetura limpa
- Separação de responsabilidades
- Padrões de projeto
- Código reutilizável
- Boas práticas de automação
- Relatórios profissionais

Além disso, ele tem como propósito **ajudar pessoas que desejam aprender automação web** a entender como funciona um projeto real utilizado no mercado.

---

## 🛠 Tecnologias Utilizadas

- **Java 20**
- **Selenium WebDriver 4**
- **JUnit 4**
- **Maven**
- **ExtentReports**
- **Apache Commons IO**
- **Git & GitHub**
- **Page Object Model (POM)**

---

## ✅ Principais Funcionalidades e Recursos

- ✔ Estrutura em camadas (Arquitetura Profissional)
- ✔ Page Object Model (POM)
- ✔ Camada de Interactions (Fluxo de negócio)
- ✔ Builder para criação de massa de dados
- ✔ Gerenciamento centralizado de configurações
- ✔ BaseTest para reaproveitamento de código
- ✔ Relatórios HTML automáticos
- ✔ Captura automática de screenshots em falhas
- ✔ Constantes globais
- ✔ Projeto preparado para CI/CD
- ✔ Código limpo, legível e escalável

---

## 📁 Arquitetura do Projeto

```
src
└── test
├── java
│ └── br
│ └── com
│ └── testedelogin
│ ├── builders
│ │ └── DataFormsBuilder.java
│ │
│ ├── config
│ │ └── ConfigManager.java
│ │
│ ├── core
│ │ └── BaseTest.java
│ │
│ ├── data
│ │ └── DataForms.java
│ │
│ ├── global
│ │ └── Constants.java
│ │
│ ├── interactions
│ │ ├── LoginInteractions.java
│ │ └── OrderInteractions.java
│ │
│ ├── pages
│ │ ├── BasePO.java
│ │ ├── LoginPO.java
│ │ └── OrderPO.java
│ │
│ ├── report
│ │ └── SparkReporterUtil.java
│ │
│ ├── tests
│ │ ├── LoginTest.java
│ │ └── OrderTest.java
│ │
│ └── utils
│ ├── DateUtils.java
│ ├── MetodoBaseUtil.java
│ └── MetodoUtil.java
│
└── resources
└── config.properties
```

---

## 🧩 Descrição das Camadas

### 🧱 core
Contém a **classe BaseTest**, responsável por:
- Inicialização do WebDriver
- Configurações globais de execução
- Setup e teardown dos testes

---

### ⚙ config
Responsável pelo **gerenciamento das configurações** do projeto:
- URL da aplicação
- Navegador
- Timeouts
- Ambientes

---

### 🌍 global
Armazena **constantes globais** utilizadas em todo o framework:
- Mensagens
- Caminhos de arquivos
- Valores fixos

---

### 🧪 tests
Contém apenas os **cenários de teste automatizados**:
- LoginTest
- OrderTest

Nenhuma regra técnica fica aqui, apenas os cenários.

---

### 🧠 interactions
Camada responsável pela **lógica de negócio e fluxos da aplicação**.  
Ela conecta Pages, dados e validações.

---

### 🖥 pages
Implementação do padrão **Page Object Model (POM)**:
- Mapeamento dos elementos da tela
- Métodos de interação com os componentes

---

### 🏗 builders
Criação de **massa de dados dinâmica** utilizando o padrão **Builder**.

---

### 📊 report
Configuração dos **relatórios automáticos em HTML** usando ExtentReports.

---

### 🛠 utils
Contém **métodos utilitários reutilizáveis** pelo projeto:
- Datas
- Manipulação de arquivos
- Funções genéricas de apoio

---

## ⚙ Arquivo de Configuração

Local: `src/test/resources/config.properties`

Exemplo:
```properties
base.url=https://site-de-teste.com
browser=chrome
timeout=10
```

---

## ▶ Como Executar o Projeto

**1️⃣ Clonar o repositório**

```bash
git clone https://github.com/seu-usuario/web-automation-selenium-java.git
```

**2️⃣ Acessar a pasta do projeto**

```bash
cd web-automation-selenium-java
```

**3️⃣ Executar os testes**

```bash
mvn clean test
```

---

## 📊 Relatórios de Execução

Gerados automaticamente com ExtentReports:

- Formato HTML
- Contém cenários executados
- Status dos testes
- Logs detalhados
- Evidências com screenshots

**Diretório padrão:** `/reports`

---

## 📸 Evidências (Screenshots)

- Capturadas automaticamente em falhas
- Salvas localmente
- Incorporadas ao relatório HTML

---

## 🧪 Cenários Automatizados

**✅ Login**
- Realizar login com sucesso com credenciais válidas

**✅ Pedido**
- Criar pedido com endereço de cadastro
- Criar pedido com endereço padrão
- Criar pedido com novo endereço

---

## 🧠 Boas Práticas Aplicadas

- Page Object Model (POM)
- Clean Code
- Separação em camadas
- Reutilização de código
- Centralização de dados
- Arquitetura utilizada em projetos corporativos reais

---

## 📦 Coordenadas do Projeto

```xml
<groupId>br.com.webautomation.selenium</groupId>
<artifactId>web-automation-selenium-java</artifactId>
<version>1.0-SNAPSHOT</version>
```

---

## 🔄 Preparado para CI/CD

Este projeto pode ser facilmente integrado com:

- GitHub Actions
- Jenkins
- GitLab CI
- Azure DevOps

**Comando padrão para pipelines:**

```bash
mvn clean test
```

---

## 👨‍💻 Autor

**Rafael de Oliveira Quinteiro**  
QA Engineer | Se especializando em Automação de Testes  
Java • Selenium • Testes Web • Arquitetura de Testes

Este projeto representa minha experiência prática em automação de testes e faz parte do meu portfólio profissional.

---

## 🤝 Contribuição

Sinta-se à vontade para:

- Clonar
- Estudar
- Criar um fork

---

## ⭐ Apoie o Projeto

Se este projeto te ajudou:

- Deixe uma ⭐ no repositório
- Compartilhe com outros profissionais
- Utilize como base de estudo