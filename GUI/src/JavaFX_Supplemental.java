import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class JavaFX_Supplemental {

    //Pass in the data that the user has input, this function will return true if it is malignant or false if benign
    public boolean bayes(double data[]) {

        double mProb=1;
        double bProb=1;

        //radius mean
        if (data[0] > 17.46)
        {
            mProb = multiply(mProb,.49);
            bProb = multiply(bProb,.002);
        }
        else if (data[0] < 12.1476)
        {
            mProb = multiply(mProb,.028);
            bProb = multiply(bProb,.484);
        }
        else
        {
            mProb = multiply(mProb,.48);
            bProb = multiply(bProb,.5126);
        }

        //text mean
        if (data[1] > 21.6044)
        {
            mProb = multiply(mProb,.45);
            bProb = multiply(bProb,.1428);
        }
        else if (data[1]<17.9157)
        {
            mProb = multiply(mProb,.146);
            bProb = multiply(bProb,.5518);
        }
        else
        {
            mProb = multiply(mProb,.40);
            bProb = multiply(bProb,.3053);
        }


        //permimter mean
        if (data[2] > 115.3598)
        {
            mProb = multiply(mProb,47);
            bProb = multiply(bProb,0);
        }
        else if (data[2]<78.0707)
        {
            mProb = multiply(mProb,.023);
            bProb = multiply(bProb,.4957);
        }
        else
        {
            mProb = multiply(mProb,.50);
            bProb = multiply(bProb,.504);
        }


        //area mean
        if (data[3] > 978.4195)
        {
            mProb = multiply(mProb, .471);
            bProb = multiply(bProb,.0028);
        }
        else if (data[3]<462.8318)
        {
            mProb = multiply(mProb,.028);
            bProb = multiply(bProb,.515);
        }
        else
        {
            mProb = multiply(mProb,.5);
            bProb = multiply(bProb, .4817);
        }


        //smoothness mean
        if (data[4] > .1029)
        {
            mProb = multiply(mProb, .476);
            bProb = multiply(bProb,.212);
        }
        else if (data[4]< .0925)
        {
            mProb = multiply(mProb, .212);
            bProb = multiply(bProb, .535);
        }
        else
        {
            mProb = multiply(mProb,.311);
            bProb = multiply(bProb,.252);
        }


        //compact mean
        if (data[5] > .1452)
        {
            mProb = multiply(mProb, .439);
            bProb = multiply(bProb, .0448);
        }
        else if (data[5]<.0801)
        {
            mProb = multiply(mProb, .089);
            bProb = multiply(bProb,.5882);
        }
        else
        {
            mProb = multiply(mProb, .471);
            bProb = multiply( bProb, .3669);
        }


        //concavity mean
        if (data[6] > .1608)
        {
            mProb = multiply(mProb, .443);
            bProb = multiply(bProb, .014);
        }
        else if (data[6]<.0461)
        {
            mProb = multiply(mProb, .033);
            bProb = multiply(bProb, .6635);
        }
        else
        {
            mProb = multiply(mProb, .524);
            bProb = multiply(bProb, .3529);
        }


        //concavity points mean
        if (data[7] > .088)
        {
            mProb = multiply(mProb, .448);
            bProb = multiply(bProb,0);
        }
        else if (data[7]<.0257)
        {
            mProb = multiply(mProb,.009);
            bProb = multiply(bProb, .5602);
        }
        else
        {
            mProb = multiply(mProb,542);
            bProb = multiply(bProb, .4397);
        }


        //sym mean
        if (data[8] > .1929)
        {
            mProb = multiply(mProb, .448);
            bProb = multiply(bProb, .210);
        }
        else if (data[8]<.1742)
        {
            mProb = multiply(mProb, .254);
            bProb = multiply(bProb, .5546);
        }
        else
        {
            mProb = multiply(mProb, .297);
            bProb = multiply(bProb, .235);
        }


        //radius standard error
        if (data[10] > .609)
        {
            mProb = multiply(mProb, .4009);
            bProb = multiply(bProb, .014);
        }
        else if (data[10]< .2841)
        {
            mProb = multiply(mProb, .108);
            bProb = multiply(bProb, .582);
        }
        else
        {
            mProb = multiply(mProb, .491);
            bProb = multiply(bProb, .4033);
        }


        //perm standard error
        if (data[12] > 4.3246)
        {
            mProb = multiply(mProb, .368);
            bProb = multiply(bProb, .014);
        }
        else if (data[12]<1.9996)
        {
            mProb = multiply(mProb, .0943);
            bProb = multiply(bProb, .571);
        }
        else
        {
            mProb = multiply(mProb, .538);
            bProb = multiply(bProb, .414);
        }


        //area standard error
        if (data[13] > 72.6586)
        {
            mProb = multiply(mProb, .372);
            bProb = multiply(bProb, .002);
        }
        else if (data[13]< 21.1241)
        {
            mProb = multiply(mProb,.0613);
            bProb = multiply(bProb,.6022);
        }
        else
        {
            mProb = multiply(mProb, .566);
            bProb = multiply(bProb, .395);
        }


        //compact standard error
        if (data[15] > .0323)
        {
            mProb = multiply(mProb, .386);
            bProb = multiply(bProb, .171);
        }
        else if (data[15]< .0214)
        {
            mProb = multiply(mProb, .2877);
            bProb = multiply(bProb, .667);
        }
        else
        {
            mProb = multiply(mProb, .3245);
            bProb = multiply(bProb, .162);
        }


        //concave standard error
        if (data[16] > .0418)
        {
            mProb = multiply(mProb, .4103);
            bProb = multiply(bProb, .157);
        }
        else if (data[16]<.026)
        {
            mProb = multiply(mProb, .207);
            bProb = multiply(bProb, .678);
        }
        else
        {
            mProb = multiply(mProb, .382);
            bProb =  multiply(bProb, .165);
        }


        //concave points standard error
        if (data[17] > .0151)
        {
            mProb = multiply(mProb, .4103);
            bProb = multiply(bProb, .1288);
        }
        else if (data[17]< .0099)
        {
            mProb = multiply(mProb, .1509);
            bProb = multiply(bProb, .574);
        }
        else
        {
            mProb = multiply(mProb, .4386);
            bProb = multiply(bProb, .2969);
        }

        //fractal dimension standard error
        if (data[19] > .0041)
        {
            mProb = multiply(mProb, .4009);
            bProb = multiply(bProb, .261);
        }
        else if (data[19]< .0036)
        {
            mProb = multiply(mProb, .471);
            bProb = multiply(bProb, .672);
        }
        else
        {
            mProb = multiply(mProb, .1273);
            bProb = multiply(bProb, .067);
        }


        //radius worst
        if (data[20] > 21.1354)
        {
            mProb = multiply(mProb, .457);
            bProb = multiply(bProb, 0);
        }
        else if (data[20]< 13.379)
        {
            mProb = multiply(mProb, .014);
            bProb = multiply(bProb, .51);
        }
        else
        {
            mProb = multiply(mProb, .528);
            bProb = multiply(bProb, .49);
        }


        //texture worst
        if (data[21] > 29.3185)
        {
            mProb = multiply(mProb, .4905);
            bProb = multiply(bProb, .129);
        }
        else if (data[21]< 23.516)
        {
            mProb = multiply(mProb, .1179);
            bProb = multiply(bProb, .560);
        }
        else
        {
            mProb = multiply(mProb, .391);
            bProb = multiply(bProb, .311);
        }


        //perimeter worst
        if (data[22] > 141.3742)
        {
            mProb = multiply(mProb, .457);
            bProb = multiply(bProb, 0);
        }
        else if (data[22]< 87.0012)
        {
            mProb = multiply(mProb, .0047);
            bProb = multiply(bProb, .507);
        }
        else
        {
            mProb = multiply(mProb, .5377);
            bProb = multiply(bProb, .493);
        }


        //area worst
        if (data[23] > 1422.3622)
        {
            mProb = multiply(mProb, .429);
            bProb = multiply(bProb, 0);
        }
        else if (data[23]< 558.7776)
        {
            mProb = multiply(mProb, .014);
            bProb = multiply(bProb, .532);
        }
        else
        {
            mProb = multiply(mProb, .5566);
            bProb = multiply(bProb, .468);
        }


        //smoothness worst
        if (data[24] > .1448)
        {
            mProb = multiply(mProb, .466);
            bProb = multiply(bProb, .1457);
        }
        else if (data[24]< .125)
        {
            mProb = multiply(mProb, .1886);
            bProb = multiply(bProb, .499);
        }
        else
        {
            mProb = multiply(mProb, .344);
            bProb = multiply(bProb, .356);
        }

        //compact worst
        if (data[25] > .3748)
        {
            mProb = multiply(mProb, .448);
            bProb = multiply(bProb, .0392);
        }
        else if (data[25]< .1827)
        {
            mProb = multiply(mProb, .0801);
            bProb = multiply(bProb, .580);
        }
        else
        {
            mProb = multiply(mProb, .4716);
            bProb = multiply(bProb, .381);
        }


        //concave worst
        if (data[26] > .4507)
        {
            mProb = multiply(mProb, .415);
            bProb = multiply(bProb, .0336);
        }
        else if (data[26]< .1663)
        {
            mProb = multiply(mProb, .0235);
            bProb = multiply(bProb, .591);
        }
        else
        {
            mProb = multiply(mProb, .5613);
            bProb = multiply(bProb, .3253);
        }


        //concave points worst
        if (data[27] > .1822)
        {
            mProb = multiply(mProb, .4905);
            bProb = multiply(bProb, 0);
        }
        else if (data[27]< .0744)
        {
            mProb = multiply(mProb, .014);
            bProb = multiply(bProb, .501);
        }
        else
        {
            mProb = multiply(mProb,.4905);
            bProb = multiply(bProb, .499);
        }


        //sym worst
        if (data[28] > .3235)
        {
            mProb = multiply(mProb, .346);
            bProb = multiply(bProb, .092);
        }
        else if (data[28]< .2702)
        {
            mProb = multiply(mProb, .2122);
            bProb = multiply(bProb, .521);
        }
        else
        {
            mProb = multiply(mProb, .3915);
            bProb = multiply(bProb, .387);
        }


        mProb = mProb * .372;
        bProb = bProb * (1-.372);


        double actualMal = mProb/(mProb+bProb);
        double actualBen = bProb/(mProb+bProb);

        if (actualMal > actualBen)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public double multiply (double currentProd,double nextProd)
    {
        return currentProd*nextProd;
    }

    //pass in the data from the user. this function will return "late" for late stage cancer, "early" for early
    //stage cancer, and "inconclusive" if they can't be clustered
    public String cluster(double data[]) {
        double late = 1;
        double early = 1;

        //smoothness mean
        if (data[4] > .1116 )
        {
            late = multiply(late, .301);
            early = multiply(early, .0625);
        }
        else if (data[4] < .0972)
        {
            late = multiply(late, .084);
            early = multiply(early, .492);
        }
        else
        {
            late = multiply(late, .6144);
            early = multiply(early, .4453);
        }

        //compactness mean
        if (data[5] > 1943 )
        {
            late = multiply(late, .4216);
            early = multiply(early, .007);
        }
        else if ( data[5] < .1128)
        {
            late = multiply(late, 0);
            early = multiply(early, .6908);
        }
        else
        {
            late = multiply(late, .5783);
            early = multiply(early, .539);
        }

        //concavity mean
        if (data[6]> .2299)
        {
            late = multiply(late, .3855);
            early = multiply(early, 0);
        }
        else if (data[6]<.1152)
        {
            late = multiply(late, 0);
            early = multiply(early, .507);
        }
        else
        {
            late = multiply(late, .6144);
            early = multiply(early, .492);
        }

        //points of concavity mean
        if (data[7] > .1164 )
        {
            late = multiply(late, .4337);
            early = multiply(early, .007);
        }
        else if (data[7] < .0693)
        {
            late = multiply(late, .036);
            early = multiply(early, .515);
        }
        else
        {
            late = multiply(late, .5301);
            early = multiply(early, .476);
        }

        //concavity worst
        if (data[26] > .6015)
        {
            late = multiply(late, .4457);
            early = multiply(early, .007);
        }
        else if (data[26] < .3474)
        {
            late = multiply(late, .024);
            early = multiply(early, .5);
        }
        else
        {
            late = multiply(late, .5301);
            early = multiply(early, .492);
        }

        //concavity points worst
        if (data[27] > .2196)
        {
            late = multiply(late, .4579);
            early = multiply(early, .039);
        }
        else if (data[27] < .1568)
        {
            late = multiply(late, .012);
            early = multiply(early, .492);
        }
        else
        {
            late = multiply(late, .5301);
            early = multiply(early, .469);
        }

        late = late * .3933;
        early = early * (1-.3933);

        double probLate = late/(late+early);
        double probEarly = early/(early+late);

        if (probLate > probEarly)
        {
            return "late";
        }
        else if (probLate == probEarly)
        {
            return "inconclusive";
        }
        else
        {
            return "early";
        }
    }

}
