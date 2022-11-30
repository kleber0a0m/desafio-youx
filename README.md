## Olá 👋
Esse projeto é uma aplicação web completa com frontend, backend.
O sistema é capaz de armazenar as vendas e os seus respectivos clientes.

### Frontend
No frontend foi utilizado HTML, CSS, Bootstrap e Java Script, juntamente com o framework react.

#### Algumas telas do sistema:
![enter image description here](https://raw.githubusercontent.com/kleber0a0m/links-youtube/main/imagens/d030h5q4.JPG)
-------------------------------------
![enter image description here](https://raw.githubusercontent.com/kleber0a0m/links-youtube/main/imagens/7ajmef89.JPG)
-----------------------------------
| ![enter image description here](https://raw.githubusercontent.com/kleber0a0m/links-youtube/main/imagens/91d83jks.JPG) | ![enter image description here](https://raw.githubusercontent.com/kleber0a0m/links-youtube/main/imagens/937rcyx5.JPG) |
|--|--|
| ![enter image description here](https://raw.githubusercontent.com/kleber0a0m/links-youtube/main/imagens/4558x48x.JPG) | ![enter image description here](https://raw.githubusercontent.com/kleber0a0m/links-youtube/main/imagens/6n67ab4e.JPG) |
-----------------------------------

### Backend
No backend foi utilizado o framework Spring Boot e banco de dados PostgreSQL. 
A API criada tem os seguintes endpoints:

##### Clientes

 - **[GET]/clients**
 - 
 Retorna um JSON com os clientes cadastrados, permite paginação.

  - **[GET]/clients/all**
  - 
 Retorna um JSON com todos os clientes cadastrados, não permite paginação.
 
   - **[GET]/clients/find/?search=**
   - 
 Retorna um JSON com o resultado da busca por CNPJ ou Nome de clientes, permite paginação.
 
    - **[GET]/clients/findById/{id}**
    
 Retorna um JSON com o cliente de id = `{id}`
 
   - **[POST]/clients/add**
   - 
Adiciona um cliente com base nas informações recebidas.

   - **[PUT]/clients/update/{id}**
   - 
Edita o cliente de id = `{id}` com base nas informações recebidas.

   - **[DELETE]/clients/delete/{id}**
   - 
Exclui o cliente de id = `{id}`.

##### Vendas
   - **[GET]/sales**
   - 
 Retorna um JSON com as vendas cadastrados, permite paginação.
 
   - **[GET]/sales/find/?search=**
   - 
 Retorna um JSON com o as vendas relacionadas com o Cliente que tenha contenham `{search}` no nome.

   - **[GET]/sales/findById/{id}**
   - 
 Retorna um JSON com o cliente de id = `{id}`

   - **[POST]/sales/add**
   - 
Adiciona uma venda com base nas informações recebidas.

   - **[PUT]/sales/update/{id}**
   - 
Edita o a venda de id = `{id}` com base nas informações recebidas.

   - **[DELETE]/sales/delete/{id}**
   - 
Exclui a venda de id = `{id}`.

   - **[GET]/sales/report**
   - 
 Retorna um JSON com informações sobre quantidade vendida e o valor por mês.
