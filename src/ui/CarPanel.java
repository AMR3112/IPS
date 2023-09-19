package ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class CarPanel extends JPanel {
	private JLabel lblType;
	private JLabel lblModel;
	private JLabel lblPrice;
	private JPanel pnButton;
	private JButton btnSelect;
	
	private String type;
	private String model;
	private String price;
	private MainWindow parent;
	private int panelNumber;

	/**
	 * Create the panel.
	 */
	public CarPanel(String t, String m, String p, MainWindow pa, int number) {
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(new GridLayout(0, 4, 0, 0));
		
		this.parent = pa;
		this.type = t;
		this.model = m;
		this.price = p;
		this.panelNumber = number;
		
		
		add(getLblType());
		add(getLblModel());
		add(getLblPrice());
		add(getPnButton());
	}
	public MainWindow getWindowParent() {
		return this.parent;
	}
	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel(type);
			lblType.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblType;
	}
	private JLabel getLblModel() {
		if (lblModel == null) {
			lblModel = new JLabel(model);
			lblModel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblModel;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel(price);
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPrice;
	}
	private JPanel getPnButton() {
		if (pnButton == null) {
			pnButton = new JPanel();
			pnButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnButton.add(getBtnSelect());
		}
		return pnButton;
	}
	private JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("Select");
			btnSelect.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getWindowParent().goToCarInfoPanel(panelNumber);
				}
			});
			btnSelect.setBackground(Color.GREEN);
		}
		return btnSelect;
	}
	protected void statusOfBtnSelect(boolean status) {
		getBtnSelect().setEnabled(status);
	}
}
