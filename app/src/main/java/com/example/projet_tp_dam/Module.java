package com.example.projet_tp_dam;

public class Module {

	private String name ;
	private int noteTp;
	private int noteTd;
	private int noteControl ;


	public Module(String name){
		this.name = name;
		this.noteTd = 0;
		this.noteTp = 0;
		this.noteControl = 0;
	}
	public int getNoteTp() {
		return noteTp;
	}

	public int getNoteTd() {
		return noteTd;
	}
	public void setNoteTp(int noteTp) {
		this.noteTp = noteTp;
	}
	public void setNoteTd(int noteTd) {
		this.noteTd = noteTd;
	}
	public int getNoteControl() {
		return noteControl;
	}

	public void setNoteControl(int noteControl) {
		this.noteControl = noteControl;
	}

	/*public Module(String name , double noteTd , double noteTp , double noteControl){
		this.name = name;
		this.noteTp = noteTp;
		this.noteTd = noteTd;
		this.noteControl = noteControl;

	}//*/



	public char getType() {
		return type;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

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
	

	

	
	public void setType(char type) {
		this.type = type;
	}


	
	
	
	


	
	
	
}
