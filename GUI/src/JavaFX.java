//


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*****************************
 * onClickBegin - clear screen, first input screen,
 * onClickNext - add to counter, go to the next input value
 * onClickBack - decrease counter, go to the most recent input value ONLY IF THERE IS TIME TO WRITE
 * onClickSubmit - clear screen, performs the analysis and prediction, spits out prediction and accuracy
 *****************************/

public class JavaFX extends JFrame {

    public static void main(String[] args) {
        JavaFX calculator = new JavaFX();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel panel = new JPanel();

    private JButton theStartButton = new JButton("Start");

    private JButton theBackButton = new JButton("Back");

    private JButton theNextButton = new JButton("Next");

    private JButton theSubmitButton = new JButton("Submit");

    private JTextArea text = new JTextArea("The purpose of this is to help determine in a biopsied tumor is benign or malignant.");

    private JTextArea inputArea = new JTextArea("Enter input here");

    private JLabel pinkRibbon = new JLabel(new ImageIcon("../Data/pink_ribbon.png"));

    private static double[] userArray = new double[30];

    private static int whereInArray = 0; //Will count where the user currently is in the array

    private static final String[] textArray = {"Please enter the mean of distances from center to points on the perimeter(radius_mean)", "Please enter the standard deviation of gray-scale values(texture_mean)", "Please enter the mean size of the core tumor(perimeter_mean)", "Please enter the mean area of the tumor(area_mean)", "Please enter the mean of local variation in radius lengths(smoothness_mean)"
            , "Please enter the mean of perimeter^2 / area - 1.0 (compactness_mean)", "Please enter the mean of severity of concave portions of the contour(concavity_mean)", "Please enter the mean for number of concave portions of the contour(concave points_mean)", "Please enter the mean of symmetry(symmetry_mean)", "Please enter the mean for \"coastline approximation\" - 1 (fractal_dimension_mean)"
            , "Please enter the standard error for the mean of distances from center to points on the perimeter (radius_se)", "Please enter the standard error for standard deviation of gray-scale values(texture_se)", "Please enter the standard error of the size of the core tumor(perimeter_se)", "Please enter the standard error of the area of the tumor(area_se)", "Please enter the standard error for local variation in radius lengths(smoothness_se)"
            , "Please enter the standard error for perimeter^2 / area - 1.0(compactness_se)", "Please enter the standard error for severity of concave portions of the contour(concavity_se)", "Please enter the standard error for number of concave portions of the contour(concave points_se)", "Please enter the standard error of symmetry(symmetry_se)", "Please enter the standard error for \"coastline approximation\" - 1 (fractal_dimension_se)"
            , "Please enter the \"worst\" or largest mean value for mean of distances from center to points on the perimeter(radius_worst)", "Please enter the \"worst\" or largest mean value for standard deviation of gray-scale values(texture_worst)", "Please enter the \"worst\" or largest mean value of the size of the core tumor(perimeter_worst)", "Please enter the \"worst\" or largest mean value of the area of the tumor(area_worst)", "Please enter the \"worst\" or largest mean value for local variation in radius lengths(smoothness_worst)"
            , "Please enter the \"worst\" or largest mean value for perimeter^2 / area - 1.0 (compactness_worst)", "Please enter the \"worst\" or largest mean value for severity of concave portions of the contour(concavity_worst)", "Please enter the \"worst\" or largest mean value for number of concave portions of the contour(concave points_worst)", "Please enter the \"worst\" or largest mean value of symmetry(symmetry_worst)", "Please enter the \"worst\" or largest mean value for \"coastline approximation\" - 1 (fractal_dimension_worst)"};

    private boolean isBenign;

    public JavaFX() {
        super("Breast Cancer Awareness");

        for(int i = 0; i < 30; i++) {
            userArray[i] = 0.0;
        }

        panel.setLayout(new GridLayout(3,3));

        theStartButton.setVisible(true);
        theStartButton.setEnabled(true);
        theStartButton.addActionListener(new onClickBegin());

        theBackButton.setVisible(false);
        theBackButton.setEnabled(false);
        theBackButton.addActionListener(new onClickBack());

        theNextButton.setVisible(false);
        theNextButton.setEnabled(false);
        theNextButton.addActionListener(new onClickNext());

        theSubmitButton.setVisible(false);
        theSubmitButton.setEnabled(false);
        theSubmitButton.addActionListener(new onClickSubmit());

        text.setLineWrap(true);
        inputArea.setEnabled(false);
        inputArea.setVisible(false);

//        BufferedImage myPicture = ImageIO.read(new File("../../pink_ribbon.png"));
//        pinkRibbon = new JLabel(new ImageIcon(myPicture));
        pinkRibbon.setIcon(new ImageIcon("../../Data/pink_ribbon.png"));
        pinkRibbon.setVisible(true);

        // Formats the GridLayout
        JPanel pinkSpace = new JPanel();
        pinkSpace.setBackground(Color.pink);
        JPanel pinkSp = new JPanel();
        pinkSp.setBackground(Color.pink);
        JPanel pinkSpa = new JPanel();
        pinkSpa.setBackground(Color.pink);
        JPanel pinkSpac = new JPanel();
        pinkSpac.setBackground(Color.pink);
        pinkSpac.add(pinkRibbon);
        JPanel pinkS = new JPanel();
        pinkS.setBackground(Color.pink);
        panel.add(pinkSpace);
        panel.add(pinkSpac);
        panel.add(theSubmitButton);
        panel.add(theBackButton);
        panel.add(theStartButton);
        panel.add(theNextButton);
        panel.add(pinkS);
        panel.add(inputArea);


        Container container = getContentPane();
        container.add(text, BorderLayout.NORTH);
        container.add(panel,BorderLayout.CENTER);
        this.add(panel,BorderLayout.CENTER);
        container.setBackground(Color.pink);
        panel.setBackground(Color.pink);
        setSize(425,250);
        setVisible(true);
    }

    class onClickBegin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            whereInArray = 0; // Just in case it isn't already set for some reason

            theNextButton.setVisible(true);
            theNextButton.setEnabled(true);

            inputArea.setVisible(true);
            inputArea.setEnabled(true);

            theStartButton.setEnabled(false);
            theStartButton.setVisible(false);

            text.setText(textArray[whereInArray]);

        }

    }

    class onClickNext implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(isNumeric(inputArea.getText())) {

                if(whereInArray == 0) { // Enables the back button to use after the first click of the next button
                    theBackButton.setVisible(true);
                    theBackButton.setEnabled(true);
                }

                userArray[whereInArray] = Double.parseDouble(inputArea.getText());

                whereInArray++;
                text.setText(textArray[whereInArray]);

                if(whereInArray == 29) {
                    theNextButton.setEnabled(false); // Disables the next and back button after all values are entered
                    theNextButton.setVisible(false);

                    theSubmitButton.setEnabled(true);
                    theSubmitButton.setVisible(true);
                }

            } else {
                text.setText("Please enter a number. " + textArray[whereInArray]);
            }

        }

    }

    class onClickBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(whereInArray == 1) { // Disables the back button if there is nowhere left to go
                theBackButton.setEnabled(false);
                theBackButton.setVisible(false);
            }

            whereInArray--;
            text.setText(textArray[whereInArray]);

        }

    }

    class onClickSubmit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            Use the Tree and the Naive Bayes tests to determine and then use an if statement then print to the TextArea
