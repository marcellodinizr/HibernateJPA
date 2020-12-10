# JAVA Hibernate/JPA
Desenvolvimento de uma camada de acesso a dados com JPA/Hibernate para um fragmento de um sistema de Imobiliária

Nota: Para este laboratório deverá ser criado um projeto Maven com a ferramenta de
sua preferência.
Regras gerais nessa etapa:

• Deverão ser criadas as classes do modelo que representam as entidades do
banco juntamente com os seus relacionamentos.

• Poderá ser utilizado qualquer banco de dados relacional.

Funcionalidade que deverão ser fornecidas nesta etapa (camada de acesso a dados):

PARTE 1: Defina as classes do modelo com os mapeamentos JPA.
Deverão serem criadas as classes do modelo que representam as entidades do
banco juntamente com os seus relacionamentos e os mapeamentos JPA de
acordo com a modelagem apresentado anteriormente. Poderá ser utilizado
qualquer banco de dados relacional.

Parte 2: Implementação da Camada de Acesso a Dados
Implementar a camada de acesso a dados com os CRUDs
 Você deverá utilizar o padrão Repository, também deverá criar um DAO
Genérico para reutilizar os códigos semelhantes.

 Cadastro de Imóveis (inserir, remover, atualizar e listar todos os imóveis
cadastrados).

 Cadastro de Locação (inserir, atualizar, remover e listar todas as locações
agrupadas por cliente), associando um imóvel a um cliente (inquilino).

 Cadastro de Alugueis (inserir, remover e listar todos os alugueis de um
determinado inquilino).
