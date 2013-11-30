package com.example.flashnotiftester;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FlashNotificationAppTester extends Activity {

	//preset patterns 
	ArrayList<Integer> pattern1 = new ArrayList<Integer>();
	ArrayList<Integer> pattern2 = new ArrayList<Integer>();
	ArrayList<Integer> pattern3 = new ArrayList<Integer>();

	//stores the previously tested custom pattern
	ArrayList<Integer> prevPattern = new ArrayList<Integer>();

	//p1 - preset test 1
	//p2 - preset test 2
	//p3 - preset test 3
	private Button p1, p2, p3;

	//create - create a new pattern
	//append - append the current pattern to previous pattern (there is a previous pattern)
	//test - test the curent pattern
	private Button create, append, test;
	
	//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash_notification_app_tester);

		setupPreset1();
		setupPreset2();
		setupPreset3();



		// three Buttons for custom tests
		create = (Button) findViewById(R.id.create);
		//append= (Button) findViewById(R.id.append);
		test = (Button) findViewById(R.id.test);

	}

	private void setupPreset1(){
		p1 = (Button) findViewById(R.id.button1);

		for (int i = 0; i < 5; i++){
			pattern1.add(100);
			pattern1.add(200);
		}

		p1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){
				Toast.makeText(FlashNotificationAppTester.this, "Preset 1 displaying.", Toast.LENGTH_LONG).show();
				Intent i = new Intent("com.leepapesweers.flashnotifier.API");

				// Put flash pattern in request
				i.putIntegerArrayListExtra("flash_pattern", pattern1);

				// Put sending application package name
				i.putExtra("calling_application", getPackageName());

				// Send the broadcast
				sendBroadcast(i);
			}
		});
	}

	private void setupPreset2(){
		p2 = (Button) findViewById(R.id.button2);

		for (int i = 0; i < 5; i++){
			pattern2.add(50);
			pattern2.add(150);
		} 

		p2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){
				Toast.makeText(FlashNotificationAppTester.this, "Preset 2 displaying.", Toast.LENGTH_LONG).show();
				Intent i = new Intent("com.leepapesweers.flashnotifier.API");

				// Put flash pattern in request
				i.putIntegerArrayListExtra("flash_pattern", pattern2);

				// Put sending application package name
				i.putExtra("calling_application", getPackageName());

				// Send the broadcast
				sendBroadcast(i);
			}
		});
	}

	private void setupPreset3(){
		p3 = (Button) findViewById(R.id.button3);
		
		for (int i = 0; i < 2; i++){
			pattern3.add(150);
			pattern3.add(250);
			pattern3.add(50);
			pattern3.add(50);
		}
		
		p3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){
				Toast.makeText(FlashNotificationAppTester.this, "Preset 3 displaying.", Toast.LENGTH_LONG).show();
				Intent i = new Intent("com.leepapesweers.flashnotifier.API");

				// Put flash pattern in request
				i.putIntegerArrayListExtra("flash_pattern", pattern3);

				// Put sending application package name
				i.putExtra("calling_application", getPackageName());

				// Send the broadcast
				sendBroadcast(i);
			}
		});
	}
		
	//for customs tests -- after the user has filled in the parameters for custom test
	public void createPattern(){
		// dialog in textbox box will prompt user to input 

	}


	//TODO: implement code that uses makes calls to the open API to make use of the pattern

}
