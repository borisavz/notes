/* Notes v8
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

public class Notes extends javax.swing.JFrame {
    private static final int BOLD_ITALIC = Font.BOLD + Font.ITALIC,
        fontSize[] = {3, 5, 8, 12, 14, 16, 18, 20, 24, 38, 72};
    JFileChooser fileChooser = new JFileChooser();
    private int tabIndex, tabCount, previousTabIndex;
    private Color defaultBackground = Color.WHITE, defaultForeground = Color.BLACK;
    private UndoManager currentUndoManager;
    private File currentFile;
    private KeyAdapter keyAdapter = new KeyAdapter() {
        public void keyPressed(KeyEvent keyEvent) {
            int keyCode = keyEvent.getKeyCode();
            int fontSizeIndex;
            if(keyEvent.isControlDown()) {
                if(keyEvent.isShiftDown())
                    switch(keyCode) {
                        case KeyEvent.VK_S:
                            saveAsActionPerformed(null);
                            return;
                        case KeyEvent.VK_N:
                            addTab();
                            break;
                        case KeyEvent.VK_R:
                            removeTab();
                            break;
                        case KeyEvent.VK_P:
                            fontStyleMenu.setSelectedIndex(Font.PLAIN);
                            return;
                        case KeyEvent.VK_B:
                            fontStyleMenu.setSelectedIndex(Font.BOLD);
                            return;
                        case KeyEvent.VK_I:
                            fontStyleMenu.setSelectedIndex(Font.ITALIC);
                            return;
                        case KeyEvent.VK_F:
                            fontSizeIndex = fontSizeMenu.getSelectedIndex();
                            fontSizeMenu.setSelectedIndex(fontSizeIndex + 1 < 11 ? fontSizeIndex + 1 : 0);
                            return;
                        case KeyEvent.VK_Z:
                            if(currentUndoManager.canRedo())
                                redoActionPerformed(null);
                            return;
                    }
                switch(keyCode) {
                    case KeyEvent.VK_B:
                        fontStyleMenu.setSelectedIndex(BOLD_ITALIC);
                        break;
                    case KeyEvent.VK_S:
                        saveActionPerformed(null);
                        break;
                    case KeyEvent.VK_O:
                        openActionPerformed(null);
                        break;
                    case KeyEvent.VK_M:
                        jTabbedPane1.setSelectedIndex(tabIndex + 1 >= tabCount ? 0 : tabIndex + 1);
                        break;
                    case KeyEvent.VK_N:
                        jTabbedPane1.setSelectedIndex(tabIndex - 1 >= 0 ? tabIndex - 1 : tabCount - 1);
                        break;
                    case KeyEvent.VK_L:
                        jTabbedPane1.setSelectedIndex(previousTabIndex);
                        break;
                    case KeyEvent.VK_F:
                        fontSizeIndex = fontSizeMenu.getSelectedIndex();
                        fontSizeMenu.setSelectedIndex(fontSizeIndex - 1 >= 0 ? fontSizeIndex - 1 : 10);
                        break;
                    case KeyEvent.VK_Z:
                        if(currentUndoManager.canUndo())
                            undoActionPerformed(null);
                        break;
                }
            }
        }
        public void keyTyped(KeyEvent keyEvent) {
            saved.set(tabIndex, false);
            updateUndoRedo();
        }
    };
    private JPopupMenu contextMenu = new JPopupMenu(), tabMenu = new JPopupMenu();
    private JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction()),
        copy = new JMenuItem(new DefaultEditorKit.CopyAction()), 
        paste = new JMenuItem(new DefaultEditorKit.PasteAction()),
        delete = new JMenuItem("Delete"), closeTab = new JMenuItem("Close tab");
    private JTextArea currentJTextArea;
    private HashMap colorMenuIndex = new HashMap<Integer, Color>(),
        menuColorIndex = new HashMap<Color, Integer>();
    private ArrayList jTextArea = new ArrayList<JTextArea>(), file = new ArrayList<File>(),
        customBackground = new ArrayList<Color>(), customForeground = new ArrayList<Color>(),
        undoManager = new ArrayList<UndoManager>(), saved = new ArrayList<Boolean>();
    public Notes(String args[]) throws FontFormatException, IOException {
        initComponents();
        setEnabledRibbon(false);
        //setting up the context menu
        int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        JMenuItem nextTab = new JMenuItem("Next tab"), previousTab = new JMenuItem("Previous tab"),
            lastTab = new JMenuItem("Last tab");
        delete.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                currentJTextArea.replaceSelection(null);
            } 
        });
        nextTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                jTabbedPane1.setSelectedIndex(tabIndex + 1 >= tabCount ? 0 : tabIndex + 1);
            } 
        });
        previousTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                jTabbedPane1.setSelectedIndex(tabIndex - 1 >= 0 ? tabIndex - 1 : tabCount - 1);
            } 
        });
        lastTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTabbedPane1.setSelectedIndex(previousTabIndex);
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
        lastTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, menuShortcutKeyMask));
        paste.setEnabled(true);
        contextMenu.add(cut);
        contextMenu.add(copy);
        contextMenu.add(paste);
        contextMenu.addSeparator();
        contextMenu.add(delete);
        contextMenu.addSeparator();
        contextMenu.add(nextTab);
        contextMenu.add(previousTab);
        contextMenu.add(lastTab);
        colorMenuIndex.put(0, Color.WHITE);
        colorMenuIndex.put(1, Color.BLACK);
        colorMenuIndex.put(2, Color.GRAY);
        colorMenuIndex.put(3, Color.LIGHT_GRAY);
        colorMenuIndex.put(4, Color.DARK_GRAY);
        colorMenuIndex.put(5, Color.YELLOW);
        colorMenuIndex.put(6, Color.BLUE);
        colorMenuIndex.put(7, Color.RED);
        colorMenuIndex.put(8, Color.GREEN);
        colorMenuIndex.put(9, Color.ORANGE);
        colorMenuIndex.put(10, Color.PINK);
        menuColorIndex.put(Color.WHITE, 0);
        menuColorIndex.put(Color.BLACK, 1);
        menuColorIndex.put(Color.GRAY, 2);
        menuColorIndex.put(Color.LIGHT_GRAY, 3);
        menuColorIndex.put(Color.DARK_GRAY, 4);
        menuColorIndex.put(Color.YELLOW, 5);
        menuColorIndex.put(Color.BLUE, 6);
        menuColorIndex.put(Color.RED, 7);
        menuColorIndex.put(Color.GREEN, 8);
        menuColorIndex.put(Color.ORANGE, 9);
        menuColorIndex.put(Color.PINK, 10);
        //setting up the tab menu
        final JMenuItem newTab = new JMenuItem("New tab");
        newTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTab();
            }
        });
        closeTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeTab();
            }
        });
        closeTab.setEnabled(false);
        tabMenu.add(newTab);
        tabMenu.add(closeTab);
        jTabbedPane1.setComponentPopupMenu(tabMenu);
        for(String path : args)
            open(new File(path));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveAs = new javax.swing.JButton();
        open = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        backgroundMenu = new javax.swing.JComboBox();
        foregroundMenu = new javax.swing.JComboBox();
        save = new javax.swing.JButton();
        fontSizeMenu = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jSeparator7 = new javax.swing.JSeparator();
        undo = new javax.swing.JButton();
        redo = new javax.swing.JButton();
        fontStyleMenu = new javax.swing.JComboBox();
        jSeparator9 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Notes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/icons/icon1-100px.png")).getImage());
        setMinimumSize(new java.awt.Dimension(660, 300));
        setPreferredSize(new java.awt.Dimension(660, 300));
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
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });

        open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open-icon20px.png"))); // NOI18N
        open.setToolTipText("Open file");
        open.setFocusable(false);
        open.setMaximumSize(new java.awt.Dimension(32, 32));
        open.setMinimumSize(new java.awt.Dimension(32, 32));
        open.setPreferredSize(new java.awt.Dimension(32, 32));
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        backgroundMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange", "Pink", "Custom", "New color..." }));
        backgroundMenu.setToolTipText("Change background color of current tab");
        backgroundMenu.setFocusable(false);
        backgroundMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundMenuActionPerformed(evt);
            }
        });

        foregroundMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Black", "Gray", "Light gray", "Dark gray", "Yellow", "Blue", "Red", "Green", "Orange", "Pink", "Custom", "New color..." }));
        foregroundMenu.setToolTipText("Change text color of current tab");
        foregroundMenu.setFocusable(false);
        foregroundMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foregroundMenuActionPerformed(evt);
            }
        });

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-icon20px.png"))); // NOI18N
        save.setToolTipText("Save file");
        save.setFocusable(false);
        save.setMaximumSize(new java.awt.Dimension(32, 32));
        save.setMinimumSize(new java.awt.Dimension(32, 32));
        save.setPreferredSize(new java.awt.Dimension(32, 32));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        fontSizeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "8", "12", "14", "16", "18", "20", "24", "38", "72" }));
        fontSizeMenu.setToolTipText("Change font size of current tab");
        fontSizeMenu.setFocusable(false);
        fontSizeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontSizeMenuActionPerformed(evt);
            }
        });

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

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

        fontStyleMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Plain", "Bold", "Italic", "Bold Italic" }));
        fontStyleMenu.setToolTipText("Set font style");
        fontStyleMenu.setFocusable(false);
        fontStyleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontStyleMenuActionPerformed(evt);
            }
        });

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontSizeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontStyleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backgroundMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(foregroundMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(open, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(saveAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(backgroundMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(foregroundMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(redo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fontStyleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fontSizeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void addTab() {
        if(tabCount == 0)
            setEnabledRibbon(true);
        tabCount++;
        closeTab.setEnabled(true);
        currentJTextArea = new JTextArea();
        currentUndoManager = new UndoManager();
        saved.add(true);
        customBackground.add(null);
        customForeground.add(null);
        file.add(null);
        currentJTextArea.setBackground(defaultBackground);
        currentJTextArea.setForeground(defaultForeground);
        currentJTextArea.setComponentPopupMenu(contextMenu);
        currentJTextArea.getDocument().addUndoableEditListener(currentUndoManager);
        currentJTextArea.addKeyListener(keyAdapter);
        JPanel jPanel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(currentJTextArea);
        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE));
        jPanelLayout.setVerticalGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));
        jTextArea.add(currentJTextArea);
        undoManager.add(currentUndoManager);
        jTabbedPane1.addTab("tab" + tabCount, jPanel);
        jTabbedPane1.setSelectedIndex(tabCount - 1);
    }
    private boolean removeTab() {
        if(!(boolean) saved.get(tabIndex)) {
            int i = JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "Exit - " + jTabbedPane1.getTitleAt(tabIndex), JOptionPane.YES_NO_CANCEL_OPTION);
            if(i == JOptionPane.YES_OPTION) 
                saveActionPerformed(null);
            else if(i == JOptionPane.CANCEL_OPTION)
                return false;
        }
        if(tabCount - 1 > 0)
            tabCount--;
        else {
            closeTab.setEnabled(false);
            setTitle("Notes");
        }
        jTextArea.remove(tabIndex);
        undoManager.remove(tabIndex);
        saved.remove(tabIndex);
        jTabbedPane1.remove(tabIndex);
        file.remove(tabIndex);
        return true;
    }    
    private void save() {
        String[] text = currentJTextArea.getText().split("\n");
        try(PrintWriter printWriter = new PrintWriter(currentFile)) {
            for(String text1 : text) 
                printWriter.println(text1);
        } catch(IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Invalid file.\nClose all programs and try again.");
        }
        saved.set(tabIndex, true);
        String name = currentFile.getName();
        jTabbedPane1.setTitleAt(tabIndex, name);
    }
    //change background color of each idividual TextArea 
    private void backgroundMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundMenuActionPerformed
        int i = backgroundMenu.getSelectedIndex();
        Color background = (Color) colorMenuIndex.get(i);
        if(background == null) {
            if(i == 12) {
                background = JColorChooser.showDialog(this, "New color", defaultBackground);
                backgroundMenu.setSelectedIndex(11);
            } else
                background = (Color) customBackground.get(tabIndex);
        }
        customBackground.set(tabIndex, background);
        currentJTextArea.setBackground(background);
    }//GEN-LAST:event_backgroundMenuActionPerformed
    //change foreground color of each individual TextArea  
    private void foregroundMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foregroundMenuActionPerformed
        int i = foregroundMenu.getSelectedIndex();
        Color foreground = (Color) colorMenuIndex.get(i);
        if(foreground == null) {
            if(i == 12) {
                foreground = JColorChooser.showDialog(this, "New color", defaultBackground);
                backgroundMenu.setSelectedIndex(11);
            } else
                foreground = (Color) customForeground.get(tabIndex);
        }
        customForeground.set(tabIndex, foreground);
        currentJTextArea.setForeground(foreground);
    }//GEN-LAST:event_foregroundMenuActionPerformed
    //change font size of current text area
    private void fontSizeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontSizeMenuActionPerformed
        currentJTextArea.setFont(new Font(Font.SANS_SERIF, currentJTextArea.getFont().getStyle(), fontSize[fontSizeMenu.getSelectedIndex()]));
    }//GEN-LAST:event_fontSizeMenuActionPerformed
    //check if user saved his work before exiting
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        while(tabCount != 0)
            if(!removeTab())
                return;
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing
    private void updateUndoRedo() {
        undo.setEnabled(currentUndoManager.canUndo());
        redo.setEnabled(currentUndoManager.canRedo());
    }
    //mouse listener would work even if the button is disabled
    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        currentUndoManager.undo();
        updateUndoRedo();
        saved.set(tabIndex, false);
    }//GEN-LAST:event_undoActionPerformed
    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        currentUndoManager.redo();
        updateUndoRedo();
        saved.set(tabIndex, false);
    }//GEN-LAST:event_redoActionPerformed
    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        previousTabIndex = tabIndex;
        if((tabCount = jTabbedPane1.getTabCount()) != 0) {
            tabIndex = jTabbedPane1.getSelectedIndex();
            currentJTextArea = (JTextArea) jTextArea.get(tabIndex);
            currentFile = (File) file.get(tabIndex);
            currentUndoManager = (UndoManager) undoManager.get(tabIndex);
            updateUndoRedo();
            //change window title to title of the selcted tab
            setTitle("Notes - " + jTabbedPane1.getTitleAt(tabIndex));
            //change font style selected in ribbon
            Font font = currentJTextArea.getFont();
            fontStyleMenu.setSelectedIndex(font.getStyle());
            Object colorIndex;
            backgroundMenu.setSelectedIndex((colorIndex = menuColorIndex.get(currentJTextArea.getBackground())) != null ? (int) colorIndex : 11);
            foregroundMenu.setSelectedIndex((colorIndex = menuColorIndex.get(currentJTextArea.getForeground())) != null ? (int) colorIndex : 11);
            //change font size selected in ribbon
            switch(currentJTextArea.getFont().getSize()) {
                case 3: 
                    fontSizeMenu.setSelectedIndex(0); 
                    break;
                case 5: 
                    fontSizeMenu.setSelectedIndex(1); 
                    break;
                case 8: 
                    fontSizeMenu.setSelectedIndex(2); 
                    break;
                case 12: 
                    fontSizeMenu.setSelectedIndex(3); 
                    break;
                case 14: 
                    fontSizeMenu.setSelectedIndex(4); 
                    break;
                case 16: 
                    fontSizeMenu.setSelectedIndex(5); 
                    break;
                case 18: 
                    fontSizeMenu.setSelectedIndex(6); 
                    break;
                case 20: 
                    fontSizeMenu.setSelectedIndex(7); 
                    break;
                case 24: 
                    fontSizeMenu.setSelectedIndex(8); 
                    break;
                case 38: 
                    fontSizeMenu.setSelectedIndex(9); 
                    break;
                case 72: 
                    fontSizeMenu.setSelectedIndex(10); 
                    break;
            }
        } else {
            setEnabledRibbon(false);
            undo.setEnabled(false);
            redo.setEnabled(false);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged
    private void setEnabledRibbon(boolean enable) {
        save.setEnabled(enable);
        saveAs.setEnabled(enable);
        fontSizeMenu.setEnabled(enable);
        fontStyleMenu.setEnabled(enable);
        foregroundMenu.setEnabled(enable);
        backgroundMenu.setEnabled(enable);
    }
    private void fontStyleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontStyleMenuActionPerformed
        currentJTextArea.setFont(new Font(Font.SANS_SERIF, fontStyleMenu.getSelectedIndex(), currentJTextArea.getFont().getSize()));
    }//GEN-LAST:event_fontStyleMenuActionPerformed
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if(file.get(tabIndex) == null) 
            saveAsActionPerformed(null); 
        else
            save();
    }//GEN-LAST:event_saveActionPerformed
    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed
        if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            String title = currentFile.getName();
            file.set(tabIndex, currentFile);
            save();
            setTitle("Notes - " + title);
            jTabbedPane1.setTitleAt(tabIndex, title);
        }
    }//GEN-LAST:event_saveAsActionPerformed
    private void open(File file) {
        try {
            addTab();
            String line = null;
            currentFile = file;  
            this.file.set(tabIndex, currentFile);
            currentJTextArea.setText(null);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(currentFile.getAbsolutePath())));
            while((line = bufferedReader.readLine()) != null) 
                currentJTextArea.append(line + "\n");
            String name = currentFile.getName();
            setTitle("Notes - " + name);
            jTabbedPane1.setTitleAt(tabIndex, name);
            undo.setEnabled(false);
            redo.setEnabled(false);
            currentJTextArea.setCaretPosition(0);
            currentUndoManager.die();
            bufferedReader.close();
        } catch (IOException | NullPointerException e) {
            removeTab();
            JOptionPane.showMessageDialog(null, "Invalid file.\nClose all programs and try again.");
        }
    }
    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            open(fileChooser.getSelectedFile());
    }//GEN-LAST:event_openActionPerformed
    public static void main(final String args[]) throws FileNotFoundException {
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
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Notes(args).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Notes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox backgroundMenu;
    private javax.swing.JComboBox fontSizeMenu;
    private javax.swing.JComboBox fontStyleMenu;
    private javax.swing.JComboBox foregroundMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton open;
    private javax.swing.JButton redo;
    private javax.swing.JButton save;
    private javax.swing.JButton saveAs;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables
}