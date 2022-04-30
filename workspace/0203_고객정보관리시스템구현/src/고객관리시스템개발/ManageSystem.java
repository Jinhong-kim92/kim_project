package 고객관리시스템개발;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * <<개정 이력(Modifiaction Information)>>
 * 
 *   개발자     작성일                작업 내용
 *   -----  -----        --------
 *   홍길동     2022.02.03   인트로 화면 구현 중 메뉴, West쪽의 입력, 신상정보 보더 
 *   홍길동     2022.02.04   인트로 화면 구현 중 SOUTH쪽, CENTER쪽, '추가' 기능 구현
 *   홍길동     2022.02.07   '수정', '삭제' 기능 구현, '검색' 버튼 클릭 시 정보검색 카드로 바꿈
 *   홍길동     2022.02.08   '검색', '파일 열기', '파일 저장' '닫기' 기능 구현 
 */

//윈도우(GUI) 프로그램 개발 시 먼저 JFrame 클래스로부터 상속을 받자!!
//JFrame는 최상위 컨테이너이다.
public class ManageSystem  extends JFrame {    //외부 클래스
	public static final String String = null;
	
	//내부 클래스 객체 생성
	MenuMain menuMain = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	ShowTable showTable = new ShowTable();
	
	
	//생성자 
	public ManageSystem() {
		OUTTER: while(true) {   //무한 Loop,  OUTTER는 레이블이라고 한다.
			ImageIcon icon = new ImageIcon("images/고객정보관리_이미지.jpg");
			JOptionPane.showMessageDialog(null, null, "고객정보관리 시스템", JOptionPane.NO_OPTION, icon);
			
			//패스워드 인증창 만들어 띄우기
			String password = JOptionPane.showInputDialog("고객관리 시스템"+"\n"+"패스워드 입력");
			String passwd = "test1234";  //실제 패스워드
			
			if(password == null) {
				break OUTTER;
			}
			else if(password.equals(passwd)) {  //인증 성공인 경우!! => 실행 창을 띄워라
				setTitle("고객정보관리 시스템");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//내부 클래스 객체 붙이기
				add(menuMain.bar, BorderLayout.NORTH);
				add(west, BorderLayout.WEST);
				add(buttons, BorderLayout.SOUTH);
				add(showTable.scrollPane, BorderLayout.CENTER);
				
				setSize(1200, 700);
				setLocation(500, 50);
				setVisible(true);
				
				break OUTTER;
			}else {
				JOptionPane.showMessageDialog(null, "패스워드가 맞지 않습니다."+"\n"+"'확인' 버튼을 누르세요.", 
						                        "패스워드 인증 실패", JOptionPane.ERROR_MESSAGE);
				continue OUTTER;
			}
		}
	}
	
	//메뉴 만들기 내부 클래스 구현
	//JPanel는 작은 컨테이너이다.
	class MenuMain extends JPanel implements ActionListener, ItemListener {
		JMenuBar bar;
		JMenu file, sort, help;
		JMenuItem fopen, fsave, fexit, proinfo;
		JCheckBoxMenuItem sno, sname, schul, sjob;
		
		FileDialog saveOpen, readOpen;
		String fileDir, fileName, savefileName, readfileName;
		ButtonGroup gr = new ButtonGroup();
		
