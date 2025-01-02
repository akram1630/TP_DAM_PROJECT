package com.example.projet_tp_dam;

public class Module {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private int id;
	private String name ;
	private double noteTp;
	private double noteTd;
	private double noteControl ;

	public Module(){};
	public Module(String name , int coefficient , int poidsControl , int poidsTdAndTp){
		this.name = name;
		this.coefficient = coefficient;
		this.poidsControl = poidsControl;
		this.poidsTdAndTp = poidsTdAndTp;
		this.noteTd = 0;
		this.noteTp = 0;
		this.noteControl = 0;
	}
	public double getNoteTp() {
		return noteTp;
	}

	public double getNoteTd() {
		return noteTd;
	}
	public void setNoteTp(double noteTp) {
		this.noteTp = noteTp;
	}
	public void setNoteTd(double noteTd) {
		this.noteTd = noteTd;
	}
	public double getNoteControl() {
		return noteControl;
	}

	public void setNoteControl(double noteControl) {
		this.noteControl = noteControl;
	}

	/*public Module(String name , double noteTd , double noteTp , double noteControl){
		this.name = name;
		this.noteTp = noteTp;
		this.noteTd = noteTd;
		this.noteControl = noteControl;

	}//*/





	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	private String  type = "3";
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
//		if (type=='1')
//			moyenne = noteControl;
//		if(type=='2')
//			moyenne = poidsControl * 0.01  * noteControl + poidsTdAndTp* 0.01 * noteTd ;
//		if(type=='3')
//			moyenne = poidsControl * 0.01 * noteControl + poidsTdAndTp* 0.01 * ((noteTd+noteTp)/2) ;
//
	}
	
	public double getMoyenne() {
		return moyenne;
	}
	

	

	



	
	
	
	


	
	
	
}
