CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_language`(
											in p_countrycode char(3),
											in p_language char(30),
											in p_isofficial enum('T','F'),
											in p_percentage float(4,1)
                                        )
BEGIN

insert into countrylanguage (CountryCode, Language, IsOfficial, Percentage)
values (p_countrycode, p_language, p_isofficial, p_percentage);

END