		//생성자 
		public MenuMain() {
			bar = new JMenuBar();
			
			file = new JMenu("파일");
			sort = new JMenu("정렬");
			help = new JMenu("도움말");
			
			fopen = new JMenuItem("열기");
			fsave = new JMenuItem("저장");
			fexit = new JMenuItem("닫기");
			
			sno = new JCheckBoxMenuItem("번호");
			sname = new JCheckBoxMenuItem("이름");
			schul = new JCheckBoxMenuItem("출신지역");
			sjob = new JCheckBoxMenuItem("직업");
			
			proinfo = new JMenuItem("프로그램 정보");
			
			//객체 붙이기
			file.add(fopen); file.add(fsave); file.addSeparator(); file.add(fexit);			
			gr.add(sno); gr.add(sname); gr.add(schul); gr.add(sjob);			
			sort.add(sno); sort.add(sname); sort.add(schul); sort.add(sjob); 
			help.add(proinfo);
			
			bar.add(file); bar.add(sort); bar.add(help);
			
			//'파일' 메뉴 이벤트 연결
			fopen.addActionListener(this);  //'열기'
			fsave.addActionListener(this);  //'저장'
			fexit.addActionListener(this);  //'닫기'
			
			//'정렬' 메뉴 이벤트 연결
			sno.addItemListener(this);  //'번호' 정렬
			sname.addItemListener(this);  //'이름' 정렬
			schul.addItemListener(this);  //'출생지역' 정렬
			sjob.addItemListener(this);  //'직업' 정렬			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("열기"))	open();
			else if(e.getActionCommand().equals("저장"))	save();
			else if(e.getActionCommand().equals("닫기"))	exit();
		}
		//'파일' 열기 기능 메소드 구현
		public void open() {
			StringTokenizer st;
			Vector v;
			
			readOpen = new FileDialog(ManageSystem.this, "문서열기", FileDialog.LOAD);
			readOpen.setVisible(true);
			
			fileDir = readOpen.getDirectory();
			fileName = readOpen.getFile();
			readfileName = fileDir + "//" + fileName;
			
			try {
				BufferedReader read = new BufferedReader(new FileReader(readfileName));
				String line = null;
				
				while((line = read.readLine()) != null) {
					//메모장에 이렇게 저장되어 있음 => 1, 홍길동, 010-2415-1234, . . ., 프로그래머
					st = new StringTokenizer(line, ", ");
					v = new Vector();
					
					while(st.hasMoreTokens()) {
						v.add(st.nextToken());
					}
					showTable.data.addElement(v);
				}
				showTable.datamodel.fireTableDataChanged();
				read.close();  //자원 해제
			}catch(Exception e) {
				System.out.println(e);
			}			
		}
		
		//'파일' 저장 기능 메소드 구현
		public void save() {
			saveOpen = new FileDialog(ManageSystem.this, "문서저장", FileDialog.SAVE);
			saveOpen.setVisible(true);
			
			fileDir = saveOpen.getDirectory();
			fileName = saveOpen.getFile();
			savefileName = fileDir + "//" + fileName;
			
			String str = "";
			String temp = "";
			
			try {
				BufferedWriter save = new BufferedWriter(new FileWriter(savefileName));
				
				for(int i=0; i<showTable.table.getRowCount(); i++) {
					temp = showTable.data.elementAt(i).toString();
					//vector 객체에 저장 형태를 보면 [1, 홍길동, 010-2415-1234, . . ., 프로그래머]
					str += temp.substring(1, temp.length()-1) + "\n";
				}
				save.write(str);
				save.close();   //자원 해제
			}catch(Exception ex) {
				System.out.println(ex);
			}			
		}
		
