package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Univers.TPersonnage;
import Univers.Enum.ECompetence;

public class DialogStatistics extends JDialog {
    private static final long serialVersionUID = 1L;

    public DialogStatistics(JFrame parent, TPersonnage joueur) {
        super(parent, "Statistiques", true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel infoPanel = setupInfoPanel(joueur);
        add(infoPanel, BorderLayout.NORTH);

        JTable skillsTable = setupSkillsTable(joueur);
        JScrollPane scrollPane = new JScrollPane(skillsTable);
        scrollPane.setPreferredSize(new Dimension(600, 150));  // Dimension ajustée pour ne pas laisser un grand espace blanc
        JPanel skillsPanel = setupSkillsPanel(scrollPane);
        add(skillsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = setupButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(new Dimension(700, 300));  // Ajustement de la taille globale de la fenêtre
        setLocationRelativeTo(parent);
    }

    private JPanel setupInfoPanel(TPersonnage joueur) {
        JPanel infoPanel = new JPanel(new GridLayout(5, 1));
        infoPanel.setBorder(new TitledBorder("Informations"));
        infoPanel.add(new JLabel("Nom: " + joueur.getNom()));
        infoPanel.add(new JLabel("Race: " + joueur.getRace().getDescription()));
        infoPanel.add(new JLabel("Classe: " + joueur.getClasse().getDescription()));
        infoPanel.add(new JLabel("PV: " + joueur.getPointVie() + "/" + joueur.getRace().getHitPointsMax(), new ImageIcon(getClass().getClassLoader().getResource(CreatorToolDialog.HEALTH_ITEM)), JLabel.LEFT));
        infoPanel.add(new JLabel("Classe d'armure: " + joueur.getClasseArmur(), new ImageIcon(getClass().getClassLoader().getResource("images/bouclier.png")), JLabel.LEFT));
        return infoPanel;
    }

    private JTable setupSkillsTable(TPersonnage joueur) {
        String[] columnNames = {"Nom", "Description", "Modif", "Dégâts Max", "Soin Max"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ECompetence comp : joueur.getClasse().getCompetences()) {
            model.addRow(new Object[]{comp.getNom(), comp.getDesc(), comp.getModif(), comp.getMaxDeDegat(), comp.getMaxDeHeal()});
        }
        JTable skillsTable = new JTable(model);
        adjustColumnWidths(skillsTable);
        return skillsTable;
    }

    private JPanel setupSkillsPanel(JScrollPane scrollPane) {
        JPanel skillsPanel = new JPanel(new BorderLayout());
        skillsPanel.setBorder(new TitledBorder("Compétences"));
        skillsPanel.add(scrollPane, BorderLayout.CENTER);
        return skillsPanel;
    }

    private JPanel setupButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton returnButton = new JButton("Retour");
        returnButton.addActionListener(e -> dispose());
        buttonPanel.add(returnButton);
        return buttonPanel;
    }

    private void adjustColumnWidths(JTable table) {
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // Nom
        table.getColumnModel().getColumn(1).setPreferredWidth(200); // Description
        table.getColumnModel().getColumn(2).setPreferredWidth(50);  // Modif
        table.getColumnModel().getColumn(3).setPreferredWidth(80);  // Dégâts Max
        table.getColumnModel().getColumn(4).setPreferredWidth(80);  // Soin Max
    }
}
