package GUI;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private String department;
    private double gpa;
	
    public Student(int id, String name, String department, double gpa) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.gpa = gpa;
    }

// Getters
    public int getId() {
		return id; 
	}
    public String getName() {
		return name; 
	}
	public String getDepartment() {
		return department; 
	}
	public double getGpa() {
		return gpa; 
	}
}

	//Acess constructor
class StudentDA {
    private ArrayList<Student> students = new ArrayList<>();
    private static  String FILE_NAME = "students.txt";
    public StudentDA() {
        loadFromFile();
    }
		//Add
    public void addStudent(Student student) throws IOException {
        students.add(student);
        saveToFile();
    }
		//Search
    public Student getStudentById(int id) {
    for (int i = 0; i < students.size(); i++) {
        Student s = students.get(i);
        if (s.getId() == id) {
            return s;
        }
    }
    return null;
}

		//Save
     private void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < students.size(); i++) {
					Student s = students.get(i);
					writer.write(s.getId() + "," + s.getName() + "," + s.getDepartment() + "," + s.getGpa());
					writer.newLine();
			}
        }
    }

		//Load
	private void loadFromFile() {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String dept = parts[2];
                    double gpa = Double.parseDouble(parts[3]);
                    students.add(new Student(id, name, dept, gpa));
                }
            }
        } catch (IOException e) {
        }
    }
}
	
		
public class Addstudent extends javax.swing.JFrame {
	 private StudentDA studentDA = new StudentDA();
	public Addstudent() {
		initComponents();

			//Empty
        nametxt.setText("");
        idtxt.setText("");
        deptxt.setText("");
        gpatxt.setText("");
	}
	

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        gpaLabel = new javax.swing.JLabel();
        Addbutt = new javax.swing.JButton();
        nametxt = new javax.swing.JTextField();
        idtxt = new javax.swing.JTextField();
        deptxt = new javax.swing.JTextField();
        gpatxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setText("Name");

        jLabel3.setText("Department");

        idLabel.setText("ID");

        gpaLabel.setText("GPA");

        Addbutt.setText("Add");
        Addbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbuttActionPerformed(evt);
            }
        });

        nametxt.setText("jTextField1");
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        idtxt.setText("jTextField2");
        idtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtxtActionPerformed(evt);
            }
        });

        deptxt.setText("jTextField3");
        deptxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptxtActionPerformed(evt);
            }
        });

        gpatxt.setText("jTextField4");
        gpatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpatxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gpaLabel)
                            .addComponent(idLabel)
                            .addComponent(nameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gpatxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nametxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 196, Short.MAX_VALUE)
                .addComponent(Addbutt)
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gpatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(gpaLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Addbutt))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
			//Add Button
    private void AddbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbuttActionPerformed
		
String idStr = idtxt.getText();
String name = nametxt.getText();
String gpaStr = gpatxt.getText();
String department = deptxt.getText();

if (idStr.isEmpty() || name.isEmpty() || department.isEmpty() || gpaStr.isEmpty()) {
    JOptionPane.showMessageDialog(this, 
            "Please fill in all fields.", "Input error", JOptionPane.ERROR_MESSAGE);
    return;
}

int id;
double gpa;

	//ID check
try {
    id = Integer.parseInt(idStr);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, 
            "ID must be a valid number", "Input error", JOptionPane.ERROR_MESSAGE);
    return;
}

		//GPA check
try {
    gpa = Double.parseDouble(gpaStr);
    if (gpa < 0.0 || gpa > 4.0) { 
         throw new NumberFormatException();
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, 
            "(GPA) must be a number between 0.0 and 4.0.", 
            "Input error", 
            JOptionPane.ERROR_MESSAGE);
    return;
}

		//used before?
 if (studentDA.getStudentById(id) != null) {
            JOptionPane.showMessageDialog(this, "This ID is already in use.", "Error: ", JOptionPane.ERROR_MESSAGE);
            return;
        }

	Student newStudent;
		 newStudent = new Student(id, name, department, gpa);

try {
        studentDA.addStudent(newStudent);
        JOptionPane.showMessageDialog(this, "Student added successfully!", "success", JOptionPane.INFORMATION_MESSAGE);
            
				//Empty
		idtxt.setText("");
	    nametxt.setText("");
        deptxt.setText("");
		gpatxt.setText("");
        } catch (Exception e) {
		JOptionPane.showMessageDialog(this, "An error occurred while saving student data.\n"+ e.getMessage(), "Saving error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_AddbuttActionPerformed

    private void gpatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gpatxtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void idtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtxtActionPerformed

    private void deptxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptxtActionPerformed

	public static void main(String args[]) {

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbutt;
    private javax.swing.JTextField deptxt;
    private javax.swing.JLabel gpaLabel;
    private javax.swing.JTextField gpatxt;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idtxt;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nametxt;
    // End of variables declaration//GEN-END:variables
