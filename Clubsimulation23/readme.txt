Club Simulation - Readme

This README provides instructions on how to run the Club Simulation code on a Linux terminal.

1. Using Makefile:
   - Open a terminal.
   - Navigate to the directory containing the source code files (e.g., `src` directory).
   - Run the following command to compile the code using the Makefile:
     ```
     make
     ```
   - Once compiled, you can run the simulation using the following command:
     ```
     java -cp bin ClubSimulation
     ```

2. Compiling and Running Directly:
   - Open a terminal.
   - Navigate to the directory containing the source code files (e.g., `src` directory).
   - Compile the code using the following command:
     ```
     javac -d bin -cp bin -sourcepath src src/clubSimulation/*.java
     ```
   - Once compiled, you can run the simulation using the following command:
     ```
     java -cp bin ClubSimulation
     ```

Note:
- The simulation will start and display the GUI window with the animation.
- Use the "Start" button to initiate the simulation, "Pause" button to pause/resume, and "Quit" button to exit.
- The simulation will display the movement of patrons inside the club according to the specified rules.

Please make sure you have Java installed on your system. If you encounter any issues, ensure that you are in the correct directory containing the source code files.
Enjoy the simulation!
