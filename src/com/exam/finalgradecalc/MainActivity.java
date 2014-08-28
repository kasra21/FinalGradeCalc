package com.exam.finalgradecalc;

import android.os.Bundle; 
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	final Context context = this;
	private Button buttonDetails, buttonScale, buttonCalculate;
	private EditText CGedi, FCedivar, DGedi ;
	private Spinner CGspi, DGspi ;
	private double aplow = 98, alow= 92, amlow =90, bplow = 88, blow = 82, bmlow = 80, cplow = 78;
	private double clow = 72, cmlow = 70, dplow = 68, dlow = 62, dmlow = 60, flow =0;
	private double aphigh = 100, ahigh= 98, amhigh =92, bphigh = 90, bhigh = 88, bmhigh = 82, cphigh = 80;
	private double chigh = 78, cmhigh = 72, dphigh = 70, dhigh = 68, dmhigh = 62, fhigh = 60;
	private double gradepercent, tempDG, tempCG, tempFC, gradepercentLow, gradepercentHigh;
	private String gradeletter, StmpDG, StmpCG, gradeletterHightemp, gradeletterlowtemp;
	private double NewCGHigh, NewCGLow;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonDetails = (Button) findViewById(R.id.DetailsButton);
		buttonScale = (Button) findViewById(R.id.ScaleButton);
		buttonCalculate = (Button) findViewById(R.id.CalcButton);
		CGedi = (EditText) findViewById(R.id.CGedit);
		FCedivar = (EditText) findViewById(R.id.newfinalcoef);
		DGedi = (EditText) findViewById(R.id.DGedit);
		CGspi = (Spinner) findViewById(R.id.CGspinner);
		DGspi = (Spinner) findViewById(R.id.FCspinner);		//it is not a mistake I named it wrong in the xml setting
		
		addListenerOnDetailButton();		//create addListener for Detailbutton
		addListenerOnScaleButton();			//create addlistener for ScalButton
		addListenerOnCalcButton();			//create addListener for calculation button
		
		
	}
	
	private void invalidDiaolog() {
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle("Invalid format");
		alertDialogBuilder
		.setMessage(" The format for Current Grade, Final Coefficient or Desired Grade is incorrect. \n Try again").setCancelable(false).			//it cannot be cancelled
		setPositiveButton("OK", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();		//exit the dialog box
				
			}
			
		}); 
		
		//has to be AFTER SETTINGS
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();		//create and show it
		
	}
	
	private void gradelp(double GLow,
			double GHigh, String letterHigh,
			String letterlow, double newCGHigh,
			double newCGLow, double tempDG) {
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle("Report");
		
		alertDialogBuilder
		.setMessage("You need to get Between " + String.format("%.02f", GLow) +
				" % ( if your current grade is " + String.format("%.02f", newCGHigh) + 
				" % ) and " + String.format("%.02f", GHigh) + 
				" % (if your current grade is " + String.format("%.02f", newCGLow) + 
				" % ) in order to obtain " + String.format("%.02f", tempDG) + " in the class." )
		.setCancelable(false).			//it cannot be cancelled
		setPositiveButton("OK", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();		//exit the dialog box
				
			}
			
		}); 
		
		//has to be AFTER SETTINGS
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();		//create and show it
		
		
	}
	
	
	
	private void gradell(double GLow,
			double GHigh, String letterHigh,
			String letterlow, double newCGHigh,
			double newCGLow, double tempDG) {
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle("Report");
		
		alertDialogBuilder
		.setMessage("You need at least to get Between " + String.format("%.02f", GLow) + " % ( if your current grade is "
		+ String.format("%.02f", newCGHigh) + " % ) and " + String.format("%.02f", GHigh) + 
		" % (if your current grade is " + String.format("%.02f", newCGLow) + " % ) in order to obtain " + 
		String.format("%.02f", tempDG) + " in the class." )
		.setCancelable(false).			//it cannot be cancelled
		setPositiveButton("OK", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();		//exit the dialog box
				
			}
			
		}); 
		
		//has to be AFTER SETTINGS
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();		//create and show it
		
		
	}
	
	private void gradepp(double percent, String letter, double Desired){
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle("Report");
		
		alertDialogBuilder
		.setMessage("You need to get a(n) " + letter + "(" + String.format("%.02f", percent) + " %) in order to obtain " + String.format("%.02f", Desired) + " in the class." ).setCancelable(false).			//it cannot be cancelled
		setPositiveButton("OK", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();		//exit the dialog box
				
			}
			
		}); 
		
		//has to be AFTER SETTINGS
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();		//create and show it
		
		
	}
	
