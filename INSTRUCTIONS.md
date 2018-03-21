
To compile:

From within the cs1302-reversi directory:

      $ javac -d . *.java
      
      - This will compile all java files in the directory

      $ javac -d . Board.java

      - This will compile the specified java file only (in this case it is Board.java)



To run:

From within the cs1302-reversi directory:

     There are three types of [PLAYERTYPE]
     - Human
     - RandomComputerPlayer
     - IntelligentComputerPlayer


     $ java cs1302.p2.Reversi [PLAYERTYPE] [PLAYERTYPE]

     - This will run the program with the first player being assigned dark (X) and the second player being assigend light (O)

     $ java cs1302.p2.Reversi Human IntelligentComputerPlayer

     - This will create a game between the human (X) and the intelligent computer player (O)