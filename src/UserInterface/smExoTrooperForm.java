package UserInterface;

import BusinessLogic.Entities.*;
import BusinessLogic.smIABOT;
import DataAccess.smDataFileHelper;
import Infrastructure.smCMD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class smExoTrooperForm extends JFrame {
    private JComboBox<String> smCbxTipoExobot;
    private JTable smTable;
    private DefaultTableModel smTableModel;
    private JButton smBtnAgregar;
    private JButton smBtnBuscar;
    private JButton smBtnEntrenar;
    private JButton smBtnAccion;
    
    private List<smExobot> smExobotList;
    private TableRowSorter<DefaultTableModel> smSorter;

    public smExoTrooperForm() {
        smExobotList = new ArrayList<>();
        
        setTitle("ExoTrooper");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel smTopPanel = new JPanel();
        smTopPanel.setLayout(new BoxLayout(smTopPanel, BoxLayout.Y_AXIS));
        smTopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JLabel smLblHeader = new JLabel("Alumno(s):");
        smLblHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        smTopPanel.add(smLblHeader);

        JPanel smStudentInfoPanel = new JPanel(new GridLayout(2, 2));
        smStudentInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        smStudentInfoPanel.setBackground(Color.WHITE);
        smStudentInfoPanel.add(new JLabel("  1754918637")); 
        smStudentInfoPanel.add(new JLabel("Alan Alcivar"));
        smStudentInfoPanel.add(new JLabel("")); 
        smStudentInfoPanel.add(new JLabel(""));
        smTopPanel.add(smStudentInfoPanel);
        
        add(smTopPanel, BorderLayout.NORTH);

        JPanel smCenterPanel = new JPanel(new BorderLayout(5, 5));
        smCenterPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JPanel smControlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        smCbxTipoExobot = new JComboBox<>(new String[]{
            "ExoAsalto", "ExoExplorador", "ExoInfanteria", "ExoMedico", "ExoComando"
        });
        smCbxTipoExobot.setPreferredSize(new Dimension(120, 30));
        
        smBtnAgregar = new JButton("Agregar");
        smBtnAgregar.setBackground(new Color(220, 220, 220));
        
        smBtnBuscar = new JButton("Buscar");
        smBtnBuscar.setBackground(Color.WHITE);
        
        smControlPanel.add(smCbxTipoExobot);
        smControlPanel.add(smBtnAgregar);
        smControlPanel.add(smBtnBuscar);
        
        smCenterPanel.add(smControlPanel, BorderLayout.NORTH);

        String[] smColNames = {"IdExobot", "TipoExobot", "Entreno", "No. Accion"};
        smTableModel = new DefaultTableModel(smColNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        smTable = new JTable(smTableModel);
        smTable.setRowHeight(25);
        
        JTableHeader smHeader = smTable.getTableHeader();
        smHeader.setBackground(new Color(154, 205, 50));
        smHeader.setForeground(Color.WHITE);
        smHeader.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        smSorter = new TableRowSorter<>(smTableModel);
        smTable.setRowSorter(smSorter);

        smCenterPanel.add(new JScrollPane(smTable), BorderLayout.CENTER);
        
        add(smCenterPanel, BorderLayout.CENTER);

        JPanel smBottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        smBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        smBtnEntrenar = new JButton("Entrenar \"AcciónArma\"");
        smBtnAccion = new JButton("\"Acción_TipoArma\"");
        
        smBottomPanel.add(smBtnEntrenar);
        smBottomPanel.add(smBtnAccion);
        
        add(smBottomPanel, BorderLayout.SOUTH);

        smBtnAgregar.addActionListener(e -> smHandleAgregar());
        smBtnEntrenar.addActionListener(e -> smHandleEntrenar());
        smBtnAccion.addActionListener(e -> smHandleAccion());
        smBtnBuscar.addActionListener(e -> smHandleBuscar());
    }

    private void smHandleAgregar() {
        String smSelected = (String) smCbxTipoExobot.getSelectedItem();
        smExobot smNewBot;
        
        switch (smSelected) {
            case "ExoAsalto": smNewBot = new smExoAsalto(); break;
            case "ExoExplorador": smNewBot = new smExoExplorador(); break;
            case "ExoInfanteria": smNewBot = new smExoInfanteria(); break;
            case "ExoMedico": smNewBot = new smExoMedico(); break;
            case "ExoComando": smNewBot = new smExoComando(); break;
            default: smNewBot = new smExoAsalto();
        }
        
        smNewBot.smSetIdExobot(smExobotList.size() + 1);
        smExobotList.add(smNewBot);
        
        smTableModel.addRow(new Object[]{
            smNewBot.smGetIdExobot(),
            smNewBot.smGetTipoExobot(),
            "NO",
            "0"
        });
    }

    private smExobot smGetSelectedBot() {
        int smRow = smTable.getSelectedRow();
        if (smRow != -1) {
            int smModelRow = smTable.convertRowIndexToModel(smRow);
            int smId = (int) smTableModel.getValueAt(smModelRow, 0);
            return smExobotList.stream().filter(b -> b.smGetIdExobot() == smId).findFirst().orElse(null);
        }
        return null;
    }

    private void smHandleEntrenar() {
        smExobot smCurrentBot = smGetSelectedBot();
        if (smCurrentBot != null) {
            smSoldadoExperto smSoldado = new smSoldadoExperto("SoldadoExperto-" + smCurrentBot.smGetArmaNombre().split("/")[0]);
            new smIABOT().smEntrenar(smCurrentBot, smSoldado);
            
            smUpdateTableRow(smCurrentBot);

            String smLog = "GOOD : " + smSoldado.smGetNombre() + " " + smCurrentBot.smGetArmaNombre() + " " + smCurrentBot.smRealizarAccion(); 
            smCMD.smImprimir(smLog);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void smHandleAccion() {
        smExobot smCurrentBot = smGetSelectedBot();
        
        if (smCurrentBot != null) {
            if (smCurrentBot.smIsEntrenado()) {
                String smMunicion = smDataFileHelper.smBuscarMunicion(smCurrentBot.smGetArmaNombre());
                smCurrentBot.smIncrementarAccion();
                
                smUpdateTableRow(smCurrentBot);

                String smLog = "GOOD : " + smCurrentBot.smGetArmaNombre() + " " + smCurrentBot.smRealizarAccion() + " " + (smMunicion != null ? smMunicion : "No Municion");
                smCMD.smImprimir(smLog);
            } else {
                String smLog = "ERROR: " + smCurrentBot.smGetTipoExobot() + " No Entrenado.";
                smCMD.smImprimir(smLog);
                JOptionPane.showMessageDialog(this, "El Exobot no está entrenado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void smUpdateTableRow(smExobot smBot) {
        for (int i = 0; i < smTableModel.getRowCount(); i++) {
            int smId = (int) smTableModel.getValueAt(i, 0);
            if (smId == smBot.smGetIdExobot()) {
                smTableModel.setValueAt(smBot.smIsEntrenado() ? "SI" : "NO", i, 2);
                smTableModel.setValueAt(smBot.smGetNumeroAccion(), i, 3);
                break;
            }
        }
    }

    private void smHandleBuscar() {
        String smSelected = (String) smCbxTipoExobot.getSelectedItem();
        if (smSelected != null && !smSelected.isEmpty()) {
            smSorter.setRowFilter(RowFilter.regexFilter(smSelected, 1));
        } else {
            smSorter.setRowFilter(null);
        }
    }
}
