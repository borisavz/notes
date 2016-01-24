package program;

//BeleskeGUI (NotesGUI in english) is codename of this project. Don't judge me.



import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BeleskeGUI extends javax.swing.JFrame {
    JFileChooser fileChooser = new JFileChooser();
    int[] fontSize = new int[5];
    int[] fontType = new int[5];
    boolean[] saved = new boolean[5];
    Color[] background = new Color[5];
    Color[] text = new Color[5];
    String path;
    public BeleskeGUI() throws FontFormatException, IOException {
        initComponents();
        //intialize variables
        for(int i = 0; i < 5; i++) { 
            saved[i] = true;
            text[i] = Color.BLACK;
            background[i] = Color.WHITE;
            fontSize[i] = 12;
            fontType[i] = Font.PLAIN;
        }
        jTextArea1.setFont(new Font(Font.SANS_SERIF, fontType[0], fontSize[0]));
        jTextArea2.setFont(new Font(Font.SANS_SERIF, fontType[1], fontSize[1]));
        jTextArea3.setFont(new Font(Font.SANS_SERIF, fontType[2], fontSize[2]));
        jTextArea4.setFont(new Font(Font.SANS_SERIF, fontType[3], fontSize[3]));
        jTextArea5.setFont(new Font(Font.SANS_SERIF, fontType[4], fontSize[4]));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/icons/icon1-100px.png")).getImage());
        setMinimumSize(new java.awt.Dimension(600, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-as-icon20px.png"))); // NOI18N
        jButton1.setToolTipText("Save file as");
        jButton1.setFocusable(false);
        jButton1.setMaximumSize(new java.awt.Dimension(32, 32));
        jButton1.setMinimumSize(new java.awt.Dimension(32, 32));
        jButton1.setPreferredSize(new java.awt.Dimension(32, 32));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open-icon20px.png"))); // NOI18N
        jButton2.setToolTipText("Open file");
        jButton2.setFocusable(false);
        jButton2.setMaximumSize(new java.awt.Dimension(32, 32));
        jButton2.setMinimumSize(new java.awt.Dimension(32, 32));
        jButton2.setPreferredSize(new java.awt.Dimension(32, 32));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Plain");
        jRadioButton1.setToolTipText("Chnage font type to plain");
        jRadioButton1.setFocusable(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jRadioButton2.setText("Bold");
        jRadioButton2.setToolTipText("Chnage font type to bold");
        jRadioButton2.setFocusable(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        jRadioButton3.setText("Italic");
        jRadioButton3.setToolTipText("Change font type to italic");
        jRadioButton3.setFocusable(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("Color:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange" }));
        jComboBox2.setToolTipText("Change background color of current tab");
        jComboBox2.setFocusable(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange" }));
        jComboBox3.setSelectedIndex(1);
        jComboBox3.setToolTipText("Change text color of current tab");
        jComboBox3.setFocusable(false);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-icon20px.png"))); // NOI18N
        jButton4.setToolTipText("Save file");
        jButton4.setFocusable(false);
        jButton4.setMaximumSize(new java.awt.Dimension(32, 32));
        jButton4.setMinimumSize(new java.awt.Dimension(32, 32));
        jButton4.setPreferredSize(new java.awt.Dimension(32, 32));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "8", "12", "14", "16", "18", "20", "24", "38", "72", " " }));
        jComboBox4.setSelectedIndex(3);
        jComboBox4.setToolTipText("Change font size of current tab");
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(jTextArea5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton3))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        save();
    }//GEN-LAST:event_jButton1MouseClicked
    //save file as
    private void save() {
        fileChooser.showSaveDialog(this);
        File file = fileChooser.getSelectedFile();
        PrintWriter printWriter = null;
        try {
            path = file.getAbsolutePath();
            printWriter = new PrintWriter(path);
            switch(jTabbedPane1.getSelectedIndex()) {
                case 0: for(String tekst1 : jTextArea1.getText().split("\n")) printWriter.println(tekst1); break;
                case 1: for(String tekst1 : jTextArea2.getText().split("\n")) printWriter.println(tekst1); break;
                case 2: for(String tekst1 : jTextArea3.getText().split("\n")) printWriter.println(tekst1); break;
                case 3: for(String tekst1 : jTextArea4.getText().split("\n")) printWriter.println(tekst1); break;
                case 4: for(String tekst1 : jTextArea5.getText().split("\n")) printWriter.println(tekst1); break;
            }
            saved[jTabbedPane1.getSelectedIndex()] = true;
            jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), file.getName());
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Invalid file.\n"
                + "Close all programs and try again.");
        } catch(NullPointerException e) {} finally { printWriter.close(); }
    }
    //change info shown in ribbon when user changes tab
    private void updateInfo(int i) {
        setTitle("Notes - " + jTabbedPane1.getTitleAt(i));
        switch(fontType[i]) {
            case Font.PLAIN: jRadioButton1.setSelected(true); break;
            case Font.BOLD: jRadioButton2.setSelected(true); break;
            case Font.ITALIC: jRadioButton3.setSelected(true); break;
        }
        if(background[i].equals(Color.WHITE)) jComboBox2.setSelectedIndex(0); else  
        if(background[i].equals(Color.BLACK)) jComboBox2.setSelectedIndex(1); else
        if(background[i].equals(Color.GRAY)) jComboBox2.setSelectedIndex(2); else
        if(background[i].equals(Color.LIGHT_GRAY)) jComboBox2.setSelectedIndex(3); else
        if(background[i].equals(Color.DARK_GRAY)) jComboBox2.setSelectedIndex(4); else
        if(background[i].equals(Color.YELLOW)) jComboBox2.setSelectedIndex(5); else
        if(background[i].equals(Color.BLUE)) jComboBox2.setSelectedIndex(6); else
        if(background[i].equals(Color.RED)) jComboBox2.setSelectedIndex(7); else
        if(background[i].equals(Color.GREEN)) jComboBox2.setSelectedIndex(8); else
        if(background[i].equals(Color.ORANGE)) jComboBox2.setSelectedIndex(9);
        if(text[i].equals(Color.WHITE)) jComboBox3.setSelectedIndex(0); else  
        if(text[i].equals(Color.BLACK)) jComboBox3.setSelectedIndex(1); else
        if(text[i].equals(Color.GRAY)) jComboBox3.setSelectedIndex(2); else
        if(text[i].equals(Color.LIGHT_GRAY)) jComboBox3.setSelectedIndex(3); else
        if(text[i].equals(Color.DARK_GRAY)) jComboBox3.setSelectedIndex(4); else
        if(text[i].equals(Color.YELLOW)) jComboBox3.setSelectedIndex(5); else
        if(text[i].equals(Color.BLUE)) jComboBox3.setSelectedIndex(6); else
        if(text[i].equals(Color.RED)) jComboBox3.setSelectedIndex(7); else
        if(text[i].equals(Color.GREEN)) jComboBox3.setSelectedIndex(8); else
        if(text[i].equals(Color.ORANGE)) jComboBox3.setSelectedIndex(9);
        switch(fontSize[i]) {
            case 3: jComboBox4.setSelectedIndex(0); break;
            case 5: jComboBox4.setSelectedIndex(1); break;
            case 8: jComboBox4.setSelectedIndex(2); break;
            case 12: jComboBox4.setSelectedIndex(3); break;
            case 14: jComboBox4.setSelectedIndex(4); break;
            case 16: jComboBox4.setSelectedIndex(5); break;
            case 18: jComboBox4.setSelectedIndex(6); break;
            case 20: jComboBox4.setSelectedIndex(7); break;
            case 24: jComboBox4.setSelectedIndex(8); break;
            case 38: jComboBox4.setSelectedIndex(9); break;
            case 72: jComboBox4.setSelectedIndex(10); break;
        }
    }
    //change font size and type of current tab
    private void setFont() {
        int i = jTabbedPane1.getSelectedIndex();
        switch(i) {
            case 0: jTextArea1.setFont(new Font(Font.SANS_SERIF, fontType[i], fontSize[i])); break;
            case 1: jTextArea2.setFont(new Font(Font.SANS_SERIF, fontType[i], fontSize[i])); break;
            case 2: jTextArea3.setFont(new Font(Font.SANS_SERIF, fontType[i], fontSize[i])); break;
            case 3: jTextArea4.setFont(new Font(Font.SANS_SERIF, fontType[i], fontSize[i])); break;
            case 4: jTextArea5.setFont(new Font(Font.SANS_SERIF, fontType[i], fontSize[i])); break;
        }
    }
    //open file
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(saved[jTabbedPane1.getSelectedIndex()] == false) if(JOptionPane.showConfirmDialog(this, "Do you want to save changes?", jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()), JOptionPane.YES_NO_OPTION) == 0) save();
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path = file.getAbsolutePath();
            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(path));
                switch(jTabbedPane1.getSelectedIndex()) {
                    case 0:
                        jTextArea1.setText(null);
                        while(scanner.hasNextLine()) jTextArea1.append(scanner.nextLine() + "\n"); 
                        break;
                    case 1:
                        jTextArea2.setText(null);
                        while(scanner.hasNextLine()) jTextArea2.append(scanner.nextLine() + "\n"); 
                        break;
                    case 2:
                        jTextArea3.setText(null);
                        while(scanner.hasNextLine()) jTextArea3.append(scanner.nextLine() + "\n"); 
                        break;
                    case 3:
                        jTextArea4.setText(null);
                        while(scanner.hasNextLine()) jTextArea4.append(scanner.nextLine() + "\n"); 
                        break;
                    case 4:
                        jTextArea5.setText(null);
                        while(scanner.hasNextLine()) jTextArea5.append(scanner.nextLine() + "\n"); 
                        break;
                }
                jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), file.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Invalid file.\n"
                    + "Close all programs and try again.");
            } catch(NullPointerException e) {} finally { scanner.close(); }
        }
    }//GEN-LAST:event_jButton2MouseClicked
    //change font type to plain
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        fontType[jTabbedPane1.getSelectedIndex()] = Font.PLAIN;
        setFont();
    }//GEN-LAST:event_jRadioButton1ActionPerformed
    //change font type to bold
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        fontType[jTabbedPane1.getSelectedIndex()] = Font.BOLD;
        setFont();
    }//GEN-LAST:event_jRadioButton2ActionPerformed
    //change font type to italic
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        fontType[jTabbedPane1.getSelectedIndex()] = Font.ITALIC;
        setFont();
    }//GEN-LAST:event_jRadioButton3ActionPerformed
    //change background color of each idividual text area 
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        //it is fucking more readable, ain't it??
        int i = jTabbedPane1.getSelectedIndex();
        switch(jComboBox2.getSelectedIndex()) {                                  
            case 0: background[i] = Color.WHITE; break;
            case 1: background[i] = Color.BLACK; break;
            case 2: background[i] = Color.GRAY; break;
            case 3: background[i] = Color.LIGHT_GRAY; break;
            case 4: background[i] = Color.DARK_GRAY; break;
            case 5: background[i] = Color.YELLOW; break;
            case 6: background[i] = Color.BLUE; break;
            case 7: background[i] = Color.RED; break;
            case 8: background[i] = Color.GREEN; break;
            case 9: background[i] = Color.ORANGE; break;
        }
        switch(i) {
            case 0: jTextArea1.setBackground(background[i]); break;
            case 1: jTextArea2.setBackground(background[i]); break;
            case 2: jTextArea3.setBackground(background[i]); break;
            case 3: jTextArea4.setBackground(background[i]); break;
            case 4: jTextArea5.setBackground(background[i]); break;
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed
    //change foreground color of each individual text area  
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        int i = jTabbedPane1.getSelectedIndex();
        switch(jComboBox3.getSelectedIndex()) {                                  
            case 0: text[i] = Color.WHITE; break;
            case 1: text[i] = Color.BLACK; break;
            case 2: text[i] = Color.GRAY; break;
            case 3: text[i] = Color.LIGHT_GRAY; break;
            case 4: text[i] = Color.DARK_GRAY; break;
            case 5: text[i] = Color.YELLOW; break;
            case 6: text[i] = Color.BLUE; break;
            case 7: text[i] = Color.RED; break;
            case 8: text[i] = Color.GREEN; break;
            case 9: text[i] = Color.ORANGE; break;
        }
        switch(i) {
            case 0: jTextArea1.setForeground(text[i]); break;
            case 1: jTextArea2.setForeground(text[i]); break;
            case 2: jTextArea3.setForeground(text[i]); break;
            case 3: jTextArea4.setForeground(text[i]); break;
            case 4: jTextArea5.setForeground(text[i]); break;
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed
    //change font size of each individual text area
    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        try { fontSize[jTabbedPane1.getSelectedIndex()] = Integer.parseInt(jComboBox4.getSelectedItem().toString()); } 
        catch(Exception e) { } finally { setFont(); }
    }//GEN-LAST:event_jComboBox4ActionPerformed
    //check if user saved his work before exiting
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        for(int i = 0; i < 5; i++) {
            jTabbedPane1.setSelectedIndex(i);
            if(saved[jTabbedPane1.getSelectedIndex()] == false) 
                if(JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "Exit - " + jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()), JOptionPane.YES_NO_OPTION) == 0) save();
        }
    }//GEN-LAST:event_formWindowClosing
    //save file 
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if(path == null) save(); else {
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(path);
                for(String text1 : jTextArea1.getText().split("\n")) printWriter.println(text1);
                saved[jTabbedPane1.getSelectedIndex()] = true;
            } catch(IOException e) {
                JOptionPane.showMessageDialog(null, "Invalid file."
                    + "Close all programs and try again.");
            } catch(NullPointerException e) {} finally { printWriter.close(); }
        }
    }//GEN-LAST:event_jButton4MouseClicked
    //set variable saved to false is user typed something (all text areas use this method for keyTyped event)
    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        saved[jTabbedPane1.getSelectedIndex()] = false;
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        updateInfo(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jTabbedPane1MouseClicked
    public static void main(String args[]) throws FileNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BeleskeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BeleskeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BeleskeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BeleskeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BeleskeGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(BeleskeGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private static javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextArea jTextArea2;
    private static javax.swing.JTextArea jTextArea3;
    private static javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    // End of variables declaration//GEN-END:variables
}
