/****************************************
 * Name: Nikita Mattingly
 * Date: May 11, 2019
 * File: testme.c
 * Description: CS362 Random Test Quiz
 * *************************************/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>

/*******************************************************************************
 * Function Name: char inputChar()
 * Parameters: None
 * Description: A random function generates ASCII numbers from 32 to 125 and
 * stores the result into the testRandom variable. 
 * Return: testRandom
 * *****************************************************************************/
char inputChar()
{
  char testRandom = rand() % (125 + 1 - 32) + 32;
   
   return testRandom;
}

/*******************************************************************************
 * Function Name: char *inputString()
 * Parameters: None
 * Description: A static character array is created for 'reset\0'. Using ASCII
 * code, the array will fill up by using a for loop with random ASCII code from 
 * 0 to 116 ('t').
 * Return: array
 * *****************************************************************************/
char *inputString()
{
   static char array[6];
   int k;
   for (k = 0; k < 5; k++)
   {
     array[k] = (rand()%16) + 101;
   }

   return array;
}

void testme()
{
  int tcCount = 0;
  char *s;
  char c;
  int state = 0;
  while (1)
  {
    tcCount++;
    c = inputChar();
    s = inputString();
    printf("Iteration %d: c = %c, s = %s, state = %d\n", tcCount, c, s, state);

    if (c == '[' && state == 0) state = 1;
    if (c == '(' && state == 1) state = 2;
    if (c == '{' && state == 2) state = 3;
    if (c == ' '&& state == 3) state = 4;
    if (c == 'a' && state == 4) state = 5;
    if (c == 'x' && state == 5) state = 6;
    if (c == '}' && state == 6) state = 7;
    if (c == ')' && state == 7) state = 8;
    if (c == ']' && state == 8) state = 9;
    if (s[0] == 'r' && s[1] == 'e'
       && s[2] == 's' && s[3] == 'e'
       && s[4] == 't' && s[5] == '\0'
       && state == 9)
    {
      printf("error ");
      exit(200);
    }
  }
}


int main(int argc, char *argv[])
{
    srand(time(NULL));
    testme();
    return 0;
}
