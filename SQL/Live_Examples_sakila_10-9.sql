/* listar todos los actores con sus peliculas */
/**
film -> film_id
actor -> actor_id

film_actor -> film_id, actor_id
**/
select		concat(actor.last_name, ', ', actor.first_name)
								as Actor,
            film.title			as Movie
from		actor
inner join	film_actor
on			actor.actor_id		= film_actor.actor_id
inner join	film
on			film.film_id		= film_actor.film_id
order by	Actor;

/* listar actores con peliculas e idiomas */
select		concat(actor.last_name, ', ', actor.first_name)
								as Actor,
            film.title			as Movie,
            language.name		as Language
from		actor
inner join	film_actor
on			actor.actor_id		= film_actor.actor_id
inner join	film
on			film.film_id		= film_actor.film_id
inner join	language
on			film.language_id	= language.language_id
order by	Actor;

/* listar actores con peliculas e idiomas originales */
select		concat(actor.last_name, ', ', actor.first_name)
										as Actor,
            film.title					as Movie,
            language.name				as Language,
            orig_lang.name				as OrigLang
from		actor
inner join	film_actor
on			actor.actor_id				= film_actor.actor_id
inner join	film
on			film.film_id				= film_actor.film_id
inner join	language
on			film.language_id			= language.language_id
left join	language					as orig_lang
on			film.original_language_id	= orig_lang.language_id
order by	Actor;

/* listar actores y cantidad de peliculas */
select		concat(actor.last_name, ', ', actor.first_name)
									as Actor,
			count(film_actor.film_id)
									as Films
from		film_actor
inner join	actor
on			actor.actor_id			= film_actor.actor_id
group by	actor.actor_id
order by	Actor;

/* con subconsulta */
select		concat(actor.last_name, ', ', actor.first_name)
								as Actor,
			films.film_count	as Films
from		(
				select		film_actor.actor_id		as actor_id,
							count(film_actor.film_id)
													as film_count
				from		film_actor
                group by	actor_id
            )
								as films
inner join	actor
on			actor.actor_id		= films.actor_id
order by	Actor;