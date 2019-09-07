# Api spring boot

Esse projeto tem como finalidade apresentar a criação de uma API RESTFULL.
Banco H2, para armazenamento em memória.
Segurança básica utilizando SpringSecurity com formLogin.
Documentação da API utilizando swagger-ui.
Monitoramento utilizando SpringSecurity-Actuator, enviando as métricas para ser monitorada através do Spring-Admin.

Documentação: http://localhost:9090/swagger-ui.html#/

Monitoramento: http://localhost:9090/actuator

Banco em memória: http://localhost:9090/h2/

API

Request: GET All
http://apetitosos.com.br:9090/places

Request: GET ONE
http://localhost:9090/places/id/1

Request: POST
http://localhost:9090/places/
Exemplo: 
{
	"name":"name",
	"slug": "slug",
	"city": "city",
	"state": "state"
}

Request: PUT
http://localhost:9090/places/
Exemplo: 
{
	id: "1",	
	"name":"name",
	"slug": "slug",
	"city": "city",
	"state": "state"
}
