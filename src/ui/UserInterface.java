package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.Tryout;

public class UserInterface {

	private JFrame frame;
	private JPanel pnPatientForm;
	private JPanel pnPatientInfo;
	private JPanel pnPatientButtons;
	private JPanel pnDoctorForm;
	private JPanel pnDoctorInfo;
	private JPanel pnDoctorButtons;
	private JTextField txtName;
	private JTextField txtSurname;
	private JPanel pnDate;
	private JTextField txtDni;
	private JButton btnCancel;
	private JButton btnAdd;
	private JComboBox cbxYear;
	private JComboBox cbxMonth;
	private JComboBox cbxDay;
	private JTextField txtDName;
	private JTextField txtDSurname;
	private JPanel pnDDate;
	private JComboBox cbxDYear;
	private JComboBox cbxDMonth;
	private JComboBox cbxDDay;
	private JTextField txtDDni;
	private JPanel pnSpecificInfo;
	private JComboBox cbxExp;
	private JTextField txtLicense;
	private JButton btnCancelD;
	private JButton btnAddD;
	private JPanel pnSelection;
	private JButton btnAddDoctor;
	private JButton btnAddPatient;
	
	
	
	private Tryout manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		manager = new Tryout();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(getPnSelection(), "pnSelection");
		frame.getContentPane().add(getPnPatientForm(), "pnPatient");
		frame.getContentPane().add(getPnDoctorForm(), "pnDoctor");
		
	}

	private JPanel getPnPatientForm() {
		if (pnPatientForm == null) {
			pnPatientForm = new JPanel();
			pnPatientForm.setLayout(new BorderLayout(0, 0));
			pnPatientForm.add(getPnPatientInfo(), BorderLayout.CENTER);
			pnPatientForm.add(getPnPatientButtons(), BorderLayout.SOUTH);
		}
		return pnPatientForm;
	}
	private JPanel getPnPatientInfo() {
		if (pnPatientInfo == null) {
			pnPatientInfo = new JPanel();
			pnPatientInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnPatientInfo.add(getTxtName());
			pnPatientInfo.add(getTxtSurname());
			pnPatientInfo.add(getPnDate());
			pnPatientInfo.add(getTxtDni());
		}
		return pnPatientInfo;
	}
	private JPanel getPnPatientButtons() {
		if (pnPatientButtons == null) {
			pnPatientButtons = new JPanel();
			pnPatientButtons.add(getBtnCancel());
			pnPatientButtons.add(getBtnAdd());
		}
		return pnPatientButtons;
	}
	private JPanel getPnDoctorForm() {
		if (pnDoctorForm == null) {
			pnDoctorForm = new JPanel();
			pnDoctorForm.setLayout(new BorderLayout(0, 0));
			pnDoctorForm.add(getPnDoctorInfo(), BorderLayout.CENTER);
			pnDoctorForm.add(getPnDoctorButtons(), BorderLayout.SOUTH);
		}
		return pnDoctorForm;
	}
	private JPanel getPnDoctorInfo() {
		if (pnDoctorInfo == null) {
			pnDoctorInfo = new JPanel();
			pnDoctorInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnDoctorInfo.add(getTxtDName());
			pnDoctorInfo.add(getTxtDSurname());
			pnDoctorInfo.add(getPnDDate());
			pnDoctorInfo.add(getTxtDDni());
			pnDoctorInfo.add(getPnSpecificInfo());
		}
		return pnDoctorInfo;
	}
	private JPanel getPnDoctorButtons() {
		if (pnDoctorButtons == null) {
			pnDoctorButtons = new JPanel();
			pnDoctorButtons.add(getBtnCancelD());
			pnDoctorButtons.add(getBtnAddD());
		}
		return pnDoctorButtons;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setColumns(10);
		}
		return txtName;
	}
	private JTextField getTxtSurname() {
		if (txtSurname == null) {
			txtSurname = new JTextField();
			txtSurname.setColumns(10);
		}
		return txtSurname;
	}
	private JPanel getPnDate() {
		if (pnDate == null) {
			pnDate = new JPanel();
			pnDate.setLayout(new GridLayout(0, 3, 0, 0));
			pnDate.add(getCbxYear());
			pnDate.add(getCbxMonth());
			pnDate.add(getCbxDay());
		}
		return pnDate;
	}
	private JTextField getTxtDni() {
		if (txtDni == null) {
			txtDni = new JTextField();
			txtDni.setColumns(10);
		}
		return txtDni;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToSelectionPane();
				}
			});
			btnCancel.setForeground(Color.RED);
		}
		return btnCancel;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						manager.addPatient(getTxtName().getText(), getTxtSurname().getText(), (int)getCbxDay().getSelectedItem(),
								(int)getCbxMonth().getSelectedItem(),(int)getCbxYear().getSelectedItem() , getTxtDni().getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnAdd.setBackground(Color.GREEN);
		}
		return btnAdd;
	}
	private JComboBox getCbxYear() {
		if (cbxYear == null) {
			cbxYear = new JComboBox();
			Integer[] years = new Integer[101];
			int j = 0;
			for(int i=2023; i>1922;i--) {
				years[j] = i;
				j++;
			}
			cbxYear.setModel(new DefaultComboBoxModel(years));
		}
		return cbxYear;
	}
	private JComboBox getCbxMonth() {
		if (cbxMonth == null) {
			cbxMonth = new JComboBox();
			Integer[] months = new Integer[12];
			for(int i=1; i<13;i++) {
				months[i-1] = i;
			}
			cbxMonth.setModel(new DefaultComboBoxModel(months));
		}
		return cbxMonth;
	}
	private JComboBox getCbxDay() {
		if (cbxDay == null) {
			cbxDay = new JComboBox();
			Integer[] days = new Integer[31];
			for(int i=1; i<32;i++) {
				days[i-1] = i;
			}
			cbxDay.setModel(new DefaultComboBoxModel(days));
		}
		return cbxDay;
	}
	private JTextField getTxtDName() {
		if (txtDName == null) {
			txtDName = new JTextField();
			txtDName.setColumns(10);
		}
		return txtDName;
	}
	private JTextField getTxtDSurname() {
		if (txtDSurname == null) {
			txtDSurname = new JTextField();
			txtDSurname.setColumns(10);
		}
		return txtDSurname;
	}
	private JPanel getPnDDate() {
		if (pnDDate == null) {
			pnDDate = new JPanel();
			pnDDate.setLayout(new GridLayout(0, 3, 0, 0));
			pnDDate.add(getCbxDYear());
			pnDDate.add(getCbxDMonth());
			pnDDate.add(getCbxDDay());
		}
		return pnDDate;
	}
	private JComboBox getCbxDYear() {
		if (cbxDYear == null) {
			cbxDYear = new JComboBox();
			Integer[] years = new Integer[101];
			int j = 0;
			for(int i=2023; i>1922;i--) {
				years[j] = i;
				j++;
			}
			cbxDYear.setModel(new DefaultComboBoxModel(years));
		}
		return cbxDYear;
	}
	private JComboBox getCbxDMonth() {
		if (cbxDMonth == null) {
			cbxDMonth = new JComboBox();
			Integer[] months = new Integer[12];
			for(int i=1; i<13;i++) {
				months[i-1] = i;
			}
			cbxDMonth.setModel(new DefaultComboBoxModel(months));
		}
		return cbxDMonth;
	}
	private JComboBox getCbxDDay() {
		if (cbxDDay == null) {
			cbxDDay = new JComboBox();
			Integer[] days = new Integer[31];
			for(int i=1; i<32;i++) {
				days[i-1] = i;
			}
			cbxDDay.setModel(new DefaultComboBoxModel(days));
		}
		return cbxDDay;
	}
	private JTextField getTxtDDni() {
		if (txtDDni == null) {
			txtDDni = new JTextField();
			txtDDni.setColumns(10);
		}
		return txtDDni;
	}
	private JPanel getPnSpecificInfo() {
		if (pnSpecificInfo == null) {
			pnSpecificInfo = new JPanel();
			pnSpecificInfo.add(getCbxExp());
			pnSpecificInfo.add(getTxtLicense());
		}
		return pnSpecificInfo;
	}
	private JComboBox getCbxExp() {
		if (cbxExp == null) {
			cbxExp = new JComboBox();
			Integer[] exp = new Integer[50];
			for(int i=1; i<51;i++) {
				exp[i-1] = i;
			}
			cbxExp.setModel(new DefaultComboBoxModel(exp));
		}
		return cbxExp;
	}
	private JTextField getTxtLicense() {
		if (txtLicense == null) {
			txtLicense = new JTextField();
			txtLicense.setColumns(10);
		}
		return txtLicense;
	}
	private JButton getBtnCancelD() {
		if (btnCancelD == null) {
			btnCancelD = new JButton("Cancel");
			btnCancelD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToSelectionPane();
				}
			});
		}
		return btnCancelD;
	}
	private JButton getBtnAddD() {
		if (btnAddD == null) {
			btnAddD = new JButton("Add");
			btnAddD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						manager.addDoctor(getTxtDName().getText(), getTxtDSurname().getText(), (int)getCbxDDay().getSelectedItem(),
								(int)getCbxDMonth().getSelectedItem(), (int)getCbxDYear().getSelectedItem(), (int)getCbxExp().getSelectedItem(),
								getTxtLicense().getText(), getTxtDDni().getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnAddD;
	}
	private JPanel getPnSelection() {
		if (pnSelection == null) {
			pnSelection = new JPanel();
			pnSelection.setLayout(new GridLayout(0, 2, 0, 0));
			pnSelection.add(getBtnAddDoctor());
			pnSelection.add(getBtnAddPatient());
		}
		return pnSelection;
	}
	private JButton getBtnAddDoctor() {
		if (btnAddDoctor == null) {
			btnAddDoctor = new JButton("ADD NEW DOCTOR");
			btnAddDoctor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToDoctorForm();
				}
			});
		}
		return btnAddDoctor;
	}
	private void goToDoctorForm() {
		CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
		cl.show(frame.getContentPane(), "pnDoctor");
	}
	private JButton getBtnAddPatient() {
		if (btnAddPatient == null) {
			btnAddPatient = new JButton("ADD NEW PATIENT");
			btnAddPatient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToPatientForm();
				}
			});
		}
		return btnAddPatient;
	}
	private void goToPatientForm() {
		CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
		cl.show(frame.getContentPane(), "pnPatient");
	}
	private void goToSelectionPane() {
		CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
		cl.show(frame.getContentPane(), "pnSelection");
	}
}
