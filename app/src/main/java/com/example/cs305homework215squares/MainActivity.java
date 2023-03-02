/*
 *Connor Sisourath
 * 29 Feb 2023
 * This file controls buttons in the game. it has an instance of the SquareModel where its instance
 * variables align with the grid of buttons.
 */

package com.example.cs305homework215squares;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //instance of SquareModel
    private SquareModel instancesm;

    //the background layout to change the color
    private View backgroundLayout;

    //the reset button to reset the board
    private Button resetButton;

    //an array of buttons that correspond to the grid of buttons
    private Button[][] buttonArr= new Button[4][4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing the instance of the SquareModel class
        instancesm = new SquareModel();

        //finding the resetButton
        resetButton = findViewById(R.id.rb);

        //finding each button in the array
        backgroundLayout = findViewById(R.id.myLayout);
        buttonArr[0][0] = findViewById(R.id.button00);
        buttonArr[0][1] = findViewById(R.id.button01);
        buttonArr[0][2] = findViewById(R.id.button02);
        buttonArr[0][3] = findViewById(R.id.button03);
        buttonArr[1][0] = findViewById(R.id.button10);
        buttonArr[1][1] = findViewById(R.id.button11);
        buttonArr[1][2] = findViewById(R.id.button12);
        buttonArr[1][3] = findViewById(R.id.button13);
        buttonArr[2][0] = findViewById(R.id.button20);
        buttonArr[2][1] = findViewById(R.id.button21);
        buttonArr[2][2] = findViewById(R.id.button22);
        buttonArr[2][3] = findViewById(R.id.button23);
        buttonArr[3][0] = findViewById(R.id.button30);
        buttonArr[3][1] = findViewById(R.id.button31);
        buttonArr[3][2] = findViewById(R.id.button32);
        buttonArr[3][3] = findViewById(R.id.button33);

        //calling the method to randomize the sequence of strings
        instancesm.generateRandomSquares();

        //setting the text of each button corresponding to the array
        for(int i = 0; i < buttonArr.length; i++) {
            for (int j = 0; j < buttonArr[i].length; j++) {
                buttonArr[i][j].setText(instancesm.arr[i][j]);
            }
        }

        //defining listeners for all the buttons
        resetButton.setOnClickListener(new resetButtonListener());
        buttonArr[0][0].setOnClickListener(new b00Listener());
        buttonArr[0][1].setOnClickListener(new b01Listener());
        buttonArr[0][2].setOnClickListener(new b02Listener());
        buttonArr[0][3].setOnClickListener(new b03Listener());
        buttonArr[1][0].setOnClickListener(new b10Listener());
        buttonArr[1][1].setOnClickListener(new b11Listener());
        buttonArr[1][2].setOnClickListener(new b12Listener());
        buttonArr[1][3].setOnClickListener(new b13Listener());
        buttonArr[2][0].setOnClickListener(new b20Listener());
        buttonArr[2][1].setOnClickListener(new b21Listener());
        buttonArr[2][2].setOnClickListener(new b22Listener());
        buttonArr[2][3].setOnClickListener(new b23Listener());
        buttonArr[3][0].setOnClickListener(new b30Listener());
        buttonArr[3][1].setOnClickListener(new b31Listener());
        buttonArr[3][2].setOnClickListener(new b32Listener());
        buttonArr[3][3].setOnClickListener(new b33Listener());
    }


    private class resetButtonListener implements OnClickListener {
        public void onClick(View view) {
            //generating a new sequence of strings
            instancesm.generateRandomSquares();

            //setting the text of each button corresponding to the array
            for(int i = 0; i < buttonArr.length; i++) {
                for (int j = 0; j < buttonArr[i].length; j++) {
                    buttonArr[i][j].setText(instancesm.arr[i][j]);
                }
            }

            //setting the background color back to white
            backgroundLayout.setBackgroundColor(Color.rgb(255, 255, 255));

            //setting the firstClicked instance variable back to false
            instancesm.firstClicked = false;

        }
    }

    //creating a subclass for a button listener that implements the onClick for every button
    private class b00Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[0][0];
                instancesm.firstPosX = 0;
                instancesm.firstPosY = 0;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[0][0];
                instancesm.secondPosX = 0;
                instancesm.secondPosY = 0;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[0][0].setText(instancesm.arr[0][0]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    //creating a subclass for a button listener that implements the onClick for every button
    private class b01Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[0][1];
                instancesm.firstPosX = 0;
                instancesm.firstPosY = 1;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[0][1];
                instancesm.secondPosX = 0;
                instancesm.secondPosY = 1;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[0][1].setText(instancesm.arr[0][1]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    //creating a subclass for a button listener that implements the onClick for every button
    private class b02Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[0][2];
                instancesm.firstPosX = 0;
                instancesm.firstPosY = 2;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[0][2];
                instancesm.secondPosX = 0;
                instancesm.secondPosY = 2;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[0][2].setText(instancesm.arr[0][2]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    //creating a subclass for a button listener that implements the onClick for every button
    private class b03Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[0][3];
                instancesm.firstPosX = 0;
                instancesm.firstPosY = 3;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[0][3];
                instancesm.secondPosX = 0;
                instancesm.secondPosY = 3;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[0][3].setText(instancesm.arr[0][3]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


//creating a subclass for a button listener that implements the onClick for every button
    private class b10Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[1][0];
                instancesm.firstPosX = 1;
                instancesm.firstPosY = 0;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[1][0];
                instancesm.secondPosX = 1;
                instancesm.secondPosY = 0;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[1][0].setText(instancesm.arr[1][0]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    //creating a subclass for a button listener that implements the onClick for every button
    private class b11Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[1][1];
                instancesm.firstPosX = 1;
                instancesm.firstPosY = 1;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[1][1];
                instancesm.secondPosX = 1;
                instancesm.secondPosY = 1;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[1][1].setText(instancesm.arr[1][1]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    //creating a subclass for a button listener that implements the onClick for every button
    private class b12Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[1][2];
                instancesm.firstPosX = 1;
                instancesm.firstPosY = 2;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[1][2];
                instancesm.secondPosX = 1;
                instancesm.secondPosY = 2;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[1][2].setText(instancesm.arr[1][2]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    //creating a subclass for a button listener that implements the onClick for every button
    private class b13Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[1][3];
                instancesm.firstPosX = 1;
                instancesm.firstPosY = 3;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[1][3];
                instancesm.secondPosX = 1;
                instancesm.secondPosY = 3;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[1][3].setText(instancesm.arr[1][3]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    //creating a subclass for a button listener that implements the onClick for every button
    private class b20Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[2][0];
                instancesm.firstPosX = 2;
                instancesm.firstPosY = 0;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[2][0];
                instancesm.secondPosX = 2;
                instancesm.secondPosY = 0;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[2][0].setText(instancesm.arr[2][0]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }

    private class b21Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[2][1];
                instancesm.firstPosX = 2;
                instancesm.firstPosY = 1;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[2][1];
                instancesm.secondPosX = 2;
                instancesm.secondPosY = 1;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[2][1].setText(instancesm.arr[2][1]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    private class b22Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[2][2];
                instancesm.firstPosX = 2;
                instancesm.firstPosY = 2;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[2][2];
                instancesm.secondPosX = 2;
                instancesm.secondPosY = 2;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[2][2].setText(instancesm.arr[2][2]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }

    private class b23Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[2][3];
                instancesm.firstPosX = 2;
                instancesm.firstPosY = 3;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[2][3];
                instancesm.secondPosX = 2;
                instancesm.secondPosY = 3;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[2][3].setText(instancesm.arr[2][3]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    private class b30Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[3][0];
                instancesm.firstPosX = 3;
                instancesm.firstPosY = 0;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[3][0];
                instancesm.secondPosX = 3;
                instancesm.secondPosY = 0;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[3][0].setText(instancesm.arr[3][0]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }

    private class b31Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[3][1];
                instancesm.firstPosX = 3;
                instancesm.firstPosY = 1;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[3][1];
                instancesm.secondPosX = 3;
                instancesm.secondPosY = 1;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[3][1].setText(instancesm.arr[3][1]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    private class b32Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[3][2];
                instancesm.firstPosX = 3;
                instancesm.firstPosY = 2;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[3][2];
                instancesm.secondPosX = 3;
                instancesm.secondPosY = 2;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[3][2].setText(instancesm.arr[3][2]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }


    private class b33Listener implements OnClickListener {
        public void onClick(View view) {
            //checking if the first button in the sequence of 2 has been clicked
            if(instancesm.firstClicked == false) {
                //if it has not then this button and its array indexes is set to the instance variables of the SquareModel class
                instancesm.firstButton = buttonArr[3][3];
                instancesm.firstPosX = 3;
                instancesm.firstPosY = 3;

                //setting the firstChecked instance variable to true to get it ready for the next click
                instancesm.firstClicked = true;

            }
            else{
                //if this is the second button clicked then this button and its array indexes is set to the instance variables
                instancesm.secondButton = buttonArr[3][3];
                instancesm.secondPosX = 3;
                instancesm.secondPosY = 3;
                //checking if it was a valid move
                if (instancesm.validMove() == true) {

                    //setting the text of the first and second button
                    buttonArr[3][3].setText(instancesm.arr[3][3]);
                    buttonArr[instancesm.firstPosX][instancesm.firstPosY].setText(instancesm.arr[instancesm.firstPosX][instancesm.firstPosY]);

                    //setting the background to green if a win is detected.
                    if (instancesm.determineWin() == true) {
                        backgroundLayout.setBackgroundColor(Color.rgb(0, 200, 0));
                    }
                }
                //setting the firstChecked instance variable to false to restart the cycle
                instancesm.firstClicked = false;
            }
        }
    }
}