//            Button IDs:  theBackButton, theNextButton
//            TextArea ID: text

            if(isNumeric(inputArea.getText())) {

                theBackButton.setVisible(false);
                theBackButton.setEnabled(false);

                J48_Tree();
                JavaFX_Supplemental tester = null;
//                Boolean bayesTest = tester.bayes(userArray);

                userArray[whereInArray] = Double.parseDouble(inputArea.getText());

                if (isBenign) {
                    text.setText("Based on the given information, there is a 93.15% chance the tumor is benign!");
                } else if (!isBenign) {

//                    String lateInconclusiveEarly = tester.cluster(userArray);
                    text.setText("Based on the given information, there is a 93.15% chance the tumor is malignant. ");
//                    + "The stage of the tumor is " + lateInconclusiveEarly);

                }

            } else {
                text.setText("Please enter a number. " + textArray[whereInArray]);
            }

        }

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

         ID IS NOT COUNTED AS A COLUMN, BECAUSE USER DOES NOT ENTER IT

         area_worst is column 23
         concave points_worst is column 27
         concavity_mean is column 6
         area_se is column 13
         texture_worst is column 21
         texture_mean is column 1
         radius_mean is column 0
         texture_se is column 11
         perimeter_se is column 12

        **************/

        if(userArray[23] <= 880.8) {
            // Area worst: less than or equal to 880.8

            if(userArray[27] <= .1357) {
                // Concave points worst: less than or equal to .1357

                if(userArray[13] <= 36.46) {
                    // area_se is less than or equal to 36.46 then benign
                    isBenign = true;

                } else {
                    // area_se is greater than 36.46

                    if(userArray[0] <= 14.97) {
                        // radius_mean is less than or equal to 14.97

                        if(userArray[11] <= 1.978) {
                            // texture_se is less than or equal to 1.978 then it is benign
                            isBenign = true;
                        } else {
                            // texture_se is greater than 1.978

                            if(userArray[11] <=2.239) {
                                // texture_se is less than or equal to 2.239 then it is malignant
                                isBenign = false;

                            } else {
                                // texture_se is greater than 2.239 then it is benign
                                isBenign = true;
                            }

                        }

                    } else {
                        // radius_mean is greater than 14.97 is malignant
                        isBenign = false;
                    }

                }

            } else {
                // Concave points worst: greater than .1357

            }

        } else {
            // Area worst: greater than 880.8

            if(userArray[6] > .0716) {
                // Malignant if concavity_mean is greater than .0716
                isBenign = false;

            } else {
                if(userArray[1] > 19.54) {
                    // Malignant if texture_mean is greater than 19.54
                    isBenign = false;
                } else {
                    // If not, then benign
                    isBenign = true;
                }
            }

        }

    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

 }

