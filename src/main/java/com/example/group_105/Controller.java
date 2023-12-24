package com.example.group_105;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;
import static com.example.group_105.getDataFromExcel.Movies;

public class Controller {
    @FXML
    private Label remainder; //Object that allows remaining chance to be displayed on the screen
    @FXML
    private Button button1,button2; //button1= Guess Button //button2= New Game Button
    @FXML
    private TextField EnterYourGuess; //Text Object Asking User to Guess
    private Rectangle[] rectArray; //The Arrays That Keeps the Boxes of the Movies Features
    private Label[] labArray; //Array of Labels Holding Features
    int counter = 0;  //Counter for Correctly Entered Number of Movies
    int chance = 5;  //User's Remaining Number of Chances
    static Random r = new Random(); // Creating an object from the Random class
    static int correctRow = r.nextInt(0,251); // The computer randomly selects a movie from 250 movies
    String[] input = new String[8]; //Arrays Keeping Movie Features of Each Line
    private final String[] tested = new String[5]; //The Arrays That Checks The Movie Hasn't Been Written Before...
    private boolean test = false; //...
    int tester = 0;               //...
    @FXML
    private void clearText() {
        EnterYourGuess.clear();
    } //Clicking on the TextField clears the value.
    @FXML
    private Rectangle box, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16, box17, box18, box19, box20, box21, box22, box23, box24, box25, box26, box27, box28, box29, box30;
    @FXML
    private Label content, content2, content3, content4, content5, content6, content7, content8, content9, content10, content11, content12, content13, content14, content15, content16, content17, content18, content19, content20, content21, content22, content23, content24, content25, content26, content27, content28, content29, content30;
    @FXML
    private void getItems(int a) //Method that displays the rows with the properties when the Guess Button is clicked.
    {
        rectArray = new Rectangle[]{box, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16, box17, box18, box19, box20, box21, box22, box23, box24, box25, box26, box27, box28, box29, box30};
        labArray = new Label[]{content, content2, content3, content4, content5, content6, content7, content8, content9, content10, content11, content12, content13, content14, content15, content16, content17, content18, content19, content20, content21, content22, content23, content24, content25, content26, content27, content28, content29, content30};

        for(int i = 1; i < 7;i++)
        {
            if(Movies[correctRow][i].equals(input[i])){
                rectArray[a].setFill(Color.GREEN);}
            rectArray[a].setVisible(true);
            labArray[a].setVisible(true);
            if (input[i].length() > 15)
                labArray[a].setText(input[i].substring(0,15) + "...");
            else
                labArray[a].setText(input[i]);
            a++;
        }
        chance--;
        if(Movies[correctRow][1].equals(input[1]))
        {
            Congratulations();
        } else remainder.setText("Remaining Chance = " + chance);
    }
    @FXML
    private void onGuessButtonClick() //Each Click of the Guess Button (maximum 5 times) brings up a row.
    {
        button2.setDisable(false); //The new Game button will not be active until the Guess Button is clicked at least once.
        String target = EnterYourGuess.getText(); //Assigns the Name of the Entered Movie to an object named Target.
        boolean founded = false;
        for(int i=0;i < 251;i++){ //Checks that the Entered Movie's Name is in the Excel...
            if (Movies[i][1].equals(target)) {      //...
                System.out.println("Found: " + i + ", " + 1);
                founded = true;
                test = false;
                System.arraycopy(Movies[i], 0, input, 0, 8);
                break;
            }
        }
        if (!founded) {
            System.out.println("Not Found");
        } else
        {
            tested[tester] = input[1];
            tester++;
            for (int k = 0; k < counter; k++)
            {
                if (tested[k].equals(input[1]))
                {
                    test = true;
                    tester--;
                    break;
                }
            }
        }
        if(founded && !test) {
            if (counter == 0) {
                getItems(0);
            }
            if (counter == 1) {
                getItems(6);
            }
            if (counter == 2) {
                getItems(12);
            }
            if (counter == 3) {
                getItems(18);
            }
            if (counter == 4) {
                getItems(24);
            }
            counter++;

        } else if (test)      //If Trying to Enter the Same Movie Again,Alerts the Screen.
        {
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle ("Exception");
            alert.setHeaderText ("Incorrect entry!");
            alert.setContentText ("You entered this movie name before.");
            alert.showAndWait ().ifPresent (rs -> {
            });
        }
        else                 //If Not Found, Alerts the Screen.
        {
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle ("Exception");
            alert.setHeaderText ("Incorrect entry!");
            alert.setContentText ("Please enter a movie name that is on the list.");
            alert.showAndWait ().ifPresent (rs -> {
            });
        }
        if(chance ==0 && !Movies[correctRow][1].equals(input[1])){         //If Chance Over,Alerts the Screen.

            String text = "The correct answer is: " + Movies[correctRow][1];

            Alert alert2 = new Alert (Alert.AlertType.INFORMATION);
            alert2.setTitle ("Warning");
            alert2.setHeaderText ("Your chance to guess is over.");
            alert2.setContentText (text);
            alert2.showAndWait ().ifPresent (rs -> {
            });
            button1.setDisable(true);
        }}
    @FXML
    public void onResetButtonClick() //It is the method that restarts the game when the New Game Button is clicked.
    {
        button2.setDisable(true);
        EnterYourGuess.setText("Enter Your Guess");
        chance=5;
        remainder.setText("Remaining Chance = " + chance);
        button1.setDisable(false);
        counter =0;
        tester =0;
        correctRow = r.nextInt(0,251);// The computer randomly selects a movie from 250 movies again.
        System.out.println((getDataFromExcel.Movies[Controller.correctRow][1]));//Code that prints to console to ensure correct movie control again.
        for(int i = 0; i < 30; i++) //Clears the all rows.
        {
            rectArray[i].setVisible(false);
            rectArray[i].setFill(Color.RED);
            labArray[i].setVisible(false);
        }
    }
            private void Congratulations()  //Method that gives a Congratulatory message when you win
            {
                System.out.println("You win");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Congratulations!");
                alert.setHeaderText(null);
                alert.setContentText("You Win!");
                alert.showAndWait();
                button1.setDisable(true);
            }}