from tkinter import Tk, Menu, Frame, PanedWindow, ttk, messagebox
from tkinter.ttk import LabelFrame, Label,Entry, Button
import tkinter.font as tkFont


import pickle
#pickle 모듈 불러온다
def saveEvtHandler():
    print("파일저장")
    with open("data_list.pickle","wb") as fw:
        pickle.dump(data_list, fw) #dump(객체, 파일객체)

def loadEvtHandler():
    print("파일열기")
    global data_list
    with open("data_list.pickle","rb") as fr:
        data_list = pickle.load(fr)
        refreshTreeview(data_list)
        seq = data_list[len(data_list)-1][0]


win = Tk()
win.title("고객정보관리 시스템")
win.geometry('%dx%d+%d+%d'%(800,600,10,10))
menubar = Menu(win)
filemenu = Menu(menubar, tearoff=0)
menubar.add_cascade(label="File", menu=filemenu)
filemenu.add_command(label="열기",command=loadEvtHandler)#command=loadEvtHandler
filemenu.add_command(label="저장",command=saveEvtHandler)#command=saveEvtHandler
filemenu.add_separator()
filemenu.add_command(label="닫기", command=win.destroy)

helpmenu = Menu(menubar, tearoff=0)
menubar.add_cascade(label="Help", menu = helpmenu )
helpmenu.add_command(label="About...")

win.config(menu=menubar)

topFrame = Frame(win)
topFrame.pack(side="top")
topFrame.config(width=800, height=100)

panedWindow = PanedWindow( relief = "raised",bd=0)
panedWindow.pack(expand=True)

leftFrame = Frame(win)
leftFrame.pack(side="left")
leftFrame.config(width=200, height=400)

rightFrame = Frame(win)
rightFrame.pack(side="right")
rightFrame.config(width=600, height=470)

panedWindow.add(leftFrame)
panedWindow.add(rightFrame)

bottomFrame = Frame(win)
bottomFrame.pack(side = "bottom")
bottomFrame.config(width=800,height=30)

#엔트리 위젯 추가
label_frame = LabelFrame(leftFrame, text = "기본 정보 입력")
label_frame.pack()

lbl_name = Label(label_frame, text = "이름")
lbl_phone = Label(label_frame, text = "전화번호")
lbl_email = Label(label_frame, text = "이메일")

entry_name = Entry(label_frame)
entry_phone = Entry(label_frame)
entry_email = Entry(label_frame)

lbl_name.grid(row=0, column=0)
entry_name.grid(row=0, column=1, padx=5, pady=5)

lbl_phone.grid(row=1, column=0)
entry_phone.grid(row=1, column=1, padx=5, pady=5)

lbl_email.grid(row=2, column=0)
entry_email.grid(row=2, column=1, padx=5, pady=5)

panedWindow = PanedWindow(bottomFrame, relief = "raised",bd=0)
panedWindow.pack()

def deleteTreeData():

    children = tree.get_children()   #get_children() 함수는 표의 하위 항목을 반환한다.

 

    if children != '()':

        for item in children:

            tree.delete(item)

 

def refreshTreeData(data_list):

    #enumerate() 함수는 기본적으로 인덱스와 요소로 이루어진 튜플을 만들어 준다.

    for i, item in enumerate(data_list):

        tree.insert('', 'end', iid='IID%d' %(i), values=item)

        

    entry_name.delete(0, 'end')

    entry_phone.delete(0, 'end')

    entry_email.delete(0, 'end')

 

def refreshTreeview(data_list):

    deleteTreeData()

    refreshTreeData(data_list)

    

seq = 0

def inputEvtHandler():
    print("추가 ...")
    name = entry_name.get()
    phone = entry_phone.get()
    email = entry_email.get()

    if name=="" or phone=="" or email=="":
        messagebox.showinfo('알림', '이름, 전화번호, 이메일을 모두 입력 하세요!!')
        return
    #[중요] 함수 안에서 전역변수의 값을 변경하려면 반드시 global로 선언해야 한다.
    global seq
    seq += 1
    #[주의] append() 함수 안의 인자 개수는 반드시 하나 여야 한다. 그래서 괄호로 묶어주자!!
    data_list.append((seq, name, phone, email))
    refreshTreeview(data_list)
    ##inputEvtHandler() END

def modifyEvtHandler():
    print("수정 ...")
    sname = entry_name.get()
    phone = entry_phone.get()
    email = entry_email.get()

    if sname == "" or phone == "" or email == "":
        messagebox.showinfo('알림', '이름, 전화번호, 이메일을 모두 입력 하세요!!')
        return
    idx = -1
    for i, data in enumerate(data_list):
        try:
            if data.index(sname) != -1:
                data_list[i] = (data[0], sname, phone, email)
                refreshTreeview(data_list)
                idx = i
            return    
        except:
            pass

    if idx == -1:

        messagebox.showinfo('경고', '찾는 정보가 없습니다.') 


    

btn_output = Button(panedWindow, text = "전체보기")
btn_input = Button(panedWindow, text = "추가", command = inputEvtHandler)
btn_search = Button(panedWindow, text = "이름 검색")
btn_modify = Button(panedWindow, text = "수정", command = modifyEvtHandler)
btn_delete = Button(panedWindow, text = "삭제")

panedWindow.add(btn_output)
panedWindow.add(btn_input)
panedWindow.add(btn_search)
panedWindow.add(btn_modify)
panedWindow.add(btn_delete)
   

#rightframe 목록추가
header_list = ['no','name','phone number','e-mail']
data_list = []

#Treeview는 그리드표를 출력하는데 유용한 위쳇이다.
tree = ttk.Treeview(rightFrame, columns=header_list, show="headings")
tree.pack()

for i, col in enumerate(header_list):
    tree.heading(col, text=col.title())

for i, item in enumerate(data_list):
    tree.insert("","end",iid="IID%d" %(i), values=item)
    
    
#Treeview 각 필드 너비 설정
tree.column(0, width=50)
tree.column(1, width=80)
tree.column(2, width=150)
tree.column(3, width=250)

#Treeview의 높이 설정

tree.config(height=22)

def click_item(event):
    selectedItem = tree.focus()
    getValue = tree.item(selectedItem).get('values')

    if len(entry_name.get()) > 0 : entry_name.delete(0, 'end')
    if len(entry_phone.get()) > 0 : entry_phone.delete(0, 'end')
    if len(entry_email.get()) > 0 : entry_email.delete(0, 'end')

    entry_name.insert(0, getValue[1])
    entry_phone.insert(0, getValue[2])
    entry_email.insert(0, getValue[3])

    tree.bind('<ButtonRelease-1>', click_item)



#앱 타이틀 라벨 추가
fontStyle = tkFont.Font(family = "궁서체",size = 28)
lbl_title = Label(topFrame, text = "고객정보관리시스템", font = fontStyle)
lbl_title.place(relx=0.5, rely=0.5, anchor='center')
 
if __name__ == '__main__': #메인함수 선언, 시작을 의미함. 
#생성한 윈도우 내부에서 수행되는 마우스 클릭 같은 이벤트들이 발생하게끔 유지해주는 함수다.

 win.mainloop()
