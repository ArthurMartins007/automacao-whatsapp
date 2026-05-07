# 🤖 WhatsApp Concierge Bot

Automação em Java desenvolvida para realizar o envio humanizado e automatizado de mensagens via WhatsApp Web, otimizando a comunicação do Concierge de um clube com os membros autorizados.

## 🎯 O Problema que Resolve
O envio manual de dezenas de mensagens individuais consumia horas de trabalho braçal. O uso de listas de transmissão nativas do WhatsApp não era uma opção, pois eliminava o "sentimento de atendimento único e exclusivo" exigido pelo clube.

## 🚀 Funcionalidades e Soluções
- **Personalização Dinâmica:** Lê uma planilha `.csv` e insere automaticamente o nome do membro na mensagem.
- **Sistema Anti-Banimento:** Em vez de usar delays fixos, o robô calcula tempos de espera aleatórios entre um envio e outro, simulando perfeitamente o comportamento humano para não acionar os bloqueios de spam da Meta.
- **Login Persistente:** Cria e gerencia um perfil isolado do Google Chrome (`user-data-dir`). Exige a leitura do QR Code apenas na primeira execução; nas seguintes, o robô já abre logado.
- **Atuação em Segundo Plano:** O envio é feito via injeção de tecla `ENTER` (e não por clique de mouse no HTML), o que permite que a automação rode em uma Área de Trabalho Virtual enquanto o computador é usado para outras tarefas.

## 🛠️ Tecnologias Utilizadas
- **Java** - **Selenium WebDriver** (Controle do navegador)
- **Maven** (Gerenciamento de dependências)
- **WebDriverManager** (Gerenciamento automático dos binários do ChromeDriver)

## ⚙️ Como executar

1. Clone o repositório.
2. Crie uma pasta no seu disco `C:\` chamada `RoboWhatsApp` (ou altere o caminho no código na classe `ChromeOptions`).
3. Crie um arquivo `teste.csv` na raiz do projeto com o formato: `Nome,55DDD9XXXXXXXXX`.
4. Rode a classe `Main.java`.

> ⚠️ **Aviso de Segurança:** Por questões de LGPD e segurança da informação, a planilha CSV com os contatos reais do clube foi adicionada ao `.gitignore` e não faz parte deste repositório público.