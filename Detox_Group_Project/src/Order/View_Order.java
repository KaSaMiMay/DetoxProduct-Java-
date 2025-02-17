package Order;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Admin_Dashboard;
import Admin.Staff_Dashboard;
import Dao.CRUD_Dao;
import DetoxProduct.ProductTableModel;
import DetoxProduct.View_Product;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Constructors.Order;
import Constructors.Staff;
public class View_Order extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private ArrayList<Order> order=new ArrayList<Order>();
	private OrderListTableModel otb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Order frame = new View_Order(new Staff());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public View_Order(Staff s) throws SQLException {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(View_Order.class.getResource("/image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 741);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 975, 62);
		contentPane.add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice\r\n ");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblAdminDashboard.setBounds(10, 0, 263, 62);
		panel.add(lblAdminDashboard);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1179, 10, 63, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblAdmin = new JLabel("Admin ");
	//	lblAdmin.setIcon(new ImageIcon(View_Order.class.getResource("/image/image/people icon.png")));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(867, 10, 98, 42);
		panel.add(lblAdmin);
		
		JLabel lblOrderList = new JLabel("Order List");
		lblOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderList.setForeground(Color.BLACK);
		lblOrderList.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		lblOrderList.setBackground(Color.BLACK);
		lblOrderList.setBounds(28, 98, 915, 43);
		contentPane.add(lblOrderList);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new Staff_Dashboard(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
	//	btnBack.setIcon(new ImageIcon(View_Order.class.getResource("/image/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(836, 78, 107, 33);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 189, 915, 444);
		contentPane.add(scrollPane);
		
		
		order=new CRUD_Dao().getOrder();
		otb=new OrderListTableModel(order);
		
		
		
		
		table = new JTable();
		table.setModel(otb);
//		new DefaultTableModel(
//			new Object[][] {
//				{new Integer(1), "Myo Myo", "Aung Aung"},
//				{new Integer(2), "Myo Myo", "Mya Mya"},
//				{new Integer(3), "Myo Myo", "Ko Ko"},
//				{new Integer(4), "Myo Myo", "Ko Ko"},
//				{new Integer(5), "Myo Myo", "Ko Ko"},
//				{new Integer(6), "Myo Myo", "Ko Ko"},
//				{new Integer(7), "Myo Myo", "Ko Ko"},
//				{new Integer(8), "Myo Myo", "Ko Ko"},
//				{new Integer(9), "Myo Myo", "Ko Ko"},
//				{new Integer(10), "Myo Myo", "Ko Ko"},
//				{new Integer(11), "Myo Myo", "Ko Ko"},
//				{new Integer(12), "Myo Myo", "Ko Ko"},
//				{new Integer(13), "Myo Myo", "Ko Ko"},
//				{new Integer(14), "Myo Myo", "Ko Ko"},
//				{new Integer(15), "Myo Myo", "Ko Ko"},
//				{new Integer(16), "Myo Myo", "Ko Ko"},
//				{new Integer(17), "Myo Myo", "Ko Ko"},
//				{new Integer(18), "Myo Myo", "Ko Ko"},
//				{new Integer(19), "Myo Myo", "Ko Ko"},
//				{new Integer(20), "Myo Myo", "Ko Ko"},
//				{new Integer(21), "Myo Myo", "Ko Ko"},
//				{new Integer(22), "Myo Myo", "Ko Ko"},
//				{new Integer(23), "Myo Myo", "Ko Ko"},
//				{new Integer(24), "Myo Myo", "Ko Ko"},
//				{new Integer(25), "Myo Myo", "Ko Ko"},
//				{new Integer(26), "Myo Myo", "Ko Ko"},
//				{new Integer(27), "Myo Myo", "Ko Ko"},
//				{new Integer(28), "Myo Myo", "Ko Ko"},
//				{new Integer(29), "Myo Myo", "Ko Ko"},
//				{new Integer(30), "Myo Myo", "Ko Ko"},
//				{new Integer(31), "Myo Myo", "Ko Ko"},
//				{new Integer(32), "Myo Myo", "Ko Ko"},
//				{new Integer(33), "Myo Myo", "Ko Ko"},
//				{new Integer(34), "Myo Myo", "Ko Ko"},
//				{new Integer(35), "Myo Myo", "Ko Ko"},
//				{new Integer(36), "Myo Myo", "Ko Ko"},
//				{new Integer(37), "Myo Myo", "Ko Ko"},
//				{new Integer(38), "Myo Myo", "Ko Ko"},
//				{new Integer(39), "Soe Soe", "Mya Mya"},
//				{new Integer(40), "Htun Htun", "Ko Ko"},
//				{new Integer(41), "Lwin Mar Aung", "Ko Ko"},
//				{new Integer(42), "Lwin Mar Aung", "Ko Ko"},
//				{new Integer(43), "Lwin Mar Aung", "Ko Ko"},
//				{new Integer(44), "Ei Sandar Kyaw", "Ko Ko"},
//				{new Integer(45), "Ei Sandar Kyaw", "Ko Ko"},
//			},
//			new String[] {
//				"A", "B", "C"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.setFont(new Font("Mongolian Baiti", Font.PLAIN, 21));
		scrollPane.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				try {
					ArrayList<Order>ur=new CRUD_Dao().getOrder();
					
					
					String keyword=txtSearch.getText().trim().toLowerCase();
					order.clear();
					order.addAll((ArrayList<Order>) ur.stream()
							.filter(u ->u.getSname().toLowerCase().contains(keyword)||u.getCname().toLowerCase().contains(keyword))
							.collect(Collectors.toList()));
					otb.fireTableDataChanged();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(573, 141, 345, 26);
		contentPane.add(txtSearch);
		
		JButton btnSearch = new JButton("");
		//btnSearch.setIcon(new ImageIcon(View_Order.class.getResource("/image/image/search.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(34, 139, 34));
		btnSearch.setBounds(919, 141, 24, 25);
		contentPane.add(btnSearch);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				
		        
		        In_vieworder viewProductPanel = null;
		        try {
					viewProductPanel = new In_vieworder(s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contentPane.add(viewProductPanel);
				contentPane.add(viewProductPanel,BorderLayout.CENTER);
		        
				
				viewProductPanel.setSize(580,620);
				viewProductPanel.setLocation(0,0);
		        contentPane.repaint();
		        contentPane.revalidate();
		        
		        int selectedRow = table.getSelectedRow();
				if(selectedRow != -1 ) {
					
					int id = (int) table.getValueAt(selectedRow, 0);
					Order o=new Order();
					int i=o.getOrderID();
					try {
						viewProductPanel.updateOrderDetails(id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
				
			}
		});
		//btnView.setIcon(new ImageIcon(View_Order.class.getResource("/image/image/view-grid-detail.png")));
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setBounds(836, 649, 107, 33);
		contentPane.add(btnView);
	}
}
