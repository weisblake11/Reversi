
I implemented the IntelligentComputer Player

My intelligent computer player first checks to see if it has an available move in one of the corners of the grid. After playing reversi online I came to realize the most important strategy is to gain control of the corners because they cannot be overturned. If it is unable to play in the corner, it then loops through all available spaces and calculates the number of opponent pawns it would flip over if placed in that spot. After looping through all available sopts, it chooses the spot that will maximize the number of opponent pawns to be flipped over. 

This CPU has a win rate of about 80-90% vs. the RandomCPU.