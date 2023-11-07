import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileChooserComponent extends JPanel {
    private JButton selectButton;
    private JFileChooser fileChooser;
    private File choosenFile;

    public FileChooserComponent() {
        selectButton = new JButton("Select File");
        fileChooser = new JFileChooser();


        final FileFilter textFileFilter = new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files (*.txt)";
            }
        };

        final FileFilter javaFileFilter = new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".java");
            }
            @Override
            public String getDescription() {
                return "Java Files (*.java)";
            }
        };

        final FileFilter excelFileFilter = new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".xlsx");
            }
            @Override
            public String getDescription() {
                return "Excel Files (*.xlsx)";
            }
        };

        final FileFilter csvFileFilter = new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".csv");
            }
            @Override
            public String getDescription() {
                return "CSV Files (*.csv)";
            }
        };
        fileChooser.addChoosableFileFilter(textFileFilter);
        fileChooser.addChoosableFileFilter(javaFileFilter);
        fileChooser.addChoosableFileFilter(excelFileFilter);
        fileChooser.addChoosableFileFilter(csvFileFilter);
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    choosenFile = selectedFile;
                    try {
                        Scanner sc = new Scanner(selectedFile);
                        while(sc.hasNextLine())
                            System.out.println(sc.nextLine());
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });
        add(selectButton);
        fileChooser.setCurrentDirectory(fileChooser.getCurrentDirectory());
    }

    public File getChoosenFile() {
        return choosenFile;
    }
}
