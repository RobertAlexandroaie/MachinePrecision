/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.MachinePrecision;
import utils.Constants;

/**
 * @author Robert
 */
public class MainFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainFrame frame = new MainFrame();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    private void initUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 495, 265);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(5, 7, 472, 208);
	contentPane.add(tabbedPane);

	JPanel pnlMachinePrecission = new JPanel();
	tabbedPane.addTab("Machine Precission", null, pnlMachinePrecission, null);
	pnlMachinePrecission.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setBounds(10, 11, 447, 88);
	pnlMachinePrecission.add(scrollPane);

	JLabel lblP1txt = new JLabel(Constants.p1txt);
	lblP1txt.setAutoscrolls(true);
	lblP1txt.setBounds(new Rectangle(0, 0, 1000, 1000));
	lblP1txt.setHorizontalTextPosition(SwingConstants.CENTER);
	lblP1txt.setHorizontalAlignment(SwingConstants.CENTER);
	lblP1txt.setPreferredSize(new Dimension(200, 14));
	lblP1txt.setVerticalTextPosition(SwingConstants.TOP);
	lblP1txt.setVerticalAlignment(SwingConstants.TOP);
	lblP1txt.setMinimumSize(new Dimension(200, 14));
	lblP1txt.setMaximumSize(new Dimension(600, 600));
	scrollPane.setViewportView(lblP1txt);

	final JLabel lblSol1 = new JLabel("Solutia: ");
	lblSol1.setBounds(10, 110, 447, 20);
	pnlMachinePrecission.add(lblSol1);

	JButton btnSolve1 = new JButton("Rezolva");

	btnSolve1.setBounds(10, 129, 447, 40);
	pnlMachinePrecission.add(btnSolve1);

	JPanel pnlSumAssociativity = new JPanel();
	tabbedPane.addTab("Sum Associativity", null, pnlSumAssociativity, null);
	pnlSumAssociativity.setLayout(null);

	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane_1.setBounds(10, 11, 447, 88);
	pnlSumAssociativity.add(scrollPane_1);

	JLabel lblP2Txt = new JLabel(Constants.p2txt);
	scrollPane_1.setViewportView(lblP2Txt);
	lblP2Txt.setVerticalAlignment(SwingConstants.TOP);

	final JLabel lblSol2 = new JLabel("Solutia:");
	lblSol2.setBounds(10, 110, 447, 20);
	pnlSumAssociativity.add(lblSol2);

	final JButton btnSolve2 = new JButton("Rezolva");
	btnSolve2.setToolTipText("\"Rezolva precizia mașină mai întâi\"");

	btnSolve2.setBounds(10, 129, 447, 40);
	btnSolve2.setEnabled(false);
	pnlSumAssociativity.add(btnSolve2);

	JPanel pnlMulAssociativity = new JPanel();
	tabbedPane.addTab("Mul Associativity", null, pnlMulAssociativity, null);
	pnlMulAssociativity.setLayout(null);

	JScrollPane scrollPane_2 = new JScrollPane();
	scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollPane_2.setBounds(10, 11, 447, 88);
	pnlMulAssociativity.add(scrollPane_2);

	JLabel lblP3txt = new JLabel(Constants.p3txt);
	scrollPane_2.setViewportView(lblP3txt);
	lblP3txt.setVerticalAlignment(SwingConstants.TOP);

	final JLabel lblSol3 = new JLabel("Solutia:");
	lblSol3.setBounds(10, 110, 447, 20);
	pnlMulAssociativity.add(lblSol3);

	final JButton btnSolve3 = new JButton("Rezolva");
	btnSolve3.setToolTipText("\"Rezolva precizia mașină mai întâi\"");
	btnSolve3.setBounds(10, 129, 447, 40);
	btnSolve3.setEnabled(false);
	pnlMulAssociativity.add(btnSolve3);

	btnSolve1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnSolve2.setEnabled(true);
		btnSolve3.setEnabled(true);
		lblSol1.setText("<html>Solutie: <b>u=" + MachinePrecision.getMachinePrecision() + "</b></html>");
	    }
	});

	btnSolve2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		double[] sol = MachinePrecision.associativeParam();
		lblSol2.setText("<html>Solutie: <b>(x+y)+z=" + sol[0] + "; x+(y+z)=" + sol[1] + "=> <b>false</b></b></html>");
	    }
	});

	btnSolve3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		double[] sol = MachinePrecision.mulAssociativeParam();
		lblSol3.setText("<html>Solutie: <b>x=" + sol[0] + "; (x+y)+z=" + sol[1] + "; x+(y+z)=" + sol[2] + "=> <b>false</b></b></html>");
	    }
	});
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
	initUI();
    }
}
