/**********************************************************************************
 * *Name: Nikita Mattingly
 * *Date: May 5, 2019
 * *File: unittest4.c (village)
 * *References: Used cardtest4.c and testUpdateCoins.c provided by the instructor
 * ********************************************************************************/ 
#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

#define TESTCARD "VILLAGE"

int main()
{
   
    int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
  
    //used to randomize the result for shuffling
    int seed = 1000;
    
    //the number of players
    int numPlayers = 2;

    int thisPlayer = 0;

    //holds a pointer to the gameState variable, in this case we have G and testG
    struct gameState G, testG;

    //an array k of 10 kingdom cards avaliable for purchase
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse, sea_hag, tribute, smithy, council_room};

    // initialize a game state and player cards
	initializeGame(numPlayers, k, seed, &G);

    printf("----------------- Testing Card: %s ----------------\n", TESTCARD);

    // copy the game state to a test case
	memcpy(&testG, &G, sizeof(struct gameState));
	choice1 = 1;
	
    
    //initializing cardEffect function for the village card
    cardEffect(village, choice1, choice2, choice3, &testG, handpos, &bonus);
    
    thisPlayer = whoseTurn(&testG);

    //UNIT TEST: CHECK TO SEE IF +1 ACTION WAS ADDED
	if(testG.numActions+2 == G.numActions)
		printf("PASSED: TWO ACTION POINTS ADDED\n");
	else
		printf("FAILED: TWO ACTION POINTS NOT ADDED\n");
 
 printf("\n >>>>> SUCCESS: Testing complete %s <<<<<\n\n", TESTCARD);

 return 0;
}
