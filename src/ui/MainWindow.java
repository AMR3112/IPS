package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logic.Car;
import logic.Rental;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSeparator;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ButtonGroup;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel pnLogo;
	private JLabel lblLogo;
	private JLabel lblName;
	private JPanel pnContents;
	private JPanel pnCars;
	private JPanel pnCarSelected;
	private JPanel pnCustomerInfo;
	private JPanel pnButtons2;
	private JPanel pnInfo;
	private JPanel pnName;
	private JPanel pnNumber;
	private JPanel pnDate;
	private JPanel pnSpace;
	private JPanel pnBut2;
	private JButton btnPrevious2;
	private JButton btnConfirm;
	private JLabel lblUserName;
	private JTextField txtUserName;
	private JLabel lblNumber;
	private JTextField txtNumber;
	private JLabel lblMonth;
	private JComboBox cbxMonth;
	private JLabel lblDay;
	private JComboBox cbxDay;
	private JLabel lblYear;
	private JComboBox cbxYear;
	private JPanel pnButtons1;
	private JPanel pnSpace2;
	private JPanel pnBut1;
	private JButton btnPrevious;
	private JButton btnNext;
	private JPanel pnCarInfo;
	private JPanel pnType;
	private JPanel pnModel;
	private JPanel pnDescription;
	private JPanel pnPrice;
	private JScrollPane scrPnDescription;
	private JLabel lblDescription;
	private JTextArea txtDescription;
	private JLabel lblType;
	private JTextField txtType;
	private JLabel lblModel;
	private JTextField txtModel;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JPanel pnTitles;
	private JPanel pnAllCars;
	private JLabel lblCarType;
	private JLabel lblCarModel;
	private JLabel lblCarPrice;
	private JPanel pnTitlesSpace;
	private JScrollPane scrlPnCars;
	
	
	
	private Rental rental;
	private JLabel lblDays;
	private JSpinner spnDays;
	
	private int currentCarNumber;
	private JButton btnCancel;
	private JMenuBar menuBar;
	private JMenu mnFilter;
	private JCheckBoxMenuItem chckbxmntmFamiliar;
	private JSeparator separator;
	private JCheckBoxMenuItem chckbxmntmUtilitario;
	private JSeparator separator_1;
	private JCheckBoxMenuItem chckbxmntmLujo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JSeparator separator_2;
	private JMenuItem mntmContents;
	private JSeparator separator_3;
	private JCheckBoxMenuItem chckbxmntmResetFilters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setLocationRelativeTo(null);
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
	public MainWindow() {
		rental = new Rental();
				
		setTitle("Car Rent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnLogo(), BorderLayout.NORTH);
		contentPane.add(getPnContents(), BorderLayout.CENTER);
		
		cargaAyuda();
	}

	private JPanel getPnLogo() {
		if (pnLogo == null) {
			pnLogo = new JPanel();
			pnLogo.setBorder(new LineBorder(Color.BLACK, 4));
			pnLogo.setName("SDHFLKSJDLFKJSLDKJF");
			pnLogo.setBackground(Color.WHITE);
			pnLogo.setLayout(new GridLayout(0, 2, 0, 0));
			pnLogo.add(getLblLogo());
			pnLogo.add(getLblName());
		}
		return pnLogo;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setBackground(Color.WHITE);
			lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/img/logotipo.jpg")));
		}
		return lblLogo;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName =  new JLabel("Car Rental Gijon");
			lblName.setBackground(Color.WHITE);
			lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblName;
	}
	private JPanel getPnContents() {
		if (pnContents == null) {
			pnContents = new JPanel();
			pnContents.setBackground(Color.WHITE);
			pnContents.setLayout(new CardLayout(0, 0));
			pnContents.add(getPnCars(), "pn1");
			pnContents.add(getPnCarSelected(), "pn2");
			pnContents.add(getPnCustomerInfo(), "pn3");
		}
		return pnContents;
	}
	private JPanel getPnCars() {
		if (pnCars == null) {
			pnCars = new JPanel();
			pnCars.setBackground(Color.WHITE);
			pnCars.setLayout(new BorderLayout(0, 0));
			pnCars.add(getPnTitles(), BorderLayout.NORTH);
			pnCars.add(getScrlPnCars(), BorderLayout.CENTER);

		}
		return pnCars;
	}
	private JPanel getPnCarSelected() {
		if (pnCarSelected == null) {
			pnCarSelected = new JPanel();
			pnCarSelected.setBackground(Color.WHITE);
			pnCarSelected.setLayout(new BorderLayout(0, 0));
			pnCarSelected.add(getPnButtons1(), BorderLayout.SOUTH);
			pnCarSelected.add(getPnCarInfo(), BorderLayout.CENTER);
		}
		return pnCarSelected;
	}
	private JPanel getPnCustomerInfo() {
		if (pnCustomerInfo == null) {
			pnCustomerInfo = new JPanel();
			pnCustomerInfo.setBackground(Color.WHITE);
			pnCustomerInfo.setLayout(new BorderLayout(0, 0));
			pnCustomerInfo.add(getPnButtons2(), BorderLayout.SOUTH);
			pnCustomerInfo.add(getPnInfo());
		}
		return pnCustomerInfo;
	}
	private JPanel getPnButtons2() {
		if (pnButtons2 == null) {
			pnButtons2 = new JPanel();
			pnButtons2.setLayout(new GridLayout(1, 1, 0, 0));
			pnButtons2.add(getPnSpace());
			pnButtons2.add(getPnBut2());
		}
		return pnButtons2;
	}
	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setBackground(Color.WHITE);
			pnInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfo.add(getPnName());
			pnInfo.add(getPnNumber());
			pnInfo.add(getPnDate());
		}
		return pnInfo;
	}
	private JPanel getPnName() {
		if (pnName == null) {
			pnName = new JPanel();
			pnName.setBackground(Color.WHITE);
			pnName.add(getLblUserName());
			pnName.add(getTxtUserName());
		}
		return pnName;
	}
	private JPanel getPnNumber() {
		if (pnNumber == null) {
			pnNumber = new JPanel();
			pnNumber.setBackground(Color.WHITE);
			pnNumber.add(getLblNumber());
			pnNumber.add(getTxtNumber());
		}
		return pnNumber;
	}
	private JPanel getPnDate() {
		if (pnDate == null) {
			pnDate = new JPanel();
			pnDate.setBackground(Color.WHITE);
			pnDate.add(getLblMonth());
			pnDate.add(getCbxMonth());
			pnDate.add(getLblDay());
			pnDate.add(getCbxDay());
			pnDate.add(getLblYear());
			pnDate.add(getCbxYear());
		}
		return pnDate;
	}
	private JPanel getPnSpace() {
		if (pnSpace == null) {
			pnSpace = new JPanel();
			pnSpace.setBackground(Color.WHITE);
		}
		return pnSpace;
	}
	private JPanel getPnBut2() {
		if (pnBut2 == null) {
			pnBut2 = new JPanel();
			pnBut2.setBackground(Color.WHITE);
			pnBut2.add(getBtnPrevious2());
			pnBut2.add(getBtnConfirm());
			pnBut2.add(getBtnCancel());
		}
		return pnBut2;
	}
	private JButton getBtnPrevious2() {
		if (btnPrevious2 == null) {
			btnPrevious2 = new JButton("Previous");
			btnPrevious2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToCarInfoPanel(currentCarNumber);
				}
			});
			btnPrevious2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnPrevious2.setBackground(Color.RED);
		}
		return btnPrevious2;
	}
	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String msg = "";
					if(getTxtUserName().getText().isBlank() || getTxtUserName().getText().isEmpty())
						msg += "The name and surname field can not be empty";
					if(getTxtNumber().getText().isBlank() || getTxtNumber().getText().isEmpty())
						msg += "The number field can not be empty nor blank\n";
					else if(getTxtNumber().getText().length() != 9)
						msg += "The number field must be no longer nor shorter than 9 numbers\n";
					
					if(msg.isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "Your rental is already saved. Thanks for choosing us");
						goToCarsPanel();
					}else {
						JOptionPane.showMessageDialog(rootPane, msg);
					}
				}
			});
			btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnConfirm.setBackground(Color.GREEN);
		}
		return btnConfirm;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("Name and Surname");
			lblUserName.setBackground(Color.WHITE);
			lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblUserName;
	}
	private JTextField getTxtUserName() {
		if (txtUserName == null) {
			txtUserName = new JTextField();
			txtUserName.setBackground(Color.WHITE);
			txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtUserName.setColumns(10);
		}
		return txtUserName;
	}
	private JLabel getLblNumber() {
		if (lblNumber == null) {
			lblNumber = new JLabel("Telephone");
			lblNumber.setBackground(Color.WHITE);
			lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNumber;
	}
	private JTextField getTxtNumber() {
		if (txtNumber == null) {
			txtNumber = new JTextField();
			
			txtNumber.setBackground(Color.WHITE);
			txtNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNumber.setColumns(10);
		}
		return txtNumber;
	}
	private JLabel getLblMonth() {
		if (lblMonth == null) {
			lblMonth = new JLabel("Month");
			lblMonth.setBackground(Color.WHITE);
			lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblMonth;
	}
	private JComboBox getCbxMonth() {
		if (cbxMonth == null) {
			cbxMonth = new JComboBox();
			cbxMonth.setModel(new DefaultComboBoxModel(Month.values()));
			cbxMonth.setBackground(Color.WHITE);
			cbxMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return cbxMonth;
	}
	private JLabel getLblDay() {
		if (lblDay == null) {
			lblDay = new JLabel("Day");
			lblDay.setBackground(Color.WHITE);
			lblDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblDay;
	}
	private JComboBox getCbxDay() {
		if (cbxDay == null) {
			cbxDay = new JComboBox();
			List<Integer> days = new ArrayList<Integer>();
			for(int i=1; i<= 31; i++) {
				days.add(i);
			}
			cbxDay.setModel(new DefaultComboBoxModel(days.toArray()));
			cbxDay.setBackground(Color.WHITE);
			cbxDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return cbxDay;
	}
	private JLabel getLblYear() {
		if (lblYear == null) {
			lblYear = new JLabel("Year");
			lblYear.setBackground(Color.WHITE);
			lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblYear;
	}
	private JComboBox getCbxYear() {
		if (cbxYear == null) {
			cbxYear = new JComboBox();
			List<Integer> years = new ArrayList<Integer>();
			for(int i=2023; i<=2043; i++) {
				years.add(i);
			}
			cbxYear.setModel(new DefaultComboBoxModel(years.toArray()));
			cbxYear.setBackground(Color.WHITE);
			cbxYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return cbxYear;
	}
	private JPanel getPnButtons1() {
		if (pnButtons1 == null) {
			pnButtons1 = new JPanel();
			pnButtons1.setLayout(new GridLayout(1, 1, 0, 0));
			pnButtons1.add(getPnSpace2());
			pnButtons1.add(getPnBut1());
		}
		return pnButtons1;
	}
	private JPanel getPnSpace2() {
		if (pnSpace2 == null) {
			pnSpace2 = new JPanel();
			pnSpace2.setBackground(Color.WHITE);
		}
		return pnSpace2;
	}
	private JPanel getPnBut1() {
		if (pnBut1 == null) {
			pnBut1 = new JPanel();
			pnBut1.setBackground(Color.WHITE);
			pnBut1.add(getBtnPrevious());
			pnBut1.add(getBtnNext());
		}
		return pnBut1;
	}
	private JButton getBtnPrevious() {
		if (btnPrevious == null) {
			btnPrevious = new JButton("Previous");
			btnPrevious.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToCarsPanel();
				}
			});
			btnPrevious.setBackground(Color.RED);
			btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnPrevious;
	}
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToCustomerInfoPanel();
				}
			});
			btnNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNext.setBackground(Color.GREEN);
		}
		return btnNext;
	}
	private JPanel getPnCarInfo() {
		if (pnCarInfo == null) {
			pnCarInfo = new JPanel();
			pnCarInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnCarInfo.add(getPnType());
			pnCarInfo.add(getPnModel());
			pnCarInfo.add(getPnDescription());
			pnCarInfo.add(getPnPrice());
		}
		return pnCarInfo;
	}
	private JPanel getPnType() {
		if (pnType == null) {
			pnType = new JPanel();
			pnType.setName("");
			pnType.setLayout(new GridLayout(0, 2, 0, 0));
			pnType.add(getLblType());
			pnType.add(getTxtType());
		}
		return pnType;
	}
	private JPanel getPnModel() {
		if (pnModel == null) {
			pnModel = new JPanel();
			pnModel.setLayout(new GridLayout(0, 2, 0, 0));
			pnModel.add(getLblModel());
			pnModel.add(getTxtModel());
		}
		return pnModel;
	}
	private JPanel getPnDescription() {
		if (pnDescription == null) {
			pnDescription = new JPanel();
			pnDescription.setLayout(new GridLayout(0, 2, 0, 0));
			pnDescription.add(getLblDescription());
			pnDescription.add(getScrPnDescription());
		}
		return pnDescription;
	}
	private JPanel getPnPrice() {
		if (pnPrice == null) {
			pnPrice = new JPanel();
			pnPrice.setLayout(new GridLayout(0, 4, 0, 0));
			pnPrice.add(getLblDays());
			pnPrice.add(getSpnDays());
			pnPrice.add(getLblPrice());
			pnPrice.add(getTxtPrice());
		}
		return pnPrice;
	}
	private JScrollPane getScrPnDescription() {
		if (scrPnDescription == null) {
			scrPnDescription = new JScrollPane();
			scrPnDescription.setViewportView(getTextArea_1());
		}
		return scrPnDescription;
	}
	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("Description : ");
			lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescription.setBackground(Color.WHITE);
			lblDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblDescription;
	}
	private JTextArea getTextArea_1() {
		if (txtDescription == null) {
			txtDescription = new JTextArea();
			txtDescription.setLineWrap(true);
			txtDescription.setWrapStyleWord(true);
			txtDescription.setEditable(false);
		}
		return txtDescription;
	}
	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type : ");
			lblType.setHorizontalAlignment(SwingConstants.CENTER);
			lblType.setBackground(Color.WHITE);
			lblType.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblType;
	}
	private JTextField getTxtType() {
		if (txtType == null) {
			txtType = new JTextField();
			txtType.setEditable(false);
			txtType.setBackground(Color.WHITE);
			txtType.setHorizontalAlignment(SwingConstants.CENTER);
			txtType.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtType.setColumns(10);
		}
		return txtType;
	}
	private JLabel getLblModel() {
		if (lblModel == null) {
			lblModel = new JLabel("Branch and Model : ");
			lblModel.setHorizontalAlignment(SwingConstants.CENTER);
			lblModel.setBackground(Color.WHITE);
			lblModel.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblModel;
	}
	private JTextField getTxtModel() {
		if (txtModel == null) {
			txtModel = new JTextField();
			txtModel.setEditable(false);
			txtModel.setHorizontalAlignment(SwingConstants.CENTER);
			txtModel.setBackground(Color.WHITE);
			txtModel.setColumns(10);
		}
		return txtModel;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Total Price :");
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrice.setBackground(Color.WHITE);
			lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblPrice;
	}
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setEditable(false);
			txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtPrice.setBackground(Color.WHITE);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}
	private JPanel getPnTitles() {
		if (pnTitles == null) {
			pnTitles = new JPanel();
			pnTitles.setLayout(new GridLayout(1, 0, 0, 0));
			pnTitles.add(getLblCarType());
			pnTitles.add(getLblCarModel());
			pnTitles.add(getLblCarPrice());
			pnTitles.add(getPnTitlesSpace());
		}
		return pnTitles;
	}
	private JPanel getPnAllCars() {
		if (pnAllCars == null) {
			pnAllCars = new JPanel();
			pnAllCars.setAutoscrolls(true);
			pnAllCars.setLayout(new GridLayout(0, 1, 0, 0));
			createCarPanels();
		}
		return pnAllCars;
	}
	private void createCarPanels() {
		for(int i=0; i<rental.getActualListOfCars().size(); i++) {
			CarPanel cp = new CarPanel(rental.getActualListOfCars().get(i).getType(),
					rental.getActualListOfCars().get(i).getModel(),
					rental.getActualListOfCars().get(i).getPrice(), 
					this, 
					i);
			pnAllCars.add(cp);
		}
	}
	private JLabel getLblCarType() {
		if (lblCarType == null) {
			lblCarType = new JLabel("Type");
			lblCarType.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCarType;
	}
	private JLabel getLblCarModel() {
		if (lblCarModel == null) {
			lblCarModel = new JLabel("Branch and Model");
			lblCarModel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCarModel;
	}
	private JLabel getLblCarPrice() {
		if (lblCarPrice == null) {
			lblCarPrice = new JLabel("Price per Day");
			lblCarPrice.setBackground(new Color(240, 240, 240));
			lblCarPrice.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCarPrice;
	}
	
	protected void goToCarsPanel() {
		((CardLayout)getPnContents().getLayout()).show(getPnContents(), "pn1");
	}
	protected void goToCarInfoPanel(int carNumber) {
		currentCarNumber = carNumber;
		getSpnDays().setValue(1);
		
		getTxtType().setText(rental.getActualListOfCars().get(carNumber).getType());
		getTxtModel().setText(rental.getActualListOfCars().get(carNumber).getModel());
		getTextArea_1().setText(rental.getActualListOfCars().get(carNumber).getDescription());
		getTxtPrice().setText(rental.getActualListOfCars().get(carNumber).getPrice());
		((CardLayout)getPnContents().getLayout()).show(getPnContents(), "pn2");
	}
	protected void goToCustomerInfoPanel() {
		((CardLayout)getPnContents().getLayout()).show(getPnContents(), "pn3");
	}
	private JPanel getPnTitlesSpace() {
		if (pnTitlesSpace == null) {
			pnTitlesSpace = new JPanel();
		}
		return pnTitlesSpace;
	}
	private JScrollPane getScrlPnCars() {
		if (scrlPnCars == null) {
			scrlPnCars = new JScrollPane();
			scrlPnCars.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrlPnCars.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrlPnCars.setViewportView(getPnAllCars());
		}
		return scrlPnCars;
	}
	private JLabel getLblDays() {
		if (lblDays == null) {
			lblDays = new JLabel("Days : ");
			lblDays.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblDays;
	}
	private JSpinner getSpnDays() {
		if (spnDays == null) {
			spnDays = new JSpinner();
			spnDays.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					getTxtPrice().setText(String.valueOf(Integer.valueOf(rental.getActualListOfCars().get(currentCarNumber).getPrice())*(Integer)spnDays.getValue()));
				}
			});
			spnDays.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spnDays.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return spnDays;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToCarsPanel();
				}
			});
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCancel.setBackground(Color.RED);
		}
		return btnCancel;
	}
	
	void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch(Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"carSelection", hs); 
		   hb.enableHelpOnButton(getMntmContents(), "carSelection", hs);
		   
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFilter());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFilter() {
		if (mnFilter == null) {
			mnFilter = new JMenu("Filter");
			mnFilter.setMnemonic('F');
			mnFilter.add(getChckbxmntmFamiliar());
			mnFilter.add(getSeparator());
			mnFilter.add(getChckbxmntmUtilitario());
			mnFilter.add(getSeparator_1());
			mnFilter.add(getChckbxmntmLujo());
			mnFilter.add(getSeparator_3());
			mnFilter.add(getChckbxmntmResetFilters());
		}
		return mnFilter;
	}
	private JCheckBoxMenuItem getChckbxmntmFamiliar() {
		if (chckbxmntmFamiliar == null) {
			chckbxmntmFamiliar = new JCheckBoxMenuItem("Familiar");
			chckbxmntmFamiliar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					applyFilter("Familiar");
				}
			});
			buttonGroup.add(chckbxmntmFamiliar);
		}
		return chckbxmntmFamiliar;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JCheckBoxMenuItem getChckbxmntmUtilitario() {
		if (chckbxmntmUtilitario == null) {
			chckbxmntmUtilitario = new JCheckBoxMenuItem("Utilitario");
			chckbxmntmUtilitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					applyFilter("Utilitario");
				}
			});
			buttonGroup.add(chckbxmntmUtilitario);
		}
		return chckbxmntmUtilitario;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JCheckBoxMenuItem getChckbxmntmLujo() {
		if (chckbxmntmLujo == null) {
			chckbxmntmLujo = new JCheckBoxMenuItem("Lujo");
			chckbxmntmLujo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					applyFilter("Lujo");
				}
			});
			buttonGroup.add(chckbxmntmLujo);
		}
		return chckbxmntmLujo;
	}
	
	private void applyFilter(String type) {	
		if(type.isEmpty())
			rental.resetFilters();
		else
			rental.sortListOfCars(type);
		
		int i=0;
//		for(Car cr : rental.getCarList()) {
//			if(!cr.getType().equals(type)) {
//				getPnAllCars().getComponent(i).setBackground(Color.GRAY);
//				((CarPanel)getPnAllCars().getComponent(i)).statusOfBtnSelect(false);
//			}else {
//				getPnAllCars().getComponent(i).setBackground(Color.WHITE);
//				((CarPanel)getPnAllCars().getComponent(i)).statusOfBtnSelect(true);
//			}
//			i++;
//		}
		getPnAllCars().removeAll();
		repaint();
		for(Car cr : rental.getActualListOfCars()) {
			getPnAllCars().add(new CarPanel(cr.getType(), cr.getModel(), cr.getPrice(),this, i));
			i++;
		}
		validate();
	}
	
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getMntmAbout());
			mnHelp.add(getSeparator_2());
			mnHelp.add(getMntmContents());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmAbout;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}
	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContents;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
		}
		return separator_3;
	}
	private JCheckBoxMenuItem getChckbxmntmResetFilters() {
		if (chckbxmntmResetFilters == null) {
			chckbxmntmResetFilters = new JCheckBoxMenuItem("Reset Filters");
			chckbxmntmResetFilters.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					for(Component c : getPnAllCars().getComponents()) {
//						c.setBackground(Color.WHITE);
//						((CarPanel)c).statusOfBtnSelect(true);
//					}
					
					applyFilter("");
				}
			});
		}
		return chckbxmntmResetFilters;
	}
}
