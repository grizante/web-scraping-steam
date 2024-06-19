# Game Stats Tracker

Este documento descreve o projeto **Game Stats Tracker**, um sistema de web scraping desenvolvido em Java para coletar e analisar informações sobre as tendências de gêneros de jogos na plataforma Steam. O objetivo é utilizar esses dados para fornecer insights valiosos que orientem a criação de novos jogos. A aplicação final será implementada em uma interface móvel utilizando React e React Native.

## Integrantes
Gabriel Souza, Ícaro Sousa, Isac Grizante, João Vianna, Lucas Cruz, Rafael Macedo

## Objetivos do Projeto
- Coletar dados sobre a tendência de gêneros de jogos na plataforma Steam.
- Armazenar essas informações em um banco de dados MongoDB.
- Analisar os dados coletados para identificar os gêneros de jogos em alta.
- Utilizar os insights obtidos para embasar a criação de um novo jogo.
- Desenvolver uma aplicação móvel cross-platform para disponibilizar os resultados da análise.

## Tecnologias Utilizadas
- **Java:** Linguagem de programação utilizada para o web scraping e análise dos dados coletados.
- **MongoDB:** Banco de dados NoSQL para armazenamento dos dados sobre jogos e gêneros.
- **React Native:** Framework para desenvolvimento de aplicativos móveis que exibirão os insights da análise de dados.

## Processo de Web Scraping
O processo de web scraping envolve as seguintes etapas:

1. **Coleta de Dados:** Utilização de bibliotecas Java como JSoup e java.net para obter dados através do scraping e da API.

2. **Tratamento e Limpeza:** Limpeza dos dados coletados para remover informações irrelevantes e padronização dos formatos utilizando Jackson.

3. **Armazenamento no MongoDB:** Dados estruturados são armazenados em um banco de dados MongoDB usando Springboot.

## Análise de Dados
Após a coleta e armazenamento dos dados, será realizada uma análise detalhada para identificar as tendências de gêneros de jogos no mercado.

- **Análise Exploratória:** Utilização de técnicas como visualização de gráficos e cálculo de métricas estatísticas para identificar padrões.

- **Identificação de Tendências:** Identificação dos gêneros de jogos populares e preferências dos jogadores através da análise exploratória.

- **Insights para Novos Jogos:** Utilização dos insights obtidos para orientar a criação de novos jogos alinhados com as tendências do mercado.

## Desenvolvimento da Interface Mobile/Desktop
A aplicação móvel será desenvolvida com React Native para permitir fácil acesso aos resultados da análise de dados em dispositivos móveis.

- **Interface Intuitiva:** Interface amigável e intuitiva para visualização e interação clara dos dados.

- **Visualização de Dados:** Implementação de gráficos, tabelas e painéis interativos para facilitar a compreensão das tendências de mercado.

- **Atualizações Constantes:** Garantia de atualizações periódicas para acesso aos dados mais recentes sobre as tendências de jogos.

## Benefícios do Projeto
Este projeto trará diversos benefícios:

- **Insights Valiosos:** Fornecimento de insights sobre tendências de gêneros de jogos para criação de jogos que atendam às demandas do mercado.

- **Vantagem Competitiva:** Capacidade de desenvolver jogos competitivos alinhados com as preferências atuais dos jogadores.

- **Tomada de Decisões Baseada em Dados:** Decisões de desenvolvimento embasadas em dados concretos, aumentando as chances de sucesso.

- **Inovação:** Contribuição para a inovação e desenvolvimento de jogos que atendam às necessidades emergentes do mercado.

## Próximos Passos
Após a conclusão deste projeto, os próximos passos incluirão:

1. **Expansão:** Ampliação do projeto para incluir outras plataformas de jogos além da Steam.

2. **Refinamento:** Melhoria contínua do processo de web scraping e análise de dados com base em feedback para maior precisão.

3. **Integração:** Integração dos insights obtidos diretamente no ciclo de desenvolvimento de jogos.

## Conclusão
O projeto **Game Stats Tracker** representa uma oportunidade valiosa para obter insights sobre as tendências do mercado de jogos e usar essas informações para orientar o desenvolvimento de novos jogos. Com a utilização das tecnologias Java, MongoDB, React e React Native, a equipe de desenvolvimento poderá criar uma solução robusta e escalável que ofereça informações cruciais para decisões estratégicas. Este projeto visa posicionar a empresa como inovadora no mercado, desenvolvendo jogos que não só acompanhem, mas antecipem as preferências dos jogadores.