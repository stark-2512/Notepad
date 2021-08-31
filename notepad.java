import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class notepad implements ActionListener
{
int sty=0;
int siz=10;
String str;
String sav="";
Frame f,f1;
MenuBar mb;
Menu fi,ed,fo,font,co,st,si;
MenuItem n,o,s,ex,cut,copy,paste,bo,it,pl,t10,t20,t30,backc,fontc;
Button bsa,bds,bca;
Label lab;
TextArea ta;
notepad()
{
f1=new Frame("Save the File");
bsa=new Button("Save");
bds=new Button("Don't Save");
bca=new Button("Cancel");
lab=new Label("Do you want to Save the File");
f=new Frame("*Untitled");
ta=new TextArea();
mb=new MenuBar();
fi=new Menu("File");
ed=new Menu("Edit");
fo=new Menu("Format");
font=new Menu("Menu");
co=new Menu("Color");
st=new Menu("Style");
si=new Menu("Size");
n=new MenuItem("New");
o=new MenuItem("Open");
s=new MenuItem("Save");
ex=new MenuItem("Exit");
cut=new MenuItem("Cut");
copy=new MenuItem("Copy");
paste=new MenuItem("Paste");
bo=new MenuItem("Bold");
it=new MenuItem("Italic");
pl=new MenuItem("Plain");
t10=new MenuItem("10");
t20=new MenuItem("20");
t30=new MenuItem("30");
backc=new MenuItem("Background Color");
fontc=new MenuItem("Font Color");

f1.add(bds);
f1.add(bsa);
f1.add(bca);
f1.add(lab);

co.add(backc);
co.add(fontc);

st.add(bo);
st.add(it);
st.add(pl);

si.add(t10);
si.add(t20);
si.add(t30);

font.add(si);
font.add(st);

fo.add(font);
fo.add(co);

fi.add(n);
fi.add(o);
fi.add(s);
fi.add(ex);

ed.add(copy);
ed.add(paste);
ed.add(cut);

mb.add(fi);
mb.add(ed);
mb.add(fo);

f.setMenuBar(mb);
f.add(ta);
f1.setLayout(null);

lab.setBounds(30,30,200,40);
bsa.setBounds(30,80,50,40);
bds.setBounds(90,80,70,40);
bca.setBounds(170,80,50,40);


bsa.addActionListener(this);
bds.addActionListener(this);
bca.addActionListener(this);
n.addActionListener(this);
o.addActionListener(this);
s.addActionListener(this);
ex.addActionListener(this);
cut.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
bo.addActionListener(this);
it.addActionListener(this);
pl.addActionListener(this);
t10.addActionListener(this);
t20.addActionListener(this);
t30.addActionListener(this);
backc.addActionListener(this);
fontc.addActionListener(this);

f1.setSize(300,150);
f.setSize(1500,1000);
f.setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bsa)
{
JFileChooser jc=new JFileChooser();
jc.showSaveDialog(f);
try
{
String s=ta.getText();
byte b[]=s.getBytes();
FileOutputStream f0=new FileOutputStream(jc.getSelectedFile());
f0.write(b);
f0.close();
f1.setVisible(false);
f.setTitle(jc.getSelectedFile().getName());
f.setTitle("*Untitled");
ta.setText("");
sav=ta.getText();
}
catch(IOException a)
{
System.out.print(a);
}
}

else if(e.getSource()==bds)
{
f.setTitle("*Untitled");
ta.setText("");
f1.setVisible(false);
}

else if(e.getSource()==bca)
{
f1.setVisible(false);
}

else if(e.getSource()==n)
{
String sav1=new String(ta.getText());
if(sav.equals(sav1))
{
f.setTitle("*Untitled");
ta.setText("");
}

else
{
f1.setVisible(true);
}

}


else if(e.getSource()==o)
{
String sav1=ta.getText();
System.out.print("1="+sav+" and 2="+sav1);
if(sav.equals(sav1))
{
JFileChooser jc=new JFileChooser();
jc.showOpenDialog(f);
try
{
FileInputStream fu=new FileInputStream(jc.getSelectedFile().getName());
int i=0;
String s="";
while((i=fu.read())!=-1)
{
s=s+String.valueOf((char)i);
}
ta.setText(s);
f.setTitle(jc.getSelectedFile().getName());
fu.close();
}catch(IOException a)
{
System.out.print(a);
}
}
else
{
f1.setVisible(true);
}
}

else if(e.getSource()==s)
{
JFileChooser jc=new JFileChooser();
jc.showSaveDialog(f);
try
{
String s=ta.getText();
byte b[]=s.getBytes();
FileOutputStream f0=new FileOutputStream(jc.getSelectedFile());
f0.write(b);
f.setTitle(jc.getSelectedFile().getName());
f0.close();
sav=ta.getText();
}
catch(IOException a)
{
System.out.print(a);
}
}

else if(e.getSource()==ex)
{
String sav1=new String(ta.getText());
if(sav.equals(sav1))
{
System.exit(0);
}
else
{
f1.setVisible(true);
}
}

else if(e.getSource()==cut)
{
str=ta.getSelectedText();
int i=ta.getSelectionStart();
int j=ta.getSelectionEnd();
ta.replaceRange("",i,j);
}

else if(e.getSource()==copy)
{
str=ta.getSelectedText();
}

else if(e.getSource()==paste)
{
ta.insert(str,ta.getSelectionStart());
}

else if(e.getSource()==backc)
{
JColorChooser jc=new JColorChooser();
Color c=jc.showDialog(f,"BackColor",Color.red);
ta.setBackground(c);
}

else if(e.getSource()==fontc)
{
JColorChooser jc=new JColorChooser();
Color c=jc.showDialog(f,"FontColor",Color.green);
ta.setForeground(c);
}
else if(e.getSource()==bo)
{
sty=1;
Font fo=new Font("Arial",sty,siz);
ta.setFont(fo);
}
else if(e.getSource()==it)
{
sty=2;
Font fo=new Font("Arial",sty,siz);
ta.setFont(fo);
}
else if(e.getSource()==pl)
{
sty=0;
Font fo=new Font("Arial",sty,siz);
ta.setFont(fo);
}
else if(e.getSource()==t10)
{
siz=10;
Font fo=new Font("Arial",sty,siz);
ta.setFont(fo);
}
else if(e.getSource()==t20)
{
siz=20;
Font fo=new Font("Arial",sty,siz);
ta.setFont(fo);
}
else if(e.getSource()==t30)
{
siz=30;
Font fo=new Font("Arial",sty,siz);
ta.setFont(fo);
}

}
public static void main(String ar[])
{
notepad n=new notepad();
}
}
