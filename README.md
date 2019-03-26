# Mars Rover Demo

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth. A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintains the same heading. Assume that the square directly North from (x, y) is (x, y+1).

### INPUT
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation.

Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.

### OUTPUT
The output for each rover should be its final co-ordinates and heading.

### INPUT AND OUTPUT
#### Test Input:
5 5  
1 2 N  
LMLMLMLMM  
3 3 E  
MMRMMRMRRM  

#### Expected Output:
1 3 N  
5 1 E

# Assumptions

When designing the Mars Rover application, following assumptions were made.

* When a Plateau is created, the bottom right co-ordinates are always (0, 0)
* The square directly North from (x, y) is (x, y + 1)
* Upper limits of the plateau is given will create a virtual grid. Eg. If (5, 5) coordinates given, the plateau will be a 6x6 grid.
* Input for the application will be taken from a file.
* Rover first scouts and validate the coordinates before movement.

# Design

The appilication has few main classes and interfaces.

1. Plateau
2. Rover
3. Position
4. Direction (Interface)  
    * NorthDirection  
    * EastDirection  
    * SouthDirection  
    * WestDirection  

The application was designed in a way that only the necessary methods for initialization movement etc. are made public and all other methods are made private. By implementing the application this way ensures that only the desired methods can be invoked. Intialization of the **Plateau** class is performed via a static method using only the given string command. Also initilization of the **Rover** class can also be performed via a static method given the correct string command. 

**Plateau** class follows a singleton pattern because it is more sensible to have a only a single instance of plateau available for the application given the scenario. This class has only a single public method, which is to initilize the plateau.

**Rover** class has public methods to initilizing, movement and aquiring the coordinates and the directions of the rover at a given time. Rover is first initialized using the input given. If the command is invalid exception is throwm. Also if the coordinates of the deployment is invalid exception is thrown. When doing a movement, the input command is validated. 

> The movement process is designed in a way that the rover first scouts the given coordinate and if the coordinate of the postion is valid then the positon is updated. This way is appropriate since validation after movement in a real scenario is dangerous.

**Direction** interface has methods which return a subclass of implementing it based on the direction of turning. The claases implemetiong the **Direction** interface are "NorthDirection", "EastDirection", "SouthDirection" and "WestDirection". Each returns a direction from their left and right.

The input for the application is taken using a file. Although getting the input through commandline is possible. Reading a file seemed appropriate for the scenario. The file is validated while throwing necessary exceptions.

The main method read the file and process the list of commands line by line and then process each command.

# Development Environment

The application was developed using,

* Java SE1.8
* JUnit (Test tool)
* Apache Maven (Build Tool)
* Spring Tool Suite (IDE)
