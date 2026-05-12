# SGBD Adapter Application

## Descrição
Aplicação que utiliza o padrão Adapter para gerenciar diferentes SGBDs baseado no perfil do usuário.

## Perfis e SGBDs
- **Gratuito (FREE)** → Paradox (Single usuário, transações únicas)
- **Básico (BASIC)** → Firebird (Multi usuário, transações únicas)
- **Ultimate (ULTIMATE)** → MySQL (Multi usuário, múltiplas transações)

## Como Compilar e Executar

### Compilação
```bash
javac -d out src/**/*.java


Execução 

bash
java -cp out Main