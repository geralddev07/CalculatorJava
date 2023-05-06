import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
    
    //Declare the buttons
    JLabel label = new JLabel();
    JFrame frame = new JFrame();
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionsButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    //Declare the font used
    Font myFont = new Font("MV Boli", Font.PLAIN,30);
    double num1=0, num2=0, result=0;
    char operator;



    Calculator(){
        // This display the label of the frame and logo
        frame.setVisible(false);
        ImageIcon image = new ImageIcon("C:\\Users\\Gerald\\Downloads\\CalcuLogo.png");
        frame.setIconImage(image.getImage());
        frame.add(label);
        frame.setTitle("Calculator Made by Gerald Perilla");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        //This display the buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("X");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionsButtons[0] = addButton;
        functionsButtons[1] = subButton;
        functionsButtons[2] = mulButton;
        functionsButtons[3] = divButton;
        functionsButtons[4] = decButton;
        functionsButtons[5] = equButton;
        functionsButtons[6] = delButton;
        functionsButtons[7] = clrButton;
        functionsButtons[8] = negButton;

        for (int i=0; i<9; i++) {
            functionsButtons[i].addActionListener(this);
            functionsButtons[i].setFont(myFont);
            functionsButtons[i].setFocusable(false);

        }
        for (int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(negButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
public static void main(String[]args) {
    Calculator calc = new Calculator();
} 
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<10;i++){
            if(e.getSource()== numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource()==addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource()==subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
    }
    if (e.getSource()==mulButton){
        num1 = Double.parseDouble(textfield.getText());
        operator = 'X';
        textfield.setText("");
}
    if (e.getSource()==divButton){
    num1 = Double.parseDouble(textfield.getText());
    operator = '/';
    textfield.setText("");
}
   if (e.getSource()==equButton){
    num2 = Double.parseDouble(textfield.getText());

    switch(operator){
        case '+':
        result=num1+num2;
        break;
        case '-':
        result=num1-num2;
        break;
        case 'X':
        result=num1*num2;
        break;
        case '/':
        result=num1/num2;
        break;
    }
    textfield.setText(String.valueOf(result));
    num1=result;

   }
   if (e.getSource()==clrButton){
    textfield.setText("");
}
if (e.getSource()==delButton) {
    String string = textfield.getText();
    textfield.setText("");
    for (int i=0; i<string.length()-1;i++){
        textfield.setText(textfield.getText()+string.charAt(i));
    }
  }
  if (e.getSource()==negButton) {
   double temp = Double.parseDouble(textfield.getText());
   temp*=-1;
   textfield.setText(String.valueOf(temp));
}

  }   
}



