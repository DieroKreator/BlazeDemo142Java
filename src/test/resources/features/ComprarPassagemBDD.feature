#language: pt
Funcionalidade: Comprar Passagem
    Escolher e comprar passagens aereas

    Cenario: Comprar com Sucesso
        Dado que acesso o site "https://blazedemo.com/"
        Quando seleciono a origem "São Paolo" e destino "Cairo"
        E clico no botao Find Flights
        Entao visualiza a lista de voos

    Esquema do Cenario: Comprar com Sucesso DDT
        Dado que acesso o site "https://blazedemo.com/"
        Quando seleciono a <origem> e <destino>
        E clico no botao Find Flights
        Entao visualiza a lista de voos
    Exemplos:
    | origem      | destino    |
    | "São Paolo" | "Cairo"    |
    | "Boston"    | "London"   |

    # Quando houve um OU é melhor separar em 2 ou mais Cenario
 #   Cenario: Cadastro Cliente
 #       Dado que acesso a pagina de cadastro de cliente
 #       Entao escolho entre PF OU PJ
 #       E preencho os dados cadastrais
 #       Quando clico em Salvar
 #       Entao exibe a mensagem de Cadastrado com Sucesso!

 #   Cenario: Cadastro Cliente PF
 #       Dado que acesso a pagina de cadastro de cliente
 #       Entao escolho o tipo "PF"
 #       E preencho o Nome, CPF e data de nascimento
 #       E preencho o telefone e o email
 #       Quando clico em Salvar
 #       Entao exibe a mensagem de Cadastrado com Sucesso!

 #   Cenario: Cadastro Cliente PJ
 #       Dado que entro na pagina de cadastro do cliente
 #       Entao escolho entre "PJ"
 #       E preencho a Razao Social, CNPJ e a data de fundacao
 #       E preencho o telefone e o email
 #       Quando clico em Salvar
 #       Entao exibe a mensagem de Cadastrado com Sucesso!