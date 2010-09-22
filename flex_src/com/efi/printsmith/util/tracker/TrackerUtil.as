// ActionScript file

public function convertMilliSecondsToString(milliSeconds:Number, showSeconds:Boolean):String {
	var txtString:String = "";
	if(showSeconds){
		if(milliSeconds==0){
			txtString = "";
		} else {
			if(milliSeconds<60000){
				if(numFormatter.format(milliSeconds/1000).length>1){
					txtString = txtString + numFormatter.format(milliSeconds/1000)+" Second(s)";
				} else if(numFormatter.format(milliSeconds/1000).length==1){
					txtString = txtString + "0"+numFormatter.format(milliSeconds/1000)+" Second(s)";
				}
			}
		}
	}
	if(milliSeconds>=60000 && milliSeconds<60000*60){
    	txtString = "0 Hrs ";
    	if(numFormatter.format(milliSeconds/60000).length>1){
    		txtString = txtString + numFormatter.format(milliSeconds/60000);
    	} else if(numFormatter.format(milliSeconds/60000).length==1){
    		txtString = txtString + "0"+numFormatter.format(milliSeconds/60000);
    	}
    	if(showSeconds){
    		if(numFormatter.format((milliSeconds%60000)/(1000)).length>1){
    			txtString = txtString + ":" + numFormatter.format((milliSeconds%60000)/(1000));
    		} else if(numFormatter.format((milliSeconds%60000)/(1000)).length==1){
    			txtString = txtString + ":" + "0"+numFormatter.format((milliSeconds%60000)/(1000));
    		}
    	}
    }
    if(milliSeconds>=60000*60 && milliSeconds<60000*60*24){
    	txtString = numFormatter.format(milliSeconds/(60000*60))+" Hrs ";
    	if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length>1){
    		txtString = txtString + numFormatter.format(milliSeconds%(60000*60)/(60000));
    	} else if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length==1){
    		txtString = txtString + "0"+numFormatter.format(milliSeconds%(60000*60)/(60000));
    	}
    	if(showSeconds){
    		if(numFormatter.format(milliSeconds%60000/1000).length>1){
    			txtString = txtString + ":" + numFormatter.format(milliSeconds%60000/1000);
    		} else if(numFormatter.format(milliSeconds%60000/1000).length==1){
    			txtString = txtString + ":" + "0"+numFormatter.format(milliSeconds%60000/1000);
    		}
    	}
    }
    if(milliSeconds>=60000*60*24){
    	txtString = numFormatter.format( milliSeconds/(60000*60*24))+" Day(s) ";
    	txtString = txtString+numFormatter.format(milliSeconds%(60000*60*24)/(60000*60))+" Hrs ";
    	if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length>1){
    		txtString = txtString+numFormatter.format(milliSeconds%(60000*60)/(60000));
    	} else if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length==1){
    		txtString = txtString+"0"+numFormatter.format(milliSeconds%(60000*60)/(60000));
    	}
    	if(showSeconds){
    		if(numFormatter.format(milliSeconds%60000/1000).length>1){
    			txtString = txtString+":"+numFormatter.format(milliSeconds%60000/1000);
    		} else if(numFormatter.format(milliSeconds%60000/1000).length==1){
    			txtString = txtString+":"+"0"+numFormatter.format(milliSeconds%60000/1000);
    		}
    	}
    }
    if(txtString==""){
    	txtString = "0:00";
    }
    return txtString;
}

public function convertMilliSecondsToNegString(milliSeconds:Number, showSeconds:Boolean):String {
	var isNegative:Boolean = false;
	if(milliSeconds<0){
		isNegative=true;
		milliSeconds = -(milliSeconds);
	}
	var txtString:String = "";
	if(showSeconds){
		if(milliSeconds==0){
			txtString = "";
		} else {
			if(milliSeconds<60000){
				if(numFormatter.format(milliSeconds/1000).length>1){
					txtString = txtString + numFormatter.format(milliSeconds/1000)+" Second(s)";
				} else if(numFormatter.format(milliSeconds/1000).length==1){
					txtString = txtString + "0"+numFormatter.format(milliSeconds/1000)+" Second(s)";
				}
			}
		}
	}
	if(milliSeconds>=60000 && milliSeconds<60000*60){
    	txtString = "0 Hrs ";
    	if(numFormatter.format(milliSeconds/60000).length>1){
    		txtString = txtString + numFormatter.format(milliSeconds/60000);
    	} else if(numFormatter.format(milliSeconds/60000).length==1){
    		txtString = txtString + "0"+numFormatter.format(milliSeconds/60000);
    	}
    	if(showSeconds){
    		if(numFormatter.format((milliSeconds%60000)/(1000)).length>1){
    			txtString = txtString + ":" + numFormatter.format((milliSeconds%60000)/(1000));
    		} else if(numFormatter.format((milliSeconds%60000)/(1000)).length==1){
    			txtString = txtString + ":" + "0"+numFormatter.format((milliSeconds%60000)/(1000));
    		}
    	}
    }
    if(milliSeconds>=60000*60 && milliSeconds<60000*60*24){
    	txtString = numFormatter.format(milliSeconds/(60000*60))+" Hrs ";
    	if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length>1){
    		txtString = txtString + numFormatter.format(milliSeconds%(60000*60)/(60000));
    	} else if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length==1){
    		txtString = txtString + "0"+numFormatter.format(milliSeconds%(60000*60)/(60000));
    	}
    	if(showSeconds){
    		if(numFormatter.format(milliSeconds%60000/1000).length>1){
    			txtString = txtString + ":" + numFormatter.format(milliSeconds%60000/1000);
    		} else if(numFormatter.format(milliSeconds%60000/1000).length==1){
    			txtString = txtString + ":" + "0"+numFormatter.format(milliSeconds%60000/1000);
    		}
    	}
    }
    if(milliSeconds>=60000*60*24){
    	txtString = numFormatter.format( milliSeconds/(60000*60*24))+" Day(s) ";
    	txtString = txtString+numFormatter.format(milliSeconds%(60000*60*24)/(60000*60))+" Hrs ";
    	if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length>1){
    		txtString = txtString+numFormatter.format(milliSeconds%(60000*60)/(60000));
    	} else if(numFormatter.format(milliSeconds%(60000*60)/(60000)).length==1){
    		txtString = txtString+"0"+numFormatter.format(milliSeconds%(60000*60)/(60000));
    	}
    	if(showSeconds){
    		if(numFormatter.format(milliSeconds%60000/1000).length>1){
    			txtString = txtString+":"+numFormatter.format(milliSeconds%60000/1000);
    		} else if(numFormatter.format(milliSeconds%60000/1000).length==1){
    			txtString = txtString+":"+"0"+numFormatter.format(milliSeconds%60000/1000);
    		}
    	}
    }
    if(txtString==""){
    	txtString = "0:00";
    }
    if(isNegative){
    	txtString = "-"+txtString;
    }
    return txtString;
}