# SYSC 3110 Course Project
The goal of this project is to perform machine learning on simple problems, by using the kNN technique. kNN or "k-Nearest Neighbours" finds the nearest neighbours to the tuple to predict by using a combination of distance functions for the features.

## Getting Started
To run this framework all you have to have installed is java on your machine and then open the executable jar file to launch the GUI, if jar file does not open the GUI, please find the <b>KNNFrame</b> and run it. This should open the GUI, where nothing is visible except for the menu. After you have entered in how many nearest neighbours, the rest of the application should be visible.

## Running tests
The framework is designed to work with the following attributes: numbers, coordinates, lists. For each tuple that you create you can add as many attributes you want for that associated tuple. You have to ensure that you enter the same number of attributes and in the same order as previously entered in other tuples. For example

Table 1.1

|Name(ID)|coordinates  |sq.ft. |age  |price  |
|-----|:-----------:|:-----:|:---:|------:|
|h1   |(12,25)      |1200   |new  |500,000|
|h2   |(10,50)      |1000   |old  |300,000|
|h3   |(30,100)     |800    |new  |400,000|
|h4   |(15,20)      |1000   |new  |???    | 

To create this in the GUI, first add all the attribute types that are needed for example for the table above you would need to create a coordinate feature for coordinates, number feature for sq. ft., a constant list feature for age which would contain new and old, and lastly another number feature for price. To start adding
the data we first have to give each of them names and values. So first you would pick the List option from the drop down and click add feature and set the desired name. Next, select Number from the dropdown and click add. Another box will show up beside List and here all that needs to be done is setting the name for the feature, in this case it would be sq. ft. Next for age, select List from the dropdown and click add. Once you enter in the name you wish to call it, select Number and repeat the same steps as we did for sq.ft., with this all of our features have been set up, we click the lock button under the dropdown list to start adding in data. 
Once the lock button has been pressed, the text fields should be unlocked under each of the name textboxes. In these textbooks we can add the data for one row of Table 1.1. For example, for coordinates we would select Number from the dropdown list under the name and click add to list, once that is clicked you can see a new pop up window on the screen. You can enter in the name and 12 and press enter, once you're done close the window and press "Add to list" again to add 25 now. Next we add the sq.ft. we add 1200 in the textbox for sq.ft and press enter. For age you select String in the List dropdown and enter in new and press enter and close. Once all of the features have the desired values, we add the data to either the training data or the testing data. The row we just entered will get added into the big textbox and the textboxes with the values in it will get reset. We can then repeat this for all the rows except for h4, because this is the tuple we want to preddict you would enter in all the values and click "Add to Testing Tuple". Now that we are done with entering in the data we can now select the feature we want to predict using the "Prediction Feature" dropdown where we can select "price" and you can set whatever distance strategy you wish to use using the "Distance Strategy" dropdown. Once you pick both, you can now add weights to each of the categories if you wish too by clicking the "Add Weights" button and once we're ready to predict, navigate to the Testing tab and select the tuple you wish to predict. In our case we only have one which is h4, one you click on that tuple select "predict", specify how many nearest neighbours you wish to use and click okay. A popup stating the overall average error on the prediction pops up and then in the Results tab you can see what the prediction was.

However if the GUI does not work, please open the <b>MLPredict</b> class and then copy the following example code to predict the desired tuple. The backend is working fine, the GUI just has a lot of bugs.
```Java
  public static void main(String[] args) {
		MLPredict predict = new MLPredict(3);
		MLRelation rel = new MLRelation();
		
		MLTuple t1 = new MLTuple(1);
			MLNumber n1 = new MLNumber("n1", 1000);
			MLFeatureComplex fc1 = new MLFeatureComplex("fc1");
			fc1.addFeature(new MLNumber("", 12));
			fc1.addFeature(new MLNumber("", 25));
			MLNumber n2 = new MLNumber("n2", 500000);
			MLString str1 = new MLString("str1", "new");

		t1.addAttributes(fc1);
		t1.addAttributes(n1);
		t1.addAttributes(str1);
		t1.addAttributes(n2);

		MLTuple t2 = new MLTuple(2);
			MLNumber n3 = new MLNumber("n3", 1200);
			MLFeatureComplex fc2 = new MLFeatureComplex("fc1");
			fc2.addFeature(new MLNumber("", 10));
			fc2.addFeature(new MLNumber("", 50));
			MLNumber n4 = new MLNumber("n4", 300000);
			MLString str2 = new MLString("str2", "old");

		t2.addAttributes(fc2);
		t2.addAttributes(n3);
		t2.addAttributes(str2);
		t2.addAttributes(n4);

		MLTuple t3 = new MLTuple(3);
			MLNumber n5 = new MLNumber("n5", 1500);
			MLFeatureComplex fc3 = new MLFeatureComplex("fc1");
			fc3.addFeature(new MLNumber("", 15));
			fc3.addFeature(new MLNumber("", 20));
			MLNumber n6 = new MLNumber("n6", 400000);
			MLString str3 = new MLString("str3", "new");

		t3.addAttributes(fc3);
		t3.addAttributes(n5);
		t3.addAttributes(str3);
		t3.addAttributes(n6);

		MLTuple t4 = new MLTuple(0);
			MLNumber n7 = new MLNumber("n7", 800);
			MLFeatureComplex fc4 = new MLFeatureComplex("fc1");
			fc4.addFeature(new MLNumber("", 20));
			fc4.addFeature(new MLNumber("", 15));
			MLNumber n8 = new MLNumber("", 600000);
			MLString str4 = new MLString("str4", "old");
		
		t4.addAttributes(fc4);     // CORD
		t4.addAttributes(n7);      // NUMBER SQ
		t4.addAttributes(str4);    // STRING
		t4.addAttributes(n8);      // NUMBER PRICE

		predictionTuple = new MLPredictTuple(0);
		Distance dist = new EculidianDistance();
		predictStrategy pre = new MLListPredictAvg();
		predictionTuple.setDistanceStrategy(dist);
		predictionTuple.setPredictStrategy(pre);
		//double user[] = {1,1,1,1};
		//rel.setUserWeights(user);

		MLRelation testing = new MLRelation();
		testing.addTuple(t4);
		rel.addTuple(t1); 
		rel.addTuple(t2);
		//rel.addTuple(t4);
		rel.addTuple(t3);
		
		rel = rel.clone();
		predict.addRelation(rel);
		Feature result = predict.predict(3, rel.getTuple(1), 0);
		System.out.println(result);
		
		ErrorCalculation error = new ErrorCalculation();
		System.out.println(error.errorCalculations(rel, testing, 0, 3, predictionTuple) + "%");
		predict.addRelation(rel);
		System.out.println(predict.predict(3, t4,0));
}
```
In the predict function the first parameter is how many K nearest neighbours you want, the second is the tuple you wish to predict, and the third is the index of the feature you wish to predict. You also have to set the stragety you wish to calculate using in this case we are using the Eculidian distance to measure distance and the predict strategy is MLCoordPredictAvg because we want to predict a coordinate. If we wish to predict a number, we have to change that to MLNumberPredictAverage, or for strings select MLStringPredictAverage, and for lists select MLListPredictAverage. 



## Known Issues

## Things to fix/add


## Authors
Rajat Bansal 101019954
Shounak Amladi 101000120
Brij Patel 101008373




