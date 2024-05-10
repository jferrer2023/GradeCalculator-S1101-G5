//MO-IT103_S1101_Group5 RedDragons - Jeffrey Dollopac, Joyce Ferrer, Ryu Ken Lindo, Mikko Jerome Bautista


import javax.swing.*;
import java.awt.event.*;
import javax.swing.SpringLayout;

public class GradeCalculator extends JFrame {
    private JLabel lblStudentName, lblStudentNo, lblQuiz1, lblQuiz2, lblQuiz3;
    private JTextField txtStudentName, txtStudentNo, txtQuiz1, txtQuiz2, txtQuiz3;
    private JButton calculateButton;

    public GradeCalculator() {
        super("Grade Calculator");
        setSize(450, 250);

        lblStudentName = new JLabel("Student Name:");
        txtStudentName = new JTextField(30);
        lblStudentNo = new JLabel("Student No:");
        txtStudentNo = new JTextField(30);
        lblQuiz1 = new JLabel("MS 1:");
        txtQuiz1 = new JTextField(10);
        lblQuiz2 = new JLabel("MS 2:");
        txtQuiz2 = new JTextField(10);
        lblQuiz3 = new JLabel("TA:");
        txtQuiz3 = new JTextField(10);
        calculateButton = new JButton("Calculate");

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(300, 300);
        panel.setLayout(layout);

        panel.add(lblStudentName);
        panel.add(txtStudentName);
        panel.add(lblStudentNo);
        panel.add(txtStudentNo);
        panel.add(lblQuiz1);
        panel.add(txtQuiz1);
        panel.add(lblQuiz2);
        panel.add(txtQuiz2);
        panel.add(lblQuiz3);
        panel.add(txtQuiz3);
        panel.add(calculateButton);

layout.putConstraint(SpringLayout.WEST, lblStudentName, 6, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.WEST, lblStudentNo, 6, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.WEST, lblQuiz1, 6, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.WEST, lblQuiz2, 6, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.WEST, lblQuiz3, 6, SpringLayout.WEST, panel);

layout.putConstraint(SpringLayout.NORTH, lblStudentName, 6, SpringLayout.NORTH, panel);
layout.putConstraint(SpringLayout.NORTH, txtStudentName, 6, SpringLayout.NORTH, panel);
layout.putConstraint(SpringLayout.NORTH, lblStudentNo, 10, SpringLayout.SOUTH, lblStudentName);
layout.putConstraint(SpringLayout.NORTH, txtStudentNo, 6, SpringLayout.SOUTH, txtStudentName);
layout.putConstraint(SpringLayout.NORTH, lblQuiz1, 10, SpringLayout.SOUTH, lblStudentNo);
layout.putConstraint(SpringLayout.NORTH, txtQuiz1, 6, SpringLayout.SOUTH, txtStudentNo);
layout.putConstraint(SpringLayout.NORTH, lblQuiz2, 10, SpringLayout.SOUTH, lblQuiz1);
layout.putConstraint(SpringLayout.NORTH, txtQuiz2, 6, SpringLayout.SOUTH, txtQuiz1);
layout.putConstraint(SpringLayout.NORTH, lblQuiz3, 10, SpringLayout.SOUTH, lblQuiz2); // Change to 10 for alignment
layout.putConstraint(SpringLayout.NORTH, txtQuiz3, 6, SpringLayout.SOUTH, txtQuiz2);


layout.putConstraint(SpringLayout.WEST, txtStudentName, 6, SpringLayout.EAST, lblStudentName);
layout.putConstraint(SpringLayout.WEST, txtStudentNo, 24, SpringLayout.EAST, lblStudentNo);
layout.putConstraint(SpringLayout.WEST, txtQuiz1, 51, SpringLayout.EAST, lblQuiz1);
layout.putConstraint(SpringLayout.WEST, txtQuiz2, 51, SpringLayout.EAST, lblQuiz2);
layout.putConstraint(SpringLayout.WEST, txtQuiz3, 51, SpringLayout.EAST, lblQuiz3); // Change to 51 for alignment

layout.putConstraint(SpringLayout.NORTH, calculateButton, 6, SpringLayout.SOUTH, txtQuiz3);
layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, calculateButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);

add(panel);


        calculateButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        
             //************ADDED/MODIFIED FOR LAB3--START*************
            if (txtStudentName.getText().isEmpty() || 
            txtStudentNo.getText().isEmpty() || 
            txtQuiz1.getText().isEmpty() || 
            txtQuiz2.getText().isEmpty() || 
            txtQuiz3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a value for all fields");
            return; // Exit the method early if any field is empty
        }

        try {
            float quiz1Value = Float.parseFloat(txtQuiz1.getText());
            float quiz2Value = Float.parseFloat(txtQuiz2.getText());
            float quiz3Value = Float.parseFloat(txtQuiz3.getText());
            
            if (quiz1Value <= 0 || quiz2Value <= 0 || quiz3Value <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
                return; // Exit the method early if any quiz value is <= 0
            }

            Student stud = new Student();
            stud.setStudentName(txtStudentName.getText());
            stud.setStudentNumber(txtStudentNo.getText());
            stud.setQuiz1(quiz1Value);
            stud.setQuiz2(quiz2Value);
            stud.setQuiz3(quiz3Value);
            
            GradeOutput output = new GradeOutput(stud);
            output.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numbers");
        }
    }
});
   //************ADDED/MODIFIED FOR LAB3--START*************
        
    //************ADDED FOR LAB3--START*************
        txtQuiz1.addFocusListener(new FocusAdapter() {
        public void focusLost(FocusEvent e) {
        try {
            float quiz1Value = Float.parseFloat(txtQuiz1.getText());
            if (quiz1Value <= 0) {
                JOptionPane.showMessageDialog(null, "Do not enter <= 0");
                txtQuiz1.setText(""); // Clear the text field
               
            }
        } catch (NumberFormatException ex) {
            // Handle the case where the user enters a non-numeric value
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
            txtQuiz1.setText(""); 
      
        }
    }
});

        txtQuiz2.addFocusListener(new FocusAdapter() {
        public void focusLost(FocusEvent e) {
        try {
            float quiz2Value = Float.parseFloat(txtQuiz2.getText());
            if (quiz2Value <= 0) {
                JOptionPane.showMessageDialog(null, "Do not enter <= 0");
                txtQuiz2.setText(""); 
              
            }
        } catch (NumberFormatException ex) {
            // Handle the case where the user enters a non-numeric value
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
            txtQuiz2.setText(""); 
          
        }
    }
});

txtQuiz3.addFocusListener(new FocusAdapter() {
    public void focusLost(FocusEvent e) {
        try {
            float quiz3Value = Float.parseFloat(txtQuiz3.getText());
            if (quiz3Value <= 0) {
                JOptionPane.showMessageDialog(null, "Do not enter <= 0");
                txtQuiz3.setText(""); 
        
            }
        } catch (NumberFormatException ex) {
            // Handle the case where the user enters a non-numeric value
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
            txtQuiz3.setText(""); 
           
        }
    }
});
      //************ADDED FOR LAB3 --END*************  
        
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GradeCalculator calculator = new GradeCalculator();
                calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                calculator.setVisible(true);
                
            }
        });
    }
}
