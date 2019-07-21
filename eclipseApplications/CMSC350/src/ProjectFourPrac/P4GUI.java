package ProjectFourPrac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Filename:    P4GUI
 * Author:      William Crutchfield
 * Date:        7/13/2017
 * Description: Takes a fileName, tokenizes contents of said file to build a DGraph. Then takes a className(vertex)
 * in which a sub-graph is topologically sorted from, output as a String.
 */
public class P4GUI extends JFrame{

    // Variables
    private String fileName;
    private String className;

    // DGraph
    private DGraph<String> dGraph;

    /**
     * Constructs the GUI and handles Action Listeners
     */
    private P4GUI() {
        // Set Title
        super ("Class Dependency Graph");

        // Create Panels
        JPanel main = new JPanel();
        JPanel labelsPanel = new JPanel();
        JPanel txtPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        JPanel inputs = new JPanel();
        JPanel output = new JPanel();

        // Panel Colors
        Color subtleGray = new Color(220,220,220);
        inputs.setBackground(subtleGray);
        labelsPanel.setBackground(subtleGray);
        txtPanel.setBackground(subtleGray);
        btnPanel.setBackground(subtleGray);

        // Set Layouts
        main.setLayout(new GridBagLayout());
        labelsPanel.setLayout(new GridBagLayout());
        txtPanel.setLayout(new GridBagLayout());
        btnPanel.setLayout(new GridBagLayout());
        inputs.setLayout(new GridBagLayout());
        output.setLayout(new BorderLayout());

        // Create Components
        JLabel fileLabel = new JLabel("Input file name:");
        JTextField fileTxt = new JTextField(null,20);
        fileTxt.setPreferredSize(new Dimension(20,20));
        JButton buildBtn = new JButton("Build Directed Graph");
        JLabel classLabel = new JLabel("Class to recompile:");
        JTextField classTxt = new JTextField(null,20);
        JButton orderBtn = new JButton("Topological Order");
        JTextArea outputTxt = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputTxt);

        // GridBagConstraints Parameters
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        // Add Components to labelsPanel
        // Add fileLabel
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .5;
        labelsPanel.add(fileLabel, c);
        // Add classLabel
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = .5;
        labelsPanel.add(classLabel, c);

        // Add Components to txtPanel
        // Add fileTxt
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .5;
        txtPanel.add(fileTxt, c);
        // Add classTxt
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = .5;
        txtPanel.add(classTxt, c);

        // Add Components to btnPanel
        // Add buildBtn
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .5;
        btnPanel.add(buildBtn, c);
        // Add orderBtn
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = .5;
        btnPanel.add(orderBtn, c);

        // Add outputTxt
        output.setBorder(BorderFactory.createTitledBorder("Recompilation Order"));
        outputTxt.setLineWrap(true);
        outputTxt.setWrapStyleWord(true);
        outputTxt.setEditable(false);
        output.add(scrollPane);

        // Add GridBagConstraints fill for Panels
        c.fill = GridBagConstraints.BOTH;

        // Add Panels to inputs Panel
        inputs.setBorder(BorderFactory.createTitledBorder(""));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        inputs.add(labelsPanel, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        inputs.add(txtPanel, c);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        inputs.add(btnPanel, c);

        // Add Panels to main
        c.insets = new Insets(1,2,1,2);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        main.add(inputs, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        main.add(output, c);

        // Add main to JFrame
        add(main);

        // JFrame Settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,350);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // "Build Directed Graph" Button Handler
        buildBtn.addActionListener((ActionEvent e) -> {

            // Create project4.DGraph Instance
            dGraph = new DGraph<>();

            fileName = fileTxt.getText();

            try {
                // Ensures List has a value
                if (fileName.isEmpty()) {
                    throw new NullPointerException();
                }

                // Attempt to build a DGraph with file
                dGraph.buildDGraphFromFile(dGraph.tokenizeFile(fileName));

                // Graph Built
                JOptionPane.showMessageDialog(null, "Graph Built Successfully","Message",JOptionPane.INFORMATION_MESSAGE);

            } catch (NullPointerException e1) {
                JOptionPane.showMessageDialog(null, "A File Name is Required","Error",JOptionPane.ERROR_MESSAGE);
            } catch (IOException e2) {
                JOptionPane.showMessageDialog(null, "File Did Not Open","Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        // "Topological Order" Button Handler
        orderBtn.addActionListener((ActionEvent e) -> {

            className = classTxt.getText();

            try {
                outputTxt.setText(dGraph.topOrdGeneration(className));

            } catch (InvalidClassNameException e1) {
                JOptionPane.showMessageDialog(null, "Invalid Class Name: " + className,"Error",JOptionPane.ERROR_MESSAGE);
            } catch (ContainsCycleException e2) {
                JOptionPane.showMessageDialog(null, "This DGraph contains a Cycle!","Message",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new P4GUI();
    }
}
