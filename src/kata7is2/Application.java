package kata7is2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import kata7is2.application.swing.HistogramPanel;
import kata7is2.application.swing.Toolbar;
import kata7is2.control.CalculateCommand;
import kata7is2.control.Command;
import kata7is2.view.AttributeDialog;
import kata7is2.view.HistogramDisplay;
import kata7is2.view.PopulationDialog;

/**
 *
 * @author Pablo Alonso
 */
public class Application extends JFrame{
    
    private Map<String,Command> commands = new HashMap<>();
    private AttributeDialog atributeDialog;
    private PopulationDialog populationDialog;
    private HistogramDisplay histogramDisplay;
    
    public static void main(String[] args){
        new Application().setVisible(true);
    }
    
    public Application(){
        this.deployUI();
        this.createCommand();
    }

    private void deployUI() {
        this.setTitle("Histogram viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,500));
        this.getContentPane().add(histogramPanel());
        this.getContentPane().add(toolbar(commands),BorderLayout.NORTH);
        this.setLocationRelativeTo(null);
    }

    private void createCommand() {
        commands.put("calculate", new CalculateCommand(atributeDialog, populationDialog, histogramDisplay));
    }

    private HistogramPanel histogramPanel() {
        HistogramPanel panel = new HistogramPanel();
        this.histogramDisplay = panel;
        return panel;        
    }

    private JPanel toolbar(Map<String, Command> commands) {
        Toolbar panel = new Toolbar(commands);
        this.atributeDialog = panel;
        this.populationDialog = panel;
        return panel;
        
    }
    
}
