>Prof. Ricardo I. A. e Silva Laboratório de Computação II

#  Lista de Atividades sobre Tabelas de Dispersão
-----------------------------------------------------------------------------
 Para fazer esta lista, parta do projeto Tabelas Dispersao, clique <a href="https://github.com/Unifil/Laboratorio-Computacao-II/blob/master/4%C2%B0%20Bimestre/tabelas_dispersao.zip?raw=true" target="_blank">aqui</a> para baixar o projeto.

1. A implementação inicial da tabela de dispersão do pacote desta atividade é funcional, porém muito simples. Seu principal problema é não verificar inserções que causem colisões
de dispersão. Portanto, implemente as seguintes políticas para tratamento de colisões:

 - <a href="http://www.lcad.icmc.usp.br/~nonato/ED/Hashing/node39.html" target="_blank">Encadeamento separado:</a> utilização de listas encadeadas em cada posição da tabela.
 

 ![Tabela de hash](http://i.imgur.com/H1o38CW.png)
 
 - Expansão: sempre que a tabela atingir 100% de ocupação em relação a ``tabela.length``
 ou alguma lista encadeada ficar maior que 3 elementos, a tabela dobra de tamanho. Lembre-se de reinserir os elementos na nova tabela utilizando a nova função de dispersão (hash).

2. A classe `Ingresso` representa o ingresso que uma pessoa adquire para assistir a uma
peça de teatro. Ela contém informações sobre o horário e local de assento do espectador. Sobrescreva o seu método `hashCode()`, para que ela gere um valor de dispersão
condizente com as políticas de `hashCode()` do Java (ver [3]).

3. O tratamento de colisões da atividade anterior é totalmente funcional e é o mais simples
de ser implementado, porém não é o que apresenta melhor desempenho, em especial
quanto a acessos e ocupação de memória. Nesta atividade, pesquise e estude em [2, 1]
sobre a técnica de endereçamento aberto e implemente-a.

4. Implemente a classe `Entrada< K, V >`, que representa uma entrada em mapas e dicionários.

5. Implemente a TAD Mapa, baseada em `Entrada< K, V >`, que possui as seguintes operações:

 `tamanho(): Retorna o número de entradas do mapa.`
 
 `estaVazia() Indica se o mapa está vazio.`
 
 `recuperar(k): Recupera o elemento associado à chave k, ou retorna null se não existir.`
 
 `inserir(k, v): Insere uma entrada (k, v), onde k é a chave e v é o elemento.`
 
 `remover(k): Remove a entrada referente à chave k.`
 
 `chaves(): Retorna uma coleção com todas as chaves do mapa.`
 
 `elementos(): Retorna uma coleção com todos os elementos do mapa.`
 
 `entradas(): Retorna uma coleção com todas as entradas do mapa.`

6. Implemente a TAD Dicionário, baseada em Entrada< K, V >, que possui as seguintes
operações:`

 `tamanho(): Retorna o número de entradas do dicionário.`
 
 `estaVazia() Indica se o dicionário está vazio.`
 
 `encontrar(k): Recupera um elemento associado à chave k, ou retorna null se não houver nenhum.`
 
 `encontrarTodos(k): Recupera todos os elementos associados à chave k, ou retorna null se não houver nenhum.`
 
 `inserir(k, v): Insere uma entrada (k, v), onde k é a chave e v é o elemento.`
 
 `remover(e): Remove a entrada e.`
 
 `entradas(): Retorna uma coleção com todas as entradas do mapa.`

7. Apresente a análise de complexidade assintótica para todas as operações de Mapa e Dicionário.

## Referências 
 > :book: CORMEN, Thomas H. et al. Algoritmos: teoria e prática. Rio de Janeiro: Campus, 2012. 926 p. ISBN 978-85-352-3699-6.
 
 > :book: GOODRICH, Michael T.; TAMASSIA, Roberto. Estruturas de dados e algoritmos em Java. 4. ed. Porto Alegre: Bookman, 2007. 600 p. ISBN 9788560031504.
 
 >  :coffee:ORACLE. Object (Java Platform SE 7). Disponível em: <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()" target="_blank">javase/7/docs/api/java/lang/Object.html#hashCode()"</a>
