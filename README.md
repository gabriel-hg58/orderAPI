This project is basically an API created with SpringBoot in order to add and consume a queue with RabbitMQ and store data in an H2 database.\
\
EndPoints for API are:\
\
For Customers\
GET - localhost:9000/cliente/lista - List all stored clients\
GET - localhost:9000/cliente/{id} - Display client with such id\
POST - localhost:9000/cliente/ - Add a client\
PUT - localhost:9000/cliente/ - Update or add a client\
DELETE - localhost:9000/cliente/{id} - delete client with such id\
\
For Products\
GET - localhost:9000/produto/lista - List all stored products\
GET - localhost:9000/produto/{id} - Display product with such id\
POST - localhost:9000/produto/ - Add a product\
PUT - localhost:9000/produto/ - Update or add a product\
DELETE - localhost:9000/produto/{id} - delete product with such id\
\
For Orders\
GET - localhost:9000/pedido/list - List all stored orders\
GET - localhost:9000/pedido/{id} - Display order with such id\
POST - localhost:9000/pedido/ - Add a order\
PUT - localhost:9000/pedido/ - Update or add a order\
\
For Deliveries\
GET - localhost:9000/entrega/lista - List all stored deliveries\
GET - localhost:9000/entrega/{id} - Display delivery with such id\
\
To add or update this data use these JSON templates.\
\
Client:\
{\
  "idClient": 0,\
  "clientName": "Name Client"\
}\
\
Product:\
{\
  "idProduct": 0,\
  "productName": "Name Product",\
  "productValue": "10.00"\
}\
\
Order:\
{\
  "idClient": 1,\
  "idProduct": [1, 2, 3],\
  "address": {\
    "idAddress": 0,\
    "street": "Street Name",\
    "establishmentNumber": 123,\
    "neighborhood": "Neighborhood Name",\
    "complement": "Complement Name",\
    "zipCode": "Zip Code"\
  }\
}
