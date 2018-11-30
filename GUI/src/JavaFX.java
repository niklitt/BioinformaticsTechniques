//

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*****************************
 * onClickBegin - clear screen, first input screen,
 * onClickNext - add to counter, go to the next input value
 * onClickBack - decrease counter, go to the most recent input value ONLY IF THERE IS TIME TO WRITE
 * onClickSubmit - clear screen, performs the analysis and prediction, spits out prediction and accuracy
 *****************************/

public class JavaFX extends Application {

    private static int whereInArray = 0; //Will count where the user currently is in the array
    private static int[] userArray = new int[30];

    public static void main(String[] args) {
        System.out.print("Hello world..\n");
//        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Breast Cancer Awareness");
        stage.show();

    }



    public void J48_Tree() {
        /**************
         *
          Where the classifier code will go
         Going to read in the lines that the user puts into the GUI and then temporarily save them
         If any feature is missing, then it will be filled in with the average value
         Once the values are saved, we run it down the tree
         Output how its classified and the percent

         id,radius_mean,texture_mean,perimeter_mean,area_mean,smoothness_mean,compactness_mean,concavity_mean,concave points_mean,symmetry_mean,fractal_dimension_mean,radius_se,texture_se,perimeter_se,area_se,smoothness_se,compactness_se,concavity_se,concave points_se,symmetry_se,fractal_dimension_se,radius_worst,texture_worst,perimeter_worst,area_worst,smoothness_worst,compactness_worst,concavity_worst,concave points_worst,symmetry_worst,fractal_dimension_worst,diagnosis

         area_worst is column
         concave points_worst is column
         concavity_mean is column
         area_se is column
         texture_worst is column
         texture_mean is column
         radius_mean is column
         texture_se is column
         perimeter_se is column

        **************/

        userArray[whereInArray] = 0; // Where the counter currently is, change to this value


    }

 }

