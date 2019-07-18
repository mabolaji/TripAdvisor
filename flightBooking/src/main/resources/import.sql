

-- # //Airline
INSERT INTO flightbook.Airlines VALUES (null,'American Airlines');
INSERT INTO flightbook.Airlines VALUES (null,'Rwandan Airlines');
INSERT INTO flightbook.Airlines VALUES (null,'Ethiopian Airlines');
INSERT INTO flightbook.Airlines VALUES (null,'Lagos Airlines');

-- # //Airport
INSERT INTO flightbook.Airport  VALUES (null,'Airport001', 'Addis Abeba', 'Ethiopian', 'Addis Airport');
INSERT INTO flightbook.Airport  VALUES (null,'Airport002', 'kigali', 'Rwanda', 'Kanombe');
INSERT INTO flightbook.Airport  VALUES (null,'Airport003', 'Lagos', 'Nigeria', 'Lagos Airport');
INSERT INTO flightbook.Airport  VALUES (null,'Airport004', 'DC', 'USA', 'DC Airport');
INSERT INTO flightbook.Airport  VALUES (null,'Airport005', 'Chicago', 'USA', 'Chicago Airport');
INSERT INTO flightbook.Airport  VALUES (null,'Airport006', 'Toronto', 'Canda', 'Toronto Airport');
INSERT INTO flightbook.Airport VALUES (null,'Airport007', 'Bruxelles', 'Belgium', 'Bruxelles Airport');

-- # //airplanes
INSERT INTO flightbook.Airplanes VALUES (null,'airplane001', '100', 1);
INSERT INTO flightbook.Airplanes VALUES (null,'airplane002', '150', 1);
INSERT INTO flightbook.Airplanes VALUES (null,'airplane003', '200', 1);
INSERT INTO flightbook.Airplanes  VALUES (null,'airplane004', '250', 2);
INSERT INTO flightbook.Airplanes  VALUES (null,'airplane005', '200', 2);
INSERT INTO flightbook.Airplanes  VALUES (null,'airplane006', '250', 3);
INSERT INTO flightbook.Airplanes  VALUES (null,'airplane007', '100', 3);
INSERT INTO flightbook.Airplanes  VALUES (null,'airplane010', '150', 4);
INSERT INTO flightbook.Airplanes  VALUES (null,'airplane008', '250', 4);

--   //Flight
INSERT INTO flightbook.Flight VALUES (null,'2019-07-25 00:00:00', '2019-07-14 00:00:00', 'Flight001', 1, 1, 3, 5);
INSERT INTO flightbook.flight  VALUES (null,'2019-07-23 00:00:00', '2019-07-22 00:00:00', 'Flight002', 2, 4, 7, 4);
INSERT INTO flightbook.flight  VALUES (null,'2019-07-25 00:00:00', '2019-07-14 00:00:00', 'Flight003', 2, 4, 3, 5);
INSERT INTO flightbook.flight  VALUES (null,'2019-07-23 00:00:00', '2019-07-22 00:00:00', 'Flight004', 3, 6, 7, 4);
INSERT INTO flightbook.flight  VALUES (null,'2019-07-25 00:00:00', '2019-07-14 00:00:00', 'Flight005', 3, 6, 3, 5);
INSERT INTO flightbook.flight  VALUES (null,'2019-07-23 00:00:00', '2019-07-22 00:00:00', 'Flight006', 2, 2, 7, 4);

