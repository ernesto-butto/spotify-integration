[![Stories in Ready](https://badge.waffle.io/poolebu/spotify-integration.png?label=ready&title=Ready)](http://waffle.io/poolebu/spotify-integration)

Queris

Creo que lo mejor es hacer un API, RESTful, y que cindy, o yo, nos encarguemos luego de hacer el frontend.

Que aguevoneado

Usar el search para buscar ids
https://developer.spotify.com/web-api/search-item/


- Las listas de un usuario en un archivo de texto
	- Requiere que el usuario se logee	
	https://developer.spotify.com/web-api/get-list-users-playlists/
- Los tracks de un album
- Una lista con las 3 mas populares de los artistas relacionados de un artista

Album
64E5px1Lqx9zXSpQ8yoVx5


id
name
popularity
release_date
tracks
	items
	available_markets
	disc_number
	duration_ms
	explicit
	external_urls
		spotify
	href
	external_urls
	id

album_type
artists
available_markets
copyrights
external_ids
external_urls
genres
images


A la final consegui este API, https://github.com/thelinmichael/spotify-web-api-java, el cual le agregas el maven y funciona.

Vamos a utilizar entonces una app web, que le metes el id del album y funciona

