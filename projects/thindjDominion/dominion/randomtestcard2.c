/**********************************************************************************
 * *Name: Nikita Mattingly
 * *Date: May 19, 2019
 * *File: randomtestcard2.c (council room)
 * *References: Used cardtest4.c and testUpdateCoins.c provided by the instructor
 * ********************************************************************************/ 
#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

#define TESTCARD "council room"

int main()
{
    int i; 
    int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
    int temp;
    

    int thisPlayer = 0;

    //holds a pointer to the gameState variable, in this case we have G and testG
    struct gameState G, testG;

    //an array k of 10 kingdom cards avaliable for purchase
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse, sea_hag, tribute, smithy, council_room};


    for (i = 0; i < 50; i++)
    {

        int numPlayers = (rand() % 50);
        int seed = (rand() % 1000);
    
        // initialize a game state and player cards
	    initializeGame(numPlayers, k, seed, &G);

        printf("----------------- Testing Card: %s ----------------\n", TESTCARD);

        // copy the game state to a test case
	    memcpy(&testG, &G, sizeof(struct gameState));
	    choice1 = 1;
	    
        //initializing cardEffect function for the council room card
        cardEffect(council_room, choice1, choice2, choice3, &testG, handpos, &bonus);
    
        thisPlayer = whoseTurn(&testG);

        //Test 1: Testing to see if the player has the Council Room card within their hand
        if (G.hand[thisPlayer][testG.handCount[thisPlayer]] != 1)
            printf("TEST 1 PASSED: THE PLAYER HAS THE COUNCIL ROOM CARD\n");
        else
            printf("TEST 1 FAILED: THE PLAYER DOES NOT HAVE THE COUNCIL ROOM CARD\n");

    
        //Test 2: Test to see if the player played the council room card
        if(testG.playedCardCount+2 == G.playedCardCount)
            printf("TEST 2 PASSED: THE PLAYER PLAYED THE COUNCIL ROOMCARD\n");
        else
            printf("TEST 2 FAILED: THE PLAYER DID NOT PLAY THE COUNCIL ROOM CARD\n");

        //Test 3: Test to see if the council room card is discarded from the hand

        if (testG.discardCount[thisPlayer] == G.discardCount[thisPlayer])
            printf("TEST 4: PASSED. COUNCIL ROOM CARD WAS DISCARDED\n");
        else
            printf("TEST 4: FAILED. COUNCIL ROOM CARD NOT DISCARDED\n");


        printf("\n >>>>> SUCCESS: Testing complete %s <<<<<\n\n", TESTCARD);

    }
return 0;
    
}