<h1 align="center"><img loading="lazy" src="https://github.com/Romano-g/Literalura/assets/143983377/b8a1eed2-adda-4097-b821-ed7047abd5de" width=400px></h1>
<br>
<p align="center">
  <img loading="lazy" alt="License badge" src="https://img.shields.io/badge/LICENSE-MIT-darkgreen">
  <img loading="lazy" alt="Java Developer Kit badge" src="https://img.shields.io/badge/JDK-V17.0.10-%23eb8302">
  <img loading="lazy" alt="Status badge" src="https://img.shields.io/badge/STATUS-FINALIZADO-9400D3">
</p>
<br>
<p>
  O projeto LiterAlura foi desenvolvido durante o projeto ONE - Oracle Next Education, é um projeto focado no backend que roda no terminal utilizando o SpringBoot, a ideia aqui é o projeto buscar na API <a href="https://gutendex.com/" target="_blank">Gutendex</a> o livro desejado, e salvar o retorno da API em um banco de dados PostgreSQL!
</p>
<br>
<h2>🔨 Funcionalidades do Projeto</h2>
<br>

- `Buscar livro`: Essa opção busca o livro digitado pelo cliente na API Gutendex, e retorna o título do livro, autor, idiomas e número de downloads, salvando-o no banco de dados caso ainda não exista, os dados são formatados utilizando a biblioteca <a href="https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.15.2" target="_blank">Jackson</a>;
<br>

- `Listar livros`: Lista os livros salvos em nosso banco de dados, mostrando todas as informações (título, autor, idiomas...);
<br>
  
- `Listar autores`: Lista os autores dos livros buscados que estão salvos no banco de dados;
<br>
  
- `Buscar autores vivos em um ano`: Utilizando informações sobre o ano de nascimento e ano de morte dos autores, lista apenas os autores vivos no ano digitado pelo cliente, utilizando uma derived query JPA para realizar o retorno;
<br>
  
- `Mostrar apenas livos em português`: Utiliza uma derived query JPA para mostrar apenas os livros em que a linguagem é "Português";
<br>

<p><img loading="lazy" alt="GIF mostrando funcionamento do projeto" src="https://github.com/Romano-g/Literalura/assets/143983377/ce964c64-0250-4826-a3cd-a71797ec35fb"></p>
<br>

<h2>🛠️ Abrindo e rodando o projeto</h2>
<br>

- Baixe o arquivo e o extraia;
- No IntelliJ (ou no editor de código de sua preferência), clique em <b>"File" > "Open"</b> (ou alguma opção similar);
- Atualize o <b>"pom.xml"</b> para que o maven atualize as dependências;
- Abra as pastas <b>"src" > "main" > "java" > "br.com.alura.challenge.literalura"</b>;
- Rode o arquivo <b>"LiteraluraApplication"</b>.
<br>

<h2>✔️ Técnicas e tecnologias utilizadas</h2>
<br>

- `Java Developer Kit V17.0.10`
<br>
  
- `IntelliJ IDEA`
<br>
  
- `Jackson v2.15.2`
<br>
  
- `PostgreSQL`
<br>
  
- `Gutendex API`
