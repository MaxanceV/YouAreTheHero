package InterfaceGame;
import javax.swing.table.DefaultTableModel;

import Univers.Enum.ECompetence;

public class CompetenceTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = {"Nom", "Description", "Modificateur", "Dégâts Max", "Soin Max"};
    
    public CompetenceTableModel(ECompetence[] competences) {
        super(convertToData(competences), COLUMN_NAMES);
    }
    
    private static Object[][] convertToData(ECompetence[] competences) {
        Object[][] data = new Object[competences.length][5];
        for (int i = 0; i < competences.length; i++) {
            data[i][0] = competences[i].getNom();
            data[i][1] = competences[i].getDesc();
            data[i][2] = competences[i].getModif();
            data[i][3] = competences[i].getMaxDeDegat();
            data[i][4] = competences[i].getMaxDeHeal();
        }
        return data;
    }
}
