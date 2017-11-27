package KNNGui;

import knnModel.MLFeatureComplex;
import knnModel.MLNumber;
import knnModel.MLString;
import knnModel.MLTuple;
/**
 * This class holds a test set of data that was provided by the professor
 * */
public class test {

	
	
	public static void main(String[] args) {
		MLTuple t1 = new MLTuple(1);
    	
    	MLFeatureComplex ball1 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance1 = new MLNumber("Distance", 1.9);
    	MLNumber ballDirection1 = new MLNumber("Direction", -167);
    	ball1.addFeature(ballDistance1);
    	ball1.addFeature(ballDirection1);
 
    	MLFeatureComplex goal1 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance1 = new MLNumber("Distance", 63.8);
    	MLNumber goalDirection1 = new MLNumber("Direction", 31);
    	goal1.addFeature(goalDistance1);
    	goal1.addFeature(goalDirection1);
    	
    	MLFeatureComplex flags1 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct1 = new MLFeatureComplex("fct");
    	MLNumber fctDistance1 = new MLNumber("Distance", 39.1);
    	MLNumber fctDirection1 = new MLNumber("Direction", -41);
    	fct1.addFeature(fctDistance1);
    	fct1.addFeature(fctDirection1);

    	
    	MLFeatureComplex fcb1 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance1 = new MLNumber("Distance");
    	MLNumber fcbDirection1 = new MLNumber("Direction");
    	fcb1.addFeature(fcbDirection1);
    	fcb1.addFeature(fcbDistance1);
    	flags1.addFeature(fct1);
    	flags1.addFeature(fcb1);
    	
    	MLString action1 = new MLString("Action", "Kick");
    	
    	t1.addAttributes(ball1);
		t1.addAttributes(goal1);
		t1.addAttributes(flags1);
		t1.addAttributes(action1);
		
		
		MLTuple t2 = new MLTuple(2);
    	
    	MLFeatureComplex ball2 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance2 = new MLNumber("Distance", 1.9);
    	MLNumber ballDirection2 = new MLNumber("Direction", 50);
    	ball2.addFeature(ballDistance2);
    	ball2.addFeature(ballDirection2);
 
    	MLFeatureComplex goal2 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance2 = new MLNumber("Distance", 63.8);
    	MLNumber goalDirection2 = new MLNumber("Direction", 31);
    	goal2.addFeature(goalDistance2);
    	goal2.addFeature(goalDirection2);
    	
    	MLFeatureComplex flags2 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct2 = new MLFeatureComplex("fct");
    	MLNumber fctDistance2 = new MLNumber("Distance", 39.1);
    	MLNumber fctDirection2 = new MLNumber("Direction", -41);
    	fct2.addFeature(fctDistance2);
    	fct2.addFeature(fctDirection2);

    	
    	MLFeatureComplex fcb2 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance2 = new MLNumber("Distance");
    	MLNumber fcbDirection2 = new MLNumber("Direction");
    	fcb2.addFeature(fcbDirection2);
    	fcb2.addFeature(fcbDistance2);
    	flags2.addFeature(fct2);
    	flags2.addFeature(fcb2);
    	
    	MLString action2 = new MLString("Action", "Kick");
    	
    	t2.addAttributes(ball2);
		t2.addAttributes(goal2);
		t2.addAttributes(flags2);
		t2.addAttributes(action2);
		
		
		MLTuple t3 = new MLTuple(3);
    	
    	MLFeatureComplex ball3 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance3 = new MLNumber("Distance", 1.8);
    	MLNumber ballDirection3 = new MLNumber("Direction", 2);
    	ball3.addFeature(ballDistance3);
    	ball3.addFeature(ballDirection3);
 
    	MLFeatureComplex goal3 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance3 = new MLNumber("Distance", 61.9);
    	MLNumber goalDirection3 = new MLNumber("Direction", -4);
    	goal3.addFeature(goalDistance3);
    	goal3.addFeature(goalDirection3);
    	
    	MLFeatureComplex flags3 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct3 = new MLFeatureComplex("fct");
    	MLNumber fctDistance3 = new MLNumber("Distance");
    	MLNumber fctDirection3 = new MLNumber("Direction");
    	fct3.addFeature(fctDistance3);
    	fct3.addFeature(fctDirection3);

    	
    	MLFeatureComplex fcb3 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance3 = new MLNumber("Distance");
    	MLNumber fcbDirection3 = new MLNumber("Direction");
    	fcb3.addFeature(fcbDirection3);
    	fcb3.addFeature(fcbDistance3);
    	flags3.addFeature(fct3);
    	flags3.addFeature(fcb3);
    	
    	MLString action3 = new MLString("Action", "Kick");
    	
    	t3.addAttributes(ball3);
		t3.addAttributes(goal3);
		t3.addAttributes(flags3);
		t3.addAttributes(action3);
		
		
		MLTuple t4 = new MLTuple(4);
    	
    	MLFeatureComplex ball4 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance4 = new MLNumber("Distance", 1.8);
    	MLNumber ballDirection4 = new MLNumber("Direction", -85);
    	ball4.addFeature(ballDistance4);
    	ball4.addFeature(ballDirection4);
 
    	MLFeatureComplex goal4 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance4 = new MLNumber("Distance", 53.5);
    	MLNumber goalDirection4 = new MLNumber("Direction", 17);
    	goal4.addFeature(goalDistance4);
    	goal4.addFeature(goalDirection4);
    	
    	MLFeatureComplex flags4 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct4 = new MLFeatureComplex("fct");
    	MLNumber fctDistance4 = new MLNumber("Distance");
    	MLNumber fctDirection4 = new MLNumber("Direction");
    	fct4.addFeature(fctDistance4);
    	fct4.addFeature(fctDirection4);

    	
    	MLFeatureComplex fcb4 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance4 = new MLNumber("Distance");
    	MLNumber fcbDirection4 = new MLNumber("Direction");
    	fcb4.addFeature(fcbDirection4);
    	fcb4.addFeature(fcbDistance4);
    	flags4.addFeature(fct4);
    	flags4.addFeature(fcb4);
    	
    	MLString action4 = new MLString("Action", "Kick");
    	
    	t4.addAttributes(ball4);
		t4.addAttributes(goal4);
		t4.addAttributes(flags4);
		t4.addAttributes(action4);
		
		MLTuple t5 = new MLTuple(5);
    	
    	MLFeatureComplex ball5 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance5 = new MLNumber("Distance", 19.2);
    	MLNumber ballDirection5 = new MLNumber("Direction", 1);
    	ball5.addFeature(ballDistance5);
    	ball5.addFeature(ballDirection5);
 
    	MLFeatureComplex goal5 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance5 = new MLNumber("Distance", 24.6);
    	MLNumber goalDirection5 = new MLNumber("Direction", -17);
    	goal5.addFeature(goalDistance5);
    	goal5.addFeature(goalDirection5);
    	
    	MLFeatureComplex flags5 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct5 = new MLFeatureComplex("fct");
    	MLNumber fctDistance5 = new MLNumber("Distance");
    	MLNumber fctDirection5 = new MLNumber("Direction");
    	fct5.addFeature(fctDistance5);
    	fct5.addFeature(fctDirection5);

    	
    	MLFeatureComplex fcb5 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance5 = new MLNumber("Distance");
    	MLNumber fcbDirection5 = new MLNumber("Direction");
    	fcb5.addFeature(fcbDirection5);
    	fcb5.addFeature(fcbDistance5);
    	flags5.addFeature(fct5);
    	flags5.addFeature(fcb5);
    	
    	MLString action5 = new MLString("Action", "Dash");
    	
    	t5.addAttributes(ball5);
		t5.addAttributes(goal5);
		t5.addAttributes(flags5);
		t5.addAttributes(action5);

		
		MLTuple t6 = new MLTuple(6);
    	
    	MLFeatureComplex ball6 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance6 = new MLNumber("Distance", 15.9);
    	MLNumber ballDirection6 = new MLNumber("Direction", 1);
    	ball6.addFeature(ballDistance6);
    	ball6.addFeature(ballDirection6);
 
    	MLFeatureComplex goal6 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance6 = new MLNumber("Distance", 22.3);
    	MLNumber goalDirection6 = new MLNumber("Direction", -18);
    	goal6.addFeature(goalDistance6);
    	goal6.addFeature(goalDirection6);
    	
    	MLFeatureComplex flags6 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct6 = new MLFeatureComplex("fct");
    	MLNumber fctDistance6 = new MLNumber("Distance");
    	MLNumber fctDirection6 = new MLNumber("Direction");
    	fct6.addFeature(fctDistance6);
    	fct6.addFeature(fctDirection6);

    	
    	MLFeatureComplex fcb6 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance6 = new MLNumber("Distance");
    	MLNumber fcbDirection6 = new MLNumber("Direction");
    	fcb6.addFeature(fcbDirection6);
    	fcb6.addFeature(fcbDistance6);
    	flags6.addFeature(fct6);
    	flags6.addFeature(fcb6);
    	
    	MLString action6 = new MLString("Action", "Dash");
    	
    	t6.addAttributes(ball6);
		t6.addAttributes(goal6);
		t6.addAttributes(flags6);
		t6.addAttributes(action6);
		
		

		MLTuple t7 = new MLTuple(7);
    	
    	MLFeatureComplex ball7 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance7 = new MLNumber("Distance", 14.5);
    	MLNumber ballDirection7 = new MLNumber("Direction", 1);
    	ball7.addFeature(ballDistance7);
    	ball7.addFeature(ballDirection7);
 
    	MLFeatureComplex goal7 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance7 = new MLNumber("Distance", 20.7);
    	MLNumber goalDirection7 = new MLNumber("Direction", -20);
    	goal7.addFeature(goalDistance7);
    	goal7.addFeature(goalDirection7);
    	
    	MLFeatureComplex flags7 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct7 = new MLFeatureComplex("fct");
    	MLNumber fctDistance7 = new MLNumber("Distance");
    	MLNumber fctDirection7 = new MLNumber("Direction");
    	fct7.addFeature(fctDistance7);
    	fct7.addFeature(fctDirection7);

    	
    	MLFeatureComplex fcb7 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance7 = new MLNumber("Distance");
    	MLNumber fcbDirection7 = new MLNumber("Direction");
    	fcb7.addFeature(fcbDirection7);
    	fcb7.addFeature(fcbDistance7);
    	flags7.addFeature(fct7);
    	flags7.addFeature(fcb7);
    	
    	MLString action7 = new MLString("Action", "Dash");
    	
    	t7.addAttributes(ball7);
		t7.addAttributes(goal7);
		t7.addAttributes(flags7);
		t7.addAttributes(action7);
		
		
		MLTuple t8 = new MLTuple(8);
    	
    	MLFeatureComplex ball8 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance8 = new MLNumber("Distance", 11);
    	MLNumber ballDirection8 = new MLNumber("Direction", 1);
    	ball8.addFeature(ballDistance8);
    	ball8.addFeature(ballDirection8);
 
    	MLFeatureComplex goal8 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance8 = new MLNumber("Distance");
    	MLNumber goalDirection8 = new MLNumber("Direction");
    	goal8.addFeature(goalDistance8);
    	goal8.addFeature(goalDirection8);
    	
    	MLFeatureComplex flags8 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct8 = new MLFeatureComplex("fct");
    	MLNumber fctDistance8 = new MLNumber("Distance", 44.8);
    	MLNumber fctDirection8 = new MLNumber("Direction", -5);
    	fct8.addFeature(fctDistance8);
    	fct8.addFeature(fctDirection8);

    	
    	MLFeatureComplex fcb8 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance8 = new MLNumber("Distance");
    	MLNumber fcbDirection8 = new MLNumber("Direction");
    	fcb8.addFeature(fcbDirection8);
    	fcb8.addFeature(fcbDistance8);
    	flags8.addFeature(fct8);
    	flags8.addFeature(fcb8);
    	
    	MLString action8 = new MLString("Action", "Dash");
    	
    	t8.addAttributes(ball8);
		t8.addAttributes(goal8);
		t8.addAttributes(flags8);
		t8.addAttributes(action8);
		
		
MLTuple t9 = new MLTuple(9);
    	
    	MLFeatureComplex ball9 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance9 = new MLNumber("Distance", 10);
    	MLNumber ballDirection9 = new MLNumber("Direction", 1);
    	ball9.addFeature(ballDistance9);
    	ball9.addFeature(ballDirection9);
 
    	MLFeatureComplex goal9 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance9 = new MLNumber("Distance", 61.3);
    	MLNumber goalDirection9 = new MLNumber("Direction", -31);
    	goal9.addFeature(goalDistance9);
    	goal9.addFeature(goalDirection9);
    	
    	MLFeatureComplex flags9 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct9 = new MLFeatureComplex("fct");
    	MLNumber fctDistance9 = new MLNumber("Distance");
    	MLNumber fctDirection9 = new MLNumber("Direction");
    	fct9.addFeature(fctDistance9);
    	fct9.addFeature(fctDirection9);

    	
    	MLFeatureComplex fcb9 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance9 = new MLNumber("Distance",41.4);
    	MLNumber fcbDirection9 = new MLNumber("Direction",43);
    	fcb9.addFeature(fcbDirection9);
    	fcb9.addFeature(fcbDistance9);
    	flags9.addFeature(fct9);
    	flags9.addFeature(fcb9);
    	
    	MLString action9 = new MLString("Action", "Dash");
    	
    	t9.addAttributes(ball9);
		t9.addAttributes(goal9);
		t9.addAttributes(flags9);
		t9.addAttributes(action9);
		
MLTuple t10 = new MLTuple(10);
    	
    	MLFeatureComplex ball10 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance10 = new MLNumber("Distance", 45.7);
    	MLNumber ballDirection10 = new MLNumber("Direction", 1);
    	ball10.addFeature(ballDistance10);
    	ball10.addFeature(ballDirection10);
 
    	MLFeatureComplex goal10 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance10 = new MLNumber("Distance", 96.6);
    	MLNumber goalDirection10 = new MLNumber("Direction", 2);
    	goal10.addFeature(goalDistance10);
    	goal10.addFeature(goalDirection10);
    	
    	MLFeatureComplex flags10 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct10 = new MLFeatureComplex("fct");
    	MLNumber fctDistance10 = new MLNumber("Distance", 55.6);
    	MLNumber fctDirection10 = new MLNumber("Direction",-37);
    	fct10.addFeature(fctDistance10);
    	fct10.addFeature(fctDirection10);

    	
    	MLFeatureComplex fcb10 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance10 = new MLNumber("Distance",56.6);
    	MLNumber fcbDirection10 = new MLNumber("Direction",40);
    	fcb10.addFeature(fcbDirection10);
    	fcb10.addFeature(fcbDistance10);
    	flags10.addFeature(fct10);
    	flags10.addFeature(fcb10);
    	
    	MLString action10 = new MLString("Action", "Dash");
    	
    	t10.addAttributes(ball10);
		t10.addAttributes(goal10);
		t10.addAttributes(flags10);
		t10.addAttributes(action10);
		
MLTuple t11 = new MLTuple(11);
    	
    	MLFeatureComplex ball11 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance11 = new MLNumber("Distance", 50.4);
    	MLNumber ballDirection11 = new MLNumber("Direction", -1);
    	ball11.addFeature(ballDistance11);
    	ball11.addFeature(ballDirection11);
 
    	MLFeatureComplex goal11 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance11 = new MLNumber("Distance", 101.5);
    	MLNumber goalDirection11 = new MLNumber("Direction", 14);
    	goal11.addFeature(goalDistance11);
    	goal11.addFeature(goalDirection11);
    	
    	MLFeatureComplex flags11 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct11 = new MLFeatureComplex("fct");
    	MLNumber fctDistance11 = new MLNumber("Distance", 75.4);
    	MLNumber fctDirection11 = new MLNumber("Direction",-24);
    	fct11.addFeature(fctDistance11);
    	fct11.addFeature(fctDirection11);

    	
    	MLFeatureComplex fcb11 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance11 = new MLNumber("Distance",46.2);
    	MLNumber fcbDirection11 = new MLNumber("Direction",40);
    	fcb11.addFeature(fcbDirection11);
    	fcb11.addFeature(fcbDistance11);
    	flags11.addFeature(fct11);
    	flags11.addFeature(fcb11);
    	
    	MLString action11 = new MLString("Action", "Turn");
    	
    	t11.addAttributes(ball11);
		t11.addAttributes(goal11);
		t11.addAttributes(flags11);
		t11.addAttributes(action11);
		
		MLTuple t12 = new MLTuple(12);
    	
    	MLFeatureComplex ball12 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance12 = new MLNumber("Distance", 41.4);
    	MLNumber ballDirection12 = new MLNumber("Direction", 0);
    	ball12.addFeature(ballDistance12);
    	ball12.addFeature(ballDirection12);
 
    	MLFeatureComplex goal12 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance12 = new MLNumber("Distance",90.1);
    	MLNumber goalDirection12 = new MLNumber("Direction", 18);
    	goal12.addFeature(goalDistance12);
    	goal12.addFeature(goalDirection12);
    	
    	MLFeatureComplex flags12 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct12 = new MLFeatureComplex("fct");
    	MLNumber fctDistance12 = new MLNumber("Distance", 65.1);
    	MLNumber fctDirection12 = new MLNumber("Direction",-27);
    	fct12.addFeature(fctDistance12);
    	fct12.addFeature(fctDirection12);

    	
    	MLFeatureComplex fcb12 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance12 = new MLNumber("Distance");
    	MLNumber fcbDirection12 = new MLNumber("Direction");
    	fcb12.addFeature(fcbDirection12);
    	fcb12.addFeature(fcbDistance12);
    	flags12.addFeature(fct12);
    	flags12.addFeature(fcb12);
    	
    	MLString action12 = new MLString("Action", "Turn");
    	
    	t12.addAttributes(ball12);
		t12.addAttributes(goal12);
		t12.addAttributes(flags12);
		t12.addAttributes(action12);
		
		MLTuple t13 = new MLTuple(13);
    	
    	MLFeatureComplex ball13 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance13 = new MLNumber("Distance", 14.5);
    	MLNumber ballDirection13 = new MLNumber("Direction", 15);
    	ball13.addFeature(ballDistance13);
    	ball13.addFeature(ballDirection13);
 
    	MLFeatureComplex goal13 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance13 = new MLNumber("Distance", 60.1);
    	MLNumber goalDirection13 = new MLNumber("Direction", 27);
    	goal13.addFeature(goalDistance13);
    	goal13.addFeature(goalDirection13);
    	
    	MLFeatureComplex flags13 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct13 = new MLFeatureComplex("fct");
    	MLNumber fctDistance13 = new MLNumber("Distance", 65.1);
    	MLNumber fctDirection13 = new MLNumber("Direction",-27);
    	fct13.addFeature(fctDistance13);
    	fct13.addFeature(fctDirection13);

    	
    	MLFeatureComplex fcb13 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance13 = new MLNumber("Distance");
    	MLNumber fcbDirection13 = new MLNumber("Direction");
    	fcb13.addFeature(fcbDirection13);
    	fcb13.addFeature(fcbDistance13);
    	flags13.addFeature(fct13);
    	flags13.addFeature(fcb13);
    	
    	MLString action13 = new MLString("Action", "Turn");
    	
    	t13.addAttributes(ball13);
		t13.addAttributes(goal13);
		t13.addAttributes(flags13);
		t13.addAttributes(action13);
		

		MLTuple t14 = new MLTuple(14);
    	
    	MLFeatureComplex ball14 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance14 = new MLNumber("Distance", 41.4);
    	MLNumber ballDirection14 = new MLNumber("Direction", 3);
    	ball14.addFeature(ballDistance14);
    	ball14.addFeature(ballDirection14);
 
    	MLFeatureComplex goal14 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance14 = new MLNumber("Distance",94.7);
    	MLNumber goalDirection14 = new MLNumber("Direction", 4);
    	goal14.addFeature(goalDistance14);
    	goal14.addFeature(goalDirection14);
    	
    	MLFeatureComplex flags14 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct14 = new MLFeatureComplex("fct");
    	MLNumber fctDistance14 = new MLNumber("Distance", 55.1);
    	MLNumber fctDirection14 = new MLNumber("Direction",-36);
    	fct14.addFeature(fctDistance14);
    	fct14.addFeature(fctDirection14);

    	
    	MLFeatureComplex fcb14 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance14 = new MLNumber("Distance", 53.5);
    	MLNumber fcbDirection14 = new MLNumber("Direction", 43);
    	fcb14.addFeature(fcbDirection14);
    	fcb14.addFeature(fcbDistance14);
    	flags14.addFeature(fct14);
    	flags14.addFeature(fcb14);
    	
    	MLString action14 = new MLString("Action", "Turn");
    	
    	t14.addAttributes(ball14);
		t14.addAttributes(goal14);
		t14.addAttributes(flags14);
		t14.addAttributes(action14);
		
		MLTuple t15 = new MLTuple(15);
    	
    	MLFeatureComplex ball15 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance15 = new MLNumber("Distance",23.2);
    	MLNumber ballDirection15 = new MLNumber("Direction", 0);
    	ball15.addFeature(ballDistance15);
    	ball15.addFeature(ballDirection15);
 
    	MLFeatureComplex goal15 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance15 = new MLNumber("Distance",76.9);
    	MLNumber goalDirection15 = new MLNumber("Direction", 2);
    	goal15.addFeature(goalDistance15);
    	goal15.addFeature(goalDirection15);
    	
    	MLFeatureComplex flags15 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct15 = new MLFeatureComplex("fct");
    	MLNumber fctDistance15 = new MLNumber("Distance");
    	MLNumber fctDirection15 = new MLNumber("Direction");
    	fct15.addFeature(fctDistance15);
    	fct15.addFeature(fctDirection15);

    	
    	MLFeatureComplex fcb15 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance15 = new MLNumber("Distance");
    	MLNumber fcbDirection15 = new MLNumber("Direction");
    	fcb15.addFeature(fcbDirection15);
    	fcb15.addFeature(fcbDistance15);
    	flags15.addFeature(fct15);
    	flags15.addFeature(fcb15);
    	
    	MLString action15 = new MLString("Action", "Turn");
    	
    	t15.addAttributes(ball15);
		t15.addAttributes(goal15);
		t15.addAttributes(flags15);
		t15.addAttributes(action15);
		

		MLTuple t16 = new MLTuple(16);
    	
    	MLFeatureComplex ball16 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance16 = new MLNumber("Distance",12);
    	MLNumber ballDirection16 = new MLNumber("Direction", 24);
    	ball16.addFeature(ballDistance16);
    	ball16.addFeature(ballDirection16);
 
    	MLFeatureComplex goal16 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance16 = new MLNumber("Distance");
    	MLNumber goalDirection16 = new MLNumber("Direction");
    	goal16.addFeature(goalDistance16);
    	goal16.addFeature(goalDirection16);
    	
    	MLFeatureComplex flags16 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct16 = new MLFeatureComplex("fct");
    	MLNumber fctDistance16 = new MLNumber("Distance");
    	MLNumber fctDirection16 = new MLNumber("Direction");
    	fct16.addFeature(fctDistance16);
    	fct16.addFeature(fctDirection16);

    	
    	MLFeatureComplex fcb16 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance16 = new MLNumber("Distance",42.7);
    	MLNumber fcbDirection16 = new MLNumber("Direction",-40);
    	fcb16.addFeature(fcbDirection16);
    	fcb16.addFeature(fcbDistance16);
    	flags16.addFeature(fct16);
    	flags16.addFeature(fcb16);
    	
    	MLString action16 = new MLString("Action", "Turn");
    	
    	t16.addAttributes(ball16);
		t16.addAttributes(goal16);
		t16.addAttributes(flags16);
		t16.addAttributes(action16);
		

		MLTuple t17 = new MLTuple(17);
    	
    	MLFeatureComplex ball17 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance17 = new MLNumber("Distance");
    	MLNumber ballDirection17 = new MLNumber("Direction");
    	ball17.addFeature(ballDistance17);
    	ball17.addFeature(ballDirection17);
 
    	MLFeatureComplex goal17 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance17 = new MLNumber("Distance",26.3);
    	MLNumber goalDirection17 = new MLNumber("Direction",2);
    	goal17.addFeature(goalDistance17);
    	goal17.addFeature(goalDirection17);
    	
    	MLFeatureComplex flags17 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct17 = new MLFeatureComplex("fct");
    	MLNumber fctDistance17 = new MLNumber("Distance");
    	MLNumber fctDirection17 = new MLNumber("Direction");
    	fct17.addFeature(fctDistance17);
    	fct17.addFeature(fctDirection17);

    	
    	MLFeatureComplex fcb17 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance17 = new MLNumber("Distance");
    	MLNumber fcbDirection17 = new MLNumber("Direction");
    	fcb17.addFeature(fcbDirection17);
    	fcb17.addFeature(fcbDistance17);
    	flags17.addFeature(fct17);
    	flags17.addFeature(fcb17);
    	
    	MLString action17 = new MLString("Action", "Turn");
    	
    	t17.addAttributes(ball17);
		t17.addAttributes(goal17);
		t17.addAttributes(flags17);
		t17.addAttributes(action17);
		
		MLTuple t18 = new MLTuple(18);
    	
    	MLFeatureComplex ball18 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance18 = new MLNumber("Distance",3.5);
    	MLNumber ballDirection18 = new MLNumber("Direction",1);
    	ball18.addFeature(ballDistance18);
    	ball18.addFeature(ballDirection18);
 
    	MLFeatureComplex goal18 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance18 = new MLNumber("Distance",56.1);
    	MLNumber goalDirection18 = new MLNumber("Direction",4);
    	goal18.addFeature(goalDistance18);
    	goal18.addFeature(goalDirection18);
    	
    	MLFeatureComplex flags18 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct18 = new MLFeatureComplex("fct");
    	MLNumber fctDistance18 = new MLNumber("Distance");
    	MLNumber fctDirection18 = new MLNumber("Direction");
    	fct18.addFeature(fctDistance18);
    	fct18.addFeature(fctDirection18);

    	
    	MLFeatureComplex fcb18 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance18 = new MLNumber("Distance");
    	MLNumber fcbDirection18 = new MLNumber("Direction");
    	fcb18.addFeature(fcbDirection18);
    	fcb18.addFeature(fcbDistance18);
    	flags18.addFeature(fct18);
    	flags18.addFeature(fcb18);
    	
    	MLString action18 = new MLString("Action", "Dash");
    	
    	t18.addAttributes(ball18);
		t18.addAttributes(goal18);
		t18.addAttributes(flags18);
		t18.addAttributes(action18);
		
		MLTuple t100 = new MLTuple(100);
    	
    	MLFeatureComplex ball100 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance100 = new MLNumber("Distance",2);
    	MLNumber ballDirection100 = new MLNumber("Direction",22);
    	ball100.addFeature(ballDistance100);
    	ball100.addFeature(ballDirection100);
 
    	MLFeatureComplex goal100 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance100 = new MLNumber("Distance",63.8);
    	MLNumber goalDirection100 = new MLNumber("Direction",-2);
    	goal100.addFeature(goalDistance100);
    	goal100.addFeature(goalDirection100);
    	
    	MLFeatureComplex flags100 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct100 = new MLFeatureComplex("fct");
    	MLNumber fctDistance100 = new MLNumber("Distance");
    	MLNumber fctDirection100 = new MLNumber("Direction");
    	fct100.addFeature(fctDistance100);
    	fct100.addFeature(fctDirection100);

    	
    	MLFeatureComplex fcb100 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance100 = new MLNumber("Distance");
    	MLNumber fcbDirection100 = new MLNumber("Direction");
    	fcb100.addFeature(fcbDirection100);
    	fcb100.addFeature(fcbDistance100);
    	flags100.addFeature(fct100);
    	flags100.addFeature(fcb100);
    	
    	MLString action100 = new MLString("Action", "Kick");
    	
    	t100.addAttributes(ball100);
		t100.addAttributes(goal100);
		t100.addAttributes(flags100);
		t100.addAttributes(action100);
		
		MLTuple t101 = new MLTuple(101);
    	
    	MLFeatureComplex ball101 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance101 = new MLNumber("Distance",2);
    	MLNumber ballDirection101 = new MLNumber("Direction",22);
    	ball101.addFeature(ballDistance101);
    	ball101.addFeature(ballDirection101);
 
    	MLFeatureComplex goal101 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance101 = new MLNumber("Distance",63.8);
    	MLNumber goalDirection101 = new MLNumber("Direction",-2);
    	goal101.addFeature(goalDistance101);
    	goal101.addFeature(goalDirection101);
    	
    	MLFeatureComplex flags101 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct101 = new MLFeatureComplex("fct");
    	MLNumber fctDistance101 = new MLNumber("Distance");
    	MLNumber fctDirection101 = new MLNumber("Direction");
    	fct101.addFeature(fctDistance101);
    	fct101.addFeature(fctDirection101);

    	
    	MLFeatureComplex fcb101 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance101 = new MLNumber("Distance");
    	MLNumber fcbDirection101 = new MLNumber("Direction");
    	fcb101.addFeature(fcbDirection101);
    	fcb101.addFeature(fcbDistance101);
    	flags101.addFeature(fct101);
    	flags101.addFeature(fcb101);
    	
    	MLString action101 = new MLString("Action", "Kick");
    	
    	t101.addAttributes(ball101);
		t101.addAttributes(goal101);
		t101.addAttributes(flags101);
		t101.addAttributes(action101);
		
		MLTuple t102 = new MLTuple(102);
    	
    	MLFeatureComplex ball102 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance102 = new MLNumber("Distance",1.9);
    	MLNumber ballDirection102 = new MLNumber("Direction",-167);
    	ball102.addFeature(ballDistance102);
    	ball102.addFeature(ballDirection102);
 
    	MLFeatureComplex goal102 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance102 = new MLNumber("Distance",63.8);
    	MLNumber goalDirection102 = new MLNumber("Direction",31);
    	goal102.addFeature(goalDistance102);
    	goal102.addFeature(goalDirection102);
    	
    	MLFeatureComplex flags102 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct102 = new MLFeatureComplex("fct");
    	MLNumber fctDistance102 = new MLNumber("Distance", 39.1);
    	MLNumber fctDirection102 = new MLNumber("Direction", -41);
    	fct102.addFeature(fctDistance102);
    	fct102.addFeature(fctDirection102);

    	
    	MLFeatureComplex fcb102 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance102 = new MLNumber("Distance");
    	MLNumber fcbDirection102 = new MLNumber("Direction");
    	fcb102.addFeature(fcbDirection102);
    	fcb102.addFeature(fcbDistance102);
    	flags102.addFeature(fct102);
    	flags102.addFeature(fcb102);
    	
    	MLString action102 = new MLString("Action", "Kick");
    	
    	t102.addAttributes(ball102);
		t102.addAttributes(goal102);
		t102.addAttributes(flags102);
		t102.addAttributes(action102);
		
		MLTuple t103 = new MLTuple(103);
    	
    	MLFeatureComplex ball103 = new MLFeatureComplex("Ball");
    	MLNumber ballDistance103 = new MLNumber("Distance",14.5);
    	MLNumber ballDirection103 = new MLNumber("Direction",0);
    	ball103.addFeature(ballDistance103);
    	ball103.addFeature(ballDirection103);
 
    	MLFeatureComplex goal103 = new MLFeatureComplex("Goal");
    	MLNumber goalDistance103 = new MLNumber("Distance",32.8);
    	MLNumber goalDirection103 = new MLNumber("Direction",5);
    	goal103.addFeature(goalDistance103);
    	goal103.addFeature(goalDirection103);
    	
    	MLFeatureComplex flags103 = new MLFeatureComplex("Flags");
    	MLFeatureComplex fct103 = new MLFeatureComplex("fct");
    	MLNumber fctDistance103 = new MLNumber("Distance", 39.1);
    	MLNumber fctDirection103 = new MLNumber("Direction", -41);
    	fct103.addFeature(fctDistance103);
    	fct103.addFeature(fctDirection103);

    	
    	MLFeatureComplex fcb103 = new MLFeatureComplex("fcb");
    	MLNumber fcbDistance103 = new MLNumber("Distance");
    	MLNumber fcbDirection103 = new MLNumber("Direction");
    	fcb103.addFeature(fcbDirection103);
    	fcb103.addFeature(fcbDistance103);
    	flags103.addFeature(fct103);
    	flags103.addFeature(fcb103);
    	
    	MLString action103 = new MLString("Action", "Turn");
    	
    	t103.addAttributes(ball103);
		t103.addAttributes(goal103);
		t103.addAttributes(flags103);
		t103.addAttributes(action103);
		
		KNNView view = new KNNView();
		view.addTrainingTuple(t1);
		view.addTrainingTuple(t2);
		view.addTrainingTuple(t3);
		view.addTrainingTuple(t4);
		view.addTrainingTuple(t5);
		view.addTrainingTuple(t6);
		view.addTrainingTuple(t7);
		view.addTrainingTuple(t8);
		view.addTrainingTuple(t9);
		view.addTrainingTuple(t10);
		view.addTrainingTuple(t11);
		view.addTrainingTuple(t12);
		view.addTrainingTuple(t13);
		view.addTrainingTuple(t14);
		view.addTrainingTuple(t15);
		view.addTrainingTuple(t16);
		view.addTrainingTuple(t17);
		view.addTrainingTuple(t18);
		
		view.addTestingTuple(t100);
		view.addTestingTuple(t101);
		view.addTestingTuple(t102);
		view.addTestingTuple(t103);
		view.addToScrollPane(new MLListView(view));
		view.addToScrollPane(new MLListView(view));
		view.addToScrollPane(new MLListView(view));
    	view.visiblity(true);

		
		
	}
}