private void gradepl(double percent, String letter, String Desired){
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle("Report");
		
		alertDialogBuilder
		.setMessage("You At least need to get a(n) " + letter + "(" + String.format("%.02f", percent) + " %) in order to obtain " + Desired + " in the class." ).setCancelable(false).			//it cannot be cancelled
		setPositiveButton("OK", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();		//exit the dialog box
				
			}
			
		}); 
		
		//has to be AFTER SETTINGS
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();		//create and show it
		
		
	}

	

	private void addListenerOnCalcButton() {				//we have not pushed the button yet
		
		buttonCalculate.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				tempFC = Double.parseDouble(FCedivar.getText().toString());
				
				/*if(((CGedi.getText().toString()==null) ) || ((DGedi.getText().toString()==null) ) ||
						((FCedivar.getText().toString()==null) ) || (((Double.parseDouble(FCedivar.getText().toString())) < 0)
								|| ((Double.parseDouble(FCedivar.getText().toString())) > 100) )){
					
					invalidDiaolog();
					
				}*/
				
				
				/*else*/ if(!("".equals(CGedi.getText().toString())) && !("".equals(DGedi.getText().toString())) &&
						!("".equals(FCedivar.getText().toString())) && (((Double.parseDouble(FCedivar.getText().toString())) >= 0)
								&& ((Double.parseDouble(FCedivar.getText().toString())) <= 100) )) 
				{	
		
		if("%".equals(String.valueOf(CGspi.getSelectedItem())) && "%".equals(String.valueOf(DGspi.getSelectedItem())) ){
			//CG:% & DG:%
			
			tempDG = Double.parseDouble(DGedi.getText().toString());
			tempCG = Double.parseDouble(CGedi.getText().toString());			
			
			if(((tempCG >= 0) && (tempCG <= 100) )&& ((tempDG >= 0) && (tempDG <= 100) )){
				
				gradepercent = (((tempDG*100)- (tempCG*(100 - tempFC)))/tempFC);
				gradeletter = setLetterGrade(gradepercent);
				gradepp(gradepercent, gradeletter, tempDG);
				
				
			}//do calculation stuff & display message
			else{
				//error check
				invalidDiaolog();
			}
			
			
		}
		else if("Letter Grade".equals(String.valueOf(CGspi.getSelectedItem())) && "%".equals(String.valueOf(DGspi.getSelectedItem()))){
			//CG:Letter & DG:%
			
			tempDG = Double.parseDouble(DGedi.getText().toString());
			StmpCG = CGedi.getText().toString();
			
			if(((tempDG >= 0) && (tempDG <= 100) )&& (("A+".equals(StmpCG)) || ("A".equals(StmpCG)) || ("A-".equals(StmpCG))
					|| ("B+".equals(StmpCG)) || ("B".equals(StmpCG)) || ("B-".equals(StmpCG))
					|| ("C+".equals(StmpCG)) || ("C".equals(StmpCG)) || ("C-".equals(StmpCG))
					|| ("D+".equals(StmpCG)) || ("D".equals(StmpCG)) || ("D-".equals(StmpCG))
					|| ("F".equals(StmpCG))) ){
				
				NewCGHigh = setNewCGHigh(StmpCG);
				NewCGLow = setNewCGLow(StmpCG);
				
				
				gradepercentLow = (((tempDG*100)- (NewCGHigh*(100 - tempFC)))/tempFC);
				gradepercentHigh = (((tempDG*100)- (NewCGLow*(100 - tempFC)))/tempFC);
				
				gradeletterHightemp = setLetterGrade(gradepercentHigh);
				gradeletterlowtemp = setLetterGrade(gradepercentLow);
				
				gradelp(gradepercentLow, gradepercentHigh, gradeletterHightemp, gradeletterlowtemp
						, NewCGHigh, NewCGLow , tempDG);
				
			}//do calculation stuff & display message
			else{
				invalidDiaolog();
				//error check
			}
			
		}
		else if("Letter Grade".equals(String.valueOf(DGspi.getSelectedItem())) && "Letter Grade".equals(String.valueOf(CGspi.getSelectedItem()))){
			//CG:Letter & DG:Letter
			StmpCG = CGedi.getText().toString();
			StmpDG = DGedi.getText().toString();
			
			if(((("A+".equals(DGedi.getText().toString())) || ("A".equals((DGedi.getText().toString()))) || ("A-".equals((DGedi.getText().toString())))
					|| ("B+".equals((DGedi.getText().toString()))) || ("B".equals((DGedi.getText().toString()))) || ("B-".equals((DGedi.getText().toString())))
					|| ("C+".equals((DGedi.getText().toString()))) || ("C".equals((DGedi.getText().toString()))) || ("C-".equals((DGedi.getText().toString())))
					|| ("D+".equals((DGedi.getText().toString()))) || ("D".equals((DGedi.getText().toString()))) || ("D-".equals((DGedi.getText().toString())))
					|| ("F".equals((DGedi.getText().toString()))))) && (("A+".equals(CGedi.getText().toString())) || ("A".equals((CGedi.getText().toString()))) || ("A-".equals((CGedi.getText().toString())))
							|| ("B+".equals((CGedi.getText().toString()))) || ("B".equals((CGedi.getText().toString()))) || ("B-".equals((CGedi.getText().toString())))
							|| ("C+".equals((CGedi.getText().toString()))) || ("C".equals((CGedi.getText().toString()))) || ("C-".equals((CGedi.getText().toString())))
							|| ("D+".equals((CGedi.getText().toString()))) || ("D".equals((CGedi.getText().toString()))) || ("D-".equals((CGedi.getText().toString())))
							|| ("F".equals((CGedi.getText().toString()))))){
				
				tempDG = setDesired(StmpDG);
				NewCGHigh = setNewCGHigh(StmpCG);
				NewCGLow = setNewCGLow(StmpCG);
				
				gradepercentLow = (((tempDG*100)- (NewCGHigh*(100 - tempFC)))/tempFC);
				gradepercentHigh = (((tempDG*100)- (NewCGLow*(100 - tempFC)))/tempFC);
				
				gradeletterHightemp = setLetterGrade(gradepercentHigh);
				gradeletterlowtemp = setLetterGrade(gradepercentLow);
				
				gradell(gradepercentLow, gradepercentHigh, gradeletterHightemp, gradeletterlowtemp
						, NewCGHigh, NewCGLow , tempDG);
				
				
		}//do calculation stuff & display message
			else{
				invalidDiaolog();
				//error check
			}
			
			
		}
		else if("Letter Grade".equals(String.valueOf(DGspi.getSelectedItem())) && "%".equals(String.valueOf(CGspi.getSelectedItem())) ){
			//CG:% & DG:Letter
			tempCG = Double.parseDouble(CGedi.getText().toString());
			StmpDG = DGedi.getText().toString();
			
			if((("A+".equals(DGedi.getText().toString())) || ("A".equals((DGedi.getText().toString()))) || ("A-".equals((DGedi.getText().toString())))
					|| ("B+".equals((DGedi.getText().toString()))) || ("B".equals((DGedi.getText().toString()))) || ("B-".equals((DGedi.getText().toString())))
					|| ("C+".equals((DGedi.getText().toString()))) || ("C".equals((DGedi.getText().toString()))) || ("C-".equals((DGedi.getText().toString())))
					|| ("D+".equals((DGedi.getText().toString()))) || ("D".equals((DGedi.getText().toString()))) || ("D-".equals((DGedi.getText().toString())))
					|| ("F".equals((DGedi.getText().toString()))))&& (((Double.parseDouble(CGedi.getText().toString())) >= 0) && ((Double.parseDouble(CGedi.getText().toString())) <= 100) )){
				
				
				tempDG = setDesired(StmpDG);
				if(tempDG == -1){invalidDiaolog();}
				gradepercent = (((tempDG*100)- (tempCG*(100 - tempFC)))/tempFC);
				gradeletter = setLetterGrade(gradepercent);
				gradepl(gradepercent, gradeletter, StmpDG);
				
				
			
			}//do calculation stuff & display message
			else{
				 invalidDiaolog();
				
			}
			
			
			
		}
		
				}
				else{
					//error check
					invalidDiaolog();
				}
				
	   }

		
	 });
		
   }
	
	private double setNewCGLow(String stringCG) {
		
		if("A+".equals(stringCG)){
			return aplow;
		}
		if("A".equals(stringCG)){
			return alow;
		}
		if("A-".equals(stringCG)){
			return amlow;
		}
		if("B+".equals(stringCG)){
			return bplow;
		}
		if("B".equals(stringCG)){
			return blow;
		}
		if("B-".equals(stringCG)){
			return bmlow;
		}
		if("C+".equals(stringCG)){
			return cplow;
		}
		if("C".equals(stringCG)){
			return clow;
		}
		if("C-".equals(stringCG)){
			return cmlow;
		}
		if("D+".equals(stringCG)){
			return dplow;
		}
		if("D".equals(stringCG)){
			return dlow;
		}
		if("D-".equals(stringCG)){
			return dmlow;
		}
		if("F".equals(stringCG)){
			return flow;
		}
		else{return -1;}
		
		
	}
	
	private double setNewCGHigh(String stringCG) {
		
		if("A+".equals(stringCG)){
			return aphigh;
		}
		if("A".equals(stringCG)){
			return ahigh;
		}
		if("A-".equals(stringCG)){
			return amhigh;
		}
		if("B+".equals(stringCG)){
			return bphigh;
		}
		if("B".equals(stringCG)){
			return bhigh;
		}
		if("B-".equals(stringCG)){
			return bmhigh;
		}
		if("C+".equals(stringCG)){
			return cphigh;
		}
		if("C".equals(stringCG)){
			return chigh;
		}
		if("C-".equals(stringCG)){
			return cmhigh;
		}
		if("D+".equals(stringCG)){
			return dphigh;
		}
		if("D".equals(stringCG)){
			return dhigh;
		}
		if("D-".equals(stringCG)){
			return dmhigh;
		}
		if("F".equals(stringCG)){
			return fhigh;
		}
		else{return -1;}
		
	}
	
	
	private double setDesired(String stringDG) {
		
		if("A+".equals(stringDG)){
			return aplow;
		}
		if("A".equals(stringDG)){
			return alow;
		}
		if("A-".equals(stringDG)){
			return amlow;
		}
		if("B+".equals(stringDG)){
			return bplow;
		}
		if("B".equals(stringDG)){
			return blow;
		}
		if("B-".equals(stringDG)){
			return bmlow;
		}
		if("C+".equals(stringDG)){
			return cplow;
		}
		if("C".equals(stringDG)){
			return clow;
		}
		if("C-".equals(stringDG)){
			return cmlow;
		}
		if("D+".equals(stringDG)){
			return dplow;
		}
		if("D".equals(stringDG)){
			return dlow;
		}
		if("D-".equals(stringDG)){
			return dmlow;
		}
		if("F".equals(stringDG)){
			return flow;
		}
		else{return -1;}
		
	}
	
	private String setLetterGrade(double X) {
		String ltr;
		
		if(X >= aplow && X <= aphigh){ ltr = "A+";  
		return ltr;
	}
		if(X >= alow && X < ahigh){ ltr = "A";  
		return ltr;
	}
		if(X >= amlow && X < amhigh){ ltr = "A-";  
		return ltr;
	}
		if(X >= bplow && X < bphigh){ ltr = "B+";  
		return ltr;
	}
		if(X >= blow && X < bhigh){ ltr = "B";  
		return ltr;
	}
		if(X >= bmlow && X < bmhigh){ ltr = "B-";  
		return ltr;
	}
		if(X >= cplow && X < cphigh){ ltr = "C+";  
		return ltr;
	}
		if(X >= clow && X < chigh){ ltr = "C";  
		return ltr;
	}
		if(X >= cmlow && X < cmhigh){ ltr = "C-";  
		return ltr;
	}
		if(X >= dplow && X < dphigh){ ltr = "D+";  
		return ltr;
	}
		if(X >= dlow && X < dhigh){ ltr = "D";  
		return ltr;
	}
		if(X >= dmlow && X < dmhigh){ ltr = "D-";  
		return ltr;
	}
		if(X >= flow && X < fhigh){ ltr = "F";  
		return ltr;
	}
		else{return "Not existing Grade";}
	
	}



	private void addListenerOnScaleButton() {
		
		buttonScale.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
								
				final Dialog dialogobj_scale = new Dialog(context);
				dialogobj_scale.setContentView(R.layout.scalelayout);
				dialogobj_scale.setTitle("Scale");
				
				final EditText aplowedi;
				final EditText alowedi;
				final EditText amlowedi, bplowedi, blowedi, bmlowedi, cplowedi;
				final EditText clowedi, cmlowedi, dplowedi, dlowedi, dmlowedi, flowedi;
				final EditText aphighedi, ahighedi, amhighedi, bphighedi, bhighedi, bmhighedi, cphighedi;
				final EditText chighedi, cmhighedi, dphighedi, dhighedi, dmhighedi, fhighedi;
				
				aplowedi = (EditText) dialogobj_scale.findViewById(R.id.AplowEdi);
				alowedi = (EditText) dialogobj_scale.findViewById(R.id.ALowEdi);
				amlowedi = (EditText) dialogobj_scale.findViewById(R.id.AmLowEdi);
				bplowedi = (EditText) dialogobj_scale.findViewById(R.id.BpowEdi);
				blowedi = (EditText) dialogobj_scale.findViewById(R.id.BlowEdi);
				bmlowedi = (EditText) dialogobj_scale.findViewById(R.id.BmlowEdi);
				cplowedi = (EditText) dialogobj_scale.findViewById(R.id.CplowEdi);
				clowedi = (EditText) dialogobj_scale.findViewById(R.id.ClowEdi);
				cmlowedi = (EditText) dialogobj_scale.findViewById(R.id.CmlowEdi);
				dplowedi = (EditText) dialogobj_scale.findViewById(R.id.DplowEdi);
				dlowedi = (EditText) dialogobj_scale.findViewById(R.id.DlowEdi);
				dmlowedi = (EditText) dialogobj_scale.findViewById(R.id.DmlowEdi);
				flowedi = (EditText) dialogobj_scale.findViewById(R.id.FlowEdi);
				aphighedi = (EditText) dialogobj_scale.findViewById(R.id.ApHighEdi);
				ahighedi = (EditText) dialogobj_scale.findViewById(R.id.AHighEdi);
				amhighedi = (EditText) dialogobj_scale.findViewById(R.id.AmHighEdi);
				bphighedi = (EditText) dialogobj_scale.findViewById(R.id.BpHighEdi);
				bhighedi = (EditText) dialogobj_scale.findViewById(R.id.BHighEdi);
				bmhighedi = (EditText) dialogobj_scale.findViewById(R.id.BmHighEdi);
				cphighedi = (EditText) dialogobj_scale.findViewById(R.id.CpHighEdi);
				chighedi = (EditText) dialogobj_scale.findViewById(R.id.CHighEdi);
				cmhighedi = (EditText) dialogobj_scale.findViewById(R.id.CmHighEdi);
				dphighedi = (EditText) dialogobj_scale.findViewById(R.id.DpHighEdi);
				dhighedi = (EditText) dialogobj_scale.findViewById(R.id.DHighEdi);
				dmhighedi = (EditText) dialogobj_scale.findViewById(R.id.DmHighEdi);
				fhighedi = (EditText) dialogobj_scale.findViewById(R.id.FHighEdi);
				
				aplowedi.setText(Double.toString(aplow));
				alowedi.setText(Double.toString(alow));
				amlowedi.setText(Double.toString(amlow));
				bplowedi.setText(Double.toString(bplow));
				blowedi.setText(Double.toString(blow));
				bmlowedi.setText(Double.toString(bmlow));
				cplowedi.setText(Double.toString(cplow));
				clowedi.setText(Double.toString(clow));
				cmlowedi.setText(Double.toString(cmlow));
				dplowedi.setText(Double.toString(dplow));
				dlowedi.setText(Double.toString(dlow));
				dmlowedi.setText(Double.toString(dmlow));
				flowedi.setText(Double.toString(flow));
				aphighedi.setText(Double.toString(aphigh));
				ahighedi.setText(Double.toString(ahigh));
				amhighedi.setText(Double.toString(amhigh));
				bphighedi.setText(Double.toString(bphigh));
				bhighedi.setText(Double.toString(bhigh));
				bmhighedi.setText(Double.toString(bmhigh));
				cphighedi.setText(Double.toString(cphigh));
				chighedi.setText(Double.toString(chigh));
				cmhighedi.setText(Double.toString(cmhigh));
				dphighedi.setText(Double.toString(dphigh));
				dhighedi.setText(Double.toString(dhigh));
				dmhighedi.setText(Double.toString(dmhigh));
				fhighedi.setText(Double.toString(fhigh));
				
							
				Button diaBtnScalSave = (Button) dialogobj_scale.findViewById(R.id.ScaleSaveButton);
				diaBtnScalSave.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						
						aplow = Double.parseDouble(aplowedi.getText().toString());
						alow = Double.parseDouble(alowedi.getText().toString());
						amlow = Double.parseDouble(amlowedi.getText().toString());
						bplow = Double.parseDouble(bplowedi.getText().toString());
						blow = Double.parseDouble(blowedi.getText().toString());
						bmlow = Double.parseDouble(bmlowedi.getText().toString());
						cplow = Double.parseDouble(cplowedi.getText().toString());
						clow = Double.parseDouble(clowedi.getText().toString());
						cmlow = Double.parseDouble(cmlowedi.getText().toString());
						dplow = Double.parseDouble(dplowedi.getText().toString());
						dlow = Double.parseDouble(dlowedi.getText().toString());
						dmlow = Double.parseDouble(dmlowedi.getText().toString());
						flow = Double.parseDouble(flowedi.getText().toString());
						aphigh = Double.parseDouble(aphighedi.getText().toString());
						ahigh = Double.parseDouble(ahighedi.getText().toString());
						amhigh = Double.parseDouble(amhighedi.getText().toString());
						bphigh = Double.parseDouble(bphighedi.getText().toString());
						bhigh = Double.parseDouble(bhighedi.getText().toString());
						bmhigh = Double.parseDouble(bmhighedi.getText().toString());
						cphigh = Double.parseDouble(cphighedi.getText().toString());
						chigh = Double.parseDouble(chighedi.getText().toString());
						cmhigh = Double.parseDouble(cmhighedi.getText().toString());
						dphigh = Double.parseDouble(dphighedi.getText().toString());
						dhigh = Double.parseDouble(dhighedi.getText().toString());
						dmhigh = Double.parseDouble(dmhighedi.getText().toString());
						fhigh = Double.parseDouble(fhighedi.getText().toString());
						
						
					}
					
					
					
				});
				
				
				
				Button diaBtnScal = (Button) dialogobj_scale.findViewById(R.id.ScalecancelButton);
				diaBtnScal.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						
						//have to save informations
						dialogobj_scale.dismiss();
						
					}
					
					
				});
				dialogobj_scale.show();
				
			}
			
			
		});
	}

	private void addListenerOnDetailButton() {
		
		buttonDetails.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				// Dialog for details
				final Dialog dialogobj_detail = new Dialog(context);
				dialogobj_detail.setContentView(R.layout.detailslayout);
				dialogobj_detail.setTitle("Details");	

				
				Button diaBtnDet = (Button) dialogobj_detail.findViewById(R.id.DetailOkButton);
				diaBtnDet.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						
						dialogobj_detail.dismiss();
						
					}
					
				});
				
				dialogobj_detail.show();
				
				
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
