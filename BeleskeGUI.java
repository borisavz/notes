/* BeleskeGUI (NotesGUI in english) is codename of this project. Don't judge me.
 *
 * version 4.1 
 * 
 * Developed by Borisav Zivanovic 2016
 *
 * Project is open source
 * 
 * E-mail & Hangouts: borisavzivanovic@gmail.com
 *
 */

package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class BeleskeGUI extends javax.swing.JFrame {
    /*macros for index of color selected in ribbon
    tip: using macros can make larger projects easier to understand*/
    private static final int WHITE = 0, BLACK = 1, GRAY = 2, LIGHT_GRAY = 3, 
            DARK_GRAY = 4, YELLOW = 5, BLUE = 6, RED = 7, GREEN = 8, ORANGE = 9;
    //macros for font size selected in ribbon
    private static final int FONT_SIZE_3 = 0, FONT_SIZE_5 = 1, FONT_SIZE_8 = 2, 
            FONT_SIZE_12 = 3, FONT_SIZE_14 = 4, FONT_SIZE_16 = 5, FONT_SIZE_18 = 6, 
            FONT_SIZE_20 = 7, FONT_SIZE_24 = 8, FONT_SIZE_38 = 9, FONT_SIZE_72 = 10;
    JFileChooser fileChooser = new JFileChooser();
    int[] fontSize = new int[5];
    int[] fontType = new int[5];
    boolean[] saved = new boolean[5];
    Color[] background = new Color[5];
    Color[] text = new Color[5];
    String path;
    UndoManager[] undoManager = new UndoManager[5];
    public BeleskeGUI() throws FontFormatException, IOException {
        initComponents();
        //intialize variables
        for(int i = 0; i < 5; i++) { 
            saved[i] = true;
            fontSize[i] = 12;
            text[i] = Color.BLACK;
            background[i] = Color.WHITE;
            fontType[i] = Font.PLAIN;
            undoManager[i] = new UndoManager();
        }
        //add UndoableEditListener for all 5 tabs
        jTextArea1.getDocument().addUndoableEditListener(undoManager[0]);
        jTextArea2.getDocument().addUndoableEditListener(undoManager[1]);
        jTextArea3.getDocument().addUndoableEditListener(undoManager[2]);
        jTextArea4.getDocument().addUndoableEditListener(undoManager[3]);
        jTextArea5.getDocument().addUndoableEditListener(undoManager[4]);
        //set default font settings
        jTextArea1.setFont(new Font(Font.SANS_SERIF, fontType[0], fontSize[0]));
        jTextArea2.setFont(new Font(Font.SANS_SERIF, fontType[1], fontSize[1]));
        jTextArea3.setFont(new Font(Font.SANS_SERIF, fontType[2], fontSize[2]));
        jTextArea4.setFont(new Font(Font.SANS_SERIF, fontType[3], fontSize[3]));
        jTextArea5.setFont(new Font(Font.SANS_SERIF, fontType[4], fontSize[4]));
        //MouseListener for opening the context menu
        jTextArea1.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { contextMenu(e); } });
        jTextArea2.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { contextMenu(e); } });
        jTextArea3.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { contextMenu(e); } });
        jTextArea4.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { contextMenu(e); } });
        jTextArea5.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { contextMenu(e); } });
        jTabbedPane1.setSelectedIndex(0);
        updateInfo(jTabbedPane1.getSelectedIndex());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        saveAs = new javax.swing.JButton();
        open = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        plain = new javax.swing.JRadioButton();
        bold = new javax.swing.JRadioButton();
        italic = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        textColor = new javax.swing.JComboBox();
        backgroundColor = new javax.swing.JComboBox();
        save = new javax.swing.JButton();
        setFontSize = new javax.swing.JComboBox();
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
        jSeparator7 = new javax.swing.JSeparator();
        undo = new javax.swing.JButton();
        redo = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/icons/icon1-100px.png")).getImage());
        setMinimumSize(new java.awt.Dimension(610, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        saveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-as-icon20px.png"))); // NOI18N
        saveAs.setToolTipText("Save file as");
        saveAs.setFocusable(false);
        saveAs.setMaximumSize(new java.awt.Dimension(32, 32));
        saveAs.setMinimumSize(new java.awt.Dimension(32, 32));
        saveAs.setPreferredSize(new java.awt.Dimension(32, 32));
        saveAs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveAsMouseClicked(evt);
            }
        });

        open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open-icon20px.png"))); // NOI18N
        open.setToolTipText("Open file");
        open.setFocusable(false);
        open.setMaximumSize(new java.awt.Dimension(32, 32));
        open.setMinimumSize(new java.awt.Dimension(32, 32));
        open.setPreferredSize(new java.awt.Dimension(32, 32));
        open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonGroup1.add(plain);
        plain.setSelected(true);
        plain.setText("Plain");
        plain.setToolTipText("Chnage font type to plain");
        plain.setFocusable(false);
        plain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plainActionPerformed(evt);
            }
        });

        buttonGroup1.add(bold);
        bold.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bold.setText("Bold");
        bold.setToolTipText("Chnage font type to bold");
        bold.setFocusable(false);
        bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldActionPerformed(evt);
            }
        });

        buttonGroup1.add(italic);
        italic.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        italic.setText("Italic");
        italic.setToolTipText("Change font type to italic");
        italic.setFocusable(false);
        italic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italicActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("Color:");

        textColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange" }));
        textColor.setToolTipText("Change background color of current tab");
        textColor.setFocusable(false);
        textColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textColorActionPerformed(evt);
            }
        });

        backgroundColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange" }));
        backgroundColor.setSelectedIndex(1);
        backgroundColor.setToolTipText("Change text color of current tab");
        backgroundColor.setFocusable(false);
        backgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundColorActionPerformed(evt);
            }
        });

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-icon20px.png"))); // NOI18N
        save.setToolTipText("Save file");
        save.setFocusable(false);
        save.setMaximumSize(new java.awt.Dimension(32, 32));
        save.setMinimumSize(new java.awt.Dimension(32, 32));
        save.setPreferredSize(new java.awt.Dimension(32, 32));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        setFontSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "8", "12", "14", "16", "18", "20", "24", "38", "72", " " }));
        setFontSize.setSelectedIndex(3);
        setFontSize.setToolTipText("Change font size of current tab");
        setFontSize.setFocusable(false);
        setFontSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFontSizeActionPerformed(evt);
            }
        });

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
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
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
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
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel5);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/undo-icon20px.png"))); // NOI18N
        undo.setToolTipText("Undo");
        undo.setEnabled(false);
        undo.setFocusable(false);
        undo.setPreferredSize(new java.awt.Dimension(32, 32));
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        redo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redo-icon20px.png"))); // NOI18N
        redo.setToolTipText("Redo");
        redo.setEnabled(false);
        redo.setFocusable(false);
        redo.setPreferredSize(new java.awt.Dimension(32, 32));
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(saveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(setFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(plain)
                        .addGap(6, 6, 6)
                        .addComponent(bold)
                        .addGap(6, 6, 6)
                        .addComponent(italic)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(textColor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(redo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(undo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setFontSize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backgroundColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bold, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plain, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(italic, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(566, 566, 566))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>                        
    
    //show context menu
    private void contextMenu(MouseEvent e) {
        boolean selected = false;
        /*check if user clicked mouse button for opening context menu
        (usually right click)*/
        if(e.isPopupTrigger()) {
            switch(jTabbedPane1.getSelectedIndex()) {
                case 0: selected = jTextArea1.getSelectionStart() != jTextArea1.getSelectionEnd(); break;
                case 1: selected = jTextArea2.getSelectionStart() != jTextArea2.getSelectionEnd(); break;
                case 2: selected = jTextArea3.getSelectionStart() != jTextArea3.getSelectionEnd(); break;
                case 3: selected = jTextArea4.getSelectionStart() != jTextArea4.getSelectionEnd(); break;
                case 4: selected = jTextArea5.getSelectionStart() != jTextArea5.getSelectionEnd(); break;
            }
            JPopupMenu menu = new JPopupMenu();
            JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
            JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
            JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
            JMenuItem delete = new JMenuItem("Delete");
            delete.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) {
                    switch(jTabbedPane1.getSelectedIndex()) {
                        case 0: jTextArea1.replaceSelection(""); break;
                        case 1: jTextArea2.replaceSelection(""); break;
                        case 2: jTextArea3.replaceSelection(""); break;
                        case 3: jTextArea4.replaceSelection(""); break;
                        case 4: jTextArea5.replaceSelection(""); break;
                    }
                } } );
            cut.setText("Cut");
            copy.setText("Copy");
            paste.setText("Paste");
            cut.setEnabled(selected);
            copy.setEnabled(selected);
            delete.setEnabled(selected);
            paste.setEnabled(true);
            menu.add(cut);
            menu.add(copy);
            menu.add(paste);
            menu.addSeparator();
            menu.add(delete);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    private void saveAsMouseClicked(java.awt.event.MouseEvent evt) {                                    
        save();
    }                                   
    //save file as
    private void save() {
        fileChooser.showSaveDialog(this);
        File file = fileChooser.getSelectedFile();
        PrintWriter printWriter = null;
        try {
            path = file.getAbsolutePath();
            printWriter = new PrintWriter(path);
            switch(jTabbedPane1.getSelectedIndex()) {
                case 0: 
                    for(String tekst1 : jTextArea1.getText().split("\n")) 
                        printWriter.println(tekst1); 
                    break;
                case 1: 
                    for(String tekst1 : jTextArea2.getText().split("\n")) 
                        printWriter.println(tekst1); 
                    break;
                case 2: 
                    for(String tekst1 : jTextArea3.getText().split("\n")) 
                        printWriter.println(tekst1); 
                    break;
                case 3: 
                    for(String tekst1 : jTextArea4.getText().split("\n")) 
                        printWriter.println(tekst1); 
                    break;
                case 4: 
                    for(String tekst1 : jTextArea5.getText().split("\n")) 
                        printWriter.println(tekst1); 
                    break;
            }
            int i = jTabbedPane1.getSelectedIndex();
            saved[i] = true;
            jTabbedPane1.setTitleAt(i, file.getName());
            updateInfo(i);
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Invalid file.\nClose all programs and try again.");
        } catch(NullPointerException e) {} 
        finally { printWriter.close(); }
    }
    //change info shown in ribbon when user changes tab
    private void updateInfo(int i) {
        //change window title to title of the selcted tab
        setTitle("Notes - " + jTabbedPane1.getTitleAt(i));
        //change font type selected in ribbon
        switch(fontType[i]) {
            case Font.PLAIN: plain.setSelected(true); break;
            case Font.BOLD: bold.setSelected(true); break;
            case Font.ITALIC: italic.setSelected(true); break;
        }
        //change text color selected in ribbon
        if(background[i].equals(Color.WHITE)) 
            textColor.setSelectedIndex(WHITE); 
        else if(background[i].equals(Color.BLACK)) 
            textColor.setSelectedIndex(BLACK); 
        else if(background[i].equals(Color.GRAY)) 
            textColor.setSelectedIndex(GRAY); 
        else if(background[i].equals(Color.LIGHT_GRAY)) 
            textColor.setSelectedIndex(LIGHT_GRAY); 
        else if(background[i].equals(Color.DARK_GRAY)) 
            textColor.setSelectedIndex(DARK_GRAY); 
        else if(background[i].equals(Color.YELLOW)) 
            textColor.setSelectedIndex(YELLOW); 
        else if(background[i].equals(Color.BLUE)) 
            textColor.setSelectedIndex(BLUE); 
        else if(background[i].equals(Color.RED)) 
            textColor.setSelectedIndex(RED); 
        else if(background[i].equals(Color.GREEN)) 
            textColor.setSelectedIndex(GREEN); 
        else if(background[i].equals(Color.ORANGE)) 
            textColor.setSelectedIndex(ORANGE);
        //change background color selected in ribbon
        if(text[i].equals(Color.WHITE))
                backgroundColor.setSelectedIndex(WHITE); 
        else if(text[i].equals(Color.BLACK)) 
            backgroundColor.setSelectedIndex(BLACK); 
        else if(text[i].equals(Color.GRAY)) 
            backgroundColor.setSelectedIndex(GRAY); 
        else if(text[i].equals(Color.LIGHT_GRAY)) 
            backgroundColor.setSelectedIndex(LIGHT_GRAY); 
        else if(text[i].equals(Color.DARK_GRAY)) 
            backgroundColor.setSelectedIndex(DARK_GRAY); 
        else if(text[i].equals(Color.YELLOW)) 
            backgroundColor.setSelectedIndex(YELLOW); 
        else if(text[i].equals(Color.BLUE)) 
            backgroundColor.setSelectedIndex(BLUE); 
        else if(text[i].equals(Color.RED)) 
            backgroundColor.setSelectedIndex(RED); 
        else if(text[i].equals(Color.GREEN)) 
            backgroundColor.setSelectedIndex(GREEN); 
        else if(text[i].equals(Color.ORANGE)) 
            backgroundColor.setSelectedIndex(ORANGE);
        //change font size selected in ribbon
        switch(fontSize[i]) {
            case 3: setFontSize.setSelectedIndex(FONT_SIZE_3); break;
            case 5: setFontSize.setSelectedIndex(FONT_SIZE_5); break;
            case 8: setFontSize.setSelectedIndex(FONT_SIZE_8); break;
            case 12: setFontSize.setSelectedIndex(FONT_SIZE_12); break;
            case 14: setFontSize.setSelectedIndex(FONT_SIZE_14); break;
            case 16: setFontSize.setSelectedIndex(FONT_SIZE_16); break;
            case 18: setFontSize.setSelectedIndex(FONT_SIZE_18); break;
            case 20: setFontSize.setSelectedIndex(FONT_SIZE_20); break;
            case 24: setFontSize.setSelectedIndex(FONT_SIZE_24); break;
            case 38: setFontSize.setSelectedIndex(FONT_SIZE_38); break;
            case 72: setFontSize.setSelectedIndex(FONT_SIZE_72); break;
        }
        //check if user can redo text for the selected tab
        undo.setEnabled(undoManager[i].canUndo());
        redo.setEnabled(undoManager[i].canRedo());
    }
    //change font size and type of current tab
    private void setFont() {
        /*makes code easier to understand
        also method calls are expensive so this will make code slightly faster*/
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
    private void openMouseClicked(java.awt.event.MouseEvent evt) {                                  
        //check if user saved his work
        if(saved[jTabbedPane1.getSelectedIndex()] == false) 
            if(JOptionPane.showConfirmDialog(this, "Do you want to save changes?", jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()), JOptionPane.YES_NO_OPTION) == 0) 
                save();
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path = file.getAbsolutePath();
            BufferedReader bufferedReader = null;
            String line = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
                switch(jTabbedPane1.getSelectedIndex()) {
                    case 0:
                        jTextArea1.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea1.append(line + "\n");
                        break;
                    case 1:
                        jTextArea2.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea2.append(line + "\n"); 
                        break;
                    case 2:
                        jTextArea3.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea3.append(line + "\n"); 
                        break;
                    case 3:
                        jTextArea4.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea4.append(line + "\n"); 
                        break;
                    case 4:
                        jTextArea5.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea5.append(line + "\n"); 
                        break;
                }
                int i = jTabbedPane1.getSelectedIndex();
                jTabbedPane1.setTitleAt(i, file.getName());
                updateInfo(i);
                undo.setEnabled(false);
                redo.setEnabled(false);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Invalid file.\nClose all programs and try again.");
            } catch(NullPointerException e) {} 
            finally { try { bufferedReader.close(); } catch (IOException ex) {}
}
        }
    }                                 
    //change font type to plain
    private void plainActionPerformed(java.awt.event.ActionEvent evt) {                                      
        fontType[jTabbedPane1.getSelectedIndex()] = Font.PLAIN;
        setFont();
    }                                     
    //change font type to bold
    private void boldActionPerformed(java.awt.event.ActionEvent evt) {                                     
        fontType[jTabbedPane1.getSelectedIndex()] = Font.BOLD;
        setFont();
    }                                    
    //change font type to italic
    private void italicActionPerformed(java.awt.event.ActionEvent evt) {                                       
        fontType[jTabbedPane1.getSelectedIndex()] = Font.ITALIC;
        setFont();
    }                                      
    //change background color of each idividual text area 
    private void textColorActionPerformed(java.awt.event.ActionEvent evt) {                                          
        /*it is fucking more readable, ain't it??
        method calls are also expensive*/
        int i = jTabbedPane1.getSelectedIndex();
        switch(textColor.getSelectedIndex()) {                                  
            case WHITE: background[i] = Color.WHITE; break;
            case BLACK: background[i] = Color.BLACK; break;
            case GRAY: background[i] = Color.GRAY; break;
            case LIGHT_GRAY: background[i] = Color.LIGHT_GRAY; break;
            case DARK_GRAY: background[i] = Color.DARK_GRAY; break;
            case YELLOW: background[i] = Color.YELLOW; break;
            case BLUE: background[i] = Color.BLUE; break;
            case RED: background[i] = Color.RED; break;
            case GREEN: background[i] = Color.GREEN; break;
            case ORANGE: background[i] = Color.ORANGE; break;
        }
        switch(i) {
            case 0: jTextArea1.setBackground(background[i]); break;
            case 1: jTextArea2.setBackground(background[i]); break;
            case 2: jTextArea3.setBackground(background[i]); break;
            case 3: jTextArea4.setBackground(background[i]); break;
            case 4: jTextArea5.setBackground(background[i]); break;
        }
    }                                         
    //change foreground color of each individual text area  
    private void backgroundColorActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int i = jTabbedPane1.getSelectedIndex();
        switch(backgroundColor.getSelectedIndex()) {                                  
            case WHITE: text[i] = Color.WHITE; break;
            case BLACK: text[i] = Color.BLACK; break;
            case GRAY: text[i] = Color.GRAY; break;
            case LIGHT_GRAY: text[i] = Color.LIGHT_GRAY; break;
            case DARK_GRAY: text[i] = Color.DARK_GRAY; break;
            case YELLOW: text[i] = Color.YELLOW; break;
            case BLUE: text[i] = Color.BLUE; break;
            case RED: text[i] = Color.RED; break;
            case GREEN: text[i] = Color.GREEN; break;
            case ORANGE: text[i] = Color.ORANGE; break;
        }
        switch(i) {
            case 0: jTextArea1.setForeground(text[i]); break;
            case 1: jTextArea2.setForeground(text[i]); break;
            case 2: jTextArea3.setForeground(text[i]); break;
            case 3: jTextArea4.setForeground(text[i]); break;
            case 4: jTextArea5.setForeground(text[i]); break;
        }
    }                                               
    //change font size of each individual text area
    private void setFontSizeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //there is no way for an exception to be thrown here
        int i = jTabbedPane1.getSelectedIndex();
        fontSize[i] = Integer.parseInt(setFontSize.getSelectedItem().toString());
        setFont();
    }                                           
    //check if user saved his work before exiting
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        for(int i = 0; i < 5; i++) {
            jTabbedPane1.setSelectedIndex(i);
            if(saved[jTabbedPane1.getSelectedIndex()] == false) 
                if(JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "Exit - " + jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()), JOptionPane.YES_NO_OPTION) == 0) 
                    save();
        }
    }                                  
    //save file 
    private void saveMouseClicked(java.awt.event.MouseEvent evt) {                                  
        /*save changes to a modified file or 
        save file as if file does not exist*/
        if(path == null) save(); else {
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(path);
                for(String text1 : jTextArea1.getText().split("\n")) 
                    printWriter.println(text1);
                saved[jTabbedPane1.getSelectedIndex()] = true;
            } catch(IOException e) {
                JOptionPane.showMessageDialog(null, "Invalid file. Close all programs and try again.");
            } catch(NullPointerException e) {} 
            finally { printWriter.close(); }
        }
    }                                 
    /*set variable saved to false is user typed something
    and allow him to undo text he typed
    (all text areas use this method for keyTyped event)*/
    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {                                    
        saved[jTabbedPane1.getSelectedIndex()] = false;
        undo.setEnabled(true);
    }                                   

   //mouse listener would work even if the button is disabled
    private void undoActionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
            int i = jTabbedPane1.getSelectedIndex();
            undoManager[i].undo();
            undo.setEnabled(undoManager[i].canUndo());
            redo.setEnabled(undoManager[i].canRedo());
            saved[i] = false;
        } catch(CannotUndoException e) {}
    }                                    

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
            int i = jTabbedPane1.getSelectedIndex();
            undoManager[i].redo();
            redo.setEnabled(undoManager[i].canRedo());
            undo.setEnabled(undoManager[i].canUndo());
            saved[i] = false;
        } catch(CannotRedoException e) {}
    }                                    

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {                                          
        updateInfo(jTabbedPane1.getSelectedIndex());
    }                                         

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
    
    // Variables declaration - do not modify                     
    private javax.swing.JComboBox backgroundColor;
    private javax.swing.JRadioButton bold;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JRadioButton italic;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private static javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextArea jTextArea2;
    private static javax.swing.JTextArea jTextArea3;
    private static javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JButton open;
    private javax.swing.JRadioButton plain;
    private javax.swing.JButton redo;
    private javax.swing.JButton save;
    private javax.swing.JButton saveAs;
    private javax.swing.JComboBox setFontSize;
    private javax.swing.JComboBox textColor;
    private javax.swing.JButton undo;
    // End of variables declaration                   

}
