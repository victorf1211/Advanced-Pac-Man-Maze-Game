import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JPanel;

public class JF implements KeyListener{
    Skill ghost = new Skill("Ghost", 5);
    Skill flash = new Skill("Flash", 5);
    Skill[] shop = {flash};
    Skill[] inventory = {ghost};
    character Victor = new character("Victor", 100, 1, 10, ghost);

    Timer timer = new Timer();

    int[] chararr = new int[4];
    int[] enemyarr = new int[4];
    boolean backtf = false;
    boolean up;
    boolean down;
    boolean left;
    boolean right;
    boolean shoptf = true;
    boolean shoptf1 = false;
    String sh = "";
    boolean flashtf = false;
    boolean maptf = false;
    boolean map1tf = false;
    boolean mtf = false;
    int position = 0;
    int x = 700;
    int y = 450;
    int ex = 400;
    int ey = 400;
    int numx = 0;
    int numy = 0;
    int xi=0;
    int yi=0;
    int xn = 0;
    int yn = 0;
    int yi2=0;
    int upperx=0;
    int upperx1=0;
    int rupperx=0;
    int lowerx=0;
    int lowerx1=0;
    int rlowerx=0;
    int uppery=0;
    int uppery1=0;
    int ruppery=0;
    int lowery=0;
    int lowery1=0;
    int rlowery=0;
    int indexx=0;
    int indexy=0;
    int dot=0;
    JFrame f = new JFrame("Game");
    JPanel panel = new JPanel();
    JPanel enemy = new JPanel();
    JPanel shoppanel = new JPanel();
    JPanel leaveshop = new JPanel();
    JPanel mappanel = new JPanel();
    JPanel winpanel = new JPanel();
    JPanel losepanel = new JPanel();
    JLabel lb = new JLabel(x + ", " + y);
    JLabel speedlb = new JLabel("Speed: " + Victor.getspeed());
    JLabel cdlb = new JLabel("cd: " + Victor.getSkill().getcd());
    JLabel pointlb = new JLabel("Point: " + Victor.getpoint());
    JLabel skilllb = new JLabel("Skill: " + Victor.getSkill().getSkill());
    JLabel shoplb = new JLabel("SHOP");
    JLabel dotlb = new JLabel("Dot: " + dot);
    JLabel winlb = new JLabel("You Win");
    JLabel loselb = new JLabel("You lose");
    JButton b = new JButton("Skill");
    JPanel flashp = new JPanel();
    JPanel ghostp = new JPanel();
    JPanel level1 = new JPanel();
    JButton buyb1 = new JButton("Buy");
    JButton changeb1 = new JButton("Change");
    JButton buyb2 = new JButton("Buy");
    JButton changeb2 = new JButton("Change");
    JButton quitb = new JButton("Quit");
    JButton backb = new JButton("Play again");

    JPanel power = new JPanel();
    JLabel power1 = new JLabel("power");

