/* BeleskeGUI (NotesGUI in english) is codename of this project. Don't judge me.
 *
 * version 6.1
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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

public class BeleskeGUI extends javax.swing.JFrame {
    /*macros for index of color selected in ribbon
    tip: using macros can make larger projects easier to understand*/
    private static final int WHITE = 0, BLACK = 1, GRAY = 2, LIGHT_GRAY = 3, 
            DARK_GRAY = 4, YELLOW = 5, BLUE = 6, RED = 7, GREEN = 8, ORANGE = 9, 
            PINK = 10, CUSTOM = 11, NEW_COLOR = 12;
    //macros for font size selected in ribbon
    private static final int FONT_SIZE_3 = 0, FONT_SIZE_5 = 1, FONT_SIZE_8 = 2, 
            FONT_SIZE_12 = 3, FONT_SIZE_14 = 4, FONT_SIZE_16 = 5, FONT_SIZE_18 = 6, 
            FONT_SIZE_20 = 7, FONT_SIZE_24 = 8, FONT_SIZE_38 = 9, FONT_SIZE_72 = 10;
    //macros for the selected tab
    private static final int TAB_1 = 0, TAB_2 = 1, TAB_3 = 2, TAB_4 = 3, TAB_5 = 4; 
    //macros for moving tab
    private static final boolean NEXT_TAB = true, PREVIOUS_TAB = false;
    JFileChooser fileChooser = new JFileChooser();
    int[] fontSize = new int[5], fontStyle = new int[5];
    boolean[] saved = new boolean[5];
    Color[] customBackground = new Color[5], customText = new Color[5];
    String[] path = new String[5];
    UndoManager[] undoManager = new UndoManager[5];
    public BeleskeGUI() throws FontFormatException, IOException {
        initComponents();
        jTextArea1.setBackground(Color.WHITE);
        jTextArea1.setForeground(Color.BLACK);
        jTextArea2.setBackground(Color.WHITE);
        jTextArea2.setForeground(Color.BLACK);
        jTextArea3.setBackground(Color.WHITE);
        jTextArea3.setForeground(Color.BLACK);
        jTextArea4.setBackground(Color.WHITE);
        jTextArea4.setForeground(Color.BLACK);
        jTextArea5.setBackground(Color.WHITE);
        jTextArea5.setForeground(Color.BLACK);
        //intialize variables
        for(int i = 0; i < 5; i++) { 
            saved[i] = true;
            fontSize[i] = 12;
            customText[i] = Color.BLACK;
            customBackground[i] = Color.WHITE;
            fontStyle[i] = Font.PLAIN;
            undoManager[i] = new UndoManager();
        }
        //add UndoableEditListener for all 5 tabs
        jTextArea1.getDocument().addUndoableEditListener(undoManager[TAB_1]);
        jTextArea2.getDocument().addUndoableEditListener(undoManager[TAB_2]);
        jTextArea3.getDocument().addUndoableEditListener(undoManager[TAB_3]);
        jTextArea4.getDocument().addUndoableEditListener(undoManager[TAB_4]);
        jTextArea5.getDocument().addUndoableEditListener(undoManager[TAB_5]);
        //set default font settings
        jTextArea1.setFont(new Font(Font.SANS_SERIF, fontStyle[TAB_1], fontSize[TAB_1]));
        jTextArea2.setFont(new Font(Font.SANS_SERIF, fontStyle[TAB_2], fontSize[TAB_2]));
        jTextArea3.setFont(new Font(Font.SANS_SERIF, fontStyle[TAB_3], fontSize[TAB_3]));
        jTextArea4.setFont(new Font(Font.SANS_SERIF, fontStyle[TAB_4], fontSize[TAB_4]));
        jTextArea5.setFont(new Font(Font.SANS_SERIF, fontStyle[TAB_5], fontSize[TAB_5]));
        //MouseListener for opening the context menu
        jTextArea1.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { 
                contextMenu(e); 
            } 
        });
        jTextArea2.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { 
                contextMenu(e); 
            } 
        });
        jTextArea3.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { 
                contextMenu(e); 
            } 
        });
        jTextArea4.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { 
                contextMenu(e); 
            } 
        });
        jTextArea5.addMouseListener(new MouseAdapter() { 
            public void mouseReleased(MouseEvent e) { 
                contextMenu(e); 
            } 
        });
        jTabbedPane1.setSelectedIndex(0);
        updateInfo(jTabbedPane1.getSelectedIndex());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        backgroundColor = new javax.swing.JComboBox();
        textColor = new javax.swing.JComboBox();
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
        position = new javax.swing.JLabel();
        boldItalic = new javax.swing.JRadioButton();

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
        plain.setToolTipText("Chnage font style to plain");
        plain.setFocusable(false);
        plain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plainActionPerformed(evt);
            }
        });

        buttonGroup1.add(bold);
        bold.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bold.setText("Bold");
        bold.setToolTipText("Chnage font style to bold");
        bold.setFocusable(false);
        bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldActionPerformed(evt);
            }
        });

        buttonGroup1.add(italic);
        italic.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        italic.setText("Italic");
        italic.setToolTipText("Change font style to italic");
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

        backgroundColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange", "Pink", "Custom", "New color..." }));
        backgroundColor.setToolTipText("Change background color of current tab");
        backgroundColor.setFocusable(false);
        backgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundColorActionPerformed(evt);
            }
        });

        textColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange", "Pink", "Custom", "New color..." }));
        textColor.setToolTipText("Change text color of current tab");
        textColor.setFocusable(false);
        textColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textColorActionPerformed(evt);
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

        setFontSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "8", "12", "14", "16", "18", "20", "24", "38", "72" }));
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jTextArea5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
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

        position.setText("Position:");
        position.setToolTipText("The cursor position in the text");

        buttonGroup1.add(boldItalic);
        boldItalic.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        boldItalic.setText("Bold Italic");
        boldItalic.setToolTipText("Change font style to bold italic");
        boldItalic.setFocusable(false);
        boldItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldItalicActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boldItalic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(textColor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setFontSize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bold, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(italic)
                        .addComponent(boldItalic))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(undo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //show context menu
    private void contextMenu(MouseEvent e) {
        boolean selected = false;
        /*check if user clicked mouse button for opening context menu
        (usually right click)*/
        final int i = jTabbedPane1.getSelectedIndex();
        int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        if(e.isPopupTrigger()) {
            switch(i) {
                case TAB_1: 
                    selected = jTextArea1.getSelectionStart() != jTextArea1.getSelectionEnd(); 
                    break;
                case TAB_2: 
                    selected = jTextArea2.getSelectionStart() != jTextArea2.getSelectionEnd(); 
                    break;
                case TAB_3: 
                    selected = jTextArea3.getSelectionStart() != jTextArea3.getSelectionEnd(); 
                    break;
                case TAB_4: 
                    selected = jTextArea4.getSelectionStart() != jTextArea4.getSelectionEnd(); 
                    break;
                case TAB_5: 
                    selected = jTextArea5.getSelectionStart() != jTextArea5.getSelectionEnd(); 
                    break;
            }
            JPopupMenu menu = new JPopupMenu();
            JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
            JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
            JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
            JMenuItem delete = new JMenuItem("Delete");
            JMenuItem nextTab = new JMenuItem("Next tab");
            JMenuItem previousTab = new JMenuItem("Previous tab");
            delete.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) {
                    switch(i) {
                        case TAB_1: 
                            jTextArea1.replaceSelection(null); 
                            break;
                        case TAB_2: 
                            jTextArea2.replaceSelection(null); 
                            break;
                        case TAB_3: 
                            jTextArea3.replaceSelection(null); 
                            break;
                        case TAB_4: 
                            jTextArea4.replaceSelection(null); 
                            break;
                        case TAB_5: 
                            jTextArea5.replaceSelection(null); 
                            break;
                    }
                } 
            } );
            nextTab.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                    moveTab(NEXT_TAB); 
                } 
            });
            previousTab.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                    moveTab(PREVIOUS_TAB); 
                } 
            });
            cut.setText("Cut");
            copy.setText("Copy");
            paste.setText("Paste");
            cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, menuShortcutKeyMask));
            copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, menuShortcutKeyMask));
            paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, menuShortcutKeyMask));
            nextTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, menuShortcutKeyMask));
            previousTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, menuShortcutKeyMask));
            cut.setEnabled(selected);
            copy.setEnabled(selected);
            delete.setEnabled(selected);
            paste.setEnabled(true);
            menu.add(cut);
            menu.add(copy);
            menu.add(paste);
            menu.addSeparator();
            menu.add(delete);
            menu.addSeparator();
            menu.add(nextTab);
            menu.add(previousTab);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    //change the tab
    private void moveTab(boolean step) {
        int i = jTabbedPane1.getSelectedIndex();
        /*you can use switch(i) for this one also.
        there's no difference here since we have a 
        small number of cases. note that if we have 
        more than five cases all items will have the 
        same access time so it is worth using it*/
        if(i == TAB_1 && !step)
            jTabbedPane1.setSelectedIndex(TAB_5);
        else if(i == TAB_5 && step)
            jTabbedPane1.setSelectedIndex(TAB_1);
        else if(step)
            jTabbedPane1.setSelectedIndex(i + 1);
        else 
            jTabbedPane1.setSelectedIndex(i - 1);
        updateInfo(jTabbedPane1.getSelectedIndex());
    }
    private void saveAsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAsMouseClicked
        //it's obvious why
        saveAs();
    }//GEN-LAST:event_saveAsMouseClicked
    //save
    private void save() {
        String[] text = null;
        int i = jTabbedPane1.getSelectedIndex();
        switch(i) {
            case TAB_1:
                text = jTextArea1.getText().split("\n");
                break;
            case TAB_2:
                text = jTextArea2.getText().split("\n");
                break;
            case TAB_3:
                text = jTextArea3.getText().split("\n");
                break;
            case TAB_4:
                text = jTextArea4.getText().split("\n");
                break;
            case TAB_5:
                text = jTextArea5.getText().split("\n");
                break;
        }
        try(PrintWriter printWriter = new PrintWriter(path[i])) {
            for(String text1 : text) 
                printWriter.println(text1);
        } catch(IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Invalid file.\nClose all programs and try again.");
        }
        saved[i] = true;
        updateInfo(i);
    } 
    //save file as
    private void saveAs() {
        fileChooser.showSaveDialog(this);
        File file = fileChooser.getSelectedFile();
        String title = file.getName();
        int i = jTabbedPane1.getSelectedIndex();
        path[i] = file.getAbsolutePath();
        save();
        setTitle("Notes - " + title);
        jTabbedPane1.setTitleAt(i, title);
    }
    //change info shown in ribbon when user changes tab
    private void updateInfo(int i) {
        //change window title to title of the selcted tab
        updateTitle(i);
        Color background = getBackgroundColor(i), text = getTextColor(i);
        //change font style selected in ribbon
        switch(fontStyle[i]) {
            case Font.PLAIN: 
                plain.setSelected(true); 
                break;
            case Font.BOLD: 
                bold.setSelected(true); 
                break;
            case Font.ITALIC: 
                italic.setSelected(true); 
                break;
            case Font.BOLD + Font.ITALIC:
                boldItalic.setSelected(true);
                break;
        }
        //change text color selected in ribbon
        if(background.equals(Color.WHITE)) 
            backgroundColor.setSelectedIndex(WHITE); 
        else if(background.equals(Color.BLACK)) 
            backgroundColor.setSelectedIndex(BLACK); 
        else if(background.equals(Color.GRAY)) 
            backgroundColor.setSelectedIndex(GRAY); 
        else if(background.equals(Color.LIGHT_GRAY)) 
            backgroundColor.setSelectedIndex(LIGHT_GRAY); 
        else if(background.equals(Color.DARK_GRAY)) 
            backgroundColor.setSelectedIndex(DARK_GRAY); 
        else if(background.equals(Color.YELLOW)) 
            backgroundColor.setSelectedIndex(YELLOW); 
        else if(background.equals(Color.BLUE)) 
            backgroundColor.setSelectedIndex(BLUE); 
        else if(background.equals(Color.RED)) 
            backgroundColor.setSelectedIndex(RED); 
        else if(background.equals(Color.GREEN)) 
            backgroundColor.setSelectedIndex(GREEN); 
        else if(background.equals(Color.ORANGE)) 
            backgroundColor.setSelectedIndex(ORANGE);
        else if(background.equals(Color.PINK))
            backgroundColor.setSelectedIndex(PINK);
        else
            backgroundColor.setSelectedIndex(CUSTOM);
        //change background color selected in ribbon
        if(text.equals(Color.WHITE))
            textColor.setSelectedIndex(WHITE); 
        else if(text.equals(Color.BLACK)) 
            textColor.setSelectedIndex(BLACK); 
        else if(text.equals(Color.GRAY)) 
            textColor.setSelectedIndex(GRAY); 
        else if(text.equals(Color.LIGHT_GRAY)) 
            textColor.setSelectedIndex(LIGHT_GRAY); 
        else if(text.equals(Color.DARK_GRAY)) 
            textColor.setSelectedIndex(DARK_GRAY);
        else if(text.equals(Color.YELLOW)) 
            textColor.setSelectedIndex(YELLOW); 
        else if(text.equals(Color.BLUE)) 
            textColor.setSelectedIndex(BLUE); 
        else if(text.equals(Color.RED)) 
            textColor.setSelectedIndex(RED); 
        else if(text.equals(Color.GREEN)) 
            textColor.setSelectedIndex(GREEN); 
        else if(text.equals(Color.ORANGE)) 
            textColor.setSelectedIndex(ORANGE);
        else if(text.equals(Color.PINK))
            textColor.setSelectedIndex(PINK);
        else
            textColor.setSelectedIndex(CUSTOM);
        //change font size selected in ribbon
        switch(fontSize[i]) {
            case 3: 
                setFontSize.setSelectedIndex(FONT_SIZE_3); 
                break;
            case 5: 
                setFontSize.setSelectedIndex(FONT_SIZE_5); 
                break;
            case 8: 
                setFontSize.setSelectedIndex(FONT_SIZE_8); 
                break;
            case 12: 
                setFontSize.setSelectedIndex(FONT_SIZE_12); 
                break;
            case 14: 
                setFontSize.setSelectedIndex(FONT_SIZE_14); 
                break;
            case 16: 
                setFontSize.setSelectedIndex(FONT_SIZE_16); 
                break;
            case 18: 
                setFontSize.setSelectedIndex(FONT_SIZE_18); 
                break;
            case 20: 
                setFontSize.setSelectedIndex(FONT_SIZE_20); 
                break;
            case 24: 
                setFontSize.setSelectedIndex(FONT_SIZE_24); 
                break;
            case 38: 
                setFontSize.setSelectedIndex(FONT_SIZE_38); 
                break;
            case 72: 
                setFontSize.setSelectedIndex(FONT_SIZE_72); 
                break;
        }
        //check if user can redo text for the selected tab
        undo.setEnabled(undoManager[i].canUndo());
        redo.setEnabled(undoManager[i].canRedo());
        //show the cursor location
        updatePosition(i);
    }
    private Color getBackgroundColor(int tab) {
        switch(tab) {
            case TAB_1:
                return jTextArea1.getBackground();
            case TAB_2:
                return jTextArea2.getBackground();
            case TAB_3:
                return jTextArea3.getBackground();
            case TAB_4:
                return jTextArea4.getBackground();
            case TAB_5:
                return jTextArea5.getBackground();
        }
        return null;
    }
    private void setBackgroundColor(Color background, int tab) {
        switch(tab) {
            case TAB_1: 
                jTextArea1.setBackground(background); 
                break;
            case TAB_2: 
                jTextArea2.setBackground(background); 
                break;
            case TAB_3: 
                jTextArea3.setBackground(background); 
                break;
            case TAB_4: 
                jTextArea4.setBackground(background); 
                break;
            case TAB_5: 
                jTextArea5.setBackground(background); 
                break;
        }
    }
    private Color getTextColor(int tab) {
        switch(tab) {
            case TAB_1:
                return jTextArea1.getForeground();
            case TAB_2:
                return jTextArea2.getForeground();
            case TAB_3:
                return jTextArea3.getForeground();
            case TAB_4:
                return jTextArea4.getForeground();
            case TAB_5:
                return jTextArea5.getForeground();
        }
        return null;
    }
    private void setTextColor(Color text, int tab) {
        switch(tab) {
            case TAB_1:
                jTextArea1.setForeground(text);
                break;
            case TAB_2:
                jTextArea2.setForeground(text);
                break;
            case TAB_3:
                jTextArea3.setForeground(text);
                break;
            case TAB_4:
                jTextArea4.setForeground(text);
                break;
            case TAB_5:
                jTextArea5.setForeground(text);
                break;
        }
    }
    //change font size and type of current tab
    private void setFont(int fontStyle, int fontSize) {
        /*makes code easier to understand
        also method calls are expensive so this will make code slightly faster*/
        int i = jTabbedPane1.getSelectedIndex();
        this.fontStyle[i] = fontStyle;
        this.fontSize[i] = fontSize;
        switch(i) {
            case TAB_1: 
                jTextArea1.setFont(new Font(Font.SANS_SERIF, this.fontStyle[i], this.fontSize[i])); 
                break;
            case TAB_2: 
                jTextArea2.setFont(new Font(Font.SANS_SERIF, this.fontStyle[i], this.fontSize[i])); 
                break;
            case TAB_3: 
                jTextArea3.setFont(new Font(Font.SANS_SERIF, this.fontStyle[i], this.fontSize[i])); 
                break;
            case TAB_4: 
                jTextArea4.setFont(new Font(Font.SANS_SERIF, this.fontStyle[i], this.fontSize[i])); 
                break;
            case TAB_5: 
                jTextArea5.setFont(new Font(Font.SANS_SERIF, this.fontStyle[i], this.fontSize[i])); 
                break;
        }
    }
    private void updatePosition(int i) {
        switch(i) {
            case TAB_1:
                position.setText("Position: " + jTextArea1.getCaret().getDot() + "/" + jTextArea1.getText().length());
                break;
            case TAB_2:
                position.setText("Position: " + jTextArea2.getCaret().getDot() + "/" + jTextArea2.getText().length());
                break;
            case TAB_3:
                position.setText("Position: " + jTextArea3.getCaret().getDot() + "/" + jTextArea3.getText().length());
                break;
            case TAB_4:
                position.setText("Position: " + jTextArea4.getCaret().getDot() + "/" + jTextArea4.getText().length());
                break;
            case TAB_5:
                position.setText("Position: " + jTextArea5.getCaret().getDot() + "/" + jTextArea5.getText().length());
                break;
        }
    }
    private void updateTitle(int i) {
        String title = jTabbedPane1.getTitleAt(i);
        int title_length = title.length() - 1;
        if(!saved[i]) {
            if(title.charAt(title_length) != '*')
                title = title.concat("*");
        } else if(title.charAt(title_length) == '*')
            title = title.substring(0, title_length);
        jTabbedPane1.setTitleAt(i, title);
        setTitle("Notes - " + title);
    }
    //open file
    private void openMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMouseClicked
        //check if user saved his work
        int i = jTabbedPane1.getSelectedIndex();
        if(!saved[i]) 
            if(JOptionPane.showConfirmDialog(this, "Do you want to save changes?", 
                jTabbedPane1.getTitleAt(i), JOptionPane.YES_NO_OPTION) == 0) 
                if(true)
                    saveMouseClicked(null);
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path[i] = file.getAbsolutePath();
            String line = null;
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path[i]), "UTF-8"))) {
                switch(i) {
                    case TAB_1:
                        jTextArea1.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea1.append(line + "\n");
                        break;
                    case TAB_2:
                        jTextArea2.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea2.append(line + "\n"); 
                        break;
                    case TAB_3:
                        jTextArea3.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea3.append(line + "\n"); 
                        break;
                    case TAB_4:
                        jTextArea4.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea4.append(line + "\n"); 
                        break;
                    case TAB_5:
                        jTextArea5.setText(null);
                        while((line = bufferedReader.readLine()) != null) 
                            jTextArea5.append(line + "\n"); 
                        break;
                }
                i = jTabbedPane1.getSelectedIndex();
                jTabbedPane1.setTitleAt(i, file.getName());
                updateInfo(i);
                undo.setEnabled(false);
                redo.setEnabled(false);
            } catch (IOException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Invalid file.\nClose all programs and try again.");
            }
        }
    }//GEN-LAST:event_openMouseClicked
    //change font type to plain
    private void plainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plainActionPerformed
        setFont(Font.PLAIN, fontSize[jTabbedPane1.getSelectedIndex()]);
    }//GEN-LAST:event_plainActionPerformed
    //change font type to bold
    private void boldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boldActionPerformed
        setFont(Font.BOLD, fontSize[jTabbedPane1.getSelectedIndex()]);
    }//GEN-LAST:event_boldActionPerformed
    //change font type to italic
    private void italicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italicActionPerformed
        setFont(Font.ITALIC, fontSize[jTabbedPane1.getSelectedIndex()]);
    }//GEN-LAST:event_italicActionPerformed
    //change background color of each idividual text area 
    private void backgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundColorActionPerformed
        /*it is fucking more readable, ain't it??
        method calls are also expensive*/
        int i = jTabbedPane1.getSelectedIndex();
        switch(backgroundColor.getSelectedIndex()) {                                  
            case WHITE: 
                setBackgroundColor(Color.WHITE, i); 
                break;
            case BLACK: 
                setBackgroundColor(Color.BLACK, i); 
                break;
            case GRAY: 
                setBackgroundColor(Color.GRAY, i); 
                break;
            case LIGHT_GRAY: 
                setBackgroundColor(Color.LIGHT_GRAY, i); 
                break;
            case DARK_GRAY: 
                setBackgroundColor(Color.DARK_GRAY, i); 
                break;
            case YELLOW: 
                setBackgroundColor(Color.YELLOW, i); 
                break;
            case BLUE: 
                setBackgroundColor(Color.BLUE, i); 
                break;
            case RED: 
                setBackgroundColor(Color.RED, i); 
                break;
            case GREEN: 
                setBackgroundColor(Color.GREEN, i); 
                break;
            case ORANGE:
                setBackgroundColor(Color.ORANGE, i); 
                break;
            case PINK:
                setBackgroundColor(Color.PINK, i);
                break;
            case CUSTOM:
                setBackgroundColor(customBackground[i], i);
                break;
            case NEW_COLOR:
                customBackground[i] = JColorChooser.showDialog(this, "New color", customBackground[i]);
                backgroundColor.setSelectedIndex(CUSTOM);
                setBackgroundColor(customBackground[i], i);
                break;
        }
    }//GEN-LAST:event_backgroundColorActionPerformed
    //change foreground color of each individual text area  
    private void textColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textColorActionPerformed
        int i = jTabbedPane1.getSelectedIndex();
        switch(textColor.getSelectedIndex()) {                                  
            case WHITE: 
                setTextColor(Color.WHITE, i); 
                break;
            case BLACK: 
                setTextColor(Color.BLACK, i); 
                break;
            case GRAY:
                setTextColor(Color.GRAY, i); 
                break;
            case LIGHT_GRAY: 
                setTextColor(Color.LIGHT_GRAY, i); 
                break;
            case DARK_GRAY: 
                setTextColor(Color.DARK_GRAY, i); 
                break;
            case YELLOW: 
                setTextColor(Color.YELLOW, i); 
                break;
            case BLUE: 
                setTextColor(Color.BLUE, i);
                break;
            case RED: 
                setTextColor(Color.RED, i); 
                break;
            case GREEN: 
                setTextColor(Color.GREEN, i); 
                break;
            case ORANGE: 
                setTextColor(Color.ORANGE, i); 
                break;
            case PINK:
                setTextColor(Color.PINK, i);
                break;
            case CUSTOM:
                setTextColor(customText[i], i);
                break;
            case NEW_COLOR:
                customText[i] = JColorChooser.showDialog(this, "New color", customBackground[i]);
                textColor.setSelectedIndex(CUSTOM);
                setTextColor(customText[i], i);
                break;
        }
    }//GEN-LAST:event_textColorActionPerformed
    //change font size of each individual text area
    private void setFontSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFontSizeActionPerformed
        /*there is no way for an exception to be thrown here
        cause jcombobox ain't editable*/
        setFont(fontStyle[jTabbedPane1.getSelectedIndex()], Integer.parseInt(setFontSize.getSelectedItem().toString()));
    }//GEN-LAST:event_setFontSizeActionPerformed
    //check if user saved his work before exiting
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        for(int i = 0; i < 5; i++) {
            /*this is a little optimiziation since we don't 
            need to call moveTab to check if user is trying 
            to do something that he shouldn't do*/ 
            jTabbedPane1.setSelectedIndex(i);
            updateTitle(i);
            if(saved[jTabbedPane1.getSelectedIndex()] == false) 
                if(JOptionPane.showConfirmDialog(this, "Do you want to save changes?", 
                    "Exit - " + jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()), JOptionPane.YES_NO_OPTION) == 0) 
                    saveMouseClicked(null);
        }
    }//GEN-LAST:event_formWindowClosing
    //save file 
    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        /*save changes to a modified file or 
        save file as if file does not exist*/
        int i = jTabbedPane1.getSelectedIndex();
        if(path[i] == null) 
            saveAs(); 
        else
            save();
    }//GEN-LAST:event_saveMouseClicked

    //mouse listener would work even if the button is disabled
    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        int i = jTabbedPane1.getSelectedIndex();
        undoManager[i].undo();
        undo.setEnabled(undoManager[i].canUndo());
        redo.setEnabled(undoManager[i].canRedo());
        saved[i] = false;
    }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        int i = jTabbedPane1.getSelectedIndex();
        undoManager[i].redo();
        redo.setEnabled(undoManager[i].canRedo());
        undo.setEnabled(undoManager[i].canUndo());
        saved[i] = false;
    }//GEN-LAST:event_redoActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        updateInfo(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jTabbedPane1MouseClicked
    //all jTaxtAreas use this method to halde KeyPressed event
    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        int i = jTabbedPane1.getSelectedIndex();
        saved[i] = false;
        undo.setEnabled(true);
        updatePosition(i);
        updateTitle(i);
    }//GEN-LAST:event_jTextArea1KeyPressed
    /*change font style to bold italic
    P.S. NetBeans you asshole I can't even edit variables, so I have those 4 
    button groups and I can't group methods well
    I can't manually edit initComponents so I am forced to point and click to add a listener*/
    private void boldItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boldItalicActionPerformed
        setFont(Font.ITALIC + Font.BOLD, fontSize[jTabbedPane1.getSelectedIndex()]);
    }//GEN-LAST:event_boldItalicActionPerformed
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
    private javax.swing.JComboBox backgroundColor;
    private javax.swing.JRadioButton bold;
    private javax.swing.JRadioButton boldItalic;
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
    private javax.swing.JLabel position;
    private javax.swing.JButton redo;
    private javax.swing.JButton save;
    private javax.swing.JButton saveAs;
    private javax.swing.JComboBox setFontSize;
    private javax.swing.JComboBox textColor;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables

}