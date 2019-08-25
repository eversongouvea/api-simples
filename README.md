# api-simples
Api spring boot


RESTFULL API Usage Example

Selecting All Place
Request: GET
http://apetitosos.com.br:9090/places

Selecting 1 place
Request: GET
http://apetitosos.com.br:9090/places/id/1

Selecting place list
Request: GET
http://apetitosos.com.br:9090/places/name/shopping

Creando  place
Request: POST
http://apetitosos.com.br:9090/places/
Exemplo: 
{
		
	"name":"name",
	"slug": "slug",
	"city": "city",
	"state": "state"
}


Edit  place
Request: PUT
http://apetitosos.com.br:9090/places/
Exemplo: 
{
	id: "1",	
	"name":"name",
	"slug": "slug",
	"city": "city",
	"state": "state"
}
