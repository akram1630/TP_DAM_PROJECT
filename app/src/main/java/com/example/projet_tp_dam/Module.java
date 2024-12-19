package com.example.projet_tp_dam;

public class Module {

	private String name ;
	private double noteTp;
	private double noteTd;


	public Module(String name , double noteTd , double noteTp){
		this.name = name;
		this.noteTp = noteTp;
		this.noteTd = noteTd;

	}//

	public double getNoteTp() {
		return noteTp;
	}

	public double getNoteTd() {
		return noteTd;
	}

	public char getType() {
		return type;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	private double noteControl ;
	private char type = '3';
	private int coefficient ;
	private int poidsControl ;
	private int poidsTdAndTp ;	
	private double moyenne ;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	
	public int getPoidsControl() {
		return poidsControl;
	}
	
	public void setPoidsControl(int poidsControl) {
		this.poidsControl = poidsControl;
	}
	
	public int getPoidsTdAndTp() {
		return poidsTdAndTp;
	}
	
	public void setPoidsTdAndTp(int poidsTdAndTp) {
		this.poidsTdAndTp = poidsTdAndTp;
	}
	
	public void setMoyenne() {
		if (type=='1')
			moyenne = noteControl;
		if(type=='2')
			moyenne = poidsControl * 0.01  * noteControl + poidsTdAndTp* 0.01 * noteTd ;
		if(type=='3')
			moyenne = poidsControl * 0.01 * noteControl + poidsTdAndTp* 0.01 * ((noteTd+noteTp)/2) ;
		
	}
	
	public double getMoyenne() {
		return moyenne;
	}
	
	public void setNoteTp(double noteTp) {
		this.noteTp = noteTp;
	}
	
	
	public void setNoteTd(double noteTd) {
		this.noteTd = noteTd;
	}
	

	
	public void setType(char type) {
		this.type = type;
	}

	public double getNoteControl() {
		return noteControl;
	}

	public void setNoteControl(double noteControl) {
		this.noteControl = noteControl;
	}
	
	
	
	


	
	
	
}
