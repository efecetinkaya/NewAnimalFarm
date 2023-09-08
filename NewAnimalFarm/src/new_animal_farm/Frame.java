package new_animal_farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtWelcomeToThe;
	private JTextField txtProductionTimes;
	private JTextField txtChicken;
	private JTextField txtCow;
	private JTextField txtSheep;
	private JTextField txtGoat;
	private JTextField txtAddNewAnimal;
	private JTextField txtAnimalType;
	private JTextField txtGender;
	private JTextField txtAge;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setForeground(new Color(64, 0, 128));
		txtWelcomeToThe.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		txtWelcomeToThe.setEnabled(false);
		txtWelcomeToThe.setText("Welcome to the Animal Farm");
		txtWelcomeToThe.setBounds(10, 11, 211, 20);
		contentPane.add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
		
		txtProductionTimes = new JTextField();
		txtProductionTimes.setEditable(false);
		txtProductionTimes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProductionTimes.setText("Production Times:");
		txtProductionTimes.setBounds(10, 33, 126, 20);
		contentPane.add(txtProductionTimes);
		txtProductionTimes.setColumns(10);
		
		txtChicken = new JTextField();
		txtChicken.setEditable(false);
		txtChicken.setText("Chicken = 3 ");
		txtChicken.setBounds(10, 61, 96, 20);
		contentPane.add(txtChicken);
		txtChicken.setColumns(10);
		
		txtCow = new JTextField();
		txtCow.setEditable(false);
		txtCow.setText("Cow = 7");
		txtCow.setBounds(10, 92, 96, 20);
		contentPane.add(txtCow);
		txtCow.setColumns(10);
		
		txtSheep = new JTextField();
		txtSheep.setEditable(false);
		txtSheep.setText("Sheep = 5");
		txtSheep.setBounds(116, 61, 96, 20);
		contentPane.add(txtSheep);
		txtSheep.setColumns(10);
		
		txtGoat = new JTextField();
		txtGoat.setEditable(false);
		txtGoat.setText("Goat = 10");
		txtGoat.setBounds(116, 92, 96, 20);
		contentPane.add(txtGoat);
		txtGoat.setColumns(10);
		
		txtAddNewAnimal = new JTextField();
		txtAddNewAnimal.setEditable(false);
		txtAddNewAnimal.setText("Add New Animal Record:");
		txtAddNewAnimal.setBounds(10, 123, 143, 20);
		contentPane.add(txtAddNewAnimal);
		txtAddNewAnimal.setColumns(10);
		
		txtAnimalType = new JTextField();
		txtAnimalType.setEditable(false);
		txtAnimalType.setText("Animal Type:");
		txtAnimalType.setBounds(10, 144, 79, 20);
		contentPane.add(txtAnimalType);
		txtAnimalType.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setText("Gender:");
		txtGender.setBounds(10, 166, 79, 20);
		contentPane.add(txtGender);
		txtGender.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setEditable(false);
		txtAge.setText("Age:");
		txtAge.setBounds(10, 189, 79, 20);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JTextArea animalText = new JTextArea();
		animalText.setBounds(99, 147, 54, 16);
		contentPane.add(animalText);
		
		JTextArea genderText = new JTextArea();
		genderText.setBounds(99, 169, 54, 16);
		contentPane.add(genderText);
		
		JTextArea ageText = new JTextArea();
		ageText.setBounds(99, 192, 54, 16);
		contentPane.add(ageText);
		
	

		JButton saveButton = new JButton("save");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		saveButton.setBounds(163, 210, 79, 23);
		contentPane.add(saveButton);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		model.addColumn("Animal Info");
		model.addColumn("Status");
		model.addColumn("Obtain Product");
		
		
	        table.getColumn("Obtain Product").setCellRenderer(new ButtonRenderer());
	        table.getColumn("Obtain Product").setCellEditor(new ButtonEditor(new JCheckBox()));
		
			
		table.setBounds(10, 244, 300, 110);
		contentPane.add(table);
		
		
		
		ArrayList<Animal> currentAnimals = new ArrayList<>(7);
		//eklenen hayvanların tutulacağı ArrayList
		
		
		saveButton.addActionListener(new ActionListener() {
			
			boolean alertOccured = false; //false olduğu müddette program çalışmaya devam edecek.
			Animal animal;
			//her save tuşuna basıldığında animal nesnesi yeni kaydın bilgileriyle tekrardan oluşur.
			@Override
			public void actionPerformed(ActionEvent e) {
				//hayvan nesnesini gerekli subclassta  oluşturduk.
				System.out.println(animalText.getText().toString());
				switch (animalText.getText().toString()) {
				case "sheep":
					animal = new Sheep(Integer.parseInt(ageText.getText()), genderText.getText().toString());
					break;
				case "cow":
					animal = new Cow(Integer.parseInt(ageText.getText()), genderText.getText().toString());
					break;
				case "chicken":
					animal = new Chicken(Integer.parseInt(ageText.getText()), genderText.getText().toString());
					break;
				case "goat":
					animal = new Goat(Integer.parseInt(ageText.getText()), genderText.getText().toString());
					break;

				default:
					JOptionPane alert = new JOptionPane();
					alert.showMessageDialog(null, "Unvalid animal type");
					alertOccured = true; //programın devamını engelleyecek.
					break;
				}
				
				if(!alertOccured) {
					JOptionPane panelimiz = new JOptionPane();
					panelimiz.showMessageDialog(null, "Record is saved");
					
					currentAnimals.add(animal);
					
					/*currentAnimals.get(currentAnimals.size()-1).setType(animalText);
				    currentAnimals.get(currentAnimals.size()-1).setAge(ageText); 
					currentAnimals.get(currentAnimals.size()-1).setGender(genderText);
					*/ //buna gerek yok gibi
					
					String hayvanbilgi = (currentAnimals.get(currentAnimals.size()-1).getType()+" "+currentAnimals.get(currentAnimals.size()-1).age+" "+currentAnimals.get(currentAnimals.size()-1).gender);
					/*System.out.println(hayvanbilgi); */
					//hayvanın bilgilerini görmek için test.
					
					//Icon icon = new ImageIcon("file:///C:/Users/Efe%20%C7etinkaya/Desktop/button-glossy-blue-vector-graphic-pixabay-19.png");

					model.addRow(new Object[]{hayvanbilgi, "not ready",new JButton()});
					}

					Timer myTimer = new Timer();
					TimerTask gorev = new TimerTask() {

						@Override
						public void run() {

							model.setValueAt("ready", currentAnimals.size()-1, 1);
							System.out.println("başarılı");
							
						}
						
					};
					
					myTimer.schedule(gorev, animal.getProductTime());
				
					
					//iki yol var. ya her kayıtta yeni anonymous row eklenecek ya da
					//ilk başta visible olmayan rowlar kayıt geldikçe visible olacaklar
					
					
					
					
					
					
					
				}
				
				
			
		});
		
	}
}


class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    
    
    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.setEnabled(false); //basıldıktan sonra disable'a döner.
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
    	
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
        	 
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(button, "Product obtained.");
            
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
