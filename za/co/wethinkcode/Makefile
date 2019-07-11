SRC = 	AircraftTest.java\
		Aircraft.java\
		AircraftFactory.java\
		Baloon.java\
		Coordinates.java\
		Flyable.java\
		Helicopter.java\
		JetPlane.java\
		Tower.java\
		WeatherProvider.java\
		WeatherTower.java

OBJ = 	AircraftTest.class\
		Aircraft.class\
		AircraftFactory.class\
		Baloon.class\
		Coordinates.class\
		Flyable.class\
		Helicopter.class\
		JetPlane.class\
		Tower.class\
		WeatherProvider.class\
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
