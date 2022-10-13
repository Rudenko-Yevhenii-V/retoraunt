# retoraunt 

SQL: 
1 select * from Country c
where 400 < all (select s.Population 
            from City s
            where s.CountryID = c.CountryID);


2 select * from Country c
where 0 = (select COUNT(1)
    from City s
        JOIN Building B ON B.CityID = S.CityID
    where s.CountryID = c.CountryID);
