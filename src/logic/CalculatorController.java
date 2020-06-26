package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
	@FXML private Button btnPlus;
	@FXML private Button btnMinus;
	@FXML private Button btnMult;
	@FXML private Button btnDiv;
	@FXML private Button btnResult;
	@FXML private Button btnDel;
	@FXML private Button btn0;
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
	@FXML private Button btn4;
	@FXML private Button btn5;
	@FXML private Button btn6;
	@FXML private Button btn7;
	@FXML private Button btn8;
	@FXML private Button btn9;
	@FXML private TextField tfResult;
	private String n1 = "";
	private String n2 = "";
	private String op;
	private Boolean isCalc = false; // Booleano messo a true dopo il calcolo del risultato
	
	@FXML
	private void pressedButton0(ActionEvent event) {
		digitNumber(0);
	}
	@FXML
	private void pressedButton1(ActionEvent event) {
		digitNumber(1);
	}
	@FXML
	private void pressedButton2(ActionEvent event) {
		digitNumber(2);
	}
	@FXML
	private void pressedButton3(ActionEvent event) {
		digitNumber(3);
	}
	@FXML
	private void pressedButton4(ActionEvent event) {
		digitNumber(4);
	}
	@FXML
	private void pressedButton5(ActionEvent event) {
		digitNumber(5);
	}
	@FXML
	private void pressedButton6(ActionEvent event) {
		digitNumber(6);
	}
	@FXML
	private void pressedButton7(ActionEvent event) {
		digitNumber(7);
	}
	@FXML
	private void pressedButton8(ActionEvent event) {
		digitNumber(8);
	}
	@FXML
	private void pressedButton9(ActionEvent event) {
		digitNumber(9);
	}
	
	private void digitNumber(int num) {
		if (Boolean.TRUE.equals(isCalc)) {
			tfResult.setText("");
			isCalc = false;
		}
		tfResult.setText(tfResult.getText() + num);
	}
	
	
	public void setNum(int who) {
		String num = this.tfResult.getText();
		if(!num.equalsIgnoreCase("")) {
			if(who == 1) {
				this.n1 = num;
			}
			else {
				this.n2 = num;
			}
		}
		this.tfResult.setText("");
	}
	
	
	@FXML
	public void setOp(ActionEvent event) {
		if(event.getSource() == this.btnPlus) {
			this.op = "+";
		}
		else if(event.getSource() == this.btnMinus) {
			this.op = "-";
		}
		else if(event.getSource() == this.btnMult) {
			this.op = "*";
		}
		else {
			this.op = "/";
		}
		setNum(1);
	}
	
	@FXML
	public void delNum(ActionEvent e) {
		String currNum = this.tfResult.getText();
		if (Boolean.TRUE.equals(isCalc)) {
			this.tfResult.setText("");
			isCalc = false;
		}
		else if(!currNum.equalsIgnoreCase("")) {
			currNum = String.valueOf(currNum.subSequence(0, currNum.length()-1));
			this.tfResult.setText(currNum);
		}
	}
	
	@FXML
	public void resultFromOp(ActionEvent e) {
		setNum(2);
		if(this.n1.equalsIgnoreCase("") || this.n2.equalsIgnoreCase("")) {
			this.tfResult.setText(String.valueOf(""));
			this.n1 = "";
			this.n2 = "";
			return;
		}
		float res = 0;
		switch(op) {
			case("+"):
				res = Float.parseFloat(this.n1) + Float.parseFloat(this.n2);
				break;
			case("-"):
				res = Float.parseFloat(this.n1) - Float.parseFloat(this.n2);
				break;
			case("*"):
				res = Float.parseFloat(this.n1) * Float.parseFloat(this.n2);
				break;
			case("/"):
				if(Integer.valueOf(this.n2) != 0) {
					res = Float.parseFloat(this.n1) / Float.parseFloat(this.n2);
				}
				else {
					this.tfResult.setText(String.valueOf(""));
					return;
				}
				break;
			default:
			}
		this.tfResult.setText(String.valueOf(res));
		this.n1 = "";
		this.n2 = "";
		isCalc = true; //imposta il booleano dopo il calcolo così che al prossimo input resetti il risultato
	}
}
