package new_animal_farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtWelcomeToThe;
	private JTextField txtAddNewAnimal;
	private JTextField txtAnimalType;
	private JTextField txtGender;
	private JTextField txtAge;
	private JTable table;
	private JTextField txtMoney;
	private JTextField txtForage;
	private JTextField moneyField;
	private JTextField forageField;
	private JTable meatButtonsTable;
	private JTable productButtonsTable;
	private JTextField slaughterText;
	private JTextField productObtainText;
	private JTable productsAndMeatTable;
	private JTextField productTableHeader;
	private JTextField currentAnimalsHeader;
	private JComboBox animalTypeComboBox;
	private JComboBox animalGenderComboBox;

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
		setBounds(100, 100, 967, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setForeground(new Color(64, 0, 128));
		txtWelcomeToThe.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		txtWelcomeToThe.setEnabled(false);
		txtWelcomeToThe.setText("  Animal Farm Database");
		txtWelcomeToThe.setBounds(10, 0, 352, 53);
		contentPane.add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);

		txtAddNewAnimal = new JTextField();
		txtAddNewAnimal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddNewAnimal.setEditable(false);
		txtAddNewAnimal.setText("Add New Animal Record:");
		txtAddNewAnimal.setBounds(10, 64, 182, 40);
		contentPane.add(txtAddNewAnimal);
		txtAddNewAnimal.setColumns(10);

		txtAnimalType = new JTextField();
		txtAnimalType.setEditable(false);
		txtAnimalType.setText("Animal Type:");
		txtAnimalType.setBounds(10, 112, 79, 20);
		contentPane.add(txtAnimalType);
		txtAnimalType.setColumns(10);

		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setText("Gender:");
		txtGender.setBounds(10, 158, 79, 20);
		contentPane.add(txtGender);
		txtGender.setColumns(10);

		txtAge = new JTextField();
		txtAge.setEditable(false);
		txtAge.setText("Age:");
		txtAge.setBounds(10, 204, 79, 20);
		contentPane.add(txtAge);
		txtAge.setColumns(10);

		JTextArea ageText = new JTextArea();
		ageText.setBounds(113, 204, 150, 20);
		contentPane.add(ageText);

		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		saveButton.setBounds(273, 217, 89, 31);
		contentPane.add(saveButton);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		model.addColumn("Animal Info");
		model.addColumn("Status");
		table.setBounds(10, 310, 247, 152);
		contentPane.add(table);

		DefaultTableModel meatbuttonsTableModel = new DefaultTableModel();
		meatButtonsTable = new JTable();
		meatButtonsTable.setEnabled(false);
		meatButtonsTable.setModel(meatbuttonsTableModel);
		meatButtonsTable.setBounds(267, 310, 79, 152);
		meatbuttonsTableModel.addColumn("meatButton");
		ButtonRenderer meatButtonRenderer = new ButtonRenderer();
		meatButtonsTable.getColumn("meatButton").setCellRenderer(meatButtonRenderer);
		meatButtonsTable.getColumn("meatButton").setCellEditor(new ButtonEditor(new JCheckBox()));
		contentPane.add(meatButtonsTable);

		DefaultTableModel productbuttonsTableModel = new DefaultTableModel();
		productButtonsTable = new JTable();
		productButtonsTable.setEnabled(false);
		productButtonsTable.setModel(productbuttonsTableModel);
		productButtonsTable.setBounds(356, 310, 153, 152);
		productbuttonsTableModel.addColumn("productButton"); 
		productButtonsTable.getColumn("productButton").setCellRenderer(new ButtonRenderer());
		productButtonsTable.getColumn("productButton").setCellEditor(new ButtonEditor(new JCheckBox()));
		contentPane.add(productButtonsTable);

		txtMoney = new JTextField();
		txtMoney.setEditable(false);
		txtMoney.setText("Money: ");
		txtMoney.setBounds(553, 70, 104, 31);
		contentPane.add(txtMoney);
		txtMoney.setColumns(10);

		txtForage = new JTextField();
		txtForage.setEditable(false);
		txtForage.setText("Forage:");
		txtForage.setBounds(553, 109, 104, 26);
		contentPane.add(txtForage);
		txtForage.setColumns(10);

		moneyField = new JTextField();
		moneyField.setText("100");
		moneyField.setBounds(669, 71, 71, 29);
		contentPane.add(moneyField);
		moneyField.setColumns(10);

		forageField = new JTextField();
		forageField.setText("10");
		forageField.setBounds(667, 112, 73, 20);
		contentPane.add(forageField);
		forageField.setColumns(10);

		JButton btnBuyForage = new JButton("Buy Forage");
		btnBuyForage.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBuyForage.setBounds(720, 146, 122, 32);
		contentPane.add(btnBuyForage);

		slaughterText = new JTextField();
		slaughterText.setText("Slaughter");
		slaughterText.setEditable(false);
		slaughterText.setBounds(267, 259, 79, 40);
		contentPane.add(slaughterText);
		slaughterText.setColumns(10);

		productObtainText = new JTextField();
		productObtainText.setText("Collect Product ");
		productObtainText.setEditable(false);
		productObtainText.setColumns(10);
		productObtainText.setBounds(356, 259, 153, 40);
		contentPane.add(productObtainText);

		productsAndMeatTable = new JTable();
		productsAndMeatTable.setColumnSelectionAllowed(true);
		productsAndMeatTable.setCellSelectionEnabled(true);
		productsAndMeatTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		productsAndMeatTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productsAndMeatTable.setModel(
				new DefaultTableModel(
			new Object[][] {
				{"Meat", new Integer(0)},
				{"Goat Hair", new Integer(0)},
				{"Milk", new Integer(0)},
				{"Sheep's Wool", new Integer(0)},
				{"Egg", new Integer(0)},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		productsAndMeatTable.getColumnModel().getColumn(0).setPreferredWidth(159);
	    productsAndMeatTable.setRowHeight(25);
		productsAndMeatTable.setBounds(553, 305, 265, 125);
		contentPane.add(productsAndMeatTable);

		productTableHeader = new JTextField();
		productTableHeader.setText("Products:");
		productTableHeader.setBounds(553, 259, 143, 40);
		contentPane.add(productTableHeader);
		productTableHeader.setColumns(10);

		currentAnimalsHeader = new JTextField();
		currentAnimalsHeader.setText("Current Animals:");
		currentAnimalsHeader.setEditable(false);
		currentAnimalsHeader.setBounds(10, 259, 247, 40);
		contentPane.add(currentAnimalsHeader);
		currentAnimalsHeader.setColumns(10);

		animalTypeComboBox = new JComboBox();
		animalTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Goat - 10 seconds", "Cow - 7 seconds", "Sheep - 5 seconds", "Chicken - 3 seconds"}));
		animalTypeComboBox.setBounds(112, 112, 153, 26);
		contentPane.add(animalTypeComboBox);
		
		animalGenderComboBox = new JComboBox();
		animalGenderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		animalGenderComboBox.setToolTipText("");
		animalGenderComboBox.setBounds(112, 158, 153, 26);
		contentPane.add(animalGenderComboBox);
		
		JButton btnNewButton = new JButton("Sell");
		btnNewButton.setBounds(828, 305, 89, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sell");
		btnNewButton_1.setBounds(828, 330, 89, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sell");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(828, 355, 89, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sell");
		btnNewButton_3.setBounds(828, 380, 89, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sell");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(828, 405, 89, 25);
		contentPane.add(btnNewButton_4);

		btnBuyForage.addActionListener(new ActionListener() {
			int parasayisi = Integer.parseInt(moneyField.getText());;
			int yemsayisi = Integer.parseInt(forageField.getText());;;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (parasayisi >= 10) {
					parasayisi -= 10;
					yemsayisi++;

					String yemSayisiString = String.valueOf(yemsayisi);
					forageField.setText(yemSayisiString);

					String parasayisiString = String.valueOf(parasayisi);
					moneyField.setText(parasayisiString);

				} else {
					JOptionPane alert = new JOptionPane();
					alert.showMessageDialog(null, "Unsufficient Balance");
				}

			}
		});

		ArrayList<Animal> currentAnimals = new ArrayList<>(7);
		// eklenen hayvanların tutulacağı ArrayList

		saveButton.addActionListener(new ActionListener() {

			boolean alertOccured = false; // false olduğu müddette program çalışmaya devam edecek.
			Animal animal;

			// her save tuşuna basıldığında animal nesnesi yeni kaydın bilgileriyle
			// tekrardan oluşur.
			@Override
			public void actionPerformed(ActionEvent e) {
				// hayvan nesnesini gerekli subclassta oluşturduk.
				System.out.println(animalTypeComboBox.getSelectedItem().toString());
				switch (animalTypeComboBox.getSelectedItem().toString()) {
				case "Sheep - 5 seconds":
					animal = new Sheep(Integer.parseInt(ageText.getText()), animalGenderComboBox.getSelectedItem().toString());
					break;
				case "Cow - 7 seconds":
					animal = new Cow(Integer.parseInt(ageText.getText()), animalGenderComboBox.getSelectedItem().toString());
					break;
				case "Chicken - 3 seconds":
					animal = new Chicken(Integer.parseInt(ageText.getText()), animalGenderComboBox.getSelectedItem().toString());
					break;
				case "Goat - 10 seconds":
					animal = new Goat(Integer.parseInt(ageText.getText()), animalGenderComboBox.getSelectedItem().toString());
					break;

				default:
					JOptionPane alert = new JOptionPane();
					alert.showMessageDialog(null, "Unvalid animal type");
					alertOccured = true; // programın devamını engelleyecek.
					break;
				}

				if (!alertOccured) {
					JOptionPane panelimiz = new JOptionPane();
					panelimiz.showMessageDialog(null, "Record is saved");

					currentAnimals.add(animal);

					/*
					 * currentAnimals.get(currentAnimals.size()-1).setType(animalText);
					 * currentAnimals.get(currentAnimals.size()-1).setAge(ageText);
					 * currentAnimals.get(currentAnimals.size()-1).setGender(genderText);
					 */ // buna gerek yok gibi

					String hayvanbilgi = (currentAnimals.get(currentAnimals.size() - 1).getType() + " "
							+ currentAnimals.get(currentAnimals.size() - 1).age + " "
							+ currentAnimals.get(currentAnimals.size() - 1).gender);
					/* System.out.println(hayvanbilgi); */
					// hayvanın bilgilerini görmek için test.

					// Icon icon = new
					// ImageIcon("file:///C:/Users/Efe%20%C7etinkaya/Desktop/button-glossy-blue-vector-graphic-pixabay-19.png");

					model.addRow(new Object[] { hayvanbilgi, "not ready" });

					JButton meatObtainButton = new JButton();

					JButton productObtainButton = new JButton();

					meatbuttonsTableModel.addRow(new Object[] { meatObtainButton });
					productbuttonsTableModel.addRow(new Object[] { productObtainButton });

					meatObtainButton.setEnabled(false);
					// button table ekleencek
				}

				Timer myTimer = new Timer();
				TimerTask gorev = new TimerTask() {
					int animalIndex = currentAnimals.size() - 1;

					// timer'ın içinde doğrudan index'i kullanmak yerine kopyasını kullanmak
					// asenkron olarak tek timer nesnesiyle kayma olmadan tüm kayıtları
					// yönetmeyi sağlıyor.
					@Override
					public void run() {

						model.setValueAt("ready", animalIndex, 1);
						System.out.println("başarılı");
						meatSetButtonsTableEnabled(true);
						productSetButtonsTableEnabled(true);

						// Et alma buttonladyrı rea ile birlikte enabled oluyor
						// şimdi tıklandığında olacaklar kaldı.
						// bir mevcut hayvan listesi oluştur.
						// hYVn eklendiğinde orada sayı artsın, et alındığında azalsın
						// button disabled a dönsün.

//							

						forageField.setText(String.valueOf(Integer.parseInt(forageField.getText()) + 1));
						;

					}

				};

				myTimer.schedule(gorev, animal.getProductTime());

				// iki yol var. ya her kayıtta yeni anonymous row eklenecek ya da
				// ilk başta visible olmayan rowlar kayıt geldikçe visible olacaklar

			}

		});
		
		
		//meat buttonlarına action listener ekliyorum.
		meatButtonRenderer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setEnabled(false);
				
				
			}
		});
	

	}

	public boolean getButtonsTableEnabled() {
		return meatButtonsTable.isEnabled();
		// ürün toplama buna bağlı yapılabilir.
		// disable oldukça timer başlatır.
	}

	public void meatSetButtonsTableEnabled( boolean enabled) {
		
		meatButtonsTable.setEnabled(enabled);
	}

	public void productSetButtonsTableEnabled(boolean enabled) {
		productButtonsTable.setEnabled(enabled);
	}
}

class ButtonRenderer extends JButton implements TableCellRenderer {

	public ButtonRenderer() {
		setOpaque(true);
		setEnabled(false);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
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

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				button.setEnabled(false); // deneme 123

			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

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
			;
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
