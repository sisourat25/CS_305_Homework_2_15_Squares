/*
*Connor Sisourath
* 29 Feb 2023
* This class controls the 2d array that corresponds to the grid of buttons. It includes public instance
* variables and methods that will detect a win, detect a valid move, mix the sequence of strings, and
* switch the strings in the array.
 */




package com.example.cs305homework215squares;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SquareModel {
    public ArrayList<String> nums;
    public String[][] arr = new String[4][4];
    public boolean firstClicked = false;
    public Button firstButton;
    public Button secondButton;
    public int firstPosX;
    public int firstPosY;
    public int secondPosX;
    public int secondPosY;

    /*
     *generateRandomSquares
     * @return type: boolean
     * This method will generate a sequence of random strings from 1-15 and a space.
     */
    public void generateRandomSquares() {

        //initializing the array list to have numbers 1-15 and a space
        nums = new ArrayList<>(Arrays.asList(" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"));

        //offset find the total number of elements in the arraylist
        int offset = 0;

        //iterating though the array to randomly add a number from the arraylist from a random index
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                Random rand = new Random();
                int randomNum = rand.nextInt(16 - offset);
                arr[i][j] = nums.get(randomNum);

                //removing the randomNum from the array list and iterating offset
                nums.remove(randomNum);
                offset++;
            }
        }
    }

    /*
     *validMove
     * @return type: boolean
     * This method if the move is valid and will switch the strings in the array of it is
     */
    public boolean validMove() {

        //getting the strings of each button
        String firstButtonString = firstButton.getText().toString();
        String secondButtonString = secondButton.getText().toString();


        //fist checking if each does not contain a number
        if (firstButtonString.equals(" ") || secondButtonString.equals(" ")) {

            //next four cases are checked if the squares are next to each other
            //case 1: if it is then the strings are switched and returns true
            if ((firstPosX == secondPosX) && (firstPosY == (secondPosY + 1))) {
                String temp = arr[firstPosX][firstPosY];
                arr[firstPosX][firstPosY] = arr[secondPosX][secondPosY];
                arr[secondPosX][secondPosY] = temp;
                return true;
            }

            //case 2: if it is then the strings are switched and returns true
            else if ((firstPosX == secondPosX) && (firstPosY == (secondPosY - 1))) {
                String temp = arr[firstPosX][firstPosY];
                arr[firstPosX][firstPosY] = arr[secondPosX][secondPosY];
                arr[secondPosX][secondPosY] = temp;
                return true;
            }

            //case 3: if it is then the strings are switched and returns true
            else if ((firstPosX == (secondPosX + 1)) && (firstPosY == secondPosY)) {
                String temp = arr[firstPosX][firstPosY];
                arr[firstPosX][firstPosY] = arr[secondPosX][secondPosY];
                arr[secondPosX][secondPosY] = temp;
                return true;
            }

            //case 4: if it is then the strings are switched and returns true
            else if ((firstPosX == (secondPosX - 1)) && (firstPosY == secondPosY)) {
                String temp = arr[firstPosX][firstPosY];
                arr[firstPosX][firstPosY] = arr[secondPosX][secondPosY];
                arr[secondPosX][secondPosY] = temp;
                return true;
            }

            //case 5: if they are not next to each other then returns false.
            else {
                return false;
            }
        }

        //else they contain numbers then false is returned
        else {
            return false;
        }
    }

    /*
     *determineWin
     * @return type: boolean
     * This method checks the array of strings to see if they are in order
     */
    public boolean determineWin() {
        //counter variable initialized to 1
        int counter = 1;

        //flag initialized to 0 and assuming it is in order
        int flag = 0;

        //iterating through the 2d array to see if it matches the counter
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {

                //once at the end of the array, break since the string must be a space
                if (counter == 16) {
                    break;
                }

                //once an element of the array doesn't match the counter, break and raise the flag
                if(!arr[i][j].equals(Integer.toString(counter))) {
                    flag = 1;
                    break;
                }

                //iterate counter
                counter++;
            }
        }

        //if flag is raised then return false
        if(flag == 1) {
            return false;
        }

        //else the array is in order and return true
        else {
            return true;
        }
    }
}
