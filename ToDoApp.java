package com.todoapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the components
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton clearButton = new JButton("Clear All");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);

        // Add tasks list
        List<String> tasks = new ArrayList<>();

        // Layout setup
        JPanel panel = new JPanel();
        panel.add(new JLabel("Task:"));
        panel.add(taskField);
        panel.add(addButton);
        panel.add(clearButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    tasks.add(task);          // Add task to the list
                    listModel.addElement(task); // Update GUI list
                    taskField.setText("");   // Clear input field
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tasks.clear();              // Clear task list
                listModel.clear();          // Clear GUI list
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}