    //JPanel [] map1 = new JPanel[450];
    JPanel [][] map1 = new JPanel[17][29];
    int [][] map1n={{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,1},
                    {1,0,1,1,0,1,1,1,0,1,0,0,1,0,1,0,0,1,0,1,1,1,1,0,1,1,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,0,0,1,1,0,1},
                    {1,1,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,0,1,0,0,0,0,0,1},
                    {1,1,1,1,0,1,1,1,1,0,0,1,1,0,1,1,0,0,1,1,1,0,0,0,1,1,1,0,1},
                    {1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,1,1,1,0,1,1,0,1,1,1,0,1},
                    {1,0,0,0,1,0,1,1,0,1,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,1,0,1,0,1,1,0,1,1,0,1,1,1,0,1,0,0,0,1,0,1,1},
                    {1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1},
                    {1,0,1,0,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,0,1,1,0,0,1},
                    {1,0,1,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0,1,0,1},
                    {1,0,1,1,1,1,0,1,1,1,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,1,0,1},
                    {1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    void graphic()
    {
        panel.setBounds(750,500,15,15);
        panel.setBackground(Color.blue);
        enemy.setBounds(400,400,15,15);
        enemy.setBackground(Color.red);
        shoppanel.setBounds(1200,0,300,150);
        shoppanel.setBackground(Color.black);
        mappanel.setBounds(0,710,300,150);
        mappanel.setBackground(Color.black);
        leaveshop.setBounds(700,840,100,20);
        leaveshop.setBackground(Color.black);
        power.setBounds(860,660,100,50);
        power.setBackground(Color.blue);
        flashp.setBounds(250,500,50,100);
        flashp.setBackground(Color.gray);
        ghostp.setBounds(250,250,50,100);
        ghostp.setBackground(Color.gray);
        level1.setBounds(0,600,50,100);
        level1.setBackground(Color.gray);
        winpanel.setBounds(0,0,1500,900);
        winpanel.setBackground(Color.gray);
        losepanel.setBounds(0,0,1500,900);
        losepanel.setBackground(Color.gray);
        //power1.setBounds(860,660,100,50);
        //shoplb.setBounds();
        lb.setBounds(5,5,100,20);
        speedlb.setBounds(5,25,100,20);
        cdlb.setBounds(5,45,100,20);
        pointlb.setBounds(5,65,100,20);
        skilllb.setBounds(5,85,100,20);
        dotlb.setBounds(5,105,100,20);
        winlb.setBounds(630,200,300,150);
        winlb.setFont(new Font("Verdana", Font.PLAIN, 50));
        loselb.setBounds(630,200,300,150);
        loselb.setFont(new Font("Verdana", Font.PLAIN, 50));
        b.setBounds(1300,780,100,50);
        buyb1.setBounds(1190,780,100,50);
        changeb1.setBounds(1080,780,100,50);
        buyb2.setBounds(1190,780,100,50);
        changeb2.setBounds(1080,780,100,50);
        quitb.setBounds(680,350,100,50);
        backb.setBounds(680,450,100,50);
        //b.setFocusPainted(false);
        b.setFocusable(false);
        buyb1.setFocusable(false);
        changeb1.setFocusable(false);
        buyb2.setFocusable(false);
        changeb2.setFocusable(false);
        quitb.setFocusable(false);
        backb.setFocusable(false);
        leaveshop.setVisible(false);
        flashp.setVisible(false);
        ghostp.setVisible(false);
        buyb1.setVisible(false);
        changeb1.setVisible(false);
        buyb2.setVisible(false);
        changeb2.setVisible(false);
        level1.setVisible(false);
        winpanel.setVisible(false);
        quitb.setVisible(false);
        winlb.setVisible(false);
        losepanel.setVisible(false);
        backb.setVisible(false);
        loselb.setVisible(false);
        enemy.setVisible(false);

        f.add(lb);
        f.add(speedlb);
        f.add(cdlb);
        f.add(pointlb);
        f.add(skilllb);
        f.add(dotlb);
        f.add(winlb);
        f.add(loselb);
        f.add(b);
        f.add(buyb1);
        f.add(changeb1);
        f.add(buyb2);
        f.add(changeb2);
        f.add(quitb);
        f.add(backb);
        f.add(panel);
        f.add(enemy);
        f.add(shoppanel);
        f.add(mappanel);
        f.add(leaveshop);
        f.add(flashp);
        f.add(ghostp);
        f.add(level1);
        f.add(winpanel);
        f.add(losepanel);
        //f.add(power);
        //power.add(power1);
        f.setSize(1500, 1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(this);
        //System.out.println(panel.getX());
        
    }
    void move()
    {
            Thread th=new Thread(){
                    @Override
                    public void run() {
                        for(;;)
                        {
                            if (up)
                            {
                                if (y <=0){}
                                else if (map1tf)
                                {   
                                    if(y<=chararr[3]){
                                    }
                                    else
                                    {
                                        y-= Victor.getspeed();
                                    } 
                                }
                                else
                                {
                                    y-= Victor.getspeed();
                                } 
                            }
                            if (down)
                            {
                                if (y >= 840){}
                                else if (map1tf)
                                {
                                    if(y>=chararr[2]){}
                                    else {
                                        y+= Victor.getspeed();
                                    }
                                }
                                else{
                                    y+= Victor.getspeed();
                                }
                            }
                            if (right)
                            {
                                if (x >= 1425){}
                                else if (map1tf)
                                {
                                    if(x>=chararr[0]){}
                                    else {
                                        x+= Victor.getspeed();
                                    }
                                }
                                else 
                                {
                                    x+= Victor.getspeed();
                                }       
                            }
                            if (left)
                            {
                                if (x<=0){}
                                else if (map1tf)
                                {
                                    if(x<=chararr[1]){}
                                    else {
                                        x-= Victor.getspeed();
                                    }
                                }
                                else
                                {
                                    x-= Victor.getspeed();
                                }
                            }
                            panel.setLocation(x,y);
                            lb.setText(x+" , "+ y);
                            try
                            {
                                sleep(2);
                            }
                            catch(InterruptedException e){}
                        }
                    }
            };
            th.start();
    }
    void jbskill()
    {
        Victor.getSkill().setcd(0);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (Victor.getSkill().getcd() <= 0)
                {
                    //System.out.println("hello");
                    if (Victor.getSkill() == ghost)
                    {
                        Victor.getSkill().setcd(5);
                        cdlb.setText("cd: " + Victor.getSkill().getcd());
                        Victor.changespeed(3);
                        speedlb.setText("Speed: " + Victor.getspeed());
                    }
                    else if (Victor.getSkill() == flash)
                    {
                        Victor.getSkill().setcd(5);
                        cdlb.setText("cd: " + Victor.getSkill().getcd());
                        if (up)
                        {
                            y-=150;
                        }
                        else if (down)
                        {
                            y+=150;
                        }
                        else if (right)
                        {
                            x+=150;
                        }
                        else if (left)
                        {
                            x-=150;
                        }
                        panel.setLocation(x,y);
                        lb.setText(x+" , "+ y);
                        
                    }
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Victor.getSkill().minuscd();
                            cdlb.setText("cd: " + Victor.getSkill().getcd());
                            if(Victor.getSkill() == ghost)
                            {
                                if(Victor.getSkill().getcd() == 3)
                                {
                                    Victor.changespeed(1);
                                    speedlb.setText("Speed: " + Victor.getspeed());
                                }
                            }
                            if (Victor.getSkill().getcd() <= 0)
                            {
                                timer.cancel();
                                timer = new Timer();
                            }
                        }
                    }, 0, 1000);
                }
            }
        });
    }
    void shop()
    {   
        Thread th=new Thread(){
                    @Override
                    public void run() {
                        for(;;)
                        {
                            if (maptf == false)
                            {
                                System.out.print("");
                                if(shoptf)
                                {
                                    if(x>=1200 && y<=150)
                                    {
                                        x=700;
                                        y=400;
                                        panel.setLocation(x,y);
                                        lb.setText(x+" , "+ y);
                                        shoppanel.setVisible(false);
                                        mappanel.setVisible(false);
                                        leaveshop.setVisible(true);
                                        flashp.setVisible(true);
                                        ghostp.setVisible(true);
                                        shoptf = false;
                                        shoptf1 = true;
                                    }
                                }
                                else 
                                {
                                    if (x<=800 && x>=700 && y<=860 && y>=840)
                                    {
                                        x=500;
                                        y=350;
                                        panel.setLocation(x,y);
                                        lb.setText(x+" , "+ y);
                                        shoppanel.setVisible(true);
                                        mappanel.setVisible(true);
                                        leaveshop.setVisible(false);
                                        flashp.setVisible(false);
                                        ghostp.setVisible(false);
                                        shoptf = true;
                                        shoptf1 = false;
                                    }
                                    //ghost
                                    if (x>=250 && x<=300 && y<=350 && y>=250)
                                    {
                                        buyb1.setVisible(true);
                                        changeb1.setVisible(true);
                                        changeb1.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                Victor.changeskill(ghost);
                                                Victor.getSkill().setcd(0);
                                                skilllb.setText("Skill: " + Victor.getSkill().getSkill());
                                            }
                                        });
                                    }
                                    //flash
                                    else if(x<=300 && x >=250 && y<=600 && y>=500)
                                    {
                                        buyb2.setVisible(true);
                                        buyb2.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                if(Victor.getpoint() >=10)
                                                {
                                                    Victor.changepoint(Victor.getpoint()-10);
                                                    pointlb.setText("Point: " + Victor.getpoint());
                                                    flashtf = true;
                                                }
                                            }
                                        });
                                        if (flashtf)
                                        {
                                            changeb2.setVisible(true);
                                            changeb2.addActionListener(new ActionListener(){
                                                @Override
                                                public void actionPerformed(ActionEvent e)
                                                {
                                                    Victor.changeskill(flash);
                                                    Victor.getSkill().setcd(0);
                                                    skilllb.setText("Skill: " + Victor.getSkill().getSkill());
                                                }
                                            });
                                        }
                                    }
                                    else
                                    {
                                        buyb1.setVisible(false);
                                        changeb1.setVisible(false);
                                        buyb2.setVisible(false);
                                        changeb2.setVisible(false);
                                    }
                                }
                            }
                        }   
                    }
        };;
        th.start();
    }
    void map()
    {
        Thread th=new Thread(){
            @Override
            public void run() {
                for(;;)
                {
                    System.out.print("");
                    if (shoptf1 == false)
                    {
                        if(maptf)
                        {
                            if(x<=49 && y<=700 && y>=600)
                            {
                                mtf = true;
                                maptf = false;
                            }
                        }
                        else 
                        {
                            if(x<=300 && y>=710)
                            {
                                maptf = true;
                                shoppanel.setVisible(false);
                                mappanel.setVisible(false);
                                level1.setVisible(true);
                            }
                        }
                        if (mtf)
                        {
                            dotlb.setText("Dot: " + dot);
                            map1tf = true;
                            level1.setVisible(false);
                            for (int i=0; i<17; i++)
                            {
                                for(int j=0; j<29; j++)
                                {
                                    map1[i][j].setVisible(true);
                                }
                            }
                            x=660;
                            y=420;
                            panel.setLocation(x,y);
                            lb.setText(x+" , "+ y);
                            enemy.setVisible(true);
                            ex=666;
                            ey=66;
                            enemy.setLocation(ex, ey);
                            wall();
                            enemymove();
                            checkpoint();
                            checkwin();
                            checkenemy();
                            mtf = false;
                        }
                    }
                }
            }
        };;
        th.start();
    }
    void enemymove()
    {
        Thread th=new Thread(){
            @Override
            public void run() {
                for(;;)
                {
                    if (ex<x && ey<y)
                    {
                        if(ex>= enemyarr[0] && ey>=enemyarr[2])
                        {

                        }
                        else if(ex>=enemyarr[0])
                        {
                            ey++;
                        }
                        else if(ey>=enemyarr[2])
                        {
                            ex++;
                        }
                        else{
                            ex++;
                            ey++;
                        }
                    }
                    else if (ex>x && ey>y)
                    {
                        if(ex<=enemyarr[1] && ey<=enemyarr[3])
                        {

                        }
                        else if (ex<=enemyarr[1])
                        {
                            ey--;
                        }
                        else if (ey<=enemyarr[3])
                        {
                            ex--;
                        }
                        else{
                            ex--;
                            ey--;
                        }
                    }
                    else if (ex<x && ey>y)
                    {
                        if (ex>= enemyarr[0] && ey<=enemyarr[3])
                        {

                        }
                        else if (ex>= enemyarr[0])
                        {
                            ey--;
                        }
                        else if(ey<=enemyarr[3])
                        {
                            ex++;
                        }
                        else{
                            ex++;
                            ey--;
                        }
                    }
                    else if (ex>x && ey<y)
                    {
                        if (ex<=enemyarr[1] && ey>=enemyarr[2])
                        {

                        }
                        else if(ex<=enemyarr[1])
                        {
                            ey++;
                        }
                        else if(ey>=enemyarr[2])
                        {
                            ex--;
                        }
                        else{
                            ex--;
                            ey++;
                        }
                    }
                    else if (ex<x)
                    {
                        if(ex>= enemyarr[0])
                        {

                        }
                        else {
                            ex++;
                        }
                    }
                    else if (ex>x)
                    {
                        if (ex<=enemyarr[1])
                        {}
                        else{
                            ex--;
                        }
                    }
                    else if (ey<y)
                    {
                        if (ey>=enemyarr[2])
                        {}
                        else{
                            ey++;
                        }
                    }
                    else if (ey>y)
                    {
                        if (ey<=enemyarr[3])
                        {}
                        else{
                            ey--;
                        }
                    }
                    try
                    {
                        sleep(5);
                    }
                    catch(InterruptedException e){}
                    enemy.setLocation(ex, ey);
                }
            }
        };;
        th.start();
    }
    void checkenemy()
    {
        quitb.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        backb.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e)
            {
                loselb.setVisible(false);
                losepanel.setVisible(false);
                quitb.setVisible(false);
                backb.setVisible(false);
                panel.setVisible(true);
                b.setVisible(true);
                enemy.setVisible(true);
                x=660;
                y=420;
                panel.setLocation(x,y);
                lb.setText(x+" , "+ y);
                ex=666;
                ey=66;
                enemy.setLocation(ex, ey);
                for (int i=0; i<17; i++)
                {
                    for(int j=0; j<29; j++)
                    {
                        if(map1n[i][j] == 2)
                        {
                            map1n[i][j] = 0;
                            map1[i][j].setVisible(true);
                        }
                    }
                }
            }
        });
        Thread th=new Thread(){
            @Override
            public void run() {
                for(;;)
                {
                    System.out.print("");
                    if(ex==x && ey==y)
                    {
                        loselb.setVisible(true);
                        losepanel.setVisible(true);
                        quitb.setVisible(true);
                        backb.setVisible(true);
                        panel.setVisible(false);
                        enemy.setVisible(false);
                        b.setVisible(false);
                    }
                }
            }
        };;
        th.start(); 
    }
    void createmap()
    {
        for (int i=0; i<17; i++)
        {
            for(int j=0; j<29; j++)
            {
                if(map1n[i][j] == 1)
                {
                    map1[i][j] = new JPanel();
                    map1[i][j].setSize(50,50);
                    map1[i][j].setBackground(Color.gray);
                    map1[i][j].setLocation(numx,numy);
                    f.add(map1[i][j]);
                    numx+=50;
                    map1[i][j].setVisible(false);
                }
                else if (map1n[i][j] == 0)
                {
                    numx+=22;
                    numy+=22;
                    map1[i][j] = new JPanel();
                    map1[i][j].setSize(6,6);
                    map1[i][j].setBackground(Color.black);
                    map1[i][j].setLocation(numx,numy);
                    f.add(map1[i][j]);
                    numx+=28;
                    numy-=22;
                    map1[i][j].setVisible(false);
                    dot++;
                }
            }
            numy+=50;
            numx=0;
        }
    }
    void checkpoint()
    {
        Thread th=new Thread(){
            @Override
            public void run() {
                for(;;)
                {
                    //dot = 235;
                    for (int i=0; i<17; i++)
                    {
                        for(int j=0; j<29; j++)
                        {
                            if (map1n[i][j]==2)
                            {

                            }
                            else
                            {
                                System.out.print("");
                                xn=x/50;
                                yn=y/50;
                                if (map1n[i][j] == 0)
                                {
                                    if(xn==j && yn==i)
                                    {
                                        map1[i][j].setVisible(false);
                                        map1n[i][j] = 2;
                                    }
                                }
                                if (map1n[i][j]==2)
                                {
                                    dot--;
                                    dotlb.setText("Dot: " + dot);
                                }
                            }
                        }
                    }
                }
            }
        };;
        th.start();
    }
    void checkwin()
    {
        quitb.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        Thread th=new Thread(){
            @Override
            public void run() {
                for(;;)
                {
                    System.out.print("");
                    if (dot==0)
                    {
                        winpanel.setVisible(true);
                        quitb.setVisible(true);
                        winlb.setVisible(true);
                        panel.setVisible(false);
                        enemy.setVisible(false);
                        b.setVisible(false);
                    }
                }
            }
        };;
        th.start();
    }
    void wall()
    {
        Thread th=new Thread(){
            @Override
            public void run() {
                for(;;)
                {
                    chararr = rwall(x,y);
                    enemyarr = rwall(ex, ey);
                }
            }
        };;
        th.start();
    }
    public int[] rwall(int x, int y)
    {
        int[] arr = new int[4];
        xi = x/50;
        yi = y/50;
        //System.out.println(x);
        //System.out.println(xi);
        //System.out.println(yi);
        System.out.print("");
                    
        //upperx
        indexx=xi+1;
        upperx=2000;
        upperx1=2000;
        while(true)
        {
            if (map1n[yi][indexx] == 1)
            {
                upperx = indexx*50 - 15;
                break;
            }
            else
            {
                indexx++;
            }
        }
        if(y%50>35)
        {
            indexx=xi+1;
            while(true)
            {
                if(map1n[yi+1][indexx]==1)
                {
                    upperx1 = indexx*50-15;
                    break;
                }
                else{
                    indexx++;
                }
            }
        }
        if(upperx<=upperx1)
        {
            rupperx = upperx;
        }
        else
        {
            rupperx = upperx1;
        }
        arr[0] = rupperx;

        //lowerx
        indexx=xi-1;
        lowerx=0;
        lowerx1=0;
        while(true)
        {
            if(map1n[yi][indexx]==1)
            {
                lowerx = (indexx+1)*50;
                break;
            }
            else{
                indexx--;
            }
        }
        if (y%50>35)
        {
            indexx=xi-1;
            while(true)
            {
                if(map1n[yi+1][indexx]==1)
                {
                    lowerx1 = (indexx+1)*50;
                    break;
                }
                else{
                    indexx--;
                }
            }
        }
        if(lowerx>=lowerx1)
        {
            rlowerx = lowerx;
        }
        else
        {
            rlowerx = lowerx1;
        }
        arr[1] = rlowerx;

        //uppery
        indexy=yi+1;
        uppery=1000;
        uppery1=1000;
        while(true)
        { 
            if (map1n[indexy][xi] == 1)
            {
                uppery = indexy*50-15;
                break;
            }
            else
            {
                indexy++;
            }
        }
        if (x%50>35)
        {
            indexy=yi+1;
            while(true)
            {
                if (map1n[indexy][xi+1] == 1)
                {
                    uppery1 = indexy*50-15;
                    break;
                }
                else
                {
                    indexy++;
                }
            }
        }
        if(uppery<=uppery1)
        {
            ruppery = uppery;
        }
        else
        {
            ruppery = uppery1;
        }
        arr[2] = ruppery;

        //lowery
        indexy=yi-1;
        lowery = 0;
        lowery1 = 0;
        while(true)
        {
            if (map1n[indexy][xi] == 1)
            {
                lowery = (indexy+1)*50;
                break;
            }
            else
            {
                indexy--;
            }
        }

        if(x%50>35)
        {
            indexy=yi-1;
            while(true)
            {    
                if (map1n[indexy][xi+1] == 1)
                {
                    lowery1 = (indexy+1)*50;
                    break;
                }
                else
                {
                    indexy--;
                }
            }
        }
        if(lowery>=lowery1)
        {
            rlowery = lowery;
        }
        else
        {
            rlowery = lowery1;
        }
        arr[3] = rlowery;
        return arr;
    }
    JF()
    {
        graphic();
        move();
        createmap();
        shop();
        jbskill();
        map();
    }
    @Override
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S)
        {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A)
        {
            left = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_W) 
        {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) 
        {
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) 
        {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) 
        {
            left = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){}

}