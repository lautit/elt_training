/* agrupar paises con cantidad de lenguajes que tengan mas de 3 lenguajes */
select		country.Name		as Country,
			count(countrylanguage.Language)
								as Languages
from		country
left join	countrylanguage
on			country.Code		= countrylanguage.CountryCode
group by	country.Code
having		count(countrylanguage.Language) > 3
order by	country.Name		asc;

/* agrupar paises con su codigo, continente, cantidad de lenguajes y poblacion */
select		country.Name		as Country,
			country.Code		as Code,
			country.Continent	as Continent,
            count(countrylanguage.Language)
								as Languages,
            country.Population	as Population
from		country
left join	countrylanguage
on			country.Code		= countrylanguage.CountryCode
group by	country.Code
order by	country.Name		asc;

/* funciona de pedo, hay que usar subconsulta */
select count(*),country.name from country;

/* con subconsulta */
select		country.Name		as Country,
			langs.CountryCode	as Code,
            country.Continent	as Continent,
			langs.Languages		as Languages,
            country.Population	as Population
from		(
				select		country.Code		as CountryCode,
							count(countrylanguage.Language)
												as Languages
                from		country
                left join	countrylanguage
                on			country.Code		= countrylanguage.CountryCode
                group by	country.Code
			)
								as langs
inner join	country                                
on			langs.CountryCode	= country.Code
group by	langs.CountryCode
order by	country.Name		asc;