SRC = 	AircraftTest.java\
		Aircraft.java\
		AircraftFactory.java\
		Baloon.java\
		./coordinates/Coordinates.java\
		Flyable.java\
		Helicopter.java\
		JetPlane.java\
		Tower.java\
		./weather/WeatherProvider.java\
		WeatherTower.java

OBJ = 	AircraftTest.class\
		Aircraft.class\
		AircraftFactory.class\
		Baloon.class\
		./coordinates/Coordinates.class\
		Flyable.class\
		Helicopter.class\
		JetPlane.class\
		Tower.class\
		./weather/WeatherProvider.class\
		WeatherTower.class


all : $(OBJ)
	
$(OBJ) : $(SRC) 
	javac $(SRC)

clean :
	rm $(OBJ)

fclean : clean

re : fclean all 

backup : 
	tar -rf backup.tar $(SRC)