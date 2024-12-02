import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CollegeManagementSystem {
    private static ArrayList<String[]> studentDataArray = new ArrayList<>();
    private static ArrayList<String[]> facultyDataArray = new ArrayList<>();

    public static void main(String[] args) {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel("", JLabel.CENTER);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("student") && password.equals("123")) {
                loginFrame.dispose();
                openStudentPanel();
            } else if (username.equals("faculty") && password.equals("123")) {
                loginFrame.dispose();
                openFacultyPanel();
            } else {
                messageLabel.setText("Invalid Credentials. Try Again!");
            }
        });

        loginFrame.add(usernameLabel);
        loginFrame.add(usernameField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(new JLabel());
        loginFrame.add(loginButton);
        loginFrame.add(messageLabel);

        loginFrame.setVisible(true);
    }

    private static void openStudentPanel() {
        JFrame studentFrame = new JFrame("Student Panel");
        studentFrame.setSize(600, 400);
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addDeleteButton = new JButton("Add/Delete Student Data");
        JButton modifyButton = new JButton("Modify Student Data");
        JButton searchButton = new JButton("Search Student Data");
        JButton reportButton = new JButton("Display Overall Student Report");
        JButton exitButton = new JButton("Exit");

        addDeleteButton.addActionListener(e -> {
            JFrame addDeleteFrame = new JFrame("Add/Delete Student");
            addDeleteFrame.setSize(400, 300);
            addDeleteFrame.setLayout(new GridLayout(5, 2, 10, 10));

            JLabel nameLabel = new JLabel("Name:");
            JTextField nameField = new JTextField();
            JLabel idLabel = new JLabel("ID:");
            JTextField idField = new JTextField();
            JButton addButton = new JButton("Add");
            JButton deleteButton = new JButton("Delete");

            addButton.addActionListener(evt -> {
                studentDataArray.add(new String[]{nameField.getText(), idField.getText()});
                JOptionPane.showMessageDialog(addDeleteFrame, "Student Added Successfully!");
            });

            deleteButton.addActionListener(evt -> {
                studentDataArray.removeIf(data -> data[1].equals(idField.getText()));
                JOptionPane.showMessageDialog(addDeleteFrame, "Student Deleted Successfully!");
            });

            addDeleteFrame.add(nameLabel);
            addDeleteFrame.add(nameField);
            addDeleteFrame.add(idLabel);
            addDeleteFrame.add(idField);
            addDeleteFrame.add(new JLabel());
            addDeleteFrame.add(addButton);
            addDeleteFrame.add(new JLabel());
            addDeleteFrame.add(deleteButton);

            addDeleteFrame.setVisible(true);
        });

        modifyButton.addActionListener(e -> {
            JFrame modifyFrame = new JFrame("Modify Student Data");
            modifyFrame.setSize(400, 300);
            modifyFrame.setLayout(new GridLayout(5, 2, 10, 10));

            JLabel idLabel = new JLabel("Enter ID:");
            JTextField idField = new JTextField();
            JLabel newNameLabel = new JLabel("New Name:");
            JTextField newNameField = new JTextField();
            JButton modifyDataButton = new JButton("Modify");

            modifyDataButton.addActionListener(evt -> {
                boolean found = false;
                for (String[] student : studentDataArray) {
                    if (student[1].equals(idField.getText())) {
                        student[0] = newNameField.getText();
                        found = true;
                        JOptionPane.showMessageDialog(modifyFrame, "Student Data Modified Successfully!");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(modifyFrame, "Student Not Found!");
                }
            });

            modifyFrame.add(idLabel);
            modifyFrame.add(idField);
            modifyFrame.add(newNameLabel);
            modifyFrame.add(newNameField);
            modifyFrame.add(new JLabel());
            modifyFrame.add(modifyDataButton);

            modifyFrame.setVisible(true);
        });

        searchButton.addActionListener(e -> {
            JFrame searchFrame = new JFrame("Search Student Data");
            searchFrame.setSize(400, 300);
            searchFrame.setLayout(new GridLayout(3, 2, 10, 10));

            JLabel idLabel = new JLabel("Enter ID:");
            JTextField idField = new JTextField();
            JTextArea resultArea = new JTextArea();
            JButton searchDataButton = new JButton("Search");

            searchDataButton.addActionListener(evt -> {
                boolean found = false;
                for (String[] student : studentDataArray) {
                    if (student[1].equals(idField.getText())) {
                        resultArea.setText("Name: " + student[0] + ", ID: " + student[1]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    resultArea.setText("Student Not Found!");
                }
            });

            searchFrame.add(idLabel);
            searchFrame.add(idField);
            searchFrame.add(new JLabel());
            searchFrame.add(searchDataButton);
            searchFrame.add(new JLabel());
            searchFrame.add(resultArea);

            searchFrame.setVisible(true);
        });

        reportButton.addActionListener(e -> {
            JFrame reportFrame = new JFrame("Student Report");
            reportFrame.setSize(400, 300);
            JTextArea reportArea = new JTextArea();
            for (String[] student : studentDataArray) {
                reportArea.append("Name: " + student[0] + ", ID: " + student[1] + "\n");
            }
            reportFrame.add(new JScrollPane(reportArea));
            reportFrame.setVisible(true);
        });

        exitButton.addActionListener(e -> studentFrame.dispose());

        studentFrame.add(addDeleteButton);
        studentFrame.add(modifyButton);
        studentFrame.add(searchButton);
        studentFrame.add(reportButton);
        studentFrame.add(exitButton);

        studentFrame.setVisible(true);
    }

    private static void openFacultyPanel() {
        JFrame facultyFrame = new JFrame("Faculty Panel");
        facultyFrame.setSize(600, 400);
        facultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        facultyFrame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addDeleteButton = new JButton("Add/Delete Faculty Data");
        JButton modifyButton = new JButton("Modify Faculty Data");
        JButton searchButton = new JButton("Search Faculty Data");
        JButton reportButton = new JButton("Display Overall Faculty Report");
        JButton exitButton = new JButton("Exit");

        // Add actions similar to student panel for faculty

        exitButton.addActionListener(e -> facultyFrame.dispose());

        facultyFrame.add(addDeleteButton);
        facultyFrame.add(modifyButton);
        facultyFrame.add(searchButton);
        facultyFrame.add(reportButton);
        facultyFrame.add(exitButton);

        facultyFrame.setVisible(true);
    }
        }
