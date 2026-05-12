# SGBD Adapter Application

Aplicação Java que demonstra o uso do **padrão estrutural Adapter** para integrar diferentes Sistemas Gerenciadores de Banco de Dados (SGBDs) de acordo com o perfil do usuário.

## 🚀 Funcionalidades

- Escolha automática do SGBD baseada no perfil do usuário:
  - **Gratuito (FREE)** → Paradox (Single usuário / transações únicas)
  - **Básico (BASIC)** → Firebird (Multi usuário / transações únicas)
  - **Ultimate (ULTIMATE)** → MySQL (Multi usuário / múltiplas transações)
- Uso do padrão **Adapter** para uniformizar a interface de acesso aos bancos.
- **Factory** para criação dinâmica do adapter correto.

## 📁 Estrutura do Projeto

sgbd-adapter-app/
├── src/
│ ├── profiles/ # Perfis de usuário
│ │ ├── ProfileType.java
│ │ └── UserProfile.java
│ ├── sgbds/ # SGBDs originais (adaptees)
│ │ ├── ParadoxDB.java
│ │ ├── FirebirdDB.java
│ │ └── MySQLDB.java
│ ├── database/ # Adapters
│ │ ├── DatabaseAdapter.java
│ │ ├── ParadoxAdapter.java
│ │ ├── FirebirdAdapter.java
│ │ └── MySQLAdapter.java
│ ├── factory/ # Fábrica de adapters
│ │ └── DatabaseFactory.java
│ └── Main.java # Classe principal
└── README.md


## 🛠️ Como executar

### Pré‑requisitos
- JDK 8 ou superior
- Git (opcional, para clonar)

### Passos

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/sgbd-adapter-app.git
   cd sgbd-adapter-app

2. **Compile os arquivos**
   javac -d out src/**/*.java

3. **Execute a aplicação**
   java -cp out Main



 ## 🧪 Exemplo de saída

 === Sistema com Padrão Adapter para SGBDs ===

Testando usuário: Victor Hugo
Perfil: FREE
----------------------------------------
Criando adapter para Paradox (Single User/Single Transaction)
SGBD Selecionado: Paradox DB - Single User / Single Transaction

1. Conectando ao banco de dados...
ParadoxDB: Banco aberto para usuário único: João Silva

2. Executando operações no banco:
ParadoxDB: Executando transação única: SELECT * FROM usuarios
ParadoxDB: Transação completada com sucesso!

...


## 📊 Diagrama UML
Veja o diagrama de classes completo aqui (adicione o link para o arquivo Mermaid ou insira o código diretamente no seu README).

## 🧠 Padrões utilizados
Adapter – permite que SGBDs com interfaces diferentes sejam usados de forma uniforme.

Factory Method – a DatabaseFactory decide qual adapter criar com base no perfil.

## 📝 Licença
Este projeto está sob a licença MIT – sinta‑se livre para usar, modificar e distribuir.
