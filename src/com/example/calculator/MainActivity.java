package com.example.calculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	enum OPERATOR {
		PLUS, SUBTRACT, MULTIPLY, DIVIDE, UNINITIALIZED
	}
	
	Button buttonOne;
	Button buttonTwo;
	Button buttonThree;
	Button buttonFour;
	Button buttonFive;
	Button buttonSix;
	Button buttonSeven;
	Button buttonEight;
	Button buttonNine;
	Button buttonZero;
	Button operatorPlus;
	Button operatorSub;
	Button operatorMul;
	Button operatorDiv;
	Button operatorEqual;
	Button operatorCE;
	
	TextView display;
	
	int operand1 = 0, operand2 = 0;
	OPERATOR operator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setUpAllButtons();
	}
	
	private void setUpAllButtons() {
		initializeAllButtons();
		setUpButtonOnClickListeners();
	}


	private void initializeAllButtons() {
		buttonOne = (Button) findViewById(R.id.buttonOne);
		buttonTwo = (Button) findViewById(R.id.buttonTwo);
		buttonThree = (Button) findViewById(R.id.buttonThree);
		buttonFour = (Button) findViewById(R.id.buttonFour);
		buttonFive = (Button) findViewById(R.id.buttonFive);
		buttonSix = (Button) findViewById(R.id.buttonSix);
		buttonSeven = (Button) findViewById(R.id.buttonSeven);
		buttonEight = (Button) findViewById(R.id.buttonEight);
		buttonNine = (Button) findViewById(R.id.buttonNine);
		buttonZero = (Button) findViewById(R.id.buttonZero);
		operatorPlus = (Button) findViewById(R.id.buttonPlus);
		operatorSub = (Button) findViewById(R.id.buttonSub);
		operatorMul = (Button) findViewById(R.id.buttonMul);
		operatorDiv = (Button) findViewById(R.id.buttonDivide);
		operatorEqual = (Button) findViewById(R.id.buttonEqual);
		operatorCE = (Button) findViewById(R.id.buttonCE);
		
		display = (TextView) findViewById(R.id.displayBox);
	}

	private void setUpButtonOnClickListeners() {
		buttonOne.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 1;
				} else {
					operand2 = 1;
				}
				
				display.append("1 ");
			}	
		});
		
		buttonTwo.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 2;
				} else {
					operand2 = 2;
				}
				
				display.append("2 ");
			}	
		});
		
		buttonThree.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 3;
				} else {
					operand2 = 3;
				}
				
				display.append("3 ");
			}	
		});
		
		buttonFour.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 4;
				} else {
					operand2 = 4;
				}
				
				display.append("4 ");
			}	
		});
		
		buttonFive.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 5;
				} else {
					operand2 = 5;
				}
				
				display.append("5 ");
			}	
		});
		
		buttonSix.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 6;
				} else {
					operand2 = 6;
				}
				
				display.append("6 ");
			}	
		});
		
		buttonSeven.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 7;
				} else {
					operand2 = 7;
				}
				
				display.append("7 ");
			}	
		});
		
		buttonEight.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 8;
				} else {
					operand2 = 8;
				}
				
				display.append("8 ");
			}	
		});
		
		buttonNine.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 9;
				} else {
					operand2 = 9;
				}
				
				display.append("9 ");
			}	
		});
		
		buttonZero.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				if(operand1 == 0) {
					operand1 = 0;
				} else {
					operand2 = 0;
				}
				
				display.append("0 ");
			}	
		});
		
		operatorPlus.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				operator = OPERATOR.PLUS;
				
				display.append("+ ");
			}	
		});
		
		operatorSub.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				operator = OPERATOR.SUBTRACT;
				
				display.append("- ");
			}	
		});
		
		operatorMul.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				operator = OPERATOR.MULTIPLY;
				
				display.append("* ");
			}	
		});
		
		operatorDiv.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				operator = OPERATOR.DIVIDE;
				
				display.append("/ ");
			}	
		});
		
		operatorCE.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				operand1 = operand2 = 0;
				operator = OPERATOR.UNINITIALIZED;
				
				display.setText("");
			}	
		});

		operatorEqual.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				doOperation();
			}

			private void doOperation() {
				double result;
				
				try{
					
					result = calculate();
					display.setText(String.format("Result: %g", result));
					
					operand1 = operand2 = 0;
					operator = OPERATOR.UNINITIALIZED;
					
				} catch(Exception e) {
					
					display.setText(e.getMessage());
				} 
			}
				
			private double calculate() throws Exception{
				double result = 0;
				
				switch(operator){
					case PLUS:
						result = operand1 + operand2;
						break;
					case SUBTRACT:
						result = operand1 - operand2;
						break;
					case MULTIPLY:
						result = operand1 * operand2;
						break;
					case DIVIDE:
						if(operand2 == 0)
							throw new Exception("Undefined");
						result = (double)operand1 / operand2;
						break;
					case UNINITIALIZED:
						throw new Exception("");
				}
				
				return result;
			}	
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
