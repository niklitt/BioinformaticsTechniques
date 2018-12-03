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

    private JPanel panel = new JPanel();

    private JButton theBackButton = new JButton("Back");

    private JButton theNextButton = new JButton("Start");

    private JTextArea text = new JTextArea("The purpose of this is to help determine in a biopsied tumor is benign or malignant.");

    private JLabel pinkRibbon = new JLabel(new ImageIcon("../Data/pink_ribbon.png"));

    private static double[] userArray = new double[30];

    private static int whereInArray = 0; //Will count where the user currently is in the array

    static final String[] theTextArray = {"Please enter 1", "Please enter 2"};

    private boolean isBenign;

    public JavaFX() {
        super("Breast Cancer Awareness");

        panel.setLayout(new GridLayout(3,3));

        theBackButton.setVisible(true);
        theBackButton.setEnabled(true);
        theBackButton.setPreferredSize(new Dimension(100,50));
//        theBackButton.addActionListener(onClickBack);

        theNextButton.setVisible(true);
        theNextButton.setEnabled(true);
        theBackButton.setPreferredSize(new Dimension(100,50));

        text.setLineWrap(true);

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
        panel.add(pinkSpa);
        panel.add(theBackButton);
        panel.add(pinkSp);
        panel.add(theNextButton);
        panel.add(pinkS);
        panel.add(new TextArea("hello"));


        Container container = getContentPane();
        container.add(text, BorderLayout.NORTH);
        container.add(panel,BorderLayout.CENTER);
        this.add(panel,BorderLayout.CENTER);
        container.setBackground(Color.pink);
        panel.setBackground(Color.pink);
        setSize(275,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.print("Hello world..\n");

        JavaFX calculator = new JavaFX();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class onClickBegin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            whereInArray = 0; // Just in case it isn't already set for some reason
            Button button = new Button();
            button.setVisible(true);
            button.setEnabled(true);
        }

    }

    class onClickNext implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            whereInArray++;
            // If not a number, then change textfield to say that it needs to be a number

        }

    }

    class onClickBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            whereInArray--;

        }

    }

    class onClickSubmit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            Use the Tree and the Naive Bayes tests to determine and then use an if statement then print to the TextArea
//            Button IDs:  theBackButton, theNextButton
//            TextArea ID: text
            whereInArray = 0;

            if (isBenign) {
                text.setText("Based on the given information, there is a 93.15% chance the tumor is Benign!");
            } else if (!isBenign) {
                text.setText("Based on the given information, there is a 93.15% chance the tumor is Malignant.");
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

         static final String[] theTextArray = {"Please enter 1", "Please enter 2"};


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

 }

