# JFEventos

- Diferente do [ListGist](http://https://github.com/JonathanFeitosa/ListGistGitHub "ListGist") que foca no modulo app, o **JFEventos** é um aplicativo focado na modularização e componentização usado por grandes empresas. Ambos trazem como benefícios: Reutilização, separação logica tornando claro o interesse de cada módulo, mais fácil para entender, testar e separar as atividades para cada membro do projeto, já que cada um trabalha em módulos/componentes separados, minumizando conflitos. Em alguns casos, possuem melhorias no build.

<img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.15.29.png?alt=media&token=c2268682-fa2a-4bdb-8999-be80cf6a0a83" width="250"> <img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.16.05.png?alt=media&token=a15fa253-cf94-475b-8df0-f280fc0c4ba3" width="250"> <img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.16.15.png?alt=media&token=03bb62b3-4085-4ec7-8959-5988179b8344" width="250">

#### Modularização

**app: **Faz a integração dos módulos e é onde fica a classe Application 
**buildSrc: **Recebe todas as dependências da aplicação.
**common:** Recebe todos os arquivos que vão ser comum em outros módulos para evitar repetição de código
**data:** Onde fica a parte da Api e Room
**domain: **Onde fica a parte dos UserCases e Models
**customViews:** Todos os componentes da aplicação
**features: **Módulos onde cada squad ou membro da equipe deve trabalhar com novas funcionalidades, minimizando conflitos.
**testUtils: **Classe de teste compartilhado para os módulos.


#### Bibliotecas

- DataBinding 
- Navigation
- ViewModel 
- Material Design 
- Retrofit 
- Koin 
- Picasso 
- SharedProcedures 
- LiveData 
- *Requisito Android 4.1+

#### Componentes

- ResumeEventView(title: String, price: BigDecimal): Componente que seta as informações resumidas do evento. Também pega as coordenadas de Lat e Long e converte no nome da Cidade e Estado.

 <img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.13.32.png?alt=media&token=2ec57dd4-f670-4135-a87f-ea169e844093" width="200">

- EventDateView (date: Long): Converte timerstamp em Data.

 <img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.13.03.png?alt=media&token=72c72339-09a3-4617-a705-296caad054b6" width="200">

- EventHourView (date: Long): Converte timerstamp em Hora.

 <img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.12.47.png?alt=media&token=a4e6c456-5eb3-4d3f-aa0c-05e3e6609fbf" width="200">

- EventLocaleView (city: String, state: String): Altera a cidade e o estado do evento

 <img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.12.25.png?alt=media&token=612140a3-e625-4468-8fc5-1eb788f1a47e" width="200">

- ResumeCheckInView(idEvent: Long, onCheckInSelected: (CheckIn) -> Unit) : Valida os campos de nome e email e chama um callback caso esteja válido.

 <img src="https://firebasestorage.googleapis.com/v0/b/cep-rural.appspot.com/o/Captura%20de%20Tela%202021-01-25%20a%CC%80s%2010.13.18.png?alt=media&token=41904326-1063-4522-b2b5-09b872e8c5dc" width="200">