		//'닫기' 기능 메소드 구현
		public void exit() {
			System.exit(0);	 //프로그램 정상 종료 시켜라!!			
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource().equals(sno))	numSort();  //'번호' 정렬  사용자 정의 메소드 호출
			else if(e.getSource().equals(sname))  stringSort(1);  //'이름' 정렬  사용자 정의 메소드 호출
			else if(e.getSource().equals(schul))  stringSort(7);  //'출생지역' 정렬  사용자 정의 메소드 호출
			else if(e.getSource().equals(sjob))  stringSort(9);  //'직업' 정렬  사용자 정의 메소드 호출
		}	
		//'번호' 정렬  사용자 정의 메소드 구현
		public void numSort() {
			/*
			 * '번호' 정렬 시나리오
			 * 1. 2차원 배열을 생성해놓고
			 * 2. Jtable에 있는 데이터들을 2차원 배열로 옮긴다.
			 * 3. 2차원 배열 정렬시킨다. => 선택 정렬 알고리즘 적용하여 해결한다.
			 * 4. 정렬시킨 2차원의 결과를 Jable에 옮기자
			 */
			int row = showTable.table.getRowCount();	 //행의 개수 얻어옴
			int col = showTable.table.getColumnCount();  //열의 개수 얻어옴
			
			String temp;
			String[][] arr = new String[row][col];
			
			//Jtable에 있는 데이터들을 2차원 배열로 옮긴다.
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					arr[i][j] = (String)showTable.table.getValueAt(i, j);
				}
			}
			//선택 정렬 알고리즘을 적용하여 2차원 배열 정렬시킨다.
			for(int i=0; i<row-1; i++) {
				for(int j=i+1; j<row; j++) {
					if(Integer.parseInt(arr[i][0]) > Integer.parseInt(arr[j][0])) {
						for(int k=0; k<col; k++) {
							temp = arr[i][k];
							arr[i][k] = arr[j][k];
							arr[j][k] = temp;
						}
					}
				}
			}
			//정렬시킨 2차원의 결과를 Jable에 옮기자
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					showTable.table.setValueAt(arr[i][j], i, j);
				}
			}			
		}
		//하나의 사용자 정의 메소드로 '이름', '출생지역', '직업' 정렬 기능을 구현
		public void stringSort(int sortType) {
			int row = showTable.table.getRowCount();	 //행의 개수 얻어옴
			int col = showTable.table.getColumnCount();  //열의 개수 얻어옴
			
			String temp;
			String[][] arr = new String[row][col];
			
			//Jtable에 있는 데이터들을 2차원 배열로 옮긴다.
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					arr[i][j] = (String)showTable.table.getValueAt(i, j);
				}
			}
			//선택 정렬 알고리즘을 적용하여 2차원 배열 정렬시킨다.
			for(int i=0; i<row-1; i++) {
				for(int j=i+1; j<row; j++) {
					if(arr[i][sortType].compareTo(arr[j][sortType]) > 0) {
						for(int k=0; k<col; k++) {
							temp = arr[i][k];
							arr[i][k] = arr[j][k];
							arr[j][k] = temp;
						}
					}
				}
			}
			//정렬시킨 2차원의 결과를 Jable에 옮기자
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					showTable.table.setValueAt(arr[i][j], i, j);
				}
			}			
		}
	} //end MenuMain 클래스
	
	//데이터를 입력받는 West쪽 내부 클래스 구현
	class West extends JPanel {
		//내부 클래스 객체 생성
		Input input = new Input();
		Output output =  new Output();		
		
		//생성자
		public West() {
			setLayout(new BorderLayout());
			add(input, BorderLayout.CENTER);
			add(output, BorderLayout.SOUTH);
		}
		//데이터 입력 받는 Input 내부 클래스 구현
		class Input extends JPanel {
			JTextField[] tf = new JTextField[5];
			String[] text = {"번호","이름","핸드폰번호","이메일","주민등록번호"};
			String[] jobText = {"선택","회사원","공무원","프로그래머","의사",
					            "변호사","학생","기타"};
			JLabel la, job;
			JComboBox box;
			
			//생성자
			public Input() {
				setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2),"입력"));
				setLayout(new GridLayout(6,2,5,30));
				
				for(int i=0; i<text.length; i++) {
					la = new JLabel(text[i]);
					tf[i] = new JTextField(10);
					la.setHorizontalAlignment(JLabel.CENTER);
					add(la); 
					add(tf[i]);
				}
				
				box = new JComboBox(jobText);
				job = new JLabel("직업");
				job.setHorizontalAlignment(JLabel.CENTER);
				add(job); 
				add(box);
				setPreferredSize(new Dimension(340, 300));
			}
		}
		//입력받은 주민번호로부터 정보 추출(나이, 성별, 출생지역, 생일)을 보여줄 내부 클래스 구현
		class Output extends JPanel implements ActionListener {
			
			JPanel info = new JPanel();    //'신상정보' 보더 만들기 JPanel
			JPanel search = new JPanel();  //'정보검색' 보더 만들기 JPanel
			
			CardLayout card = new CardLayout();
			String[] text = {"   나이:", "   성별:", "  출생지역:", "  생일:"};
			JLabel[] label = new JLabel[4];
			ButtonGroup group = new ButtonGroup();
			JRadioButton[] searchRadio = new JRadioButton[4];
			JButton searchButton;
			JButton exitButton;
			JTextField nameText;
			String[] search_name = {"이름","직업","출생지역","생일"};
			int searchType;  //전역변수
			
			//생성자 
			public Output() {
				//'신상정보' 보더 만들기
				info.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2),"신상정보"));
				info.setLayout(new GridLayout(4, 1));
				
				for(int i=0; i<text.length; i++) {
					label[i] = new JLabel(text[i], JLabel.LEFT);
					info.add(label[i]);					
				}
				
				//'정보검색' 보더 만들기
				search.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2),"정보검색"));
				nameText = new JTextField(10);
				searchButton = new JButton("찾기");
				exitButton = new JButton("나가기");
				
				searchButton.setBackground(Color.CYAN);
				exitButton.setBackground(Color.LIGHT_GRAY);	
				
				//이벤트 연결
				searchButton.addActionListener(this);
				exitButton.addActionListener(this);
				
				setPreferredSize(new Dimension(340, 300));
				
				int x = -70;
				search.setLayout(null); //사용자 정의 배치 방법 
				
				for(int i=0; i<searchRadio.length; i++) {
					searchRadio[i] = new JRadioButton(search_name[i]);
					searchRadio[i].setBounds(x+=80, 60, 80, 30);
					
					group.add(searchRadio[i]);
					search.add(searchRadio[i]);
					//이벤트 연결
					searchRadio[i].addActionListener(this);
				}
				nameText.setBounds(40, 110, 200, 30);
				searchButton.setBounds(35, 170, 80, 30);
				exitButton.setBounds(140, 170, 110, 30);
				search.add(nameText);
				search.add(searchButton);
				search.add(exitButton);
				
				card = new CardLayout();
				setLayout(card);
				
				add(info,"신상정보 카드");
				add(search,"정보검색 카드");
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				//[중요] searchType 값을 search() 메소드에게 전달하여 하나의 메소드로 
				//네 가지 검색 기능을 해결하자!!
				if(e.getActionCommand().equals("이름"))			searchType = 1;
				else if(e.getActionCommand().equals("직업"))		searchType = 9;
				else if(e.getActionCommand().equals("출생지역"))	searchType = 7;
				else if(e.getActionCommand().equals("생일"))		searchType = 8;
				else if(e.getActionCommand().equals("찾기"))		search(); //사용자 정의 메소드 호출
				else if(e.getActionCommand().equals("나가기"))	goOut();  //사용자 정의 메소드 호출
			}
			//'찾기' 버튼 클릭 시 처리할 메소드 구현
			public void search() {
				Vector v = new Vector();
				
				//순차 검색(Sequenal search) 알고리즘 적용
				for(int i=0; i<showTable.data.size(); i++) {
					//[아주 중요] 테크닉 
					if(nameText.getText().equals(showTable.data.elementAt(i).get(searchType))) {
						v.addElement(showTable.data.elementAt(i));
					}
				}
				showTable.datamodel.setDataVector(v, showTable.column_name);
				showTable.TableSize();  //셀 크기 조절 메소드 호출
				nameText.setText(null);
			}
			//'나가기' 버튼 클릭 시 처리할 메소드 구현 => 다시 Jtable에 전체 데이터를 보여주기
			public void goOut() {
				west.output.card.show(west.output,  "신상정보 카드");
				
				buttons.addBtn.setEnabled(true);  //'추가' 버튼 활성화
				//buttons.nextBtn.setEnabled(true);  //'다음' 버튼 활성화
				
				west.input.tf[0].setText(null);
				west.input.tf[1].setText(null);
				west.input.tf[2].setText(null);
				west.input.tf[3].setText(null);
				west.input.tf[4].setText(null);
				west.input.box.setSelectedIndex(0);  //선택으로 초기화 시켜라					
				west.input.tf[0].requestFocus();
				
				west.output.label[0].setText("   나 이 :");
				west.output.label[1].setText("   성 별 :");
				west.output.label[2].setText("   출생지역 :");
				west.output.label[3].setText("   생 일 :");
					
				showTable.datamodel.setDataVector(showTable.data, showTable.column_name);
				showTable.TableSize();  //셀 크기 조절 메소드 호출
			}
		}		
	} //end West 클래스
	
	//버튼 컴퍼넌트들 만들기 내부 클래스
	class Buttons extends JPanel implements ActionListener {
		//객체 참조변수 선언
		Vector<String> vector;
		JButton addBtn, preBtn, nextBtn, updateBtn, delBtn, searchBtn;
		
		int age;
		String jumniNum, sung, chul;		
		
		//생성자
		public Buttons() {
			setLayout(new GridLayout(1, 6));
			
			addBtn = new JButton("추가");
			preBtn = new JButton("이전");
			nextBtn = new JButton("다음");
			updateBtn = new JButton("수정");
			delBtn = new JButton("삭제");
			searchBtn = new JButton("검색");
			
			addBtn.setBackground(Color.YELLOW);
			delBtn.setBackground(Color.LIGHT_GRAY);
			updateBtn.setBackground(Color.PINK);
			searchBtn.setBackground(Color.GREEN);
			
			//버튼 객체들 JPanel에 붙이기 
			add(addBtn); add(preBtn); add(nextBtn); 
			add(updateBtn); add(delBtn); add(searchBtn);
			
			//버튼들의 이벤트 연결
			addBtn.addActionListener(this);
			preBtn.addActionListener(this);
			nextBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			delBtn.addActionListener(this);
			searchBtn.addActionListener(this);
		}

		@Override  //자식 클레스에 맞게 재정의해라!!
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("추가"))  addData();  //사용자 정의 메소드 호출
			if(e.getActionCommand().equals("수정"))  updateData();  //사용자 정의 메소드 호출
			if(e.getActionCommand().equals("삭제"))  deleteData();  //사용자 정의 메소드 호출
			if(e.getActionCommand().equals("검색"))  searchData();  //사용자 정의 메소드 호출
		}
		
		//[중요] '검색' 버튼에서 ActionEvent가 발생했을 때 처리하는 메소드 구현
		public void searchData() {
			//west.output.card.next(west.output);  //[1방법]
			
			west.output.card.show(west.output, "정보검색 카드");  //[2방법]
		}
		
		//'수정' 버튼에서 ActionEvent가 발생했을 때 처리하는 메소드 구현
		public void deleteData() {
			int yes_no_selcet = JOptionPane.showConfirmDialog(null, 
					                                          "정말 삭제하겠습니까?", 
					                                          "삭제 확인 창", 
					                                          JOptionPane.YES_NO_OPTION);
			if(yes_no_selcet == JOptionPane.YES_OPTION) {
				addBtn.setEnabled(true);
				
				JTable tb = showTable.table;
				int deleteRow = tb.getSelectedRow();
				
				if(deleteRow == -1) {   //사용자가 어느 행을 선택하지 않고 "삭제" 버튼을 누른 경우
					return;   //현재 상태 그대로 유지해라!!
				}else {
					DefaultTableModel model = (DefaultTableModel)tb.getModel();
					model.removeRow(deleteRow);
					
					west.input.tf[0].setText(null);
					west.input.tf[1].setText(null);
					west.input.tf[2].setText(null);
					west.input.tf[3].setText(null);
					west.input.tf[4].setText(null);
					west.input.box.setSelectedIndex(0);  //선택으로 초기화 시켜라					
					
					west.output.label[0].setText("   나 이 :" + "");
					west.output.label[1].setText("   성 별 :" + "");
					west.output.label[2].setText("   출생지역 :" + "");
					west.output.label[3].setText("   생 일 :" + "");
					west.input.tf[0].requestFocus();					
				}
			}else {
				return;
			}
		}		
		
		//'수정' 버튼에서 ActionEvent가 발생했을 때 처리하는 메소드 구현
		public void updateData() {			
			int updateRow = showTable.table.getSelectedRow();
			
			//'핸드폰번호' 수정 시
			showTable.table.setValueAt(west.input.tf[2].getText(), updateRow, 2);
			
			//'이메일'  수정 시
			showTable.table.setValueAt(west.input.tf[3].getText(), updateRow, 3);
			
			//'직업'  수정 시
			showTable.table.setValueAt(west.input.box.getSelectedItem().toString(),updateRow,9);
			
			west.input.tf[0].setText(null);
			west.input.tf[1].setText(null);
			west.input.tf[2].setText(null);
			west.input.tf[3].setText(null);
			west.input.tf[4].setText(null);
			west.input.box.setSelectedIndex(0);  //선택으로 초기화 시켜라
			
			//데이터 "수정" 후 다음 데이터를 입력 받기 위해서 주민번호 입력란 다시 활성화 시키자!!
			west.input.tf[4].setEditable(true);			
			west.input.tf[0].requestFocus();  //번호 입력란에 포커스를 넣어라!!
			
			west.output.label[0].setText("   나 이 :" + "");
			west.output.label[1].setText("   성 별 :" + "");
			west.output.label[2].setText("   출생지역 :" + "");
			west.output.label[3].setText("   생 일 :" + "");
			return;
		}
		
		public void addData() {
			nextBtn.setEnabled(true);  //'다음' 버튼 활성화
			
			vector = new Vector<String>();
			vector.add(west.input.tf[0].getText());	//번호
			vector.add(west.input.tf[1].getText());	//이름
			vector.add(west.input.tf[2].getText());	//핸드폰번호
			vector.add(west.input.tf[3].getText()); //이메일
			
			//[중요] 사용자가 입력한 주민번호는 바로 Vector 객체에 저장하지 않고
			//먼저 주민번호가 정상인지 아닌지 체크한 후에 정상일 때만 Vector 객체에 추가하자!!
			jumniNum = west.input.tf[4].getText();
			
			//jumniNum가 가리키는 주민번호를 체크 공식 적용하여 체크하자!!
			int[] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5};   //가중치 배열 준비
			int sum = 0;
			int temp, result;
			
			//'주민번호' 정규 표현식(regex) 적용  => 유효성 체크
			String regex = "[0-9]{6}-[1234][0-9]{6}";
			boolean check = jumniNum.matches(regex);
			
			if(check == false) {
				JOptionPane.showMessageDialog(null, 
						"주민번호가 형식에 맞지 않음"+"\n"+"주민번호를 다시 입력하세요.", 
						"에러메시지", JOptionPane.ERROR_MESSAGE);
				
				//사용자를 위한 배려
				west.input.tf[4].setText(null);
				west.input.tf[4].requestFocus();
				return;   //그 상태로 그대로 있어라!!
			}else {   //형식에 맞으면
				//주민번호 공식 적용!!
				//[1단계 공식]
				for(int i=0; i<jumniNum.length()-1; i++) {
					if(jumniNum.charAt(i) == '-') continue;
						sum += (jumniNum.charAt(i)-48) * weight[i];
				}
				//[2단계, 3단계 공식 적용]
				temp = 11 - (sum%11);
				result = temp%10;
				
				if(result == jumniNum.charAt(13)-48) {
					JOptionPane.showMessageDialog(null, 
							"주민번호 체크 결과 정상입니다." + "\n" +"'확인' 버튼을 누르면 정보가 출력됨!!");
					
					vector.add(jumniNum); //주민번호가 정상이기 때문에 Vector 객체에 추가시킨다.
					
					//정상인 주민번호로부터 정보 추출하기
					//나이 추출
					Calendar cal = Calendar.getInstance(Locale.KOREA);
					int year = cal.get(Calendar.YEAR);   //2022
					
					//주민번호 앞 두 자리 얻어오기
					int yy = Integer.parseInt(jumniNum.substring(0, 2)); 
					if(jumniNum.charAt(7)-48 <3) {
						yy = yy + 1900;						
					}else {
						yy = yy + 2000;
					}
					age = year -yy + 1; //본나이
					
					//성별 추출하기
					if((jumniNum.charAt(7)-48)%2 == 0) {
						sung = "여자";						
					}else {
						sung = "남자";	
					}
					//"출생지역" 추출하기
					//2차원 배열로 초기화
					String[][] localeCode = {{"서울","00","08"},{"부산","09","12"},
							                 {"인천","13","15"},{"경기","16","25"},
							                 {"강원","26","34"},{"충북","35","39"},
							                 {"대전","40","40"},{"충남","41","43"},
							                 {"충남","45","57"},{"세종","44","44"},
							                 {"세종","96","96"},{"전북","48","54"},
							                 {"전남","55","64"},{"광주","65","66"}	,
							                 {"대구","67","70"},{"경북","71","80"},
							                 {"경남","81","84"},{"경남","86","90"},
							                 {"울산","85","85"},{"제주","91","95"}};
					
					String localeStr = jumniNum.substring(8, 10);
					int locale = Integer.parseInt(localeStr);
					String birthplace = null;
					
					for(int j=0; j<=19; j++) {
						if(locale >= Integer.parseInt(localeCode[j][1]) &&
								locale <= Integer.parseInt(localeCode[j][2])) {
							birthplace = localeCode[j][0];
						}
					}
					vector.add(String.valueOf(age));  //정수값을 문자열로 변환하여 리턴
					vector.add(sung);
					vector.add(birthplace);
					vector.add(jumniNum.substring(2, 4)+"월"+jumniNum.substring(4, 6)+"일");	
					showTable.TableSize();  //셀 크기 조절 메소드 호출
				}else {
					JOptionPane.showMessageDialog(null, 
							"주민번호가 틀림.", 
							"에러메시지", JOptionPane.ERROR_MESSAGE);
					
					//사용자를 위한 배려
					west.input.tf[4].setText(null);
					west.input.tf[4].requestFocus();
					return;   //그 상태로 그대로 있어라!!
				}
			} //end if문
			
			//사용자가 선택한 직업 얻어내기
			//getSelectedItem() 메소드는 리턴 타입이 Object이기 때문에 
			//toString() 메소드를 호출하여 String 타입으로 변환하여 리턴해야함!!
			vector.add(west.input.box.getSelectedItem().toString());
			
			//사용자에 대한 배려			
			west.input.tf[0].setText(null);
			west.input.tf[1].setText(null);
			west.input.tf[2].setText(null);
			west.input.tf[3].setText(null);
			west.input.tf[4].setText(null);
			west.input.box.setSelectedIndex(0);  //선택으로 초기화 시켜라
			west.input.tf[0].requestFocus();  //번호 입력란에 포커스를 넣어라!!
			
			showTable.data.addElement(vector);
			showTable.datamodel.fireTableDataChanged();	//변화를 통보해준다.		
		}		
	} //end Buttons 클래스
	
	//JTable에 입력한 데이터를 보여주는 내부 클래스
	class ShowTable extends MouseAdapter{		
		DefaultTableModel datamodel;
		JTable table;
		JScrollPane scrollPane;
		
		String[] colName = {"번호","이름","핸드폰번호","E-Mail","주민번호",
				            "나이","성별","출생지역","생일","직업"};
		
		Vector<Vector<String>> data;    //[아주 중요]
		Vector<String> column_name;
		
		int row = -1;	//전역 변수 선언
		
		//생성자
		public ShowTable() {
			data = new Vector<Vector<String>>();
			column_name = new Vector<String>();
			
			for(int i=0; i<colName.length; i++) {
				column_name.add(colName[i]);
			}
			//[1단계] DefaultTableModel 객체 생성
			//DefaultTableModel(Vector data, Vector columnNames) 생성자 적용
			datamodel = new DefaultTableModel(data, column_name) {
				public boolean isCellEditable(int row, int column) {
					return false;    //Cell 에서 수정을 방지할려면 false로 준다.
				};
			};
			//[2단계] JTable 객체 생성			
			table = new JTable(datamodel);
			
			//[3단계] JScrollPane 객체 생성
			scrollPane = new JScrollPane(table);
			
			//이벤트 연결   => addXxxListener() 메소드
			table.addMouseListener(this);			
		}

		@Override   //수동으로 오버라이드 시킨다.
		public void mouseClicked(MouseEvent e) {
			row = table.getSelectedRow();
			Info();  //사용자 정의 메소드 호출
		}
		public void Info() {
			int row = this.row;
			
			west.input.tf[0].setText((String)showTable.table.getValueAt(row, 0));
			west.input.tf[1].setText((String)showTable.table.getValueAt(row, 1));
			west.input.tf[2].setText((String)showTable.table.getValueAt(row, 2));
			west.input.tf[3].setText((String)showTable.table.getValueAt(row, 3));
			west.input.tf[4].setText((String)showTable.table.getValueAt(row, 4));
			
			//[중요] 주민번호를 수정 못하게 비활성화 시키자!!
			west.input.tf[4].setEditable(false);
			
			//직업을 west.input 객체에 보여주기
			west.input.box.setSelectedItem(showTable.table.getValueAt(row, 9)); //직업
			
			west.output.label[0].setText("    나이  :"+"   "+showTable.table.getValueAt(row, 5));  
			west.output.label[1].setText("    성별  :"+"   "+showTable.table.getValueAt(row, 6));
			west.output.label[2].setText("    출신지역  :"+"   "+showTable.table.getValueAt(row, 7));
			west.output.label[3].setText("    생일  :"+"   "+showTable.table.getValueAt(row, 8));  
			
			showTable.table.changeSelection(row, 0, false, false);
		} //end Info()
		
		//Jtable의 셀의 크기 조절하기
		public void TableSize() {
			table.getColumnModel().getColumn(0).setPreferredWidth(50);  //번호 셀 넓이
			table.getColumnModel().getColumn(1).setPreferredWidth(50);  //이름 셀 넓이
			table.getColumnModel().getColumn(2).setPreferredWidth(120);  //핸드폰번호 셀 넓이
			table.getColumnModel().getColumn(3).setPreferredWidth(150);  //이메일 셀 넓이
			table.getColumnModel().getColumn(4).setPreferredWidth(130);  //주민번호 셀 넓이
			table.getColumnModel().getColumn(5).setPreferredWidth(50);  //나이 셀 넓이
			table.getColumnModel().getColumn(6).setPreferredWidth(50);  //성별 셀 넓이
			table.getColumnModel().getColumn(7).setPreferredWidth(80);  //출생지역 셀 넓이
			table.getColumnModel().getColumn(8).setPreferredWidth(70);  //생일 셀 넓이
			table.getColumnModel().getColumn(9).setPreferredWidth(50);  //직업 셀 넓이
		}
	}
	

	public static void main(String[] args) {
		//객체 생성
		ManageSystem manageSystem = new ManageSystem();
	}